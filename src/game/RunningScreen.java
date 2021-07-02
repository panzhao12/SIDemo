package game;

import java.awt.Image;
import javax.swing.ImageIcon;


import character.CharacterHandler;


public class RunningScreen implements Screen {
	
	private CharacterHandler handler;
	private double time;
	private int frames, fps, maxWaves;
	private ShopSystem shop;
	private InputSystem inputSystem;
	protected static int currentScore;
	
	@Override
	public void update(GamePanel panel) 
    {
		inputSystem = panel.getInput();
		handler = new CharacterHandler(inputSystem);
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		SpriteHandler sh = new SpriteHandler(4);
		shop = new ShopSystem(inputSystem, handler);
		ImageIcon logo = new ImageIcon("sprites/bckgrd.gif");
		Image img = logo.getImage();
		maxWaves = handler.maxWaves();
		
		long lastTick = System.currentTimeMillis();
		while (true) {
			long currentTick = System.currentTimeMillis();
			double diffSeconds = (currentTick - lastTick) / 1000.0;
			lastTick = currentTick;			
			// moves all GameCharacters
			shop.update();
			
			if (maxWaves == handler.getWaveCounter()) {
				currentScore = handler.getPoints();
				break;
			}
			if (!shop.getOpenShop()) {
				handler.move(diffSeconds);
			}
			//shop.update();
			panel.clear();
			panel.drawImage(img, 0, 0);
			// gets the int "score" from CharacterHandler and draws it
			panel.drawText("Credits: " + handler.getScore(), 30, 40);
			//draws fps on screen
			panel.drawText("FPS: " + fps, 250, 40);
			// draws the current health of the player
			panel.drawHealth(handler.getAvatar(), 30, 80);
			panel.drawText("Wave: " + handler.getWaveCounter(), 400, 40);
			// draws all GameCharacters
			panel.draw(handler.getList());
			if (shop.getOpenShop()) {
				panel.drawShop(shop.btnArray);
				if (shop.selectedItem != null) {
					panel.drawSelectedItem(shop.selectedItem, shop.purchaseBtn, sh);
				}
			}
			panel.drawShopBtn(shop.shopBtn);
			panel.redraw();
			
			if(handler.getAvatar().getHealth() == 0) {
				currentScore = handler.getPoints();
				break;
			}
			
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

}
