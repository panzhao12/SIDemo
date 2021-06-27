package character.enemy;

import java.awt.Color;

import character.bullet.Bullet;
import game.A_Const;

public class EnemyBullet extends Bullet {
	double angle;
	int speed;
	public EnemyBullet(double x, double y, double angle, int speed, int radius, int damage, Color color) {
		super(x, y, damage);
		super.color = color;
		this.angle = angle;
		this.speed = speed;
		this.radius = radius;
	}
	
	public void move(double diffSeconds) {
		x += Math.cos(angle)*speed * diffSeconds;
		y += Math.sin(angle)*speed * diffSeconds;
		if (x < 0+radius) {
			remove = true;
		}
	}
	
	public int type() {
		return A_Const.TYPE_ENEMY_BULLET;
	}

}
