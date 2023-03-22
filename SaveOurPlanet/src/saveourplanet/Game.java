/**
 * 
 */
package saveourplanet;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author Phil
 *
 */
public class Game {

	/*
	 * Public ArrayList to store the players of the game
	 * Used to access the Leaderboard
	 */
	public static List<Player> players = new ArrayList<>(); 
	
	/**
	 * Game class used to play the game
	 * Contains main method
	 * @param args
	 */
	public static void main(String[] args) {
		
		//Ascii art
		asciiArt();
		
		//Start menu
		mainMenu();
		
		//tutorial
		
		
	}
	
	/**
<<<<<<< HEAD
	 * Method to display Main Menu. 
	 * Gives user option to create New Game or Quit application. 
	 * If New Game is selected, user is moved on to tutorial screen -- not yet implemented. 
	 */
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
	
	/**
	 * This method creates the areas through which the game will be played. 
	 */
	public static void createBoard() {
		
		
		
	}
	
	/**
	 * Method to call the opening main menu.
	 * User is given choice to start New Game (1) or Quit (2). 
	 * If choosing to start a New Game, the user is brought to the tutorial level. 
	 * If choosing to Quit the game, the user exits the application. 
	 * At each stage in their decision, the user is asked to confirm their choice. 
	 */
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
//		scanner.close();
			
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
	
	public static void tutorial() {
		
		Scanner scanner2 = new Scanner(System.in);

		int choice;

		do {
			System.out.println("Menu:");
			System.out.println("1. Rules");
			System.out.println("2. Start game");
			System.out.println("3. Exit");

			System.out.print("Enter your choice: ");
			choice = scanner2.nextInt();

			switch (choice) {
			case 1:
				displayRules();
				break;
			case 2:
//	          startGame();
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
	
	public static void displayRules() {
		System.out.println("You have left tutorial and are in display rules.");
	}
	
	/**
	 * Quits the game/application. 
	 */
	public static void quit() {
		// inform the user they have quit the game
		System.out.println("You have quit the game. Thank you for playing 'Save Our Planet'.");
	}
	
	/**
	 * 
	 * @param players
	 */
	public static void displayLeaderboard(List<Player> players) {
		
	}
	
//	/**
//	 * Method for entering the name of each player
//	 */
//	public void enterName() {
//		
//		String nameHolder; // to hold name before confirmed
//		String confirmation = null; // to hold confirmation from user of name
//
//		Scanner name = new Scanner(System.in);
//		Scanner confirm = new Scanner(System.in);
//
//		do {
//			
//			do {
//				
//				System.out.println("Please enter a username between 1 and 15 characters to play the game:");
//				nameHolder = name.nextLine();
//
//				if (nameHolder == "") {
//					System.out.println("You must enter a username to play this game.");
//				} else if (nameHolder.length() > 15) {
//					System.out.println("The username you entered is too long.");
//					username = null;
//				} else { // NEED TO INCLUDE FILE READING HERE!
//					username = nameHolder;
//					System.out.println("Your name has been registered as " + username + ".");
//
//					do {
//						System.out
//								.println("Is this correct? Type 'yes' if correct or 'no' if incorrect to enter again.");
//						confirmation = confirm.nextLine();
//
//						if (confirmation.equalsIgnoreCase("yes")) {
//							System.out.println("Thank you, your name has been confirmed as " + username + ".");
//						} else if (confirmation.equalsIgnoreCase("no")) {
//							System.out.println("Please try again and write your name below.");
//							nameHolder = name.nextLine();
//							confirmation = null;
//						} else if (!confirmation.equalsIgnoreCase("yes") || !confirmation.equalsIgnoreCase("no")) {
//							confirmation = null;
//							System.out.println("That is not an accepted response, please try again.");
//						}
//					} while (confirmation == null);
//				}
//			} while (confirmation.equalsIgnoreCase("no"));
//
//		} while (username == null);
//
//		players.add(username);
//
//	}
//
//	/**
//	 * Method for displaying player number
//	 */
//	public void displayPlayerNum() { // ISSUES GOING FROM 0-5?!
//
//		for (int num = 1; num < players.size(); num++) {
//			playerNumber = num;
//		}
//
//		System.out.println("You are player number: " + playerNumber);
//
//	}
//
//	/**
//	 * Method for confirming all players have been entered
//	 */
//	public void confirmAllPlayersEntered() {
//
//		System.out.println(
//				"A minimum of 2 players and a maximum of 4 players is allowed to play this game. Please enter information for the next player.");
//
//		do {
//			enterName();
//			displayPlayerNum();
//
//		} while (playerNumber <= 4);
//
//		System.out.println("This is the final player. No more players can be entered.");
//
//		// CALL START GAME METHOD HERE);

//	}


}
