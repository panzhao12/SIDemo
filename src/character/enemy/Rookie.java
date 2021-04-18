package character.enemy;

import java.awt.Rectangle;

import character.GameObject;

public class Rookie extends GameObject {

    public Rookie(double x, double y, double life, double speed) {
        this.x = x;
        this.y = y;
        this.life = life;
        this.speed = speed;
    }

    public void move(double diffSeconds) {
        x -= speed * diffSeconds;
    }

    @Override
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
    	return new Rectangle((int)x, (int)y, 40, 40);
    }

}
