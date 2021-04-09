package game;

import character.avatar.Avatar;
import character.enemy.Rookie;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameLoop {

    private GamePanel panel;
    private static Avatar avatar;
    private static Rookie rookie;

    //Initialize resource
    static {
        try {
            avatar = new Avatar(100, 100, 100);
            rookie = new Rookie(900, 100, 200, 100);
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                double x = e.getX();
                double y = e.getY();
                avatar.setDestination(x, y);
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

            panel.clear();
            panel.draw(avatar);
            panel.draw(rookie);
            panel.redraw();
        }
    }

    public void setGraphicPanel(GamePanel panel) {
        this.panel = panel;
    }
}
