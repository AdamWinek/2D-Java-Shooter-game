package fortpex;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Player extends Sprite {

	
	public List<Bullet> bullets = new ArrayList<>();
	
	
	public enum directionFacing {
		NORTH, EAST, SOUTH, WEST 
		}
	public directionFacing direction;
	
	
	
	public Player(int x, int y, String imageLocation) {
		super(x, y, imageLocation);
		// TODO Auto-generated constructor stub
		direction = directionFacing.NORTH;
	}

	
	public directionFacing getDirection() {
		return direction;
	}

	public void move() {
		
		x += dx;
		y += dy;
		
		if (getCenterX() + 15  > 1000 ) {
			x = 970  ; 
			dx = 0;	
	
			
		}
		if (getCenterX() < 1) {
			x = 1;
			dx = 0;
		}
		if (getCenterY() < 1) {
			y = 1;
			dy = 0;
		}
		if (y + 30 > 780) {
			y = 750;
			dy = 0;
		}
		
	}	
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
			dx = -4;
		}

		if (key == KeyEvent.VK_RIGHT) {
			dx = 4;
		}

		if (key == KeyEvent.VK_UP) {
			dy = -4;
		}

		if (key == KeyEvent.VK_DOWN) {
			dy = 4;
		}
		
		
		if (key == KeyEvent.VK_W) {
			direction = directionFacing.NORTH;
			shoot();
		}
		
		if (key == KeyEvent.VK_A) {
			direction = directionFacing.WEST;
			shoot();
		}
		
		if (key == KeyEvent.VK_S) {
			direction = directionFacing.SOUTH;
			shoot();
		}
		
		if (key == KeyEvent.VK_D) {
			direction = directionFacing.EAST;
			shoot();
		}
			
	}		
		
	public void shoot() {
		Bullet beingShot = new Bullet(getCenterX(), getCenterY(), "src/resources/bullet.png");
		
		beingShot.bulletMove(getDirection());
		beingShot.hasBeenFired();
		bullets.add(beingShot);
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
	
	
	public void shotAt() {
		health -= 2;
	}
	public boolean isOnleftOfScreen() {
		return x <= 500;
	}
	
}
	

