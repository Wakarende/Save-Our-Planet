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
	 * Setter method for setting the username of the player as a String
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		Scanner name = new Scanner(System.in);
		String nameHolder;
		nameHolder = name.nextLine();

		do {
			if (nameHolder.length() <= 0 || nameHolder.length() > 15) {
				this.username = nameHolder;
				System.out.println("Your name has been registered as " + username + ".");
			} else {
				System.out.println("The username must be more than 0 characters and less than 15 characters.");
				this.username = null;
			}
		} while (username == null);

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
		System.out.println("Player Info:\n Username: " + this.getUsername() + "\nPlayer Number: "
				+ this.getPlayerNumber() + "\nEcoPoints Balance: " + this.getEcoPoints() + "\nPowerPoints Balance: "
				+ this.getPowerPoints());
	}

	public void displayBalance() {

		System.out.println("Your EcoPoints resource balance is " + this.getEcoPoints());
		System.out.println("Your PowerPoints resource balance is " + this.getPowerPoints());

		if (ecoPoints <= 0) {
			System.out.println("You have run of ecoPoints! The game has ended.");
			System.out.println("Let's see the final scores!");
		} else if (powerPoints <= 0) {
			System.out.println("You have run of powerPoints! The game has ended.");
			System.out.println("Let's see the final scores!");
		}

	}

	public void addEcoPoints(int ecoPoints) {
		this.ecoPoints += ecoPoints;
	}

	public void minusEcoPoints(int ecoPoints) {
		this.ecoPoints -= ecoPoints;
	}

	public void addPowerPoints(int powerPoints) {
		this.powerPoints += powerPoints;
	}

	public void minusPowerPoints(int powerPoints) {
		this.powerPoints -= powerPoints;
	}

}
