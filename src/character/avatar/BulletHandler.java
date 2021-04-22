package character.avatar;

import java.util.LinkedList;

import character.enemy.Enemy;
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

	public void collisionCheckEnemy(LinkedList<Enemy> enemyList) {
		for (int i = 0; i < enemyList.size(); i++) {
			for (int j = 0; j < object.size(); j++) {
				if (physics.checkCollision(enemyList.get(i), object.get(j))) {
					// deal damage based on bullet damage
					enemyList.get(i).changeHealth(-(object.get(j).damage));
					object.remove(j);
					if (enemyList.get(i).getHealth() <= 0) {
						enemyList.get(i).setRemove();
					}
				}

			}
		}
	}
}
