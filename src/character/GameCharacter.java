package character;

import java.awt.Color;
import java.awt.Image;

import game.Audio;

public abstract class GameCharacter {
	
	protected int score, health, radius, speed;
	protected boolean remove = false;
	protected double x, y;
	protected Color color;
	protected CharacterHandler handler;
	protected String deathSound;
	public GameCharacter(double x, double y, int health, int radius, int score, int speed, Color color) {
		this.x = x;
		this.y = y;
		this.health = health;
		this.radius = radius;
		this.score = score;
		this.speed = speed;
		this.color = color;
		this.handler = CharacterHandler.handler;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	public Color color() {
		return color;
	}
	
	public void changeHealth(int value) {
		health += value;
		if (this.health <= 0) {
			this.setRemove();
		}
	}
	
	public void setRemove() {
		remove = true;
		Audio.playSound(deathSound);
	}
	
	public int getHealth() {
		return health;
	}	
	public boolean getRemove() {
		return remove;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public int getScore() {
		return score;
	}

	
	public abstract void move(double diffSeconds);
	
	public abstract int type();
	
}
