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
	
	public void run() {
	
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
            
            //moves all GameCharacters
            handler.move(diffSeconds);
            //Checks for collisions
            handler.collisionCheck();
            //runs the shoot method of the avatar class
            avatar.shoot(diffSeconds);
            
            
            panel.clear();

            // gets the int "score" from CharacterHandler and draws it
            panel.drawScore(handler.getScore());
            //draws the current health of the player
            panel.drawHealth(avatar);
            // draws all GameCharacters
            panel.draw(handler.getList());

            
            panel.redraw();
        }
    }
    
    public void setGraphicPanel(GamePanel panel) {
        this.panel = panel;
    }
    
}
