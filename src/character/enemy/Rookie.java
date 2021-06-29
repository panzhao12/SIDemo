package character.enemy;








import character.GameCharacter;
import game.A_Const;
import game.Audio;
import game.SpriteHandler;

public class Rookie extends GameCharacter {

	static SpriteHandler sh = new SpriteHandler(1);

	 
	public Rookie(double x, double y, int r) {
		super(x, y, 5, 20, 10, 100,sh.getSub(r));
	}

	public void move(double diffSeconds) {
		x -= speed * diffSeconds;
		if (x < -2*radius) {
			x = A_Const.SCREEN_WIDTH+radius;
		}
	}
	public void setRemove() {
		remove = true;
		Audio.playSound("audio/explosion_2.wav");
	}
	@Override
	public int type() {
		return A_Const.TYPE_ENEMY;
	}

}
