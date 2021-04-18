package character.avatar;

import java.util.LinkedList;

public class BulletHandler {
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
		for (int i=0; i<object.size();i++) {
			object.get(i).move(diffSeconds);
			if(object.get(i).x > 800) {
				removeObject(object.get(i));
			}
		}
	}
}
