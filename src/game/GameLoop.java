package game;

import character.CharacterHandler;
import character.avatar.Avatar;
import character.avatar.Bullet;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
public class GameLoop {

	private GamePanel panel;
	private Avatar avatar;
	//private BulletHandler bulletHandler;
	//private EnemyHandler enemyHandler;
	private KeyInput keyInput;
	private CharacterHandler handler;
	
	public void run() {
		//bulletHandler = new BulletHandler();
		// creates RookieHandler + all rookies specified in the constructor
		//enemyHandler = new EnemyHandler();
		keyInput = new KeyInput();
		handler = new CharacterHandler();
		avatar = new Avatar(100, 100, 3, keyInput, handler, panel);
		handler.addObject(avatar);

		MouseAdapter mouseAdapter = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				handler.addObject(new Bullet(avatar.x + avatar.getRadius(), avatar.y, 1));			}
		};
		panel.addMouseListener(mouseAdapter);
        panel.addKeyListener(keyInput);
        panel.setFocusable(true);
        panel.requestFocusInWindow();
    
        long lastTick = System.currentTimeMillis();        
        while (true) {
            long currentTick = System.currentTimeMillis();
            double diffSeconds = (currentTick-lastTick) / 1000.0;
            lastTick = currentTick;
//            avatar.move(diffSeconds);
            handler.move(diffSeconds);
            handler.collisionCheck();
            
            avatar.shoot(diffSeconds);
            // move array of rookies
//            enemyHandler.move(diffSeconds);
            // move array of bullets
//            bulletHandler.move(diffSeconds);
//            avatar.collisionCheck(enemyHandler.getList());
//            bulletHandler.collisionCheck(enemyHandler.getList());
            panel.clear();
            //panel.draw(avatar);
            panel.drawHealth(avatar);

            // gets the int "score" from rookieHandler and draws it
            panel.drawScore(handler.getScore());
            // draws all enemies
            panel.draw(handler.getList());
            // draws all bullets
            //panel.drawBullet(bulletHandler.getList());

            panel.redraw();
        }
    }
    
    public void setGraphicPanel(GamePanel panel) {
        this.panel = panel;
    }
    
}
