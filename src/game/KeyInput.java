package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	private boolean up = false, down = false, left = false, right = false, space = false;

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_W:		up 		= true;	break;
		case KeyEvent.VK_S:		down 	= true;	break;
		case KeyEvent.VK_A:		left 	= true;	break;
		case KeyEvent.VK_D:		right	= true; break;
		case KeyEvent.VK_SPACE:	space	= true; break;
		case KeyEvent.VK_UP:	up		= true;	break;
		case KeyEvent.VK_DOWN:	down 	= true;	break;
		case KeyEvent.VK_LEFT:	left	= true;	break;
		case KeyEvent.VK_RIGHT:	right 	= true;	break;
		}
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_W:		up	 	= false; break;
		case KeyEvent.VK_S:		down 	= false; break;
		case KeyEvent.VK_A:		left 	= false; break;
		case KeyEvent.VK_D:		right 	= false; break;
		case KeyEvent.VK_SPACE:	space 	= false; break;
		case KeyEvent.VK_UP:	up 		= false; break;
		case KeyEvent.VK_DOWN:	down 	= false; break;
		case KeyEvent.VK_LEFT:	left 	= false; break;
		case KeyEvent.VK_RIGHT:	right 	= false; break;
		}
	}

	public boolean isUp() {
		return up;
	}

	public boolean isDown() {
		return down;
	}

	public boolean isLeft() {
		return left;
	}

	public boolean isRight() {
		return right;
	}

	public boolean isSpace() {
		return space;
	}
}
