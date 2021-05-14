package game;

import java.util.ArrayList;

import character.GameCharacter;

public class PhysicsSystem {

	public boolean checkCollision(GameCharacter a, GameCharacter b) {
		if (getDistance(b, a) <= a.getRadius() + b.getRadius()) {
			return true;
		}
		return false;
	}

	public double getDistance(GameCharacter a, GameCharacter b) {

		double x1 = a.getX();
		double x2 = b.getX();
		double y1 = a.getY();
		double y2 = b.getY();
		double dx = x1 - x2;
		double dy = y1 - y2;
		return Math.sqrt((dx * dx) + (dy * dy));
	}

	// returns a shorter list with all collisions between GameCharacter a and list of enemies
	public ArrayList<GameCharacter> getCollisions(GameCharacter a, ArrayList<GameCharacter> list) {
		ArrayList<GameCharacter> collisions = new ArrayList<GameCharacter>();
		switch (a.type()) {
		case A_Const.TYPE_AVATAR:
			for (int i = 0; i < list.size(); i++) {
				GameCharacter current = list.get(i);
				//check if avatar is touching current object
				if (current.type() == A_Const.TYPE_ENEMY || current.type() == A_Const.TYPE_ENEMY_BULLET || current.type() == A_Const.TYPE_BOSS) {
					if (checkCollision(a, current)) {
						collisions.add(current);
					}
				}
			}
			break;

		case A_Const.TYPE_BULLET:
			for (int i = 0; i < list.size(); i++) {
				GameCharacter current = list.get(i);
				//check if bullet is touching current object
				if (current.type() == A_Const.TYPE_ENEMY || current.type() == A_Const.TYPE_BOSS) {
					if (checkCollision(a, current)) {
						collisions.add(current);
					}
				}
			}
			break;
		}
		return collisions;
	}
}
