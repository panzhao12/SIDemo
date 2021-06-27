package game;

import java.util.ArrayList;
import character.GameCharacter;
import character.enemy.*;

public class EnemyWaves {
	private ArrayList<ArrayList<GameCharacter>> waves = new ArrayList<ArrayList<GameCharacter>>();
	private ArrayList<GameCharacter> wave;
	private int counter;

	public EnemyWaves() {
		// generates a wave with preset enemies and random locations
		ArrayList<GameCharacter> wave1 = new ArrayList<GameCharacter>();
		wave1 = EnemyFactory.getEnemy("rookie", A_Const.WAVE1_ROOKIE_NUM, wave1);
		wave1 = EnemyFactory.getEnemy("sergeant", A_Const.WAVE1_SERGEANT_NUM, wave1);
		wave1 = EnemyFactory.getEnemy("boss1", A_Const.WAVE1_BOSS1_NUM, wave1);
		waves.add(wave1);

		ArrayList<GameCharacter> wave2 = new ArrayList<GameCharacter>();
		wave2 = EnemyFactory.getEnemy("rookie", A_Const.WAVE2_ROOKIE_NUM, wave2);
		wave2 = EnemyFactory.getEnemy("sergeant", A_Const.WAVE2_SERGEANT_NUM, wave2);
		wave2 = EnemyFactory.getEnemy("boss1", A_Const.WAVE2_BOSS1_NUM, wave2);
		waves.add(wave2);

		ArrayList<GameCharacter> wave3 = new ArrayList<GameCharacter>();
		wave3 = EnemyFactory.getEnemy("rookie", A_Const.WAVE3_ROOKIE_NUM, wave3);
		wave3 = EnemyFactory.getEnemy("sergeant", A_Const.WAVE3_SERGEANT_NUM, wave3);
		wave3 = EnemyFactory.getEnemy("boss1", A_Const.WAVE3_BOSS1_NUM, wave3);
		waves.add(wave3);

		ArrayList<GameCharacter> wave4 = new ArrayList<GameCharacter>();
		wave4 = EnemyFactory.getEnemy("rookie", A_Const.WAVE4_ROOKIE_NUM, wave4);
		wave4 = EnemyFactory.getEnemy("sergeant", A_Const.WAVE4_SERGEANT_NUM, wave4);
		wave4 = EnemyFactory.getEnemy("boss1", A_Const.WAVE4_BOSS1_NUM, wave4);
		waves.add(wave4);

		ArrayList<GameCharacter> wave5 = new ArrayList<GameCharacter>();
		wave5 = EnemyFactory.getEnemy("rookie", A_Const.WAVE5_ROOKIE_NUM, wave5);
		wave5 = EnemyFactory.getEnemy("sergeant", A_Const.WAVE5_SERGEANT_NUM, wave5);
		wave5 = EnemyFactory.getEnemy("boss1", A_Const.WAVE5_BOSS1_NUM, wave5);
		waves.add(wave5);

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
