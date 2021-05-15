package items;

public class Gun extends Items {

	protected int damage;
	protected double fireRate;
	
	public Gun(String name, int price, int damage, double fireRate) {
		super(name, price);
		this.damage = damage;
		this.fireRate = fireRate;
	}
	
	public int getDamage() {
		return damage;
	}
	
	public double getFireRate() {
		return fireRate;
	}
}
