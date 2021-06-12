package game;

import java.awt.Color;

public class GameOverScreen implements Screen {

	private InputSystem inputSystem;
	ShopButton restartBtn;
	
	@Override
	public void update(GamePanel panel) 
    {
		inputSystem = panel.getInput();
		restartBtn  = new ShopButton(A_Const.SCREEN_WIDTH / 2, A_Const.SCREEN_HEIGHT / 2, 60, 40, new Color(82,68,58), inputSystem);
		restartBtn.toggleColor = new Color(48,39,34);
		
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		
		while(true) {		
			panel.clear();
			
			panel.drawText("You died!", 380, 250);
			panel.drawStartBtn(restartBtn);
			panel.redraw();
			
			if(restartBtn.clicked()) { 
				break;
			}
			
		}
    }

}
