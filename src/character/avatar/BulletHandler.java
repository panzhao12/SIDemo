package character.avatar;

import java.util.LinkedList;

import character.GameCharacter;
import character.enemy.Rookie;

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
			if(object.get(i).getRemove()) {
				removeObject(object.get(i));
			}
		}
	}

    public void collisionCheck(GameCharacter r) {
    	for(int i=0;i<object.size();i++) {
    		if(r.getBounds().intersects(object.get(i).getBounds())) {
    			object.remove(i);
    			r.changeHealth(-1);
    		}
    	}
    }
}
