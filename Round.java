package fortpex;

import java.util.ArrayList;
import java.util.List;

public class Round {

	private List<Enemy>  zombies = new ArrayList<>();
	private int roundCounter = 0;
	private int health;
	
	public Round() {
		// TODO Auto-generated constructor stub
		
	}

	
	public List<Enemy> getZombies() {
		return zombies;
	}
	
	
	public int getHealth() {
		return health;
	}
	
	
	public void runRound(Player  p) {
		
		int zombiesInRound = roundCounter + 10;
		int additionalHealth = 0;
		
		if (roundCounter % 2 == 0) {
			zombiesInRound += 2;
		}
		if (roundCounter % 2 != 0) {
			additionalHealth++;
		}
		
		this.health = additionalHealth + 10;
		
		for (int i = 0; i < zombiesInRound; i++) {
			
			int offset = 0;
			if(p.isOnleftOfScreen()) {
				offset = 500;
			}
			
			Enemy zom = new Enemy( (int) (( Math.random() * 500) + offset), (int)  (Math.random() * 1000), "src/resources/zombie.png", 10 + additionalHealth);
			
			zombies.add(zom);
			
		}
		
		
		
		
		
	}
	
	public int getRoundCount() {
		return roundCounter;
	}
	
	
	public boolean isRoundOver() {
		
		boolean allded = true;
		
		
		
		for(Enemy zom: zombies) {
			if (zom.getIsVisible()) {
				allded = false;
			}
		}
		
		
		
		return allded;
		
	}
	
	
	
	public void roundOver() {
		zombies.clear();
		roundCounter++;
		
		
		
	}
	
	
	
}
