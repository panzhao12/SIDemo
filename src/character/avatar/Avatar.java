package character.avatar;

import java.awt.Color;

import character.CharacterHandler;
import character.GameCharacter;
import game.A_Const;
import game.KeyInput;

public class Avatar extends GameCharacter {

	private CharacterHandler handler;
	private KeyInput keyinput;
	private double startTime = 0;
	
	//bullets per second
	private double fireRate = 3;

	public Avatar(double x, double y, int health, KeyInput keyinput, CharacterHandler handler) {
		super(x, y, 3, 20, 0, 300, Color.GREEN);
		this.keyinput = keyinput;
		this.handler = handler;
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

	public void shoot(double diffSeconds) {
		if (keyinput.isSpace() && !remove) {
			startTime += diffSeconds;
			if (startTime >= 1/fireRate) {
				handler.addObject(new Bullet(x + radius, y, 1));
				startTime = 0;
			}
		}
	}


	@Override
	public void move(double diffSeconds) {
		double dx = 0, dy = 0;
		
		if	(keyinput.isUp()) dy--;
		if	(keyinput.isDown()) dy++;
		if	(keyinput.isLeft()) dx--;
		if	(keyinput.isRight()) dx++;
		shoot(diffSeconds);

		if	(dx != 0 || dy != 0) {

			if	(x+dx < 0 + radius || x+dx > A_Const.SCREEN_WIDTH*0.75) dx = 0;
			if	(y+dy < 0 + radius || y+dy > A_Const.SCREEN_HEIGHT-radius) dy = 0;
			
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
	public Color color() {
		return color;
	}
}
