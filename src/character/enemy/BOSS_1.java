package character.enemy;

import java.awt.Color;
import java.util.Random;
import character.GameCharacter;
import game.A_Const;
import game.Audio;

public class BOSS_1 extends GameCharacter {
	
	Random random = new Random();
	protected String deathSound = "audio/explosion.wav";
	private String shootingSound = "audio/bosslaser.wav";
	double dx = -1, dy = 1, fireRate = 3, startTime = 3, timer = 0;
	int maxHealth, shootingDuration;
	boolean fireCooldown = false;
	
	public BOSS_1(double x, double y) {
		super(x, y, 50, 40, 100, 150, Color.RED);
		this.maxHealth = health;
		super.deathSound = deathSound;
	}
	
	public void move(double diffSeconds) {
		
		if (x+dx > A_Const.SCREEN_WIDTH-radius) dx = -1;
		if (x + dx < 600) dx = 1;
		if (y+dy > A_Const.SCREEN_HEIGHT - radius) dy = -1;
		if (y + dy < 0+radius) dy = 1;
		
		y += dy*speed*diffSeconds;
		x += dx*speed*diffSeconds;
		timer += diffSeconds;
		
		if(!fireCooldown) shoot(diffSeconds);
		
		if (timer >= shootingDuration) {
			fireCooldown = !fireCooldown;
			timer = 0;
			shootingDuration = random.nextInt(3)+1;
		}
	}
	
	public void shoot(double diffSeconds) {
		startTime += diffSeconds;
		if (startTime >= 1/fireRate) {
			handler.addObject(new EnemyBullet(x - radius, y, Math.PI, 400, 10,  1, Color.blue));
			Audio.playSound(shootingSound);
			startTime = 0;
		}
	}

	@Override
	public int type() {
		return A_Const.TYPE_BOSS;
	}
}
