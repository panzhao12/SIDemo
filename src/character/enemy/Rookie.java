package character.enemy;

import character.GameCharacter;

public class Rookie extends GameCharacter {

    public Rookie(double x, double y, double life, double speed) {
        this.x = x;
        this.y = y;
        this.life = life;
        this.speed = speed;
    }

    public void move(double diffSeconds) {
        x -= speed * diffSeconds;
    }

    @Override
    public void setDestination(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
