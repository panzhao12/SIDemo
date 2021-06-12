package game;

public class GameLoop {

	//private State state = State.RUNNING;
	protected State state = State.START;
	private GamePanel panel;

    public void run()
    {
    	StartScreen startScrn = new StartScreen();
    	RunningScreen runScrn = new RunningScreen();
    	GameOverScreen gmOvScrn = new GameOverScreen();
    	while(true) {
    		switch(state) {
            case START:
                startScrn.update(panel);
                state = State.RUNNING;
                break;
            case RUNNING:
                runScrn.update(panel);
                state = State.GAME_OVER;
                break;
            case GAME_OVER:
            	gmOvScrn.update(panel);
            	state = State.RUNNING;
            	break;
            default:
                throw new RuntimeException("Unknown state: " + state);
            }
    	}
    	
        
    }
		
    public void setGraphicPanel(GamePanel panel) {
		this.panel = panel;
	}
}
