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
	private int days;

	List<String> players = new ArrayList<String>();

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
	public Player(String username, int playerNumber, int ecoPoints, int powerPoints, int days) {
		super();
		this.username = username;
		this.playerNumber = playerNumber;
		this.ecoPoints = ecoPoints;
		this.powerPoints = powerPoints;
		this.days = days;
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
		this.username = username;
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
	public int getDays() {
		return days;
	}

	/**
	 * Setter method to set the number of days he player has left throughout the
	 * game
	 * 
	 * @param days
	 */
	public void setDays(int days) {
		this.days = days;
	}

	
	public void addEcoPoints(int ecoPoints) {
		this.ecoPoints += ecoPoints; 
	}

	public void minusEcoPoints(int ecoPoints) {
		this.ecoPoints -= ecoPoints; 

		if (ecoPoints <= 0) {
			System.out.println("You have run of ecoPoints! The game has ended.");
			System.out.println("Let's see the final scores!");
		}
		
		// CALL LEADERBOARD
		// CALL WINNER
		// CALL END GAME
	}

	public void addPowerPoints(int powerPoints) {
		this.powerPoints += powerPoints; 
	}

	public void minusPowerPoints(int powerPoints) {
		this.powerPoints -= powerPoints; 

		if (powerPoints <= 0) {
			System.out.println("You have run of powerPoints! The game has ended.");
			System.out.println("Let's see the final scores!");
		}

		// CALL LEADERBOARD
		// CALL WINNER
		// CALL END GAME
	}
	
	public void addDays(int days) {
		this.days += days; 

		if (days <= 0) {
			System.out.println("You have run of days! The game has ended.");
			System.out.println("Let's see the final scores!");
		}

		// CALL LEADERBOARD
		// CALL WINNER
		// CALL END GAME
	}

	public void minusDays(int days) {
		this.days -= days; 

		if (days <= 0) {
			System.out.println("You have run of days! The game has ended.");
			System.out.println("Let's see the final scores!");
		}

		// CALL LEADERBOARD
		// CALL WINNER
		// CALL END GAME
	}
	
	/**
	 * Method for entering the name of each player
	 */
	public void enterName() {
		
		String nameHolder; // to hold name before confirmed
		String confirmation = null; // to hold confirmation from user of name

		Scanner name = new Scanner(System.in);
		Scanner confirm = new Scanner(System.in);

		do {
			
			do {
				
				System.out.println("Please enter a username between 1 and 15 characters to play the game:");
				nameHolder = name.nextLine();

				if (nameHolder == "") {
					System.out.println("You must enter a username to play this game.");
				} else if (nameHolder.length() > 15) {
					System.out.println("The username you entered is too long.");
					username = null;
				} else { // NEED TO INCLUDE FILE READING HERE!
					username = nameHolder;
					System.out.println("Your name has been registered as " + username + ".");

					do {
						System.out
								.println("Is this correct? Type 'yes' if correct or 'no' if incorrect to enter again.");
						confirmation = confirm.nextLine();

						if (confirmation.equalsIgnoreCase("yes")) {
							System.out.println("Thank you, your name has been confirmed as " + username + ".");
						} else if (confirmation.equalsIgnoreCase("no")) {
							System.out.println("Please try again and write your name below.");
							nameHolder = name.nextLine();
							confirmation = null;
						} else if (!confirmation.equalsIgnoreCase("yes") || !confirmation.equalsIgnoreCase("no")) {
							confirmation = null;
							System.out.println("That is not an accepted response, please try again.");
						}
					} while (confirmation == null);
				}
			} while (confirmation.equalsIgnoreCase("no"));

		} while (username == null);

		players.add(username);

	}

	/**
	 * Method for displaying player number
	 */
	public void displayPlayerNum() { // ISSUES GOING FROM 0-5?!

		for (int num = 1; num < players.size(); num++) {
			playerNumber = num;
		}

		System.out.println("You are player number: " + playerNumber);

	}

	/**
	 * Method for confirming all players have been entered
	 */
	public void confirmAllPlayersEntered() {

		System.out.println(
				"A minimum of 2 players and a maximum of 4 players is allowed to play this game. Please enter information for the next player.");

		do {
			enterName();
			displayPlayerNum();

		} while (playerNumber <= 4);

		System.out.println("This is the final player. No more players can be entered.");

		// CALL START GAME METHOD HERE);

	}
}

