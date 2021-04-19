package game;

import character.GameCharacter;
import character.avatar.Avatar;
import character.avatar.Bullet;
import character.avatar.BulletHandler;
import character.enemy.Rookie;
import character.enemy.RookieHandler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class GameLoop {

    private GamePanel panel;
    private Avatar avatar;
    private BulletHandler bulletHandler;
    private RookieHandler rookieHandler;

    //Initialize resource

    public void run() {
    	bulletHandler = new BulletHandler();
    	rookieHandler = new RookieHandler();
    	
    	rookieHandler.addObject(new Rookie(900, 100, 5, 50));
    	rookieHandler.addObject(new Rookie(900, 300, 5, 50));
    	rookieHandler.addObject(new Rookie(800, 200, 5, 100));
    	rookieHandler.addObject(new Rookie(800, 400, 5, 50));
    	rookieHandler.addObject(new Rookie(1200, 400, 5, 50));

    	avatar = new Avatar(100, 100, 3);

        MouseAdapter mouseAdapter = new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                double x = e.getX();
                double y = e.getY();
                avatar.setDestination(x-20, y-20);
            } 
            public void mouseClicked(MouseEvent e) {
            	bulletHandler.addObject(new Bullet(avatar.x+40, avatar.y+20, 300, 1));
            }
        };
        panel.addMouseListener(mouseAdapter);
        panel.addMouseMotionListener(mouseAdapter);
        
        long lastTick = System.currentTimeMillis();

        while (true) {
            long currentTick = System.currentTimeMillis();
            double diffSeconds = (currentTick-lastTick) / 1000.0;
            lastTick = currentTick;
            //move array of rookies
            rookieHandler.move(diffSeconds);
            //move array of bullets
            bulletHandler.move(diffSeconds);
            collisionCheckBullet(rookieHandler.getList());
            collisionCheckRookie(avatar);
            rookieHandler.checkHealth();
            panel.clear();
            panel.draw(avatar);
            panel.drawRookie(rookieHandler.getList());
            panel.drawBullet(bulletHandler.getList());
            
            panel.redraw();
        }
    }
    
    public void setGraphicPanel(GamePanel panel) {
        this.panel = panel;
    }
    
    //checks whether any bullet is making collision with a Rookie
    public void collisionCheckBullet(LinkedList<Rookie> a) {
    	for(int i=0;i<a.size();i++) {
    		bulletHandler.collisionCheck(a.get(i));
    	}
    }
    public void collisionCheckRookie(GameCharacter a) {
    	rookieHandler.collisionCheck(a);
    	
    }
}
