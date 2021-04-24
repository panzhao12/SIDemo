package character.avatar;

import java.util.LinkedList;

import character.GameCharacter;
import game.KeyInput;
import game.PhysicsSystem;

public class Avatar extends GameCharacter {
	private PhysicsSystem physics = new PhysicsSystem();
	private int radius = 20;
	private int speed = 200;
	private KeyInput keyinput;
	private double dy, dx;
	private BulletHandler bulletHandler;

	public Avatar(double x, double y, int health, KeyInput keyinput, BulletHandler bulletHandler) {
		this.x = x;
		this.y = y;
		this.health = health;
		this.keyinput = keyinput;
		this.bulletHandler = bulletHandler;
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
				linkedList.get(i).setRemove();
				;
			}
		}

	}
	public void shoot() {
		if(keyinput.isSpace()) {
			bulletHandler.addObject(new Bullet(x + radius, y, 300, 1));
			keyinput.setSpace();
		}
	}
	@Override
	public void move(double diffSeconds) {
		System.out.println(dx);
		this.x += dx * diffSeconds;
		this.y += dy * diffSeconds;
		if (keyinput.isLeft() && !keyinput.isRight()) {
			dx = -speed;
		} else if (keyinput.isRight() && !keyinput.isLeft()) {
			dx = speed;
		} else {
			dx = 0;
		}
		
		if (keyinput.isUp() && !keyinput.isDown()) {
			dy = -speed;
		} else if (keyinput.isDown() && !keyinput.isUp()) {
			dy = speed;
		} else {
			dy = 0;
		}

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
