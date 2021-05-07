package character;

import java.util.LinkedList;
import character.avatar.Bullet;
import game.A_Const;
import game.EnemyWaves;
import game.PhysicsSystem;

public class CharacterHandler {

	private EnemyWaves waves;
	private int enemyCounter;
	private PhysicsSystem physics = new PhysicsSystem();
	private LinkedList<GameCharacter> objectList = new LinkedList<GameCharacter>();
	private int score = 0;


	public CharacterHandler() {
		// initialize EnemyWaves and get the initial wave
		EnemyWaves waves = new EnemyWaves(this);
		this.waves = waves;
		LinkedList<GameCharacter> wave = waves.getNewWave();
		for (int i = 0; i < wave.size(); i++) {
			objectList.add(wave.get(i));
			enemyCounter++;
		}
	}

	public void addObject(GameCharacter gc) {
		objectList.add(gc);
	}

	public void removeObject(GameCharacter gc) {
		// if removed object is an enemy, decrement enemyCounter
		if (gc.type() == A_Const.TYPE_ENEMY)
			enemyCounter--;
		objectList.remove(gc);
		// if enemies make it across the screen, score will not increase
		if (gc.x > gc.getRadius()) {
			score += gc.getScore();
		}
		// if all enemies have died and there are more waves to get, get new wave
		if (enemyCounter < 1 && waves.getCounter() > 0) {
			LinkedList<GameCharacter> wave = waves.getNewWave();
			for (int i = 0; i < wave.size(); i++) {
				objectList.add(wave.get(i));
				enemyCounter++;
			}
		}
	}

	public LinkedList<GameCharacter> getList() {
		return objectList;
	}

	public void move(double diffSeconds) {
		for (int i = 0; i < objectList.size(); i++) {
			GameCharacter gc = objectList.get(i);

			gc.move(diffSeconds);
			collisionCheck(gc);
			if (gc.getRemove()) {
				removeObject(gc);
			}
		}
	}

	public void collisionCheck(GameCharacter gc) {
		LinkedList<GameCharacter> enemyListSmall;
		switch (gc.type()) {
		case A_Const.TYPE_AVATAR:
			enemyListSmall = physics.getCollisions(gc, objectList);
			for (int i = 0; i < enemyListSmall.size(); i++) {
				enemyListSmall.get(i).setRemove();
				gc.changeHealth(-1);
			}
			break;
		case A_Const.TYPE_BULLET:
			enemyListSmall = physics.getCollisions(gc, objectList);
			for (int j = 0; j < enemyListSmall.size(); j++) {
				enemyListSmall.get(j).changeHealth(-((Bullet) gc).getDamage());
				gc.setRemove();
			}
			break;
		}	
	}

	public int getScore() {
		return score;
	}

}
