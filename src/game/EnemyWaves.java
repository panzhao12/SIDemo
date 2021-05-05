package game;

import java.util.LinkedList;
import java.util.Random;

import character.GameCharacter;
import character.enemy.*;

public class EnemyWaves {
	LinkedList<LinkedList<GameCharacter>> waves = new LinkedList<LinkedList<GameCharacter>>();
	LinkedList<GameCharacter> wave;
	private int counter;
	private int waveNumber = 0;
	private Random random = new Random();

	public EnemyWaves() {

		//generates a wave with preset enemies and locations
		LinkedList<GameCharacter> wave1 = new LinkedList<GameCharacter>();
		wave1.add(new Rookie(800, 200));
		wave1.add(new Sergeant(900, 500));
		wave1.add(new Rookie(1000, 300));
		waves.add(wave1);

		LinkedList<GameCharacter> wave2 = new LinkedList<GameCharacter>();
		wave2.add(new Rookie(550, 300));
		wave2.add(new Rookie(450, 300));
		wave2.add(new Rookie(500, 300));
		waves.add(wave2);

		LinkedList<GameCharacter> wave3 = new LinkedList<GameCharacter>();
		wave3.add(new Rookie(500, 400));
		wave3.add(new Rookie(400, 400));
		wave3.add(new Rookie(600, 400));
		wave3.add(new Sergeant(200, 400));
		waves.add(wave3);

		//generates 10-50 random waves with random number of enemies and spawnlocations
		int r = random.nextInt(40) + 10;
		for (int i = 0; i < r; i++) {
			LinkedList<GameCharacter> wave = new LinkedList<GameCharacter>();
			int rookies = random.nextInt(10);
			int sergeants = random.nextInt(3);
				for (int j = 0; j < rookies; j++) {
					wave.add(new Rookie(random.nextInt(1000) + 600, random.nextInt(600)));
				}
				for (int j = 0; j < sergeants; j++) {
					wave.add(new Sergeant(random.nextInt(1000) + 600, random.nextInt(600)));
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
