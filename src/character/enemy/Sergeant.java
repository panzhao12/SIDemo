package character.enemy;

import java.awt.Color;

import character.GameCharacter;
import game.A_Const;

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
		// TODO Auto-generated method stub
		return A_Const.TYPE_ENEMY;

	}
}
