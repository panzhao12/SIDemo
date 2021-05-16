package game;

import java.awt.Color;
import java.util.ArrayList;

import items.Gun;
import items.Items;

public class ShopSystem {
	private InputSystem inputSystem;
	protected ArrayList<Items> itemArray;
	protected ArrayList<ShopButton> btnArray;
	protected Items selectedItem;
	protected boolean openShop;
	ShopButton shopBtn;
	ShopButton purchaseBtn;



	public ShopSystem(InputSystem inputSystem) {
		this.inputSystem = inputSystem;
		
		//create an item array with items in it
		itemArray = new ArrayList<Items>();
		itemArray.add(new Gun("Machine gun", 1000, 1, 5));
		itemArray.add(new Gun("Revolver", 500, 2, 2));
		
		//shop button that opens and closes the shop
		shopBtn  = new ShopButton(50, 500, 50, 50, Color.blue, inputSystem);
		purchaseBtn = new ShopButton(400, 400, 100, 50, Color.yellow, inputSystem);
		btnArray = new ArrayList<ShopButton>();
		
		//initial coordinates for the buttons to fit into the "shop screen"
		int x = 170;
		int y = 120;
		
		//create the buttons for items in the shop
		for (int i = 0; i < itemArray.size(); i++) {
			btnArray.add(new ShopButton(x, y, 50, 50, Color.blue, inputSystem));
			x += 80;
		}
	}
	
	//gets called every frame
	public void update() {
		openShop();
		if (openShop) selectItem();
	}

	//select an item in the shop
	private void selectItem() {
		for (int i = 0; i < itemArray.size(); i++) {
				btnArray.get(i).toggle();
				if (btnArray.get(i).contains(inputSystem.mousePoint())) {
					
					//unselect all other shopButtons
					for (int j = 0; j < btnArray.size(); j++) {
						if (btnArray.get(j) == btnArray.get(i)) continue;
						btnArray.get(j).color = btnArray.get(j).iniColor;
						btnArray.get(j).toggled = false;
					}
					
					//set selectedItem as the item being clicked on
					if (btnArray.get(i).toggled) selectedItem = itemArray.get(i);
					else selectedItem = null;
			}
		}
	}
	
	private void purchaseItem() {
		if (selectedItem != null) {
			purchaseBtn.toggle();
			
		}
	}

	//open or close the shop screen
	private void openShop() {
		shopBtn.toggle();
		if (shopBtn.color == shopBtn.iniColor) openShop = false;
		else openShop = true;
	}
	
	private void removeItem(int i) {
		if (i < 0 || i > itemArray.size()) return;
		itemArray.remove(i);
		btnArray.remove(i);
	}

	public boolean getOpenShop() {
		return openShop;
	}
	
	public Items getSelected() {
		return selectedItem;
	}
	// Shop weapons and stuff
}
