package game;

import character.GameCharacter;
import character.avatar.Bullet;
import character.enemy.Rookie;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class GamePanel extends JPanel implements GraphicService, ControlService, MouseListener {

    public final static int WIDTH = 800;
    public  final static int HEIGHT = 600;

    private BufferedImage imageBuffer;
    private Graphics      graphics;

    public GamePanel() {
        this.setSize(WIDTH, HEIGHT);
        GraphicsConfiguration graphicsConf = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        imageBuffer = graphicsConf.createCompatibleImage(this.getWidth(), this.getHeight());
        graphics = imageBuffer.getGraphics();
    }

    public void clear() {
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
    }

    public void draw(GameCharacter character) {
        graphics.setColor(new Color(96,96,100));
        graphics.fillOval((int)character.x, (int)character.y, 20 * 2, 20 * 2);
    }
    public void drawRookie(LinkedList<Rookie> rookieList) {
    	for(int i=0;i < rookieList.size(); i++) {
            graphics.setColor(new Color(96,96,100));
            graphics.fillOval((int)rookieList.get(i).x, (int)rookieList.get(i).y, 20 * 2, 20 * 2);
    	}
    }
    public void drawBullet(LinkedList<Bullet> bulletList) {
    	for (int i=0;i<bulletList.size();i++) {
    		graphics.setColor(new Color(100,100,50));
    		graphics.fillRect((int)bulletList.get(i).x, (int)bulletList.get(i).y, 10, 5);
    	}
    }
    
    public void drawHealth(GameCharacter a) {
    	int hp = a.getHealth();
    	int x = 80;
    	graphics.setColor(new Color(200,0,100));
    	graphics.setFont(new Font("TimesRoman", Font.PLAIN, 24));
    	graphics.drawString("Health: ", 10, 40);
    	for(int i=0; i<hp; i++) {
    		graphics.drawString("\u2665", x, 40);
    		x += 20;
    	}
    }
    @Override
    public void redraw() {
        this.getGraphics().drawImage(imageBuffer, 0, 0, this);
    }

    @Override
    public GameControl getUserInput() {
        return null;
    }

    @Override
    public void command() {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    	
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
