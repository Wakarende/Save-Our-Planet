/**
 * 
 */
package saveourplanet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Phil
 * @author joy
 * @author fiona
 * @author kudzai
 *
 */
public class Game {

	/*
	 * Public ArrayList to store the players of the game Used to access the
	 * Leaderboard
	 */
	public static List<Player> players = new ArrayList<>();

	/**
	 * Game class used to play the game Contains main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Ascii art
		asciiArt();

		// Start menu
		mainMenu();

		// tutorial
//		tutorial();

	}

	/**
	 * Create Ascii art at beginning of game
	 */
	public static void asciiArt() {
		try {

			String text = "\r\n" + "\r\n"
					+ " ________  ________  ___      ___ _______           ________  ___  ___  ________          ________  ___       ________  ________   _______  _________   \r\n"
					+ "|\\   ____\\|\\   __  \\|\\  \\    /  /|\\  ___ \\         |\\   __  \\|\\  \\|\\  \\|\\   __  \\        |\\   __  \\|\\  \\     |\\   __  \\|\\   ___  \\|\\  ___ \\|\\___   ___\\ \r\n"
					+ "\\ \\  \\___|\\ \\  \\|\\  \\ \\  \\  /  / | \\   __/|        \\ \\  \\|\\  \\ \\  \\\\\\  \\ \\  \\|\\  \\       \\ \\  \\|\\  \\ \\  \\    \\ \\  \\|\\  \\ \\  \\\\ \\  \\ \\   __/\\|___ \\  \\_| \r\n"
					+ " \\ \\_____  \\ \\   __  \\ \\  \\/  / / \\ \\  \\_|/__       \\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\   _  _\\       \\ \\   ____\\ \\  \\    \\ \\   __  \\ \\  \\\\ \\  \\ \\  \\_|/__  \\ \\  \\  \r\n"
					+ "  \\|____|\\  \\ \\  \\ \\  \\ \\    / /   \\ \\  \\_|\\ \\       \\ \\  \\\\\\  \\ \\  \\\\\\  \\ \\  \\\\  \\|       \\ \\  \\___|\\ \\  \\____\\ \\  \\ \\  \\ \\  \\\\ \\  \\ \\  \\_|\\ \\  \\ \\  \\ \r\n"
					+ "    ____\\_\\  \\ \\__\\ \\__\\ \\__/ /     \\ \\_______\\       \\ \\_______\\ \\_______\\ \\__\\\\ _\\        \\ \\__\\    \\ \\_______\\ \\__\\ \\__\\ \\__\\\\ \\__\\ \\_______\\  \\ \\__\\\r\n"
					+ "   |\\_________\\|__|\\|__|\\|__|/       \\|_______|        \\|_______|\\|_______|\\|__|\\|__|        \\|__|     \\|_______|\\|__|\\|__|\\|__| \\|__|\\|_______|   \\|__|\r\n"
					+ "   \\|_________|                                                                                                                                         \r\n"
					+ "                                                                                                                                                        \r\n"
					+ "                                                                                                                                                        \r\n"
					+ "\r\n" + "";

			for (int i = 0; i < text.length(); i++) {
				System.out.print(text.charAt(i));
				Thread.sleep(2); // adjust delay time as needed
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void mainMenu() {

		try {

			// Scanner to record user input
			Scanner scanner = new Scanner(System.in);

			// variables to store user input
			String userConfirmation = "no";
			int userInput;

			// boolean to record the player's choice
			boolean tutorial = false;

			do {

				// Main Menu text
				System.out.println("Welcome to Save Our Planet.");
				System.out.println("Main Menu: \n");
				System.out.println("1. New Game");
				System.out.println("2. Quit \n");
				System.out.println("Please enter either 1 or 2: \n");

				// record the user's decision in the scanner
				userInput = scanner.nextInt();

				switch (userInput) {

				case 1: // New Game
					// asks for confirmation
					System.out.println("You have chosen to create a new game. Is this correct? (yes/no)");
					userConfirmation = scanner.next();
					// user leaves the application
					if (userConfirmation.equalsIgnoreCase("yes")) {
						tutorial = true;
					}
					break;

				case 2: // Quit Game
					// asks for confirmation
					System.out.println("You have chosen to quit game. Is this correct? (yes/no)");
					userConfirmation = scanner.next();
					// user leaves the application
					if (userConfirmation.equalsIgnoreCase("yes")) {
						tutorial = false;
					}
					break;

				// default statement
				default:
					System.out.println("Wrong input! Please try again...\n");
					break;
				}

			} while (userConfirmation.equalsIgnoreCase("no"));

			// close scanner
//			scanner.close();

			// use the boolean to decide which module of the game the player is moving on to
			if (tutorial == true) {
				tutorial();
			} else {
				quit();
			}

		} catch (InputMismatchException wrongInput) {
			System.out.println("Sorry, wrong input.\n");
		}

	}

	/**
	 * Displays tutorial for user
	 */
	public static void tutorial() {
		Scanner scanner = new Scanner(System.in);

		int choice;

		do {
			System.out.println("Menu:");
			System.out.println("1. Rules");
			System.out.println("2. Start game");
			System.out.println("3. Exit");

			System.out. print("Enter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				displayRules();
				break;
			case 2:
	          startGame();
				break;
			case 3:
				System.out.println("Exiting Tutorial!");
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 3);
			
//			scanner.close();
		}
	
	
	/**
	 * Quits the game/application. 
	 */
	public static void quit() {
		// inform the user they have quit the game
		System.out.println("You have quit the game. Thank you for playing 'Save Our Planet'.");
	}


	/**
	 * Displays game rules
	 */
	private static void displayRules() {
		try {
			FileReader fileReader = new FileReader("tutorial.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);

			String line;
			while ((line = bufferedReader.readLine()) != null) {
				String[] sentences = line.split("(?<=[.!?])\\s+(?=[a-zA-Z])");
				for (String sentence : sentences) {
					slowPrint(sentence.trim());
					Thread.sleep(2); // pause between sentences
				}
				System.out.println("\n"); // print a new line after each paragraph
			}

			bufferedReader.close();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Method that prints rules of game with a delay
	 * 
	 * @param str
	 * @throws InterruptedException
	 */
	private static void slowPrint(String str) throws InterruptedException {
		for (char c : str.toCharArray()) {
			System.out.print(c);
			Thread.sleep(10); // pause between characters
		}
		System.out.print(" ");
	}

	
	/**
	 * Method Start game method
	 */
	public static void startGame() {
		System.out.println("Start game");
	}
	/**
	 * 
	 * @param players
	 */
	public static void displayLeaderboard(List<Player> players) {

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
