package game;

import character.CharacterHandler;
import character.avatar.Avatar;
import character.avatar.Bullet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameLoop {

	private GamePanel panel;
	private Avatar avatar;
	private KeyInput keyInput;
	private CharacterHandler handler;

	private double time;
	private int frames, oldFrames;

	public void run() {
		keyInput = new KeyInput();
		handler = new CharacterHandler();
		avatar = new Avatar(100, 100, 3, keyInput, handler);
		handler.addObject(avatar);

		MouseAdapter mouseAdapter = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				handler.addObject(new Bullet(avatar.getX() + avatar.getRadius(), avatar.getY(), 1));
			}
		};
		panel.addMouseListener(mouseAdapter);
		panel.addKeyListener(keyInput);
		panel.setFocusable(true);
		panel.requestFocusInWindow();

		long lastTick = System.currentTimeMillis();
		while (true) {
			long currentTick = System.currentTimeMillis();
			double diffSeconds = (currentTick - lastTick) / 1000.0;
			lastTick = currentTick;
			//counts the frames per second that you are running at
			fpsCount(diffSeconds);
			// moves all GameCharacters
			handler.move(diffSeconds);
			// Checks for collisions
			handler.collisionCheck();
			// runs the shoot method of the avatar class
			avatar.shoot(diffSeconds);

			panel.clear();

			// gets the int "score" from CharacterHandler and draws it
			panel.drawScore(handler.getScore());
			//draws fps on screen
			panel.drawFps("FPS: ", oldFrames);
			// draws the current health of the player
			panel.drawHealth(avatar);
			// draws all GameCharacters
			panel.draw(handler.getList());

			panel.redraw();
		}
	}
	
	public void fpsCount(double diffSeconds) {
		time += diffSeconds;
		frames++;
		if (time >= 0.5) {
			oldFrames = 2*frames;
			frames = 0;
			time = 0;
		}
	}

	public void setGraphicPanel(GamePanel panel) {
		this.panel = panel;
	}
}
