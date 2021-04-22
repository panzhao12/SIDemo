package character.avatar;

import character.GameCharacter;

public class Bullet extends GameCharacter {
	int damage;
	private boolean remove = false;

	public Bullet(double x, double y, int speed, int damage, int radius) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.damage = damage;
		this.radius = radius;
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
	public void changeHealth(int value) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return 0;
	}
}
