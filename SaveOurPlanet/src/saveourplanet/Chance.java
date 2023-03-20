/**
 * 
 */
package saveourplanet;

/**
 * @author phil <3
 *
 */
public class Chance extends Tile {

	/**
	 * Default constructor without arguments
	 */
	public Chance() {
		
	}

	/**
	 * Constructor with arguments
	 * @param number
	 * @param name
	 * @param description
	 */
	public Chance(int number, String name, String description) {
		super(number, name, description);
	}
	
	// METHODS
	
	/**
	 * Method for printing information of the Chance tile, including its number, name and description.
	 */
	public void displayInfo() {
		System.out.println("Tile " + this.getNumber());
		System.out.println(this.getName());
		System.out.println(this.getDescription());
	}

	/**
	 * Method to add resources (ecoPoints and powerPoints) to the player's balance
	 * @param player
	 * @param ecoPoints
	 * @param powerPoints
	 */
	public void addResources(Player player, int ecoPoints, int powerPoints) {
		
		// informing player of their current resources
		System.out.println(player.getUsername() + " has " + ecoPoints + " EcoPoints and " + powerPoints + " PowerPoints.");
		
		// adding resources
		player.addPowerPoints(powerPoints);
		player.addEcoPoints(ecoPoints);
		
		// showing their updated balance
		System.out.println(player.getUsername() + " now has " + ecoPoints + " EcoPoints and " + powerPoints + " PowerPoints!");
	}
	
	/**
	 * Method to minus resources (ecoPoints and powerPoints) to the player's balance
	 * @param player
	 * @param ecoPoints
	 * @param powerPoints
	 */
	public void minusResources(Player player, int ecoPoints, int powerPoints) {
		
		// informing player of their current resources
		System.out.println(player.getUsername() + " has " + ecoPoints + " EcoPoints and " + powerPoints + " PowerPoints.");
		
		// taking away resources
		player.minusPowerPoints(powerPoints);
		player.minusEcoPoints(ecoPoints);
		
		// showing their updated balance
		System.out.println(player.getUsername() + " now has " + ecoPoints + " EcoPoints and " + powerPoints + " PowerPoints!");
	}
	
	/**
	 * Method to remove resources (ecoPoints and powerPoints) from player1 and give them to player2
	 * @param p1
	 * @param p2
	 * @param ecoPoints
	 * @param powerPoints
	 */
	public void giveResources(Player p1, Player p2, int ecoPoints, int powerPoints) {
		
		// informing players of their current resources
		System.out.println(p1.getUsername() + " has " + ecoPoints + " EcoPoints and " + powerPoints + " PowerPoints.");
		System.out.println(p2.getUsername() + " has " + ecoPoints + " EcoPoints and " + powerPoints + " PowerPoints.");
		
		// removing resources from player 1 and transferring them to player 2
		p1.minusEcoPoints(ecoPoints);
		p2.addEcoPoints(ecoPoints);
		
		p1.minusPowerPoints(powerPoints);
		p1.addPowerPoints(powerPoints);
		
		// showing their updated balance
		System.out.println(p1.getUsername() + " now has " + ecoPoints + " EcoPoints and " + powerPoints + " PowerPoints!");
		System.out.println(p2.getUsername() + " now has " + ecoPoints + " EcoPoints and " + powerPoints + " PowerPoints!");
	}
	
	/**
	 * Method to take resources (ecoPoints and powerPoints) from player2 and give them to player1
	 * @param p1
	 * @param p2
	 * @param ecoPoints
	 * @param powerPoints
	 */
	public void takeResources(Player p1, Player p2, int ecoPoints, int powerPoints) {
		
		// informing players of their current resources
		System.out.println(p2.getUsername() + " has " + ecoPoints + " EcoPoints and " + powerPoints + " PowerPoints.");
		System.out.println(p1.getUsername() + " has " + ecoPoints + " EcoPoints and " + powerPoints + " PowerPoints.");
				
		// removing resources from player 2 and transferring them to player 1
		p2.minusEcoPoints(ecoPoints);
		p1.addEcoPoints(ecoPoints);
		
		p2.minusPowerPoints(powerPoints);
		p1.addPowerPoints(powerPoints);
		
		// showing their updated balance
		System.out.println(p2.getUsername() + " now has " + ecoPoints + " EcoPoints and " + powerPoints + " PowerPoints!");
		System.out.println(p1.getUsername() + " now has " + ecoPoints + " EcoPoints and " + powerPoints + " PowerPoints!");
		
	}
	
	/**
	 * Method to skip the player's go
	 * @param player
	 */
	public void skipAGo(Player player) {
		
		// Player is informed they will be resting
		System.out.println(player.getUsername() + " skips a go...");
		
		// Short animation to indicate their resting time
		try {
			for (int loop = 3; loop > 0; loop--) {
				System.out.println("...");
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Player is informed the rest is over
		System.out.println(player.getUsername() + "'s go has been skipped!");
	}
}
