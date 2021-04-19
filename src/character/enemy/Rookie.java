package character.enemy;

import java.awt.Rectangle;

import character.GameCharacter;

public class Rookie extends GameCharacter {

	private boolean remove = false;
    public Rookie(double x, double y, int health, double speed) {
        this.x = x;
        this.y = y;
        this.health = health;
        this.speed = speed;
    }

    public void move(double diffSeconds) {
        x -= speed * diffSeconds;
		if(x < 0) {
			remove = !remove;
		}
    }
    
    public boolean getRemove() {
    	return remove;
    }
    public void setDestination(double x, double y) {
        this.x = x;
        this.y = y;
    }
    
    public double getX() {
    	return x;
    }
    public double getY() {
    	return y;
    }
    public Rectangle getBounds() {
    	return new Rectangle((int)x, (int)y, 39, 39);
    }
    public void changeHealth(int health) {
    	this.health += health;
    }

    public int getHealth() {
    	return health;
    }
}
