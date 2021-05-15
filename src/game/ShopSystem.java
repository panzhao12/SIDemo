package game;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;

public class ShopSystem  {
	private InputSystem inputSystem;
	private Color btnColor = Color.black;
	private boolean released = true;
	protected ArrayList<Rectangle> shopArray;
	private boolean openShop;
	
	public ShopSystem(InputSystem inputSystem) {
		this.inputSystem = inputSystem;
		shopArray = new ArrayList<Rectangle>();
		shopArray.add(new Rectangle(10, 10, 50, 50));
		shopArray.add(new Rectangle(70,10, 50, 50));
	}
	Rectangle shopButton = new Rectangle(50, 500, 50, 50);
	
	public Rectangle getRect() {
		return shopButton;
	}
	public Color getColor() {
		return btnColor;
	}
	
	public void update() {
		if (inputSystem.mousePressed() && released) {
			released = false;
			if (shopButton.contains(inputSystem.mousePoint())) {
				if (btnColor == Color.red) btnColor = Color.black;
				else btnColor = Color.red;
			}
		}
		if (!inputSystem.mousePressed()) {
			released = true;
		}
		
		if (btnColor == Color.black) {
			openShop = false;
		}
		if (btnColor == Color.red) {
			openShop = true;
		}
	}
	
	public boolean openShop() {
		return openShop;
	}
	// Shop weapons and stuff
}
