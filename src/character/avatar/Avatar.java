package character.avatar;

import java.util.LinkedList;

import character.GameCharacter;
import game.PhysicsSystem;

public class Avatar extends GameCharacter {
	PhysicsSystem physics = new PhysicsSystem();
	int radius = 20;
	public Avatar(double x, double y, int health) {
		this.x = x;
		this.y = y;
		this.health = health;
	}

	public void setDestination(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void changeHealth(int health) {
		this.health += health;
		if (this.health <= 0) {
			System.out.println("u ded lmao");
		}
	}

	public int getHealth() {
		return health;
	}

	public void collisionCheck(LinkedList<GameCharacter> linkedList) {
		for (int i = 0; i < linkedList.size(); i++) {
			if (physics.checkCollision(linkedList.get(i), this)) {
				changeHealth(-1);
				linkedList.get(i).setRemove();;
			}
		}

	}



	@Override
	public void move(double diffSeconds) {
		// TODO Auto-generated method stub

	}

	public int getRadius() {
		return radius;
	}

	@Override
	public void setRemove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getRemove() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

}
