package game;

import java.awt.Dimension;

import javax.swing.*;

public class GameFrame extends JFrame {

	private GamePanel panel = new GamePanel();

	public GameFrame() {
		// needed for Keyboard input
		// this.setFocusable(true);
		// this.requestFocusInWindow();

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// this.setSize(GamePanel.WIDTH, GamePanel.HEIGHT);

		ImageIcon gameIcon = new ImageIcon("src/icon_220.png");
		setIconImage(gameIcon.getImage());

		setTitle("Space Impact Demo");
		panel = new GamePanel();
		this.setContentPane(panel);

		// Set the actual dimension for GamePanel
		this.getContentPane().setPreferredSize(new Dimension(panel.WIDTH, panel.HEIGHT));
		this.pack();

	}

	public int getWidth() {
		return panel.getWidth();
	}

	public GamePanel getPanel() {
		return panel;
	}
}
