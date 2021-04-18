package game;

import character.GameObject;
import character.avatar.Avatar;
import character.avatar.Bullet;
import character.avatar.BulletHandler;
import character.enemy.Rookie;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.LinkedList;

public class GameLoop {

    private GamePanel panel;
    private static Avatar avatar;
    private static Rookie rookie;
    private BulletHandler bulletHandler;

    //Initialize resource
    static {
        try {
            avatar = new Avatar(100, 100, 100);
            rookie = new Rookie(900, 100, 200, 50);
        }catch(Exception e) {
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
			System.out.println(a.get(i).getBounds());
			System.out.println(b.getBounds());
    		if (a.get(i).getBounds().intersects(b.getBounds())) {
    			System.out.println(a.get(i).getBounds());
    			a.remove(i);
    		}
    	}
    	
    }
}
