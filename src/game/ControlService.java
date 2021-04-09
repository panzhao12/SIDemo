package game;

public interface ControlService {

    // return User Input Object
    public GameControl getUserInput();

    // interpret UserInput and tell the User Object what to do
    public void command();
}
