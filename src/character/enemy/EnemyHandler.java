package character.enemy;

import java.util.LinkedList;

import character.GameCharacter;

public class EnemyHandler {

	public EnemyHandler() {
		addObject(new Rookie(900, 100, 5, 50, 20));
		addObject(new Rookie(900, 300, 5, 50, 20));
		addObject(new Rookie(800, 200, 5, 100, 20));
		addObject(new Rookie(800, 400, 5, 1000, 20));
		addObject(new Rookie(1200, 400, 5, 80, 20));
		addObject(new Rookie(1200, 200, 5, 160, 20));
		addObject(new Rookie(1400, 400, 5, 50, 20));
		addObject(new Rookie(1600, 600, 5, 50, 20));
		addObject(new Rookie(500, 500, 50, 0, 20));
		addObject(new Rookie(1800, 450, 5, 50, 20));

	}

	LinkedList<GameCharacter> object = new LinkedList<GameCharacter>();
	private int score = 0;

	public void addObject(GameCharacter gc) {
		object.add(gc);
	}

	public void removeObject(GameCharacter gc) {
		object.remove(gc);
		score += 10;
	}

	public LinkedList<GameCharacter> getList() {
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

	public int getScore() {
		return score;
	}
}
