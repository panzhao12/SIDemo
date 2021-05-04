package character;

import java.util.LinkedList;
import character.avatar.Bullet;
import character.enemy.*;
import game.A_Const;
import game.PhysicsSystem;

public class CharacterHandler {

	public CharacterHandler() {
		addObject(new Rookie(900, 100));
		addObject(new Rookie(900, 300));
		addObject(new Rookie(800, 200));
		addObject(new Rookie(800, 400));
		addObject(new Rookie(1200, 400));
		addObject(new Rookie(1200, 200));
		addObject(new Rookie(1400, 400));
		addObject(new Rookie(1600, 500));
		addObject(new Rookie(500, 500));
		addObject(new Rookie(1800, 450));
		addObject(new Sergeant(250, 300));
		addObject(new Sergeant(2500, 400));
	}

	private PhysicsSystem physics = new PhysicsSystem();
	private LinkedList<GameCharacter> object = new LinkedList<GameCharacter>();
	private int score = 0;

	public void addObject(GameCharacter gc) {
		object.add(gc);
	}

	public void removeObject(GameCharacter gc) {
		object.remove(gc);
		if (gc.x > gc.getRadius()) {
			score += gc.getScore();
		}
	}

	public LinkedList<GameCharacter> getList() {
		return object;
	}

	public void move(double diffSeconds) {
		for (int i = 0; i < object.size(); i++) {
			GameCharacter gc = object.get(i);
			gc.move(diffSeconds);
			if (gc.getRemove()) {
				removeObject(gc);
			}
		}
	}

	// Checks collisions between avatar and all enemies + all bullets with all enemies
	public void collisionCheck() {
		LinkedList<GameCharacter> enemyList1;
		for (int i = 0; i < object.size(); i++) {

			if (object.get(i).type() == A_Const.TYPE_BULLET) {
				enemyList1 = physics.getCollisions(object.get(i), object);
				for (int j = 0; j < enemyList1.size(); j++) {
					enemyList1.get(j).changeHealth(-(((Bullet) object.get(i)).getDamage()));
					object.get(i).setRemove();
				}
			}
			if (object.get(i).type() == A_Const.TYPE_AVATAR) {
				enemyList1 = physics.getCollisions(object.get(i), object);
				for (int j = 0; j < enemyList1.size(); j++) {
					enemyList1.get(j).setRemove();
					object.get(i).changeHealth(-1);
				}

			}
		}
	}

	public int getScore() {
		return score;
	}

}
