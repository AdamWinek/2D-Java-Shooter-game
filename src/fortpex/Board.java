package fortpex;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Board extends JPanel implements ActionListener  {

	private Timer timer;
	private Player sprite;
	private final int DELAY = 10;
	
	private boolean touched = false;
	private boolean shot = false;
	private Round round;
	Image image;
	private List<Healthkit> kits = new ArrayList();
	
	
	
	public Board() {
		// TODO Auto-generated constructor stub

		initBoard();
	}

	private void initBoard() {
		addKeyListener(new TAdapter());
        // setBackground(Color.white);
        setFocusable(true);
		
        sprite = new Player(0, 0, "src/resources/player.png");
        round = new Round();
        round.runRound(sprite);
        timer = new Timer(DELAY, this);
        timer.start();
        ImageIcon back = new ImageIcon("src/resources/backround.jpg");
    	
		image = back.getImage();
		Image newImage = image.getScaledInstance(1000, 800, Image.SCALE_DEFAULT);
		image = newImage;
		
	}
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        
        
        
        
        
        
        if (!touched) {
        	
        	
        	try {
				doDrawing(g);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
				System.out.print("shit done fucked up");
			}
        } else {
        	
        	drawGameOver(g);
        }
        	

      
        
        Toolkit.getDefaultToolkit().sync();
    }
    
    private void doDrawing(Graphics g) throws InterruptedException {
        
       
    	Graphics2D g2d = (Graphics2D) g;

    	// Draws backround
        ImageIcon back = new ImageIcon("src/resources/backround.jpg");
	
		
        
       
        if (g2d.drawImage(image, 0 ,0 ,this)) {
        	
        
       
        // DRAWS CHARECTER
        switch (sprite.getDirection()) {
        case NORTH:
   
  	
       	 	g2d.rotate( -Math.PI / 2 , sprite.getCenterX(), sprite.getCenterY() );
        	
        	
        	g2d.drawImage(sprite.getImage(), sprite.getX(),
                    sprite.getY(), this);
       	 	g2d.rotate( Math.PI / 2 , sprite.getCenterX(), sprite.getCenterY() );

        	break;
        case EAST:
        	
        	g2d.drawImage(sprite.getImage(), sprite.getX(), 
                    sprite.getY(), this);
        	
        	break;
        case SOUTH:
       	 	g2d.rotate( Math.PI / 2 , sprite.getCenterX(), sprite.getCenterY() ); 

        	
        	g2d.drawImage(sprite.getImage(), sprite.getX(), 
                    sprite.getY(), this);
        	
       	 	g2d.rotate( -Math.PI / 2 , sprite.getCenterX(), sprite.getCenterY() );

        	break;
        case WEST:
        	
        	
       	 	g2d.rotate( Math.PI  , sprite.getCenterX(), sprite.getCenterY() );

        	g2d.drawImage(sprite.getImage(), sprite.getX(), 
                    sprite.getY(), this);
       	 	
        	g2d.rotate( -Math.PI , sprite.getCenterX(), sprite.getCenterY() );




        	
        	break;
        }
        
        for (Healthkit kit: kits) {
        	if (kit.getIsVisible()) {
        		g2d.drawImage(kit.getImage(), kit.getX(), kit.getY(), this);
            }
        }
        	
        
        
   
       for (Enemy zom: round.getZombies()) {
        	 
            zom.angleBetween(sprite.getX(), sprite.getY());
           
            
            if (zom.getIsVisible()) {
            	
            	 g2d.rotate(zom.getRot(), zom.getCenterX(), zom.getCenterY() );
                 
                 g2d.drawImage(zom.getImage(), zom.getX(), zom.getY(), this);
                 
                 g2d.rotate(-zom.getRot(), zom.getCenterX(), zom.getCenterY());
                 
                 Color red = new Color (214, 48, 36);
                 g2d.setColor(red);
                 
                 g2d.fillRect(zom.getX(), zom.getCenterY() - 40 , (int) ((int)40 / ((10.0/zom.getHealth()))), 5);
                 
            }
        	
        	
        	
        }
        
        for (Bullet bullet: sprite.bullets) {
        	
        	if (bullet.getIsVisible()) {
        		
        		switch (sprite.getDirection()) {
        		case NORTH:
        			g2d.drawImage(bullet.getImage(), bullet.getX() + 6, bullet.getY() , this);
        			break;
        		case EAST:
        			g2d.drawImage(bullet.getImage(), bullet.getX(), bullet.getY()  + 6 , this);
        			break;
        		case SOUTH:
        			
        			g2d.drawImage(bullet.getImage(), bullet.getX() - 10, bullet.getY() , this);
        			break;
        		case WEST:
        			g2d.drawImage(bullet.getImage(), bullet.getX(), bullet.getY()  - 10 , this);
        			
        			break;
        		}
        		
        	}
        	
        	
        }
        
        Font tr = new Font("Monospaced", Font.BOLD, 18);
  
        Color red = new Color (196, 67, 41);
        Color yellow = new Color (255 ,255 , 255);
        g.setFont(tr);
        g.setColor(yellow);
        g.drawString("Rounds survived " + round.getRoundCount(), 10 ,  45);
        
        g.drawString("Score: " + sprite.getScore(), 10, 105);
        
       
        
        Graphics healthbar = (Graphics2D) g;
        
        healthbar.setColor(red);
        healthbar.drawString("Health:" , 10, 75);
        healthbar.fillRect(95, 60, 15 * sprite.getHealth(), 15);
        }
        

        
    }
    private void drawGameOver(Graphics g) {

    	String msg = "Game Over";
        Font small = new Font("Helvetica", Font.BOLD, 50);
        FontMetrics fm = getFontMetrics(small);

        
        g.setColor(Color.black);
        g.setFont(small);
        g.drawString(msg, (1000 - fm.stringWidth(msg)) / 2,
                800 / 2 );
   }
    
    private void drawStartScreen(Graphics g) {
    	
    	
    	
    	
    	
    }
    
    
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		sprite.move();
		
		for (Enemy zom:round.getZombies()) {
			zom.chase(sprite.getCenterX(), sprite.getCenterY(), round.getZombies());

			
			

			if (sprite.checkCollision(zom)) {
				sprite.shotAt();
				zom.knockBack();
			}
			if (sprite.getHealth() == 0) {
				touched = true;
				
			}
			
			for (Bullet bullet: sprite.bullets) {
				bullet.bulletMove(Player.directionFacing.NORTH);
				if (bullet.checkCollision(zom)) {
					shot = true;
					sprite.shotZom();
					zom.shotat();
					bullet.changeVisible();
					if (zom.getHealth() == 0 || zom.getHealth() == 1) {
						zom.changeVisible();
						
						double random = Math.random();
								if (random >= .9) {
									kits.add(new Healthkit(zom.getCenterX(), zom.getCenterY(), "src/resources/healthkit.png"));
								}
						
						
						
						
					}
					
					
				}
			}

		}
		for (Healthkit kit: kits) {
			if(sprite.checkCollision(kit)) {
				if(sprite.getHealth() <= 8) {
					
					sprite.changeHealth(2);
					
					
				}
				kit.changeVisible();
			}
		}
		
		
		
		
		
		
		if (round.isRoundOver()) {
			round.roundOver();
			round.runRound(sprite);
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

