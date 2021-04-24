package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {
	private boolean up = false, down = false, left = false, right = false, space = false;

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP)
			
			up = true;

		if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN)
			down = true;

		if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT)
			left = true;

		if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT)
			right = true;
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		if (key == KeyEvent.VK_W || key == KeyEvent.VK_UP)
			up = false;

		if (key == KeyEvent.VK_S || key == KeyEvent.VK_DOWN)
			down = false;

		if (key == KeyEvent.VK_A || key == KeyEvent.VK_LEFT)
			left = false;

		if (key == KeyEvent.VK_D || key == KeyEvent.VK_RIGHT)
			right = false;
		if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_E)
			space = true;
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
	public void setSpace() {
		space = !space;
	}
}
