package game;

import java.util.HashMap;
import java.util.Map;

public class GameLoop {

	private State state = State.RUNNING;
	private Map<State, Screen> screens = new HashMap<>();
	private GamePanel panel;

    public void addScreen(State state, Screen screen)
    {
        screens.put(state, screen);
    }

    public void run()
    {
        Screen screen = screens.get(state);
        screen.update(panel);
    }
		
    public void setGraphicPanel(GamePanel panel) {
		this.panel = panel;
	}
}
