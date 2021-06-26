package game;

import character.GameCharacter;
import items.Items;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel implements GraphicService {

	private static final long serialVersionUID = 1L;
	public final int WIDTH = A_Const.SCREEN_WIDTH;
	public final int HEIGHT = A_Const.SCREEN_HEIGHT;

	private static final Font  font = new Font("Helvetica",Font.PLAIN,24);

	private static final Color UITextColor = new Color(200, 0, 100);


	private BufferedImage imageBuffer;
	private Graphics graphics;
	//private KeyInput keyInput = new KeyInput();
	private InputSystem inputSystem;

	public GamePanel() {
		this.setSize(WIDTH, HEIGHT);
		GraphicsConfiguration graphicsConf = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
		imageBuffer = graphicsConf.createCompatibleImage(this.getWidth(), this.getHeight());
		graphics = imageBuffer.getGraphics();
		inputSystem = new InputSystem();
		this.addKeyListener(inputSystem);
		this.addMouseListener(inputSystem);
		this.addMouseMotionListener(inputSystem);
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
	
	public void draw(ArrayList<GameCharacter> List) {
		for (int i = 0; i < List.size(); i++) draw(List.get(i));	
	}
	
	public void drawHealth(GameCharacter avatar, int x, int y) {
		int origX = x;
		int hp = avatar.getHealth();
		graphics.setColor(UITextColor);
		graphics.setFont(font);
		graphics.drawString("Health:", x, y);
		for (int i = 1; i-1 < hp; i++) {
			graphics.drawString("  \u2665", x+70, y);
			x+=20;
			if(i % 8 == 0) {
				y+=20;
				x=origX;
			}
		}
	}

	public void drawText(String string, int x, int y) {
		graphics.setColor(UITextColor);
		graphics.setFont(font);
		graphics.drawString(string, x, y);
	}
	
	public void drawCenteredString(String string, int y) {
	    // Draw a horizontally centered string on the screen
	    FontMetrics metrics = graphics.getFontMetrics(font);
	    int x = (WIDTH - metrics.stringWidth(string)) / 2;
	    graphics.setFont(font);
	    graphics.drawString(string, x, y);
	}
	
	public void drawCenteredBtn(GameButton r, String s) {
		int margin = 10;
		FontMetrics metrics = graphics.getFontMetrics(font);
	    r.setBounds((WIDTH - metrics.stringWidth(s)) / 2 - margin, r.y, metrics.stringWidth(s) + 2*margin, r.height);
	    graphics.setColor(r.getColor());
	    graphics.fill3DRect(r.x, r.y, r.width, r.height, true);
		graphics.setColor(UITextColor);
		drawCenteredString(s, r.y+2*r.height/3);
	}
	
	public void drawShopBtn(GameButton r) {
		graphics.setColor(r.getColor());
		graphics.fill3DRect(r.x, r.y, r.width, r.height,true);
		graphics.setColor(UITextColor);
		drawText("Shop",  r.x+r.width/30, r.y+4*r.height/6);
	}
	
	public void drawBtn(GameButton r, String s) {
		graphics.setColor(r.getColor());
		graphics.fill3DRect(r.x, r.y, r.width, r.height,true);
		graphics.setColor(UITextColor);
		drawText(s,  r.x+r.width/30, r.y+4*r.height/6);
	}
	
	public void drawShop(ArrayList<GameButton> rect) {
		Rectangle shopUI = new Rectangle(150,100,500,400);

		graphics.setColor(Color.gray);
		graphics.fillRect(shopUI.x, shopUI.y, shopUI.width, shopUI.height);
		for (int i=0; i<rect.size(); i++) {
			GameButton r = rect.get(i);
			graphics.setColor(r.getColor());
			graphics.fill3DRect(r.x, r.y, r.width, r.height,true);
		}
	}
	
	public void drawSelectedItem(Items selectedItem, GameButton pb) {
		graphics.setColor(UITextColor);
		graphics.drawString(selectedItem.getName(), 220, 240);
		graphics.drawString("Price: " + selectedItem.getPrice() , 220, 390);
		graphics.setColor(pb.getColor());
		graphics.drawImage(selectedItem.getImage(), 220, 260, null);
		graphics.fill3DRect(pb.x, pb.y, pb.width + 5, pb.height,true);
		graphics.setColor(UITextColor);
		drawText("Purchase", 401, 433);
	}
	
		public void drawImage(Image img, int x, int y) {
		
		graphics.drawImage(img, x, y, null);
		
	}
		
	public void clear() {
		graphics.setColor(new Color(184, 224, 180));
		graphics.fillRect(0, 0, WIDTH, HEIGHT);
	}

	
	public void redraw() {
		this.getGraphics().drawImage(imageBuffer, 0, 0, this);
	}
	public final InputSystem getInput() {
		return inputSystem;
	}

 }