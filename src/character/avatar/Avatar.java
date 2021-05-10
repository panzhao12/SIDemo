package character.avatar;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import character.CharacterHandler;
import character.GameCharacter;
import game.A_Const;
import game.KeyInput;

public class Avatar extends GameCharacter {

	private CharacterHandler handler;
	private KeyInput keyinput;
	private double startTime = 0;
	MouseAdapter mouseAdapter;
	//bullets per second
	private double fireRate = 3;

	public Avatar(double x, double y, int health, KeyInput keyinput, CharacterHandler handler) {
		super(x, y, health, 20, 0, 300, Color.GREEN);
		this.keyinput = keyinput;
		this.handler = handler;
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
		
		if	(keyinput.isUp()) 	 dy--;
		if	(keyinput.isDown())  dy++;
		if	(keyinput.isLeft())  dx--;
		if	(keyinput.isRight()) dx++;
		shoot(diffSeconds);

		if	(dx != 0 || dy != 0) {

			if	(x+dx < 0 + radius || x+dx > A_Const.SCREEN_WIDTH*0.75)		dx = 0;
			if	(y+dy < 0 + radius || y+dy > A_Const.SCREEN_HEIGHT-radius)	dy = 0;
			
			y += dy*speed*diffSeconds;
			x += dx*speed*diffSeconds;
		}
	}

	@Override
	public int type() {
		return A_Const.TYPE_AVATAR;

	}

	public MouseListener getMouseListener() {
		mouseAdapter = new MouseAdapter() {
				public void mousePressed(MouseEvent e) {
					handler.addObject(new Bullet(x + radius, y, 1));
				}
		};
		return mouseAdapter;
	}
}
