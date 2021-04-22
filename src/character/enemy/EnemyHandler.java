package character.enemy;

import java.util.LinkedList;

import character.GameCharacter;

public class EnemyHandler {

	public EnemyHandler() {
		addObject(new Rookie(900, 100));
		addObject(new Rookie(900, 300));
		addObject(new Rookie(800, 200));
		addObject(new Rookie(800, 400));
		addObject(new Rookie(1200, 400));
		addObject(new Rookie(1200, 200));
		addObject(new Rookie(1400, 400));
		addObject(new Rookie(1600, 600));
		addObject(new Rookie(500, 500));
		addObject(new Rookie(1800, 450));
		addObject(new Sergeant(250, 300));
		addObject(new Sergeant(2500, 400));
	}

	LinkedList<Enemy> object = new LinkedList<Enemy>();
	private int score = 0;

	public void addObject(Enemy e) {
		object.add(e);
	}

	public void removeObject(Enemy e) {
		object.remove(e);
		if (e.x > e.getRadius()) {
			score += e.getScore();
		}
	}

	public LinkedList<Enemy> getList() {
		return object;
	}

	public void move(double diffSeconds) {
		for (int i = 0; i < object.size(); i++) {
			Enemy e = object.get(i);
			e.move(diffSeconds);
			if (e.getRemove()) {
				removeObject(e);
			}
		}
	}

	public int getScore() {
		return score;
	}
}
