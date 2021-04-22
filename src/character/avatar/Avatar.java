package character.avatar;

import java.util.LinkedList;

import character.GameCharacter;
import game.PhysicsSystem;

public class Avatar extends GameCharacter {
	PhysicsSystem physics = new PhysicsSystem();

	public Avatar(double x, double y, int health, int radius) {
		this.x = x;
		this.y = y;
		this.health = health;
		this.radius = radius;
	}

	@Override
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
	
	public void collisionCheck(LinkedList<GameCharacter> a) {
		for(int i=0;i<a.size();i++) {
			if(physics.checkCollision(a.get(i), this)) {
				changeHealth(-1);
				a.remove(i);
			}
		}

	}

	@Override
	public void setRemove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(double diffSeconds) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getRemove() {
		// TODO Auto-generated method stub
		return false;
	}

}
