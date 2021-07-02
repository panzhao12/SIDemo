package character;

import java.util.ArrayList;
import character.avatar.Avatar;
import character.bullet.Bullet;
import game.A_Const;
import game.Audio;
import game.EnemyWaves;
import game.InputSystem;
import game.PhysicsSystem;
import items.*;

public class CharacterHandler {

	private EnemyWaves waves;
	private int waveCounter = 0, enemyCounter = 0, score = 1000, points = 0, maxWaves = 0;
	private PhysicsSystem physics = new PhysicsSystem();
	private ArrayList<GameCharacter> objectList = new ArrayList<GameCharacter>();
	private static Avatar avatar;
	protected static CharacterHandler handler;

	public CharacterHandler(InputSystem inputSystem) {
		handler = this;
		avatar = new Avatar(100, 200, 3, inputSystem);
		addObject(avatar);
		// initialize EnemyWaves and get the initial wave
		EnemyWaves waves = new EnemyWaves();
		this.waves = waves;
		maxWaves = waves.getCounter();
		getNewWave();
	}

	public void addObject(GameCharacter gc) {
		objectList.add(gc);
	}

	public void removeObject(GameCharacter gc) {
		// if removed object is an enemy, decrement enemyCounter
		if (gc.type() == A_Const.TYPE_ENEMY || gc.type() == A_Const.TYPE_BOSS) {
			enemyCounter--;
		}
		score += gc.getScore();
		points += gc.getScore();
		objectList.remove(gc);
		
		// if all enemies have died and there is another wave to get, get new wave
		if (enemyCounter < 1 && waves.getCounter() > 0) {
			getNewWave();
		}
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
		ArrayList<GameCharacter> enemyListSmall;
		switch (gc.type()) {
		case A_Const.TYPE_AVATAR:
			enemyListSmall = physics.getCollisions(gc, objectList);
			for (int i = 0; i < enemyListSmall.size(); i++) {
				enemyListSmall.get(i).setRemove();
				gc.changeHealth(-1);
				Audio.playSound("audio/hurt.wav");


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
	
	private void getNewWave() {
		ArrayList<GameCharacter> wave = waves.getNewWave();
		waveCounter++;
		for (int i = 0; i < wave.size(); i++) {
			addObject(wave.get(i));
			enemyCounter++;
		}
	}
	
	public void setNewWeapon(Gun gun) {
		avatar.setWeapon(gun);
		score -= gun.getPrice();
	}
	
	  public void setHealth(Health health) { 
		  avatar.healthUp(); 
		  score -= health.getPrice();
		
	} 
	  
	  
	  public void setDamage(Damage damage) { 
		  avatar.damageUp(); 
		  score -= damage.getPrice();
		
	}   
	  
	  
	  public void setFirerate(Firerate firerate) { 
		  avatar.fireRateUp(); 
		  score -= firerate.getPrice();
		
	} 

	public ArrayList<GameCharacter> getList() {
		return objectList;
	}

	public int getScore() {
		return score;
	}
	
	public int getPoints() {
		return points;
	}
	
	public Avatar getAvatar() {
		return avatar;
	}

	public int maxWaves() {
		return maxWaves;
	}
	public int getWaveCounter() {
		return waveCounter;
	}
}
