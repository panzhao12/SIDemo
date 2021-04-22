package character.enemy;

public abstract class Enemy {
	int score;
	boolean remove = false;
	public int health;
	public double x,y;
	public int radius;
	

	public abstract void changeHealth(int value);
	
	public abstract int getHealth();

	public abstract void setRemove();

	public abstract void move(double diffSeconds);
	
	public abstract boolean getRemove();
	public abstract int getRadius();
	public abstract int getScore();
}
