package character.enemy;

import java.util.LinkedList;

import character.GameCharacter;

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
			if(object.get(i).getRemove()) {
				object.remove(i);
			}
		}		
	}
    public void checkHealth() {
    	for(int i=0; i<object.size(); i++) {
    		if (object.get(i).getHealth() <= 0) {
    			object.remove(i);
    		}
    	}
     }

    
    public void collisionCheck(GameCharacter r) {
    	for(int i=0;i<object.size();i++) {
    		if(r.getBounds().intersects(object.get(i).getBounds())) {
    			r.changeHealth(-1);
    			object.remove(i);
    		}
    	}
    }
}
