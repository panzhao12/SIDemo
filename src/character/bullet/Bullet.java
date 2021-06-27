package character.bullet;

import java.awt.Color;

import character.GameCharacter;
import game.A_Const;

public class Bullet extends GameCharacter {
	
	private int damage;
	
	public Bullet(double x, double y, int damage) {
		super(x, y, 0, 5, 0, 400, Color.YELLOW);
		this.damage = damage;
	}

	public void move(double diffSeconds) {
		x += speed * diffSeconds;
		if (x > A_Const.SCREEN_WIDTH+radius) {
			remove = true;
		}
	}

	public int getDamage() {
		return damage;
	}

	@Override
	public int type() {
		return A_Const.TYPE_BULLET;
	}
}
