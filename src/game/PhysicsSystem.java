package game;

import java.util.TimerTask;

import character.GameCharacter;
public class PhysicsSystem {

	public boolean checkCollision(GameCharacter a, GameCharacter b) {
		if (getDistance(b, a) <= a.getRadius() + b.getRadius()) {
			return true;
		}
		return false;
	}

	public double getDistance(GameCharacter a, GameCharacter b) {

		double x1 = a.x;
		double x2 = b.x;
		double y1 = a.y;
		double y2 = b.y;

		return Math.sqrt((Math.pow(x1 - x2, 2)) + (Math.pow(y1 - y2, 2)));
	}
	
	public void scheduleAtFixedRate(TimerTask task, long delay, long period) {
		
	}
}
