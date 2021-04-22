package character;

public abstract class GameCharacter {

    public double x, y;
    protected int health;
    protected double speed;
    protected int radius;

    protected abstract void setDestination(double x, double y);
        
    public abstract void changeHealth(int value);

	public abstract int getHealth();

	public abstract void setRemove();

	public abstract void move(double diffSeconds);

	public abstract boolean getRemove();

	public int getRadius() {
		return radius;
	}
}
