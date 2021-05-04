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

	public final int WIDTH = 800;
	public final int HEIGHT = 600;

	private BufferedImage imageBuffer;
	private Graphics graphics;

	public GamePanel() {
		this.setSize(WIDTH, HEIGHT);
		GraphicsConfiguration graphicsConf = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
		imageBuffer = graphicsConf.createCompatibleImage(this.getWidth(), this.getHeight());
		graphics = imageBuffer.getGraphics();
	}

	public void clear() {
		graphics.setColor(new Color(184, 224, 180));
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
	}

	public void draw(GameCharacter gc) {
		int x = (int) (gc.x - gc.radius);
		int y = (int) (gc.y - gc.radius);
		int d = (int) (gc.radius * 2);
		
		graphics.setColor(gc.color);
		graphics.fillOval(x, y, d, d);
		graphics.setColor(Color.BLACK);
		graphics.drawOval(x, y, d, d);
	}
	
	public void draw(LinkedList<GameCharacter> linkedList) {
		for (int i = 0; i < linkedList.size(); i++) {
			draw(linkedList.get(i));
		}
	}

	public void drawBullet(LinkedList<Bullet> bulletList) {
		for (int i = 0; i < bulletList.size(); i++) {
			draw(bulletList.get(i));
		}
	}

	public void drawHealth(GameCharacter avatar) {
		int hp = avatar.getHealth();
		int x = 100;
		graphics.setColor(new Color(200, 0, 100));
		graphics.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		graphics.drawString("Health: ", x - 70, 40);
		for (int i = 0; i < hp; i++) {
			graphics.drawString("\u2665", x, 40);
			x += 20;
		}
	}

	public void drawScore(int score) {
		graphics.setColor(new Color(200, 0, 100));
		graphics.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		graphics.drawString("Score:" + score, 600, 40);
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
