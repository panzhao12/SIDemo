package character.avatar;

import java.awt.Color;

import game.A_Const;

public class EnemyBullet extends Bullet {

	public EnemyBullet(double x, double y, int damage, Color color) {
		super(x, y, damage);
		super.color = color;
	}
	
	public void move(double diffSeconds) {
		x -= speed * diffSeconds;
		if (x < 0+radius) {
			remove = true;
		}
	}
	
	public int type() {
		return A_Const.TYPE_ENEMY_BULLET;
	}

}
