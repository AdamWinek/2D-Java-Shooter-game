package fortpex;

import java.awt.event.KeyEvent;

import fortpex.Player.directionFacing;


public class Bullet extends Sprite {
	

	boolean hasShot = false;
	public Bullet(int x, int y, String imageLocation) {
		super(x, y, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public void shoot(Player player) {
		
		
		
		
		switch (player.getDirection()) {
		case NORTH:
			dy = -10;
			break;
		case EAST:
			dx = 10;
			break;
		case SOUTH:
			dy = 10;
			break;
		case WEST:
			dx = -10;
			break;
			
		}
		hasShot = true;
			
	}
	
	public void bulletMove() {
		if (!hasShot) {
			return;
		} else {
			x += dx;
			y += dy;
			
			
			if (x > 1000) {
				x = 1020;
			}
			if ( x < 1) {
				x = 1020;
			}
			if ( y < 1) {
				y = 1020;
			}
			if ( y > 1000) {
				y = 1020;
			}
			
			
			
			
		}
	}
		
	
	
	
	
	
}
