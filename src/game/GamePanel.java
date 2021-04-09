package game;

import character.GameCharacter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements GraphicService, ControlService, MouseListener {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 600;

    private BufferedImage imageBuffer;
    private Graphics      graphics;

    public GamePanel() {
        this.setSize(WIDTH, HEIGHT);
        GraphicsConfiguration graphicsConf = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
        imageBuffer = graphicsConf.createCompatibleImage(this.getWidth(), this.getHeight());
        graphics = imageBuffer.getGraphics();
    }

    @Override
    public void clear() {
        graphics.setColor(Color.LIGHT_GRAY);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
    }

    @Override
    public void draw(GameCharacter character) {
        graphics.setColor(new Color(96,96,100));
        graphics.fillOval((int)character.x, (int)character.y, 20 * 2, 20 * 2);
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
