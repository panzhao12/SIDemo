package character.avatar;

import java.awt.Rectangle;

import character.GameObject;

public class Bullet extends GameObject {
	int damage;
	public Bullet(double x, double y, int speed, int damage) {
		this.x = x;
		this.y = y;
		this.speed = speed;
		this.damage = damage;
	}

	public void move(double diffSeconds) {
		x += speed*diffSeconds;
	}
	
	public void setDestination(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 10, 5);
	}
}
