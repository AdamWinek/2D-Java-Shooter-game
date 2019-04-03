 package fortpex;

public class Enemy extends Sprite {

	private double rot;
	
	
	public Enemy(int x, int y, String imageLocation) {
		super(x, y, imageLocation);
		// TODO Auto-generated constructor stub
	}

	public void angleBetween(int x1, int y1) {
		
		double opposite = y - y1;
		double adjacent = x - x1;
		
		
		rot = Math.atan(( opposite/ adjacent));
		
		
		if ( x1 < x) {
			rot = rot + Math.PI;
		}
		
		
		
	}
	
	public void chase(int x1,int y1) {
		if (x1 > this.x) {
			dx = 2;
		}
		if (x1 < this.x) {
			dx = -2;
		}
		if (x1 == this.x) {
			dx = 0;
			
		}
		if (y1 > this.y) {
			dy = 2;
		}
		if (y1 < this.y) {
			dy = -2;
		}
		if (y1 == this.y) {
			dy = 0;
		}
		x += dx;
		y += dy;		
		
	}
	
	public double getRot() {
		return rot;
		
	}
	public void shotat() {
		health -= 2;
		
		
	}
		
	public void knockBack() {
		
		x -= 100 * Math.cos(rot);
		y -= 100 * Math.sin(rot);
		
		
	}
}
