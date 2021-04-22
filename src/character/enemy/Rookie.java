package character.enemy;

import character.GameCharacter;

public class Rookie extends GameCharacter {

	private boolean remove = false;

	public Rookie(double x, double y, int health, double speed, int radius) {
		this.x = x;
		this.y = y;
		this.health = health;
		this.speed = speed;
		this.radius = radius; 
	}

	public void move(double diffSeconds) {
		x -= speed * diffSeconds;
		if (x < -40) {
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

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}


	public void changeHealth(int health) {
		this.health += health;
	}

	public int getHealth() {
		return health;
	}
}
