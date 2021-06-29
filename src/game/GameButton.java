package game;

import java.awt.*;


public class GameButton extends Rectangle  {

	private static final long serialVersionUID = 1L;

	private InputSystem input;
	protected Color color, iniColor, toggleColor;
	private boolean released = true;
	boolean toggled = false;
	
	GameButton(int x, int y, int width, int height, Color color, InputSystem input) {
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
			Point mousePoint = input.mousePoint();
			if (mousePoint != null && contains(mousePoint)) {
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

	public void setReleased(boolean released) {
		this.released = released;
	}
}
