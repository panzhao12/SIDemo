package character;


public abstract class GameCharacter {


    public double x, y;
    protected int life;
    protected double speed;

    protected abstract void setDestination(double x, double y);



}
