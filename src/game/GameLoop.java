package game;

import character.avatar.Avatar;
import character.avatar.Bullet;
import character.avatar.BulletHandler;
import character.enemy.EnemyHandler;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
public class GameLoop {


  private GamePanel panel;
	private Avatar avatar;
	private BulletHandler bulletHandler;
	private EnemyHandler enemyHandler;
	private double dx;
	private double dy;
	public void run() {
		bulletHandler = new BulletHandler();
		// creates RookieHandler + all rookies specified in the constructor
		enemyHandler = new EnemyHandler();
		avatar = new Avatar(100, 100, 3);

		MouseAdapter mouseAdapter = new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				bulletHandler.addObject(new Bullet(avatar.x + avatar.getRadius(), avatar.y, 300, 1));
			}
		};
		panel.addMouseListener(mouseAdapter);
		panel.addMouseMotionListener(mouseAdapter);
		

        KeyAdapter keyAdapter = new KeyAdapter() {
        	public void keyPressed(KeyEvent e) {
        		int key = e.getKeyCode();

                if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                    dx = -0.5;
                }

                if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                    dx = 0.5;
                }

                if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
                    dy = -0.5;
                }

                if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                    dy = 0.5;
                }

                if (key == KeyEvent.VK_SPACE) {
                	bulletHandler.addObject(new Bullet(avatar.x+20, avatar.y+20, 200, 1));
                }

        	}

        	public void keyReleased(KeyEvent e) {
        		int key = e.getKeyCode();

                if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) {
                    dx = 0;
                }

                if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
                    dx = 0;
                }

                if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W) {
                    dy = 0;
                }

                if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
                    dy = 0;
                }
        	}
        };
        panel.addKeyListener(keyAdapter);

        panel.setFocusable(true);
        panel.requestFocusInWindow();
    
        long lastTick = System.currentTimeMillis();

        while (true) {
            long currentTick = System.currentTimeMillis();
            double diffSeconds = (currentTick-lastTick) / 1000.0;
            lastTick = currentTick;
            
            // 40 was defined as the avatar's (circle) diameter 
            // where (x,y) is the upper left corner
            if(avatar.x >= 0 && avatar.x <= GamePanel.WIDTH - 40 && 
            		avatar.y >= 0 && avatar.y <= GamePanel.HEIGHT - 40) {
            	avatar.setDestination(avatar.x + dx, avatar.y + dy);
            } else if(avatar.x < 0){
            	avatar.setDestination(0, avatar.y);
            } else if(avatar.x > GamePanel.WIDTH - 40){
            	avatar.setDestination(GamePanel.WIDTH - 40, avatar.y);
            } else if(avatar.y < 0){
            	avatar.setDestination(avatar.x, 0);
            } else if(avatar.y > GamePanel.HEIGHT - 40){
            	avatar.setDestination(avatar.x, GamePanel.HEIGHT - 40);
            }
                 
            // move array of rookies
            enemyHandler.move(diffSeconds);
            // move array of bullets
            bulletHandler.move(diffSeconds);
            avatar.collisionCheck(enemyHandler.getList());
            bulletHandler.collisionCheckEnemy(enemyHandler.getList());
            panel.clear();
            panel.draw(avatar);
            panel.drawHealth(avatar);
            // gets the int "score" from rookieHandler and draws it
            panel.drawScore(enemyHandler.getScore());
            // draws all enemies
            panel.drawEnemy(enemyHandler.getList());
            // draws all bullets
            panel.drawBullet(bulletHandler.getList());

            panel.redraw();
        }
    }
    
    public void setGraphicPanel(GamePanel panel) {
        this.panel = panel;
    }
}
