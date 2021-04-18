package character.enemy;

import java.awt.Rectangle;

import character.GameCharacter;

public class Rookie extends GameCharacter {

    public Rookie(double x, double y, int life, double speed) {
        this.x = x;
        this.y = y;
        this.life = life;
        this.speed = speed;
    }

    public void move(double diffSeconds) {
        x -= speed * diffSeconds;
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
    public void setLife(int life) {
    	this.life = life;
    }

    public int getLife() {
    	return life;
    }
    public boolean death() {
    	if (life <= 0) {
    		return true;
    	}
		return false;
    }
}
