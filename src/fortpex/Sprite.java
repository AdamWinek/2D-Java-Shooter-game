package fortpex;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

public class Sprite {

	protected int x;
	protected int y;
	protected int w;
	protected int h;
	protected int dx;
	protected int dy;
	protected boolean isVisible;
	protected Image image;
	protected String imageLocation;
	
	
	
	public Sprite(int x, int y, String imageLocation) {
		// TODO Auto-generated constructor stub
		this.x = x;
		this.y =y;
		this.imageLocation = imageLocation;
		loadImage();
	}

	
	private void loadImage() {
		ImageIcon ii = new ImageIcon(imageLocation);
		int dimensionsX = 100;
		int dimensionsY = 100;
		
		image = ii.getImage();
		Image newImage = image.getScaledInstance(dimensionsX, dimensionsY, Image.SCALE_DEFAULT);
		image = newImage;
		
		w = dimensionsX;
		h = dimensionsY;
	}
	
	
	public int getCenterX() {
		return x + (w / 2);
	}
	
	public int getCenterY() {
		return y + (h / 2);
	}
	
	
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public int getW() {
		return w;
	}
	public int getH() {
		return h;
	}
	
	public boolean getIsVisible() {
		return isVisible;
	}
	
	
	public Image getImage() {
		return image;
	}
	public Rectangle getBounds() {
        return new Rectangle(x, y, w, h);
    }
	
	
	public boolean checkCollision(Sprite obj) {
		
		Rectangle active = new Rectangle(x, y, w, h);
		Rectangle passive = obj.getBounds();
		
		if (active.intersects(passive)) {
			return true;
		} else {
			return false;
		}
		
	}
	
	
	
	
	
}
