package game;

import java.util.ArrayList;
import character.GameCharacter;
import character.enemy.*;

public class EnemyWaves {
	private ArrayList<ArrayList<GameCharacter>> waves = new ArrayList<ArrayList<GameCharacter>>();
	private ArrayList<GameCharacter> wave;
	private int counter;

	public EnemyWaves() {
		// generates a wave with preset enemies and locations
		ArrayList<GameCharacter> wave1 = new ArrayList<GameCharacter>();
		wave1.add(new BOSS_1(800, 250));
		waves.add(wave1);

		ArrayList<GameCharacter> wave2 = new ArrayList<GameCharacter>();
		wave2.add(new Rookie(800, 250));
		waves.add(wave2);

		ArrayList<GameCharacter> wave3 = new ArrayList<GameCharacter>();
		wave3.add(new Rookie(800, 250));
		wave3.add(new Rookie(900, 300));
		wave3.add(new Rookie(800, 400));
		wave3.add(new Sergeant(1000, 500));
		waves.add(wave3);

		// counter is equal to the amount of waves
		counter = waves.size();
	}

	// returns a new wave to CharacterHandler
	public ArrayList<GameCharacter> getNewWave() {
		if (counter < 1)
			return null;
		counter--;
		wave = waves.get(0);
		waves.remove(0);
		return wave;
	}

	public int getCounter() {
		return counter;
	}
}
