package character.avatar;

import java.awt.Rectangle;

import character.GameCharacter;

public class Avatar extends GameCharacter {

    public Avatar(double x, double y, double life) {
        this.x = x;
        this.y = y;
        this.life = life;
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
    	return new Rectangle((int)x+20, (int)y+20);
    }


}
