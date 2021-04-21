package character.enemy;

import java.util.LinkedList;

public class RookieHandler {

	public RookieHandler() {
		addObject(new Rookie(900, 100, 5, 50));
		addObject(new Rookie(900, 300, 5, 50));
		addObject(new Rookie(800, 200, 5, 100));
		addObject(new Rookie(800, 400, 5, 50));
		addObject(new Rookie(1200, 400, 5, 50));
		addObject(new Rookie(1200, 200, 5, 50));
		addObject(new Rookie(1400, 400, 5, 50));
		addObject(new Rookie(1600, 600, 5, 50));
		addObject(new Rookie(1900, 600, 5, 50));
		addObject(new Rookie(1800, 450, 5, 50));

	}

	LinkedList<Rookie> object = new LinkedList<Rookie>();
	private int score = 0;

	public void addObject(Rookie rookie) {
		object.add(rookie);
	}

	public void removeObject(Rookie rookie) {
		object.remove(rookie);
		score += 10;
	}

	public LinkedList<Rookie> getList() {
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
