package game;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;

public class GameOverScreen implements Screen {

	private InputSystem inputSystem;
	ShopButton restartBtn;
	
	@Override
	public void update(GamePanel panel) 
    {
		inputSystem = panel.getInput();
		restartBtn  = new ShopButton(A_Const.SCREEN_WIDTH / 2, A_Const.SCREEN_HEIGHT / 2, 60, 40, new Color(82,68,58), inputSystem);
		restartBtn.toggleColor = new Color(48,39,34);
		
		ImageIcon logo = new ImageIcon("sprites/endgame.png");
		Image img = logo.getImage();
		
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		
		while(true) {		
			panel.clear();
			panel.drawImage(img, 205,40);
			panel.drawBtn(restartBtn,"Retry");
			panel.redraw();
			
			if(restartBtn.clicked()) { 
				Audio.playSound("audio/click.wav");
				break;
			}
			
		}
    }

}
