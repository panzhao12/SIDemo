package character.enemy;

import java.awt.Color;
import java.util.Random;

import character.CharacterHandler;
import character.GameCharacter;
import character.avatar.EnemyBullet;
import game.A_Const;

public class BOSS_1 extends GameCharacter {
	
	double dx = -1;
	double dy = 1;
	double fireRate = 3;
	double startTime = 0;
	boolean fireCooldown = false;
	double timer = 0;
	int maxHealth;
	Random random = new Random();
	CharacterHandler handler;
	int shootingDuration;
	public BOSS_1(double x, double y, CharacterHandler handler) {
		super(x, y, 50, 40, 100, 150, Color.RED);
		this.maxHealth = health;
		this.handler = handler;
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
			handler.addObject(new EnemyBullet(x - radius, y, Math.PI, 400,  1, Color.blue));
			startTime = 0;
		}
	}

	
	public int getMaxHealth() {
		return maxHealth;
	}

	@Override
	public int type() {
		return A_Const.TYPE_BOSS;
	}


}
