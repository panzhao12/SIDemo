package character.enemy;

import java.awt.Color;

import character.CharacterHandler;
import character.GameCharacter;
import character.avatar.EnemyBullet;
import game.A_Const;

public class BOSS_1 extends GameCharacter {
	
	double dx = -1;
	double dy = 1;
	double fireRate;
	double startTime = 0;
	CharacterHandler handler;
	public BOSS_1(double x, double y, double fireRate, CharacterHandler handler) {
		super(x, y, 50, 40, 100, 150, Color.RED);
		this.fireRate = fireRate;
		this.handler = handler;
	}

	@Override
	public double getX() {
		return x;
	}

	@Override
	public double getY() {
		return y;
	}

	@Override
	public Color color() {
		return color;
	}

	public void changeHealth(int health) {
		this.health += health;
		if(this.health <= 0) {
			setRemove();
		}
	}

	@Override
	public int getHealth() {
		return 0;
	}

	@Override
	public void setRemove() {
		remove = true;
	}

	public void move(double diffSeconds) {
		
		if (x+dx > 800-radius) dx = -1;
		if (x + dx < 600) dx = 1;
		if (y+dy > A_Const.SCREEN_HEIGHT - radius) dy = -1;
		if (y + dy < 0+radius) dy = 1;
		y += dy*speed*diffSeconds;
		x += dx*speed*diffSeconds;
		shoot(diffSeconds);
	}

	public void shoot(double diffSeconds) {
		startTime += diffSeconds;
		if (startTime >= fireRate) {
			handler.addObject(new EnemyBullet(x - radius, y, 1, Color.blue));
			startTime = 0;
		}
	}
	public boolean getRemove() {
		return remove;
	}

	@Override
	public int getRadius() {
		return radius;
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public int type() {
		// TODO Auto-generated method stub
		return A_Const.TYPE_ENEMY;
	}

}
