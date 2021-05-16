package game;

import character.CharacterHandler;

public class GameLoop {

	private GamePanel panel;
	private InputSystem inputSystem;
	private CharacterHandler handler;
	private double time;
	private int frames, fps;
	private ShopSystem shop;
	
	public void run() {
		inputSystem = panel.getInput();
		handler = new CharacterHandler(inputSystem);
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		shop = new ShopSystem(inputSystem, handler);

		long lastTick = System.currentTimeMillis();
		while (true) {
			long currentTick = System.currentTimeMillis();
			double diffSeconds = (currentTick - lastTick) / 1000.0;
			lastTick = currentTick;			
			// moves all GameCharacters
			shop.update();

			if (!shop.getOpenShop()) {
				handler.move(diffSeconds);
			}
			//shop.update();
			panel.clear();
			// gets the int "score" from CharacterHandler and draws it
			panel.drawText("Score: " + handler.getScore(), 30, 40);
			//draws fps on screen
			panel.drawText("FPS: " + fps, 250, 40);
			// draws the current health of the player
			panel.drawHealth(handler.getAvatar(), 30, 80);
			panel.drawText("Wave: " + handler.getWaveCounter(), 350, 40);
			// draws all GameCharacters
			panel.draw(handler.getList());
			if (shop.getOpenShop()) {
				panel.drawShop(shop.btnArray);
				if (shop.selectedItem != null) {
					panel.drawSelectedItem(shop.selectedItem, shop.purchaseBtn);
				}
			}
			panel.drawShopBtn(shop.shopBtn);
			panel.redraw();
			//counts the frames per second that you are running at
			fpsCount(diffSeconds);
		}
	}
	
	private void fpsCount(double diffSeconds) {
		time += diffSeconds;
		frames++;
		if (time >= 1) {
			fps = frames;
			frames = 0;
			time = 0;
		}
	}
 
	public void setGraphicPanel(GamePanel panel) {
		this.panel = panel;
	}
}
