package fortpex;

import java.util.ArrayList;
import java.util.List;

public class Round {

	private List<Enemy>  zombies = new ArrayList<>();
	private int roundCounter;
	
	
	public Round() {
		// TODO Auto-generated constructor stub
		
	}

	
	public List<Enemy> getZombies() {
		return zombies;
	}
	
	
	public void runRound() {
		
		int zombiesInRound = roundCounter + 10;
		int additionalHealth = 0;
		
		if (roundCounter % 2 == 0) {
			zombiesInRound += 2;
		}
		if (roundCounter % 2 != 0) {
			additionalHealth++;
		}
		
		
		
		for (int i = 0; i < zombiesInRound; i++) {
			Enemy zom = new Enemy( (int) (( Math.random() * 500) + 500), (int)  (Math.random() * 1000), "src/resources/zombie.png", 10 + additionalHealth);
			
			
			
		}
		
	}
	
	
	
	
	
}
