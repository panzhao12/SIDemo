package game;

import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import items.Items;
import items.MachineGun;

public class ShopSystem {
	Rectangle shopButton = new Rectangle(50, 500, 50, 50);
	private InputSystem inputSystem;
	private Color btnColor = Color.black;
	private boolean released = true, selected = false;
	protected ArrayList<Rectangle> shopArray;
	protected ArrayList<Items> itemArray;
	protected boolean openShop;

	public ShopSystem(InputSystem inputSystem) {
		this.inputSystem = inputSystem;

		shopArray = new ArrayList<Rectangle>();
		itemArray = new ArrayList<Items>();

		shopArray.add(new Rectangle(160, 110, 50, 50));
		shopArray.add(new Rectangle(230, 110, 50, 50));

		itemArray.add(new MachineGun());
		itemArray.add(new MachineGun());

	}

	public Rectangle getRect() {
		return shopButton;
	}

	public Color getColor() {
		return btnColor;
	}

	public void update() {
		openShop();
		if (openShop)
			selectItem();
	}

	private void selectItem() {
		if (inputSystem.mousePressed() && !selected) {
			for (int i = 0; i < shopArray.size(); i++) {
				if (shopArray.get(i).contains(inputSystem.mousePoint())) {
					System.out.println(itemArray.get(i).getName());
					selected = true;
				}
			}
		} if (!inputSystem.mousePressed())
			selected = false;
	}

	private void openShop() {
		if (inputSystem.mousePressed() && released) {
			released = false;
			if (shopButton.contains(inputSystem.mousePoint())) {
				if (btnColor == Color.red)
					btnColor = Color.black;
				else
					btnColor = Color.red;
			}
		}
		if (!inputSystem.mousePressed())
			released = true;
		if (btnColor == Color.black)
			openShop = false;
		if (btnColor == Color.red)
			openShop = true;
	}

	public boolean getOpenShop() {
		return openShop;
	}
	// Shop weapons and stuff
}
