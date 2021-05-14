package game;

import java.awt.Color;
import java.awt.Rectangle;

public class ShopSystem  {
	private InputSystem inputSystem;
	private Color color = Color.black;
	private boolean released = true;
	
	public ShopSystem(InputSystem inputSystem) {
		this.inputSystem = inputSystem;
	}
	Rectangle shopRect = new Rectangle(50, 500, 50, 50);
	
	public Rectangle getRect() {
		return shopRect;
	}
	public Color getColor() {
		return color;
	}
	
	public void update() {
		if (inputSystem.mousePressed() && released) {
			released = false;
			if (shopRect.contains(inputSystem.mousePoint())) {
				if (color == Color.red) {
					color = Color.black;
				}
				else {
					color = Color.red;
				}
			}
		}
		if (!inputSystem.mousePressed()) {
			released = true;
		}
	}
	// Shop weapons and stuff
}
