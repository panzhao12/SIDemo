package character.enemy;

import java.awt.Color;

import character.GameCharacter;
import game.A_Const;

public class Rookie extends GameCharacter {

	
	public Rookie(double x, double y) {
		super(x, y, 5, 20, 10, 100, Color.PINK);
	}

	public void move(double diffSeconds) {
		x -= speed * diffSeconds;
		if (x < -2*radius) {
			x = A_Const.SCREEN_WIDTH+radius;
		}
	}

	@Override
	public int type() {
		return A_Const.TYPE_ENEMY;
	}

}
