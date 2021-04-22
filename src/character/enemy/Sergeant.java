package character.enemy;

public class Sergeant extends Enemy {

	private boolean remove = false;
	private int health = 10;
	private int speed = 150;
	private int radius = 40;
	private int score = 30;
	public Sergeant(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public void move(double diffSeconds) {
		x -= speed * diffSeconds;
		if (x < -40) {
			remove = !remove;
		}
	}

	public boolean getRemove() {
		return remove;
	}

	public void setRemove() {
		remove = !remove;
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

	public void changeHealth(int health) {
		this.health += health;
	}

	public int getHealth() {
		return health;
	}

	public int getRadius() {
		return radius;
	}

	public int getScore() {
		return score;
	}
}
