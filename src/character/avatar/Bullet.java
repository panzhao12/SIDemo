package character.avatar;

import java.awt.Color;

import character.GameCharacter;

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
			remove = !remove;
		}
	}

	public boolean getRemove() {
		return remove;
	}
	
	public void setRemove() {
		remove = !remove;
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
		// TODO Auto-generated method stub

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
}
