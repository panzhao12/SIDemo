package game;

import java.awt.Color;

public class StartScreen extends GameLoop implements Screen {
	
	private InputSystem inputSystem;
	ShopButton startBtn;
	
	@Override
	public void update(GamePanel panel) 
    {
		inputSystem = panel.getInput();
		startBtn  = new ShopButton(A_Const.SCREEN_WIDTH / 2, A_Const.SCREEN_HEIGHT / 2, 60, 40, new Color(82,68,58), inputSystem);
		startBtn.toggleColor = new Color(48,39,34);
		
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		
		while(true) {		
			panel.clear();
			
			panel.drawText("Space Impact (demo)", 310, 200);
			panel.drawStartBtn(startBtn);
			panel.redraw();
			
			if(startBtn.clicked()) { 
				break;
			}
			
		}
    }
}
