package game;

import character.GameCharacter;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	public final int WIDTH = A_Const.SCREEN_WIDTH;
	public final int HEIGHT = A_Const.SCREEN_HEIGHT;
	private static final Color UITextColor   = new Color(200, 0, 100);


	private BufferedImage imageBuffer;
	private Graphics graphics;
	//private KeyInput keyInput = new KeyInput();
	private KeyInput inputSystem = new KeyInput();


	public GamePanel() {
		this.setSize(WIDTH, HEIGHT);
		GraphicsConfiguration graphicsConf = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
		imageBuffer = graphicsConf.createCompatibleImage(this.getWidth(), this.getHeight());
		graphics = imageBuffer.getGraphics();
		this.addKeyListener(inputSystem);
	}

	public void clear() {
		graphics.setColor(new Color(184, 224, 180));
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
	}

	public void draw(GameCharacter gc) {
		int x = (int) (gc.getX() - gc.getRadius());
		int y = (int) (gc.getY() - gc.getRadius());
		int d = (int) (gc.getRadius() * 2);
		
		graphics.setColor(gc.color());
		graphics.fillOval(x, y, d, d);
		graphics.setColor(Color.BLACK);
		graphics.drawOval(x, y, d, d);
	}
	
	public void draw(LinkedList<GameCharacter> linkedList) {
		for (int i = 0; i < linkedList.size(); i++) {
			draw(linkedList.get(i));
		}
	}
	
	public void drawHealth(GameCharacter avatar, int x, int y) {
		int origX = x;
		int hp = avatar.getHealth();
		graphics.setColor(UITextColor);
		graphics.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		graphics.drawString("Health: ", x, y);
		for (int i = 1; i-1 < hp; i++) {
			graphics.drawString("\u2665", x+70, y);
			x+=20;
			if(i % 8 == 0) {
				y+=20;
				x=origX;
			}
		}
	}

	public void drawText(String string, int x, int y) {
		graphics.setColor(UITextColor);
		graphics.setFont(new Font("TimesRoman", Font.PLAIN, 24));
		graphics.drawString(string, x, y);
	}

	public void redraw() {
		this.getGraphics().drawImage(imageBuffer, 0, 0, this);
	}
	public final KeyInput getKeyInput() {
		return inputSystem;
	}
	
}
