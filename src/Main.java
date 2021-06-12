import game.GameFrame;
import game.GameLoop;
import game.RunningScreen;
import game.StartScreen;
import game.State;

public class Main {

	public static void main(String[] args) {
		GameFrame frame = new GameFrame();
		frame.setVisible(true);

		GameLoop game = new GameLoop();
		game.setGraphicPanel(frame.getPanel());
		//game.addScreen(State.START, new StartScreen());
		game.addScreen(State.RUNNING, new RunningScreen());
		//game.addScreen(State.GAME_OVER, new GameOverScreen());
		game.run();
	}
}