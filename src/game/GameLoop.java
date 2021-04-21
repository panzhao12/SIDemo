package game;

import character.avatar.Avatar;
import character.avatar.Bullet;
import character.avatar.BulletHandler;
import character.enemy.RookieHandler;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameLoop {

	private GamePanel panel;
	private Avatar avatar;
	private BulletHandler bulletHandler;
	private RookieHandler rookieHandler;
	private PhysicsSystem physicsSystem;

	// Initialize resource

	public void run() {
		bulletHandler = new BulletHandler();
		// creates RookieHandler + all rookies specified in the constructor
		rookieHandler = new RookieHandler();
		avatar = new Avatar(100, 100, 3);
		physicsSystem = new PhysicsSystem();

		MouseAdapter mouseAdapter = new MouseAdapter() {
			public void mouseMoved(MouseEvent e) {
				double x = e.getX();
				double y = e.getY();
				avatar.setDestination(x - 20, y - 20);
			}

			public void mouseClicked(MouseEvent e) {
				bulletHandler.addObject(new Bullet(avatar.x + 40, avatar.y + 20, 300, 1));
			}
		};
		panel.addMouseListener(mouseAdapter);
		panel.addMouseMotionListener(mouseAdapter);

		long lastTick = System.currentTimeMillis();

		while (true) {
			long currentTick = System.currentTimeMillis();
			double diffSeconds = (currentTick - lastTick) / 1000.0;
			lastTick = currentTick;
			// move array of rookies
			rookieHandler.move(diffSeconds);
			// move array of bullets
			bulletHandler.move(diffSeconds);
			// check if any bullets hit rookies
			physicsSystem.collisionCheck(avatar, bulletHandler, rookieHandler);
//			rookieHandler.checkHealth();
			panel.clear();
			panel.draw(avatar);
			panel.drawHealth(avatar);
			// gets the int "score" from rookieHandler and draws it
			panel.drawScore(rookieHandler.getScore());
			// draws all rookies
			panel.drawRookie(rookieHandler.getList());
			// draws all bullets
			panel.drawBullet(bulletHandler.getList());
			panel.redraw();
		}
	}

	public void setGraphicPanel(GamePanel panel) {
		this.panel = panel;
	}
}
