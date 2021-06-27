package character.enemy;

import character.GameCharacter;
import game.PhysicsSystem;

import java.util.ArrayList;

public class EnemyFactory {
    //TODO define the area for enemies, need to be more precise
    private static int minX = 800, maxX = 1000;
    private static int minY = 0, maxY = 600;

    public static ArrayList<GameCharacter> getEnemy(String enemyType, int quantity, ArrayList<GameCharacter> enemyList) {
        for (int i = 0; i < quantity; i++){
            enemyList.add(getCharacter(enemyType, enemyList));
        }
        return enemyList;
    }

    private static GameCharacter getCharacter(String enemyType, ArrayList<GameCharacter> enemyList) {
        int x = minX + (int)(Math.random() * (maxX - minX + 1));
        int y = minY + (int)(Math.random() * (maxY - minY + 1));

        GameCharacter character;

        switch (enemyType) {
            case "boss1":
                character = new BOSS_1(x, y);
                break;
            case "sergeant":
                character = new Sergeant(x, y);
                break;
            case "rookie":
                character = new Rookie(x, y);
                break;
            default:
                character = null;
        }

        //go through the whole enemyList and check if any two enemies are overlap recursively
        if (enemyList.size() != 0) {
            for (GameCharacter enemy : enemyList) {
                if (PhysicsSystem.isCollision(character, enemy)) {
                    return getCharacter(enemyType, enemyList);
                }
            }
        }
        return character;
    }
}
