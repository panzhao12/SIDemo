package character.avatar;

import java.awt.Rectangle;

import character.GameCharacter;

public class Avatar extends GameCharacter {
	
    public Avatar(double x, double y, int health) {
        this.x = x;
        this.y = y;
        this.health = health;
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
    
    public void changeHealth(int health) {
    	this.health += health;
    	if (this.health <= 0) {
    		System.out.println("u ded lmao");
    	}
    }
    public int getHealth() {
    	return health;
    }


}
