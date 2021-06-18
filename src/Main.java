import game.GameFrame;
import game.GameLoop;

public class Main {

	public static void main(String[] args) {
		GameFrame frame = new GameFrame();
		frame.setVisible(true);
		GameLoop game = new GameLoop();
		game.setGraphicPanel(frame.getPanel());
		game.run();
	}
}