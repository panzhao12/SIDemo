package character.avatar;

import java.awt.Color;
import java.util.LinkedList;

import character.CharacterHandler;
import character.GameCharacter;
import game.A_Const;
import game.GamePanel;
import game.KeyInput;
import game.PhysicsSystem;

public class Avatar extends GameCharacter {

	private PhysicsSystem physics = new PhysicsSystem();
	private CharacterHandler bulletHandler;
	private GamePanel panel;
	private KeyInput keyinput;
	private boolean remove = false;

	private double startTime = 0;
	private double fireRate = 0.2;

	public Avatar(double x, double y, int health, KeyInput keyinput, CharacterHandler bulletHandler, GamePanel panel) {
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
			this.setRemove();
		}
	}

	public int getHealth() {
		return health;
	}

	public void collisionCheck(LinkedList<GameCharacter> enemyList) {
		LinkedList<GameCharacter> enemyList1 = physics.getCollisions(this, enemyList);
			for(int i = 0; i<enemyList1.size();i++) {
				enemyList1.get(i).setRemove();
				changeHealth(-1);
		}
	}

	public void shoot(double diffSeconds) {
		if (keyinput.isSpace() && !remove) {
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
		remove = true;
	}

	@Override
	public boolean getRemove() {
		// TODO Auto-generated method stub
		return remove;
	}

	@Override
	public int getScore() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int type() {
		// TODO Auto-generated method stub
		return A_Const.TYPE_AVATAR;

	}

}
