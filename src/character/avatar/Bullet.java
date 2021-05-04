package character.avatar;

import java.awt.Color;

import character.GameCharacter;
import game.A_Const;

public class Bullet extends GameCharacter {
	int damage;
	private boolean remove = false;
	public Bullet(double x, double y, int damage) {
		super(x, y, 0, 5, 0, 400, Color.YELLOW);
		this.damage = damage;
	}

	public void move(double diffSeconds) {
		x += speed * diffSeconds;
		if (x > 800) {
			remove = true;
		}
	}

	public boolean getRemove() {
		return remove;
	}
	
	public void setRemove() {
		remove = true;
	}

	public void setDestination(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public int getDamage() {
		return damage;
	}

	@Override
	public int getRadius() {
		return radius;
	}

	@Override
	public void changeHealth(int value) {
		this.health += value;
		if(health <= 0) {
			setRemove();
		}

	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int type() {
		// TODO Auto-generated method stub
		return A_Const.TYPE_BULLET;
	}
}
