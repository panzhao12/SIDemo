package character.enemy;


import java.awt.Image;

import javax.swing.ImageIcon;

import character.bullet.Bullet;
import game.A_Const;

public class EnemyBullet extends Bullet {
	double angle;
	int speed;
	static ImageIcon logo = new ImageIcon("sprites/bull2.png");
	static Image img = logo.getImage();
	public EnemyBullet(double x, double y, double angle, int speed, int radius, int damage) {
		super(x, y, damage,img);
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
