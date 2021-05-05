package character.enemy;

import java.awt.Color;

import character.GameCharacter;
import game.A_Const;

public class Rookie extends GameCharacter {

	//private boolean remove = false;
	public Rookie(double x, double y) {
		super(x, y, 5, 20, 10, 100, Color.PINK);
	}

	public void move(double diffSeconds) {
		x -= speed * diffSeconds;
		if (x < -2*radius) {
			setRemove();
		}
	}

	public boolean getRemove() {
		return remove;
	}

	public void setRemove() {
		remove = true;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void changeHealth(int health) {
		this.health += health;
		if(this.health <= 0) {
			setRemove();
		}
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

	@Override
	public int type() {
		return A_Const.TYPE_ENEMY;
	}
	public Color color() {
		return color;
	}
}
