/**
 * 
 */
package saveourplanet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Class to represent any player playing the game at any time.
 * 
 * @author Fiona
 *
 */
public class Player {

	// Vars
	private String username;
	private int playerNumber;
	private int ecoPoints;
	private int powerPoints;
	private int position;

	/**
	 * Default Constructor
	 */
	public Player() {

	}

	/**
	 * Constructor with args
	 * 
	 * @param username
	 * @param playerNumber
	 * @param ecoPoints
	 * @param powerPoints
	 * @param days
	 */
	public Player(String username, int playerNumber, int ecoPoints, int powerPoints) {
		super();
		this.username = username;
		this.playerNumber = playerNumber;
		this.ecoPoints = ecoPoints;
		this.powerPoints = powerPoints;

	}

	// Getters & Setters Methods
	/**
	 * Getter method to return the player in question's username
	 * 
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Creates the username of the player as a String, takes the game as a parameter
	 * so that we can add this new player's name to the list of playerNames in the
	 * game
	 * 
	 * @param username
	 */
	public String createUsername(List<String> currentPlayerUsernames, Scanner scanner) {
		boolean validUsername = false;
		String newUsername;
		System.out.print("\nPlease enter a username: ");
		do {

			newUsername = scanner.next();
			if (newUsername.length() == 0 || newUsername.length() > 15) {
				System.out.println("\nThe username must be more than 0 characters and less than 15 characters.");

			} else if (currentPlayerUsernames.contains(newUsername)) {
				System.out.println("\nThis name has already been used. Please enter a different name.");

			} else {
				System.out.println("Your name has been registered as " + newUsername + ".");
				validUsername = true;
			}

			if (validUsername == true) {

				System.out.print("Is this correct? Type 'yes' if correct, or 'no' if incorrect to enter again: ");
				String answer = scanner.next();
				if (answer.equalsIgnoreCase("yes")) {

					System.out.println("Thank you, your name has been confirmed as " + newUsername + ".");

				} else if (answer.equalsIgnoreCase("no")) {
					System.out.println("Please try again and write your name below:");
					validUsername = false;
				} else {
					System.out.println("That is not an accepted response, please try again.");
					validUsername = false;
				}
			}

		} while (validUsername == false);

		// Finally set the userName if validation above is passed
		return newUsername;

	}

	/**
	 * Getter method to get the players number assigned to them at start
	 * 
	 * @return
	 */
	public int getPlayerNumber() {

		return playerNumber;
	}

	/**
	 * Setter method to set the players number as an int when they sign up at start
	 * automatically
	 * 
	 * @param playerNumber
	 */
	public void setPlayerNumber(int playerNumber) {

		this.playerNumber = playerNumber;

	}

	/**
	 * Getter method to get the players eco points balance at that time
	 * 
	 * @return
	 */
	public int getEcoPoints() {
		return ecoPoints;
	}

	/**
	 * Setter method to set players ecoPoints throughout the game
	 * 
	 * @param ecoPoints
	 */
	public void setEcoPoints(int ecoPoints) {
		this.ecoPoints = ecoPoints;
	}

	/**
	 * Getter method to get players powerpoints score at that time
	 * 
	 * @return
	 */
	public int getPowerPoints() {
		return powerPoints;
	}

	/**
	 * Setter method to set players powerPoints throughout the game
	 * 
	 * @param ecoPoints
	 */
	public void setPowerPoints(int powerPoints) {
		this.powerPoints = powerPoints;
	}

	/**
	 * Getter method to get players number of days left at that time
	 * 
	 * @return
	 */
	public void displayPlayerInfo() {
		System.out.println("\nPlayer Info:\n" + "Username: " + this.getUsername() + "\nPlayer Number: "
				+ this.getPlayerNumber() + "\nEcoPoints Balance: " + this.getEcoPoints() + "\nPowerPoints Balance: "
				+ this.getPowerPoints());
	}

	public void displayBalance() {

		System.out.println("Your EcoPoints resource balance is " + this.getEcoPoints());
		System.out.println("Your PowerPoints resource balance is " + this.getPowerPoints());

		if (powerPoints <= 0) {
			System.out.println("You have run of powerPoints! The game has ended.");
			System.out.println("Let's see the final scores!");
		}

	}

	public void addEcoPoints(int ecoPoints) {
		this.ecoPoints += ecoPoints;
	}


	public void addPowerPoints(int powerPoints) {
		this.powerPoints += powerPoints;
	}

	public void minusPowerPoints(int powerPoints) {
		this.powerPoints -= powerPoints;
	}

	public void minusRent(Tile tile) {
		this.powerPoints -= powerPoints;
	}

	private void buyTile(Area area, Scanner scanner, Game game) {

		System.out.println("Tile information: " + "\nName: " + area.getName() + "\nDescription: "
				+ area.getDescription() + "\nCost: " + area.getBuyingPrice() + "\nEco Points Reward: "
				+ area.getBuyingReward() + "\nRent Price: " + area.getRentPrice());

		boolean playerCanAffordTile = (this.getPowerPoints() > area.getBuyingPrice());

		if (playerCanAffordTile) {

			System.out.println("This tile is free to buy. Would you like to purchase it? Please enter 'yes' or 'no'. ");

			String response = scanner.next();

			if (response.equalsIgnoreCase("yes")) {

				area.setOwnerName(this.username);
				this.minusPowerPoints(area.getBuyingPrice());
				this.addEcoPoints(area.getBuyingReward());

				System.out.println(
						"The owner of this tile is now: " + this.getUsername() + "\nYour balance is as follows:");
				this.displayBalance();

			} else if (response.equalsIgnoreCase("no")) {

				game.auctionTile(area, this, scanner);

			}

		} else {

			System.out.println("You do not have enough money to buy this tile. This tile will now go to auction.");

			game.auctionTile(area, this, scanner);

		}

	}

	private void payRent(Area area) {

		System.out.println("This tile is already owned.\nYou must pay rent of " + area.getRentPrice()
				+ " powerPoints to " + area.getOwnerName());

		this.minusPowerPoints(area.getRentPrice());
		

		System.out.println("Your remaining balance:");
		this.displayBalance();
	}

	public int buyTileInAuction(Scanner scanner) {

		int playerBid = 0;
		boolean playerHasAnswered = false;

		System.out.println(
				"This tile is now open for the rest of the players to buy in an auction.\nPlease enter whether you would like to bid ('yes') or not like to bid ('no')");

		do {

			String response = scanner.next();

			if (response.equalsIgnoreCase("yes")) {

				System.out.println(this.username + ", please enter the amount you would like to bid:");
				playerBid = scanner.nextInt();
				playerHasAnswered = true;

			} else if (response.equalsIgnoreCase("no")) {
				System.out.println("Okay, moving on to the next player.");
				playerHasAnswered = true;
				playerBid = 0;

			} else {
				System.out.println("Sorry didn't catch that! What is your answer?");
			}

		} while (playerHasAnswered == false);

		return playerBid;

	}

	public void landsOnTile( Tile tile, Scanner scanner, Game game) {

		
		if(tile instanceof Area) {
			
			Area area = (Area) tile;
			
		if (area.getOwnerName() != null) {

			this.payRent(area);

			if (this.powerPoints <= 0) {
				game.endGame(this);
			}

		} else {

			this.buyTile( area, scanner, game);
		}
		}
	}
}
