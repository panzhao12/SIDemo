package character.avatar;

import java.util.LinkedList;

import character.GameCharacter;
import game.PhysicsSystem;

public class BulletHandler {
	PhysicsSystem physics = new PhysicsSystem();
	LinkedList<Bullet> object = new LinkedList<Bullet>();

	public void addObject(Bullet bullet) {
		object.add(bullet);
	}

	public void removeObject(Bullet bullet) {
		object.remove(bullet);

	}

	public LinkedList<Bullet> getList() {
		return object;
	}

	public void move(double diffSeconds) {
		for (int i = 0; i < object.size(); i++) {
			object.get(i).move(diffSeconds);
			if (object.get(i).getRemove()) {
				removeObject(object.get(i));
			}
		}
	}

	public void collisionCheckEnemy(LinkedList<GameCharacter> r) {
		for (int i=0;i<r.size();i++) {
			for (int j = 0; j < object.size(); j++) {
				if (physics.checkCollision(r.get(i), object.get(j))) {
					// deal damage based on bullet damage
					r.get(i).changeHealth(-(object.get(j).damage));
					object.remove(j);
					if (r.get(i).getHealth() <= 0) {
						r.get(i).setRemove();
					}
				}
			
			}
		}
	}
}
