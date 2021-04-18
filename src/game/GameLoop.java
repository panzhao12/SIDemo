package game;

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
    private static Avatar avatar;
    private BulletHandler bulletHandler;
    private RookieHandler rookieHandler;

    //Initialize resource
    static {
        try {
            avatar = new Avatar(100, 100, 100);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
    	bulletHandler = new BulletHandler();
    	rookieHandler = new RookieHandler();
    	rookieHandler.addObject(new Rookie(900, 100, 5, 50));
    	rookieHandler.addObject(new Rookie(900, 50, 5, 50));
    	rookieHandler.addObject(new Rookie(800, 80, 5, 50));
    	rookieHandler.addObject(new Rookie(800, 60, 5, 50));


        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                double x = e.getX();
                double y = e.getY();
                avatar.setDestination(x-20, y-20);
            } 
            public void mouseClicked(MouseEvent e) {
            	bulletHandler.addObject(new Bullet(avatar.x+20, avatar.y+20, 200, 1));
            }
        };
        panel.addMouseListener(mouseAdapter);
        panel.addMouseMotionListener(mouseAdapter);
        
        long lastTick = System.currentTimeMillis();

        while (true) {
            long currentTick = System.currentTimeMillis();
            double diffSeconds = (currentTick-lastTick) / 1000.0;
            lastTick = currentTick;

            rookieHandler.move(diffSeconds);
//            rookie.move(diffSeconds);
            //move array of bullets
            bulletHandler.move(diffSeconds);
            collisionCheck(bulletHandler.getList(), rookieHandler.getList());
            checkHealth(rookieHandler.getList());
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
    public void collisionCheck(LinkedList<Bullet> a, LinkedList<Rookie> b) {
    	for (int i = 0;i<a.size();i++) {
    		for (int j=0;j<b.size(); j++) {
    			//check if the collision boxes of any bullets and rookies overlap
        		if (a.get(i).getBounds().intersects(b.get(j).getBounds())) {
        			//first deal damage and then remove bullet from array
        			b.get(j).setLife((b.get(j).getLife()-a.get(i).getDamage()));
        			a.remove(i);
        			return;
        		}

    		}
    	
    	}
    }
    //checks whether any Rookies have died and removes them
    public void checkHealth(LinkedList<Rookie> b) {
    	for(int i=0; i<b.size(); i++) {
    		if (b.get(i).death()) {
    			b.remove(i);
    		}
    	}
     }
}
