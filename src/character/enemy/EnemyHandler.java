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
		addObject(new Rookie(1600, 500));
		addObject(new Rookie(500, 500));
		addObject(new Rookie(1800, 450));
		addObject(new Sergeant(250, 300));
		addObject(new Sergeant(2500, 400));
	}

	LinkedList<GameCharacter> object = new LinkedList<GameCharacter>();
	private int score = 0;

	public void addObject(GameCharacter e) {
		object.add(e);
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
			GameCharacter e = object.get(i);
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
