package game;
import character.CharacterHandler;
import character.avatar.Avatar;

public class GameLoop {

	private GamePanel panel;
	private Avatar avatar;
	private InputSystem inputSystem;
	private CharacterHandler handler;
	
	private double time;
	private int frames, oldFrames;

	public void run() {
		inputSystem = panel.getKeyInput();
		handler = new CharacterHandler();
		avatar = new Avatar(100, 100, 3, inputSystem, handler);
		handler.setAvatar(avatar);
		handler.addObject(avatar);
		panel.addKeyListener(inputSystem);
		panel.setFocusable(true);
		panel.requestFocusInWindow();

		long lastTick = System.currentTimeMillis();
		while (true) {
			long currentTick = System.currentTimeMillis();
			double diffSeconds = (currentTick - lastTick) / 1000.0;
			lastTick = currentTick;
			
			// moves all GameCharacters
			handler.move(diffSeconds);
			panel.clear();
			// gets the int "score" from CharacterHandler and draws it
			panel.drawText("Score: " + handler.getScore(), 30, 40);
			//draws fps on screen
			panel.drawText("FPS: " + oldFrames, 250, 40);
			// draws the current health of the player
			panel.drawHealth(avatar, 30, 80);
			panel.drawText("Wave: " + handler.getWaveCounter(), 350, 40);
			// draws all GameCharacters
			panel.draw(handler.getList());
			
			panel.redraw();
			
			
			//counts the frames per second that you are running at
			fpsCount(diffSeconds);

		}
	}
	
	public void fpsCount(double diffSeconds) {
		time += diffSeconds;
		frames++;
		if (time >= 1) {
			oldFrames = frames;
			frames = 0;
			time = 0;
		}
	}

	public void setGraphicPanel(GamePanel panel) {
		this.panel = panel;
	}
	
}
