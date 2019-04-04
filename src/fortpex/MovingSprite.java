package fortpex;

import java.awt.EventQueue;

import javax.swing.JFrame;


public class MovingSprite extends JFrame {

	public MovingSprite() {
		// TODO Auto-generated constructor stub
        
		
		
		initUI();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 EventQueue.invokeLater(() -> {
	            MovingSprite ex = new MovingSprite();
	            ex.setVisible(true);
	        });
	}
	
	private void initUI() {
		
		add(new Board());		
		
		
		
		
		setTitle("fuck");
		setSize( 1000, 800);
		setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
