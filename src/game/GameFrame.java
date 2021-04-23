package game;

import javax.swing.*;

public class GameFrame extends JFrame {

    private GamePanel panel = null;

    public GameFrame() {
        // needed for Keyboard input
        //this.setFocusable(true);
        //this.requestFocusInWindow();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(GamePanel.WIDTH, GamePanel.HEIGHT);

        panel = new GamePanel();
        this.setContentPane(panel);
    }
    public int getWidth() {
    	return panel.getWidth();
    }
    public GamePanel getPanel() {return panel;}
}
