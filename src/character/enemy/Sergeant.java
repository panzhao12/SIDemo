package character.enemy;

import java.awt.Color;
import character.CharacterHandler;
import character.GameCharacter;
import character.avatar.Avatar;
import character.avatar.EnemyBullet;
import game.A_Const;

public class Sergeant extends GameCharacter {
	private double startTime = 0;
	private double fireRate = 0.5;
	private CharacterHandler handler;
	private static Avatar avatar;

	public Sergeant(double x, double y, CharacterHandler handler) {
		super(x, y, 10, 40, 30, 100, Color.CYAN);
		this.handler = handler;
	}

	public void move(double diffSeconds) {
		avatar = handler.getAvatar();
		x -= speed * diffSeconds;
		if (x < A_Const.SCREEN_WIDTH) shoot(diffSeconds);
		if (x < -2 * radius) {
			x = A_Const.SCREEN_WIDTH+radius;
		}
	}
	
	public void shoot(double diffSeconds) {
		startTime += diffSeconds;
		if (startTime >= 1 / fireRate) {
			double px = avatar.getX()+radius;
			double py = avatar.getY();
			double alfa = Math.atan2(py - y, px - x);
			if (Math.abs(alfa) > 1.3)	handler.addObject(new EnemyBullet(x - radius, y, alfa ,250, 1, Color.blue));
			startTime = 0;
		}
	}

	@Override
	public int type() {
		return A_Const.TYPE_ENEMY;
	}
}
