package character.avatar;

import character.GameCharacter;

public class Avatar extends GameCharacter {

    public Avatar(double x, double y, double life) {
        this.x = x;
        this.y = y;
        this.life = life;
    }

    @Override
    public void setDestination(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
