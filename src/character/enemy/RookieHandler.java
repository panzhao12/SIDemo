package character.enemy;

import java.util.LinkedList;

public class RookieHandler {
	LinkedList<Rookie> object = new LinkedList<Rookie>();
	public void addObject(Rookie rookie) {
		object.add(rookie);
	}
	
	public void removeObject(Rookie rookie) {
		object.remove(rookie);
	}
	
	public LinkedList<Rookie> getList() {
		return object;
	}
	
	public void move(double diffSeconds) {
		for (int i=0; i<object.size();i++) {
			object.get(i).move(diffSeconds);
		}
	}
	
}
