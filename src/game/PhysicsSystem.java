package game;

import java.util.LinkedList;

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
		double dx = x1-x2;
		double dy = y1-y2;
		return Math.sqrt((dx*dx) + (dy * dy));
	}
	
	//returns a shorter list with all collisions between GameCharacter a and list of enemies
	public LinkedList<GameCharacter> getCollisions(GameCharacter a, LinkedList<GameCharacter> list) {
		LinkedList<GameCharacter> collisions = new LinkedList<GameCharacter>();
		if(a.type() == A_Const.TYPE_AVATAR || a.type() == A_Const.TYPE_BULLET) {
			for (int i = 0; i< list.size(); i++) {
				if(list.get(i).type() == A_Const.TYPE_ENEMY) {
					if(checkCollision(a, list.get(i))) {
						collisions.add(list.get(i));
					}
				}
			}
		}

		return collisions;
		
	}

}
