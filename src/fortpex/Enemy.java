 package fortpex;

import java.util.List;

public class Enemy extends Sprite {

	private double rot;
	
	
	public Enemy(int x, int y, String imageLocation, int health) {
		super(x, y, imageLocation);
		this.health = health;
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
	
	
	
	
	public void chase(int x1,int y1, List<Enemy> zombies) {
		
		
		
		
		
		
		
		int fuckU = 12;
		
		
		
		if (x1 > this.getCenterX()) {
			dx = 2;
			for(Enemy zom: zombies) {
				if (zom.isVisible) {
					if(Math.abs(getCenterX()  - zom.getCenterX()) < fuckU && (zom.getCenterX() != getCenterX() && zom.getCenterY() != getCenterY()) && getCenterX() < zom.getCenterX()) {
						dx = 0;
					}
				}
				
			}
			
			
			
			
		}
		if (x1 < this.getCenterX()) {
			
			dx = -2;
			for(Enemy zom: zombies) {
				if(zom.getIsVisible()) {
					if(Math.abs(getCenterX()  - zom.getCenterX()) < fuckU && (zom.getCenterX() != getCenterX() && zom.getCenterY() != getCenterY())  && getCenterX() > zom.getCenterX()) {
						dx = 0;
					}
				}
				
			}
			
			
		}
		if (x1 == this.getCenterX()) {
			dx = 0;
			
		}
		
		if (y1 > this.getCenterY()) {
			dy = 2;
			for(Enemy zom: zombies) {
				if(zom.getIsVisible()) {
					if(Math.abs(getCenterY()  - zom.getCenterY()) < fuckU && (zom.getCenterX() != getCenterX() && zom.getCenterY() != getCenterY()) && getCenterY() < zom.getCenterY()) {
						dy = 0;
					}
				}
				
			}
			
		}
		if (y1 < this.getCenterY()) {
			
			dy = -2;
			
			for(Enemy zom: zombies) {
				if(zom.isVisible) {
					if(  Math.abs(getCenterY()  - zom.getCenterY() ) < fuckU &&  (zom.getCenterX() != getCenterX() && zom.getCenterY() != getCenterY()) && getCenterY() > zom.getCenterY()) {
						dy = 0;
					}
				}
				
			}
			
		}
		
		if (y1 == this.getCenterY()) {
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
