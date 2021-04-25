package character.avatar;

import java.util.LinkedList;
import character.GameCharacter;
import game.GamePanel;
import game.KeyInput;
import game.PhysicsSystem;

public class Avatar extends GameCharacter {

	private PhysicsSystem physics = new PhysicsSystem();
	private BulletHandler bulletHandler;
	private GamePanel panel;
	private KeyInput keyinput;

	private int radius = 20;
	private int speed = 200;
	private double dy, dx;
	private double startTime = 0;
	private double fireRate = 0.1;

	public Avatar(double x, double y, int health, KeyInput keyinput, BulletHandler bulletHandler, GamePanel panel) {
		this.x = x;
		this.y = y;
		this.health = health;
		this.keyinput = keyinput;
		this.bulletHandler = bulletHandler;
		this.panel = panel;
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

	public void shoot(double diffSeconds) {
		if (keyinput.isSpace()) {
			startTime += diffSeconds;
			if (startTime >= fireRate) {
				bulletHandler.addObject(new Bullet(x + radius, y, 300, 1));
				startTime = 0;
			}
		}
	}

	@Override
	public void move(double diffSeconds) {
		dx = speed * diffSeconds;
		dy = speed * diffSeconds;

		if (keyinput.isLeft() && !keyinput.isRight()) {
			if (dx + x > 0 + radius) {
				dx = -speed;
			}
		} else if (keyinput.isRight() && !keyinput.isLeft()) {
			if (dx + x < panel.WIDTH * 0.75 - radius) {
				dx = speed;
			}
		} else {
			dx = 0;
		}

		if (keyinput.isUp() && !keyinput.isDown()) {
			if ((y - dy) > 0 + radius) {
				dy = -speed;

			}
		} else if (keyinput.isDown() && !keyinput.isUp()) {
			if (y + dy < panel.HEIGHT - radius) {
				dy = speed;
			}
		} else {
			dy = 0;
		}

		this.x += dx * diffSeconds;
		this.y += dy * diffSeconds;

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
