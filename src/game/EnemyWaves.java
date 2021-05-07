package game;

import java.util.LinkedList;
import java.util.Random;

import character.CharacterHandler;
import character.GameCharacter;
import character.enemy.*;

public class EnemyWaves {
	LinkedList<LinkedList<GameCharacter>> waves = new LinkedList<LinkedList<GameCharacter>>();
	LinkedList<GameCharacter> wave;
	private int counter;
	private int waveNumber = 0;
	CharacterHandler handler;
	private Random random = new Random();

	public EnemyWaves(CharacterHandler handler) {
		this.handler = handler;
		//generates a wave with preset enemies and locations
		LinkedList<GameCharacter> wave1 = new LinkedList<GameCharacter>();
		wave1.add(new BOSS_1(800, 200, 4, handler));
		waves.add(wave1);

		LinkedList<GameCharacter> wave2 = new LinkedList<GameCharacter>();
		wave2.add(new Rookie(850, 300));
		wave2.add(new Rookie(850, 500));
		wave2.add(new Rookie(800, 400));
		waves.add(wave2);

		LinkedList<GameCharacter> wave3 = new LinkedList<GameCharacter>();
		wave3.add(new Rookie(800, 250));
		wave3.add(new Rookie(900, 300));
		wave3.add(new Rookie(800, 400));
		wave3.add(new Sergeant(1000, 500));
		waves.add(wave3);

		//generates 10-50 random waves with random number of enemies and spawnlocations
		int r = random.nextInt(40) + 10;
		for (int i = 0; i < r; i++) {
			LinkedList<GameCharacter> wave = new LinkedList<GameCharacter>();
			int rookies = random.nextInt(10);
			int sergeants = random.nextInt(3);
				for (int j = 0; j < rookies; j++) {
					wave.add(new Rookie(random.nextInt(500) + A_Const.SCREEN_WIDTH, random.nextInt(A_Const.SCREEN_HEIGHT-40)+40));
				}
				for (int j = 0; j < sergeants; j++) {
					wave.add(new Sergeant(random.nextInt(1000) + A_Const.SCREEN_WIDTH, random.nextInt(A_Const.SCREEN_HEIGHT-40)+40));
				}
			waves.add(wave);
		}
		// counter is equal to the amount of waves
		counter = waves.size();
	}

	//returns a new wave to CharacterHandler
	public LinkedList<GameCharacter> getNewWave() {
		if (counter < 1)
			return null;
		counter--;
		wave = waves.get(waveNumber);
		waveNumber++;
		return wave;
	}

	public int getCounter() {
		return counter;
	}

}
