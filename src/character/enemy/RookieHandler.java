package character.enemy;

import java.util.LinkedList;

import character.GameCharacter;

public class RookieHandler {
	
	LinkedList<Rookie> object = new LinkedList<Rookie>();
	private int score = 0;
	public void addObject(Rookie rookie) {
		object.add(rookie);
	}
	
	public void removeObject(Rookie rookie) {
		object.remove(rookie);
		score += 10;
		System.out.println(score);
	}
	
	public LinkedList<Rookie> getList() {
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
    public void checkHealth() {
    	for(int i=0; i<object.size(); i++) {
    		if (object.get(i).getHealth() <= 0) {
				removeObject(object.get(i));
    		}
    	}
     }

    
    public void collisionCheck(GameCharacter r) {
    	for(int i=0;i<object.size();i++) {
    		if(r.getBounds().intersects(object.get(i).getBounds())) {
    			r.changeHealth(-1);
				removeObject(object.get(i));
    		}
    	}
    }
    
    public int getScore() {
    	return score;
    }
}
