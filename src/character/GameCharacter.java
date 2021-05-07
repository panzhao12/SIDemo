package character;

import java.awt.Color;

public abstract class GameCharacter {
	protected int score;
	protected boolean remove = false;
	protected int health;
	protected double x,y;
	protected int radius;
	protected int speed;
	protected Color color;
	
	public GameCharacter(double x, double y, int health, int radius, int score, int speed, Color color) {
		this.x = x;
		this.y = y;
		this.health = health;
		this.radius = radius;
		this.score = score;
		this.speed = speed;
		this.color = color;
	}
	
	public abstract double getX();
	
	public abstract double getY();
	
	public abstract Color color();
	
	public abstract void changeHealth(int value);
	
	public abstract void setRemove();

	public abstract void move(double diffSeconds);
	
	public abstract boolean getRemove();
	
	public abstract int getRadius();
	
	public abstract int getScore();
	
	public abstract int type();
}
