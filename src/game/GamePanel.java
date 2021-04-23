package game;

import character.GameCharacter;
import character.avatar.Bullet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class GamePanel extends JPanel implements GraphicService, ControlService, MouseListener, KeyListener {

    public final static int WIDTH = 800;
    public final static int HEIGHT = 600;

    private BufferedImage imageBuffer;
    private Graphics      graphics;
    

    public GamePanel() {
        this.setSize(WIDTH, HEIGHT);
        GraphicsConfiguration graphicsConf = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        imageBuffer = graphicsConf.createCompatibleImage(this.getWidth(), this.getHeight());
        graphics = imageBuffer.getGraphics();
    }

    public void clear() {
        graphics.setColor(new Color(184,224,180));
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
    }

    public void draw(GameCharacter character) {
        graphics.setColor(new Color(96,96,100));
        graphics.fillOval((int)character.x, (int)character.y, 20 * 2, 20 * 2);
    }
    public void draw(LinkedList<Bullet> bulletList) {
    	for (int i=0;i<bulletList.size();i++) {
    		graphics.setColor(new Color(100,100,50));
    		graphics.fillRect((int)bulletList.get(i).x, (int)bulletList.get(i).y, 10, 5);
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
    public void command(GameCharacter av, GameControl userInput) {
    	
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

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
