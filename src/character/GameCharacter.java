package character;


import java.awt.Image;

import game.Audio;

public abstract class GameCharacter {
	
	protected int score, health, radius, speed;
	protected boolean remove = false;
	protected double x, y;
	protected CharacterHandler handler;
	protected String deathSound;
	private Image sprite;
	public GameCharacter(double x, double y, int health, int radius, int score, int speed,Image sprite) {
		this.x = x;
		this.y = y;
		this.health = health;
		this.radius = radius;
		this.score = score;
		this.speed = speed;
		this.setSprite(sprite);
		this.handler = CharacterHandler.handler;
	}
	
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
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

	public Image getSprite() {
		return sprite;
	}

	public void setSprite(Image sprite) {
		this.sprite = sprite;
	}
	
}
