package fortpex;

import java.util.ArrayList;
import java.util.List;

public class Round {

	private List<Enemy>  zombies = new ArrayList<>();
	private int roundCounter = 0;
	
	
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
			
			zombies.add(zom);
			
		}
		
		
		
		
		
	}
	
	public boolean isRoundOver() {
		
		boolean allded = true;
		
		if (zombies == null) {
			
			roundOver();
			
			return true;
		}
		for(Enemy zom: zombies) {
			if (zom.getIsVisible()) {
				allded = false;
			}
		}
		
		if (allded) {
			this.roundOver();
		}
		return !allded;
		
	}
	
	
	
	private void roundOver() {
		zombies.clear();
		roundCounter++;
		
		
		
	}
	
	
	
}
