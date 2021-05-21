package game;

import java.awt.Color;
import java.awt.Rectangle;

public class ShopButton extends Rectangle {

	private static final long serialVersionUID = 1L;

	private InputSystem input;
	protected Color color, iniColor, toggleColor;
	private boolean released = true;
	boolean toggled = false;
	
	ShopButton(int x, int y, int width, int height, Color color, InputSystem input) {
		super(x, y, width, height);
		this.color = color;
		iniColor = color;
		this.input = input;
		toggleColor = Color.red;
	}
	
	//check if a Button has been clicked
	public boolean clicked() {
		if (input.mousePressed() && released) {
			released = false;
			if (contains(input.mousePoint())) {
				return true;
			}
		}
		if (!input.mousePressed()) released = true;
		return false;
	}

	//Toggle the colour of the button
	public void toggle() {
		toggled = !toggled;
		if (toggled) {
			color = toggleColor;
		} else
			color = iniColor;
	}

	public Color getColor() {
		return color;
	}
}
