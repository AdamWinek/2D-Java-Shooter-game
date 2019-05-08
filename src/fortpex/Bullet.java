package fortpex;



import java.awt.Image;

import fortpex.Player.directionFacing;




public class Bullet extends Sprite {
	
	
	private boolean hasShot;

	public Bullet(int x, int y, String imageLocation) {
		super(x, y, imageLocation);
		hasShot = false;
		// TODO Auto-generated constructor stub
		
		isVisible = true;
		int dimensionsX = 5;
		int dimensionsY = 5;
		
		Image newImage = image.getScaledInstance(dimensionsX , dimensionsY, Image.SCALE_DEFAULT);
		image = newImage;
	}

	
	
	
	public void bulletMove(directionFacing d) {
				
			
			
		
		
			if ( !hasShot) {
			
				switch (d) {
				case NORTH:
					dy = -5;
					break;
				case EAST:
					dx = 5;
					break;
				case SOUTH:
					dy = 5;
					break;
				case WEST:
					dx = -5;
					break;
					
				}	
			}	else {
				x += dx;
				y += dy;
				
			}
			
			
			
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
	
		
	public void hasBeenFired() {
		hasShot = true;
	}
	public void isOutOfBounds() {
		if (x == 1020) {
			isVisible = false;
		}
		isVisible = true;
	}
	
	
	
}
