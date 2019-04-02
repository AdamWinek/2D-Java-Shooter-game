package fortpex;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener  {

	private Timer timer;
	private Player sprite;
	private final int DELAY = 10;
	private Enemy bad;
	
	
	
	public Board() {
		// TODO Auto-generated constructor stub
		initBoard();
	}

	private void initBoard() {
		addKeyListener(new TAdapter());
        setBackground(Color.black);
        setFocusable(true);
		
        sprite = new Player(0, 0, "src/resources/box.png");
        bad = new Enemy(500, 500, "src/resources/zombie.png");
       
        timer = new Timer(DELAY, this);
        timer.start();
		
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);

        doDrawing(g);
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void doDrawing(Graphics g) {
        
        Graphics2D g2d = (Graphics2D) g;

        

        g2d.drawImage(sprite.getImage(), sprite.getX(), 
                sprite.getY(), this);
        
        
        bad.angleBetween(sprite.getX(), sprite.getY());
        
        g2d.rotate(bad.getRot(), bad.getCenterX(), bad.getCenterY() );
        
        g2d.drawImage(bad.getImage(), bad.getX(), bad.getY(), this);
        
        g2d.rotate(-bad.getRot(), bad.getCenterX(), bad.getCenterY());
        
        for (Bullet bullet: sprite.bullets) {
        	
        	g2d.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), this);
        }
        
        
        g.setColor(Color.WHITE);
        g.drawString("Rounds survived ", 5, 15);

        
    }
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		sprite.move();
		bad.chase(sprite.getX(), sprite.getY());
		
		for (Bullet bullet: sprite.bullets) {
			bullet.bulletMove(Player.directionFacing.NORTH);
		}
		
		
		repaint();
	}
	 private class TAdapter extends KeyAdapter {

	        @Override
	        public void keyReleased(KeyEvent e) {
	            sprite.keyReleased(e);
	        }

	        @Override
	        public void keyPressed(KeyEvent e) {
	            sprite.keyPressed(e);
	        }
	        
	       
	    }
	}

