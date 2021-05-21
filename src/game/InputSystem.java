package game;

import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class InputSystem extends KeyAdapter implements MouseListener, MouseMotionListener {
	private boolean up = false, down = false, left = false, right = false, space = false, mousePressed = false, inside = false;
	private double mouseX, mouseY;
	private Point mousePoint;
	public boolean mouseClicked;

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
 
	public double MouseX() {
		return mouseX;
	}
	
	public double MouseY() {
		return mouseY;
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		mousePressed = true;	
		mousePoint = e.getPoint();
		mouseX = e.getX();
		mouseY = e.getY();
	}
	
	public Point mousePoint() {
		return mousePoint;
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		mousePressed = false;
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
	
	public boolean mousePressed() {
		return mousePressed;
	}
	
	public boolean inside() {
		return inside;
	}
	public void mouseClicked(MouseEvent e) {
	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		inside = true;
	}

	@Override
	public void mouseExited(MouseEvent e) {
		inside = false;
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

}
