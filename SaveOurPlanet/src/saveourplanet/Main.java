/**
 * 
 */
package saveourplanet;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author fionn
 *
 */
public class Main {

	private static List<Player> players = new ArrayList<Player>();

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		setUpPlayer();

	}

	public static void setUpPlayer() {

		// Confirm there are enough players to meet requirements for game (between 2 and
		// 4)

		int playerTot;
		boolean allowedNum;

		Scanner playersTotal = new Scanner(System.in);

		do {

			// Ask user for number of players and save to int playerTot
			System.out.println(
					"A minimum of 2 players and a maximum of 4 players is allowed to play this game. Please enter the number of players you have for this game:");
			playerTot = playersTotal.nextInt();

			if (playerTot >= 2 && playerTot <= 4) {
				System.out.println("You have chosen "+playerTot+" players. Now let's set your usernames.");
			} else {
				System.out.println("Number of players not allowed. Please try again.");
				allowedNum = false;
			}

		} while (allowedNum = false);
		playersTotal.close();

		// Use playerTot int to decide how many times user can enter a name for a player
		// and to determine thier player number.
		for (int loop = 1; loop <= playerTot; loop++) {

			// Declaring a new player for each rotation
			Player newPlayer = new Player();

			String nameHolder; // to hold name before confirmed
			String confirmation = null; // to hold confirmation from user of name

			Scanner name = new Scanner(System.in); // To read in user name
			Scanner confirm = new Scanner(System.in); // To read in user confirmation of name

			do { // Repeat if user says name is incorrect

				do {
					System.out.println("Please enter a username between 1 and 15 characters to play the game:");
					nameHolder = name.nextLine();

					if (players.contains(nameHolder)) {
						System.out.println("This name has already been used. Please enter a different name.");
						nameHolder = null;
					} else {
						System.out.println("Your name has been registered as " + nameHolder + ".");
					}

				} while (nameHolder == null);

				do { // Repeat if user response to confirmation prompt is not applicable
					System.out.println("Is this correct? Type 'yes' if correct or 'no' if incorrect to enter again.");
					confirmation = confirm.nextLine();

					if (confirmation.equalsIgnoreCase("yes")) {
						newPlayer.setUsername(nameHolder); // Officially set username
						newPlayer.setPlayerNumber(loop); // Officially assign a playernumber to thier name
						System.out
								.println("Thank you, your name has been confirmed as " + newPlayer.getUsername() + ".");
					} else if (confirmation.equalsIgnoreCase("no")) {
						System.out.println("Please try again and write your name below.");
					} else {
						System.out.println("That is not an accepted response, please try again.");
						confirmation = null;
					}
				} while (confirmation == null);

			} while (confirmation.equalsIgnoreCase("no"));

			System.out.println("You are player number: " + newPlayer.getPlayerNumber());

			// Set starting points
			newPlayer.setEcoPoints(100);
			newPlayer.setPowerPoints(100);

			newPlayer.displayBalance();

			// Add as a complete player in the array list
			players.add(newPlayer);

		}

	}

	public static void showAllPlayersInfo(ArrayList<Player> players) {

		for (Player player : players) {
			player.displayPlayerInfo();
		}
	}
}
