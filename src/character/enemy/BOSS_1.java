package character.enemy;




import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;

import character.GameCharacter;
import game.A_Const;
import game.Audio;
import game.SpriteHandler;

public class BOSS_1 extends GameCharacter {
	
	Random random = new Random();

	double dx = -1, dy = 1, fireRate = 3, startTime = 3, timer = 0;
	int maxHealth, shootingDuration;
	boolean fireCooldown = false;
	
	protected String deathSound = "audio/explosion.wav";
	private String shootingSound = "audio/bosslaser.wav";
	
	static SpriteHandler sh = new SpriteHandler(3);

	
	static ImageIcon logo = new ImageIcon("sprites/end.png");
	static Image img = logo.getImage();
	
	public BOSS_1(double x, double y) {
		super(x, y, 150, 70, 1000, 175,img);
		this.maxHealth = health;
		super.deathSound = deathSound;
	}
	
	public BOSS_1(double x, double y, int b) {
		super(x, y, 50, 60, 100, 150,sh.getSub(b));
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
			handler.addObject(new EnemyBullet(x - radius, y, Math.PI, 400, 10,  1));
			Audio.playSound(shootingSound);
			startTime = 0;
		}
	}

	@Override
	public int type() {
		return A_Const.TYPE_BOSS;
	}
}
