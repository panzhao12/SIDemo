package game;

import java.util.LinkedList;
import character.CharacterHandler;
import character.GameCharacter;
import character.enemy.*;

public class EnemyWaves {
	private LinkedList<LinkedList<GameCharacter>> waves = new LinkedList<LinkedList<GameCharacter>>();
	private LinkedList<GameCharacter> wave;
	private int counter;

	public EnemyWaves(CharacterHandler handler) {
		//generates a wave with preset enemies and locations
		LinkedList<GameCharacter> wave1 = new LinkedList<GameCharacter>();
		wave1.add(new BOSS_1(800, 250, handler));
		waves.add(wave1);

		LinkedList<GameCharacter> wave2 = new LinkedList<GameCharacter>();
		wave2.add(new Rookie(800, 250));
		waves.add(wave2);

		LinkedList<GameCharacter> wave3 = new LinkedList<GameCharacter>();
		wave3.add(new Rookie(800, 250));
		wave3.add(new Rookie(900, 300));
		wave3.add(new Rookie(800, 400));
		wave3.add(new Sergeant(1000, 500, handler));
		waves.add(wave3);

		// counter is equal to the amount of waves
		counter = waves.size();
	}

	//returns a new wave to CharacterHandler
	public LinkedList<GameCharacter> getNewWave() {
		if (counter < 1) return null;
		counter--;
		wave = waves.get(0);
		waves.remove(0);
		return wave;
	}

	public int getCounter() {
		return counter;
	}

}
