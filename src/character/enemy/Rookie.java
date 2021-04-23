package character.enemy;

import character.GameCharacter;

public class Rookie extends GameCharacter {

	private boolean remove = false;
	private int health = 5;
	private int speed = 100;
	private int radius = 20;
	private int score = 10;
	public Rookie(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void move(double diffSeconds) {
		x -= speed * diffSeconds;
		if (x < -2*radius) {
			remove = !remove;
		}
	}

	public boolean getRemove() {
		return remove;
	}

	public void setRemove() {
		remove = !remove;
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
	public int getRadius() {
		return radius;
	}
	public int getScore() {
		return score;
	}
}
