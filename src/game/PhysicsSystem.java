package game;

import character.GameCharacter;
import character.enemy.Enemy;

public class PhysicsSystem {

	public boolean checkCollision(Enemy enemy, GameCharacter b) {
		if (getDistance(b, enemy) <= enemy.getRadius() + b.getRadius()) {
			return true;
		}
		return false;
	}

	public double getDistance(GameCharacter a, Enemy b) {

		double x1 = a.x;
		double x2 = b.x;
		double y1 = a.y;
		double y2 = b.y;

		return Math.sqrt((Math.pow(x1 - x2, 2)) + (Math.pow(y1 - y2, 2)));
	}
}
