package character.avatar;

import java.awt.Color;
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

	private double startTime = 0;
	private double fireRate = 0.2;

	public Avatar(double x, double y, int health, KeyInput keyinput, BulletHandler bulletHandler, GamePanel panel) {
		super(x, y, 3, 20, 0, 300, Color.GREEN);
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
			}
		}
	}

	public void shoot(double diffSeconds) {
		if (keyinput.isSpace()) {
			startTime += diffSeconds;
			if (startTime >= fireRate) {
				bulletHandler.addObject(new Bullet(x + radius, y, 1));
				startTime = 0;
			}
		}
	}

	@Override
	public void move(double diffSeconds) {
		double dx = 0, dy = 0;
		
		if(keyinput.isUp()) dy--;
		if(keyinput.isDown()) dy++;
		if(keyinput.isLeft()) dx--;
		if(keyinput.isRight()) dx++;
		
		if(dx != 0 || dy != 0) {

			if(x+dx < 0 + radius || x+dx > panel.WIDTH*0.75) dx = 0;
			if(y+dy < 0 + radius || y+dy > panel.HEIGHT-radius) dy = 0;
			y += dy*speed*diffSeconds;
			x += dx*speed*diffSeconds;

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
