package fortpex;

import java.awt.event.KeyEvent;

public class Player extends Sprite {

	
	public enum directionFacing {
		NORTH, EAST, SOUTH, WEST 
		}
	public directionFacing direction;
	
	
	
	public Player(int x, int y, String imageLocation) {
		super(x, y, imageLocation);
		// TODO Auto-generated constructor stub
	}

	
	public directionFacing getDirection() {
		return direction;
	}

	public void move() {
		x += dx;
		y += dy;
		
		
		if ( x  > 900 ) {
			x = 900  ; 
			dx = 0;	
	
			
		}
		if (x < 1) {
			x = 1;
			dx = 0;
		}
		if (y < 1) {
			y = 1;
			dy = 0;
		}
		if (y > 650) {
			y = 650;
			dy = 0;
		}
	}	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			dx = -4;
			direction = directionFacing.WEST;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 4;
			direction = directionFacing.EAST;
		}

		if (key == KeyEvent.VK_UP) {
			dy = -4;
			direction = directionFacing.NORTH;
		}

		if (key == KeyEvent.VK_DOWN) {
			dy = 4;
			direction = directionFacing.SOUTH;
		}
	}
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			dx = 0;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 0;
		}

		if (key == KeyEvent.VK_UP) {
			dy = 0;
		}

		if (key == KeyEvent.VK_DOWN) {
			dy = 0;
		}
	}
	
		
}
