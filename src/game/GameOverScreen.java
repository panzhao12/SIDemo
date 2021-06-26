package game;

import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;

public class GameOverScreen implements Screen {

	private InputSystem inputSystem;
	GameButton restartBtn;
	
	@Override
	public void update(GamePanel panel) 
    {
		inputSystem = panel.getInput();
		restartBtn  = new GameButton(A_Const.SCREEN_WIDTH / 2, A_Const.SCREEN_HEIGHT / 2, 60, 40, new Color(82,68,58), inputSystem);
		restartBtn.toggleColor = new Color(48,39,34);
		
		ImageIcon logo = new ImageIcon("sprites/endgame.png");
		Image img = logo.getImage();
		
		panel.setFocusable(true);
		panel.requestFocusInWindow();
		
		// Determine the high score
	    int highScore = 0;
	    File file = new File("./scores.txt");
	    try {
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line = reader.readLine();
	        
	        while (line != null)                 // Read the score file line by line
	        {
	            try {
	                int score = Integer.parseInt(line.trim());   // Parse each line as an int
	                if (score > highScore)                       // and keep track of the largest
	                { 
	                    highScore = score; 
	                }
	            } catch (NumberFormatException e1) {
	                // Ignore invalid scores
	                System.err.println("Ignoring invalid score: " + line);
	            }
	            
	            line = reader.readLine();
	        }
	        
	        reader.close();

	    } catch (IOException ex) {
	        System.err.println("ERROR reading scores from file");
	    }
		
	    // Append the last score to the end of the file
	    try {
	        BufferedWriter output = new BufferedWriter(new FileWriter(file, true));
	        output.append("" + game.RunningScreen.currentScore);
	        output.newLine();
	        output.close();

	    } catch (IOException ex1) {
	        System.out.printf("ERROR writing score to file: %s\n", ex1);
	    }
		
	    // Display Game Over screen
		while(true) {		
			panel.clear();
			panel.drawImage(img, A_Const.SCREEN_WIDTH / 2 - 200, 40);
			panel.drawCenteredBtn(restartBtn,"Retry");
			
			
			// Display the high score
		    if (game.RunningScreen.currentScore > highScore)
		    {    
		        panel.drawCenteredString("New high score!", restartBtn.y + 100);
		        panel.drawCenteredString("Your score: " + highScore, restartBtn.y + 150);
		    } else if (game.RunningScreen.currentScore == highScore) {
		    	panel.drawCenteredString("You tied the high score!", restartBtn.y + 100);
		    	panel.drawCenteredString("Your score: " + highScore, restartBtn.y + 150);
		    } else {
		    	panel.drawCenteredString("Highest score: " + highScore, restartBtn.y + 100);
		        panel.drawCenteredString("Your score: " + game.RunningScreen.currentScore, restartBtn.y + 150);
		    }
		    
		    panel.redraw();
			
			if(restartBtn.clicked()) { 
				Audio.playSound("audio/click.wav");
				break;
			}
			
		}
    }

}
