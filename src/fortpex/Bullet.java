package fortpex;



import fortpex.Player.directionFacing;




public class Bullet extends Sprite {
	
	
	private boolean hasShot;

	public Bullet(int x, int y, String imageLocation) {
		super(x, y, imageLocation);
		hasShot = false;
		// TODO Auto-generated constructor stub
	}

	
	
	
	public void bulletMove(directionFacing d) {
				
			
			
			if (d == null) {
				return;
			}
		
		
			if ( !hasShot) {
			
				switch (d) {
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
		hasShot = false;
	}
	
	
	
	
}
