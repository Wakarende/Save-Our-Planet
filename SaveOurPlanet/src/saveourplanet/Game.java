/**
 * 
 */
package saveourplanet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;
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

//		// create board
//		createBoard();
//		
//		// Ascii art
//		asciiArt();
//
//		// Start menu
//		mainMenu();
		
		
	}

	/**
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
	 * This method creates the areas and tiles through which the game will be played. 
	 */
	public static void createBoard() {
		
		// technology, recycling, energy and conservation
		
		// Tiles belonging to the Technology field - least expensive
		Area clothesApp = new Area("Technology", false, 3, "2nd-Hand Clothes App", "Invest in this start-up and become a champion for vintage fashionistas.", false, null, 0, 20, 30); 
		Area socialMediaCampaign = new Area("Technology", false, 5, "Social-Media Campaign", "Use this social media campaign to spread awareness about the climate.", false, null, 0, 15, 20); 
		
		// Tiles belonging to the Recycling field
		
		
		// Tiles belonging to the Energy field - most expensive
		
		
		// Tiles belonging to the Conservation field
		
		// tech is supposed to be cheapest
		// renewable energy the most expensive. 
		
		
		// creating instances of the Chance tiles
		Tile rest1 = new Tile(); 
		Chance rest = new Chance("Chance", false, 2, "Rest", "You have landed on the Rest tile! Take a breather..."); 
		Chance governmentGrant = new Chance("Chance", false, 4, "Government Grant", "To award you for your excellent work in the climate sector, the government is giving you a one-off grant. Enjoy!"); 
		Chance governmentTax = new Chance("Chance", false, 7, "Government Tax", "To help fund climate projects elsewhere in the world, the Government is collecting tax. Sorry (not sorry)"); 
		Chance give = new Chance("Chance", false, 10, "Sharing is Caring", "What is 'Our Planet' without eachother? Celebrate your differences by giving a fellow player some resources."); 
		Chance take = new Chance("Chance", false, 12, "Make them Pay", "Your enemies deserve punishment. Take some hard-earned resources from them. Mwah-ha-ha-ha-haaaaaa..."); 
		Chance skipAGo = new Chance("Chance", false, 16, "Skip-A-Go", "It's your favourite part of the game! Not playing. Skip-a-Go!"); 
		
		ArrayList<Tile> gameBoard = new ArrayList<>();  
		
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


			System.out.print("Enter your choice: ");
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

		// sort Players array list
		Collections.sort(players, new CompareByEcoPoints());
		
		
		for (int loop = 0; loop < players.size(); loop++) {
			System.out.println(loop+1 + ": " + players.get(loop).getUsername() + " with " + players.get(loop).getEcoPoints() + " EcoPoints"); 
		}
		
		
	}

}
