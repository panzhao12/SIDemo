package game;

import character.avatar.Avatar;
import character.avatar.Bullet;
import character.avatar.BulletHandler;
import character.enemy.Rookie;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class GameLoop {

    private GamePanel panel;
    private static Avatar avatar;
    private static Rookie rookie;
    private BulletHandler bulletHandler;
    
    private double dx;
    private double dy;

    //Initialize resource
    static {
        try {
            avatar = new Avatar(100, 100, 100);
            rookie = new Rookie(900, 100, 200, 50);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
    	bulletHandler = new BulletHandler();

        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                double x = e.getX();
                double y = e.getY();
                //avatar.setDestination(x-20, y-20);
            } 
            public void mouseClicked(MouseEvent e) {
            	bulletHandler.addObject(new Bullet(avatar.x+20, avatar.y+20, 200, 1));
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
            
           
            rookie.move(diffSeconds);
            bulletHandler.move(diffSeconds);
            collision(bulletHandler.getList(), rookie);
            panel.clear();
            
            panel.draw(avatar);
            panel.draw(rookie);
            panel.draw(bulletHandler.getList());
            
            panel.redraw();
        }
    }
    
    public void setGraphicPanel(GamePanel panel) {
        this.panel = panel;
    }
    public void collision(LinkedList<Bullet> a, Rookie b) {
    	for (int i = 0;i<a.size();i++) {
    		if (a.get(i).getBounds().intersects(b.getBounds())) {
    			a.remove(i);
    		}
    	}
    	
    }
}
