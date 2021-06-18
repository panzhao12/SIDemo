package game;

import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class StartScreen extends GameLoop implements Screen {
	
	private InputSystem inputSystem;
	ShopButton startBtn;
	
	@Override
	public void update(GamePanel panel) 
    {
		inputSystem = panel.getInput();
		startBtn  = new ShopButton(A_Const.SCREEN_WIDTH / 2, A_Const.SCREEN_HEIGHT / 2, 60, 40, new Color(82,68,58), inputSystem);
		startBtn.toggleColor = new Color(48,39,34);
		
		ImageIcon logo = new ImageIcon("sprites/logo.png");
		Image img = logo.getImage();
		
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		
	
		while(true) {		
			panel.clear();
			panel.setLayout(null);
			panel.drawStartBtn(startBtn);
			panel.drawImage(img, 280,100);
			panel.redraw();
			
			if(startBtn.clicked()) { 
				break;
			}
			
		}
    }
}
