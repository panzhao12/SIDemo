package character.enemy;

import java.awt.Color;

import character.GameCharacter;

public class Sergeant extends GameCharacter {

	private boolean remove = false;

	public Sergeant(double x, double y) {
		super(x, y, 10, 40, 30, 150, Color.CYAN);

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
