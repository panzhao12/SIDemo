package character;

import java.awt.Rectangle;

public abstract class GameCharacter {

    public double x, y;
    protected int health;
    protected double speed;

    protected abstract void setDestination(double x, double y);
    
    public abstract Rectangle getBounds();
    
    public abstract void changeHealth(int value);

	public abstract int getHealth();
}
