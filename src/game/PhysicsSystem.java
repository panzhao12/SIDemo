package game;

import java.util.LinkedList;

import character.avatar.Avatar;
import character.avatar.BulletHandler;
import character.enemy.Rookie;
import character.enemy.RookieHandler;

public class PhysicsSystem {

	public void collisionCheck(Avatar a, BulletHandler bulletHandler, RookieHandler rookieHandler) {
		LinkedList<Rookie> list = rookieHandler.getList();
		for (int i = 0; i < list.size(); i++) {
			bulletHandler.collisionCheckEnemy(list.get(i));
		}
		for (int i = 0; i < list.size(); i++) {
			a.collisionCheck(list.get(i));
		}
	}
}
