package character;

import java.awt.Color;

public abstract class GameCharacter {
	public int score;
	boolean remove = false;
	public int health;
	public double x,y;
	public int radius;
	public int speed;
	public Color color;
	
	public GameCharacter(double x, double y, int health, int radius, int score, int speed, Color color) {
		this.x = x;
		this.y = y;
		this.health = health;
		this.radius = radius;
		this.score = score;
		this.speed = speed;
		this.color = color;
	}
	public abstract void changeHealth(int value);
	
	public abstract int getHealth();

	public abstract void setRemove();

	public abstract void move(double diffSeconds);
	
	public abstract boolean getRemove();
	
	public abstract int getRadius();
	
	public abstract int getScore();
	
	public abstract int type();
}
