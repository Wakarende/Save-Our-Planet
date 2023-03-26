/**
 * 
 */
package saveourplanet;

import java.util.Random;

/**
 * @author phil <3
 *
 */
public class Chance extends Tile {

	// public instance of random class to generate random numbers for use in Chance methods
	public Random r = new Random(); 
	
	/**
	 * Default constructor without arguments
	 */
	public Chance() {
		
	}

	
	
	// METHODS
	
	


	/**
	 * @param number
	 * @param name
	 * @param description
	 */
	public Chance(int number, String name, String description) {
		super(number, name, description);
	}



	/**
	 * Method for printing information of the Chance tile, including its number, name and description.
	 */
	public void displayInfo() {
		System.out.println("Tile " + this.getNumber());
		System.out.println(this.getName());
		System.out.println(this.getDescription());
	}

	/**
	 * Method to add PowerPoints to the player's balance as part of the Government Grant chance card.
	 * @param player
	 * @param ecoPoints
	 * @param powerPoints
	 */
	public void governmentGrant(Player player) {
		
		// generated random number to represent PowerPoints
		int powerPoints = r.nextInt(20+1); 
		
		// informing the player which card they have pulled
		System.out.println("You have pulled the 'Government Grant' card!");
		System.out.println("To reward you for your excellent work, the government is giving you a grant of " + powerPoints + " PowerPoints to help in further investment. Enjoy!\n");
				
		
		// informing player of their current resources
		System.out.println(player.getUsername() + " had " + player.getPowerPoints() + " PowerPoints.");
		
		// adding resources
		player.addPowerPoints(powerPoints);
		
		// showing their updated balance
		System.out.println(player.getUsername() + " now has " + player.getPowerPoints() + " PowerPoints!");
	}
	
	/**
	 * Method to minus PowerPoints from the player's balance as part of the Government Tax chance card.
	 * @param player
	 * @param powerPoints
	 */
	public void governmentTax(Player player) {
		
		// generated random number to represent PowerPoints
		int powerPoints = r.nextInt(20+1);  
		
		// informing player which card they have pulled
		System.out.println("You have pulled the 'Government Tax' card!");
		System.out.println("To help fund climate projects elsewhere in the world, the Government is collecting " + powerPoints + " PowerPoints. Sorry (not sorry).\n");
		
		// informing player of their current resources
		System.out.println(player.getUsername() + " had " + player.getPowerPoints() + " PowerPoints.");
		
		// taking away resources
		player.minusPowerPoints(powerPoints);
		
		// showing their updated balance
		System.out.println(player.getUsername() + " now has " + player.getPowerPoints() + " PowerPoints!\n");
	}
	
	/**
	 * Method to remove PowerPoints from player1 and give them to player2. 
	 * Method for the Sharing is Caring chance card.
	 * @param p1
	 * @param p2
	 * @param powerPoints
	 */
	public void sharingIsCaring(Player p1, Player p2) {
		
		// generated random number to represent PowerPoints
		int powerPoints = r.nextInt(20+1);  
		
		// informing the player of which card they have pulled
		System.out.println("You have pulled the 'Sharing is Caring' card!");
		System.out.println("What is 'Our Planet' without eachother? Celebrate your differences by giving the next player " + powerPoints + " PowerPoints.\n");
		
		// informing players of their current resources
		System.out.println(p1.getUsername() + " had " + p1.getPowerPoints() + " PowerPoints.");
		System.out.println(p2.getUsername() + " had " + p2.getPowerPoints() + " PowerPoints.\n");
		
		// removing resources from player 1 and transferring them to player 2
		p1.minusPowerPoints(powerPoints);
		p2.addPowerPoints(powerPoints);
		
		// showing their updated balance
		System.out.println(p1.getUsername() + " now has " + p1.getPowerPoints() + " PowerPoints!");
		System.out.println(p2.getUsername() + " now has " + p2.getPowerPoints() + " PowerPoints!\n");
		System.out.println("Didn't that feel good?\n");
	}
	
	/**
	 * Method to take PowerPoints from player2 and give them to player1
	 * Part of the 'Make Them Pay' chance card
	 * @param p1
	 * @param p2
	 * @param powerPoints
	 */
	public void makeThemPay(Player p1, Player p2) {
		
		// generated random number to represent PowerPoints
		int powerPoints = r.nextInt(20+1); 
		
		// informing player of the card they have pulled
		System.out.println("You have pulled the 'Make Them Pay' card!");
		System.out.println("Your enemies deserve punishment. Take " + powerPoints + " hard-earned PowerPoints from the next player. Mwah-ha-ha-ha-haaaaaa...\n");
		
		// informing players of their current resources
		System.out.println(p1.getUsername() + " had " + p1.getPowerPoints() + " PowerPoints.");
		System.out.println(p2.getUsername() + " had " + p2.getPowerPoints() + " PowerPoints.\n");
				
		// removing resources from player 2 and transferring them to player 1
		p2.minusPowerPoints(powerPoints);
		p1.addPowerPoints(powerPoints);
		
		// showing their updated balance
		System.out.println(p1.getUsername() + " now has " + p1.getPowerPoints() + " PowerPoints!");
		System.out.println(p2.getUsername() + " now has " + p2.getPowerPoints() + " PowerPoints!\n");
		
	}
	
	/**
	 * Method to skip the player's go
	 * @param player
	 */
	public void skipAGo(Player player) {
		
		// Player is informed they will be resting
		System.out.println("You have pulled the 'Skip A Go' card!");
		System.out.println("It's your favourite part of the game! Not playing.");
		
		// Short animation to indicate the player skipping a go
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

	/**
	 * Method to pull random chance card. 
	 * Generates a random number and invokes a method based on the number generated. 
	 * @param p1
	 * @param p2
	 */
	public void pullChanceCard(Player p1, Player p2) {
		
		// generating random number
		int random = r.nextInt(5 + 1); 
		
		// switch to select a method (card) based on random number generated
		switch (random) {
		case 1: 
			governmentGrant(p1);
			break; 
		case 2: 
			governmentTax(p1);
			break; 
		case 3: 
			sharingIsCaring(p1, p2);
			break; 
		case 4: 
			makeThemPay(p1, p2); 
			break; 
		case 5: 
			skipAGo(p1);
			break; 
		default: 
			governmentGrant(p1);
			break; 
		}
	}
}
