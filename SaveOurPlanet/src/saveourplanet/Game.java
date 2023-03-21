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
//		mainMenu();

		// tutorial
		tutorial();

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
		// Scanner to record user input
		Scanner menuScanner = new Scanner(System.in);
		try {

			// variables to store user input
			String userConfirmation = "no";
			int userInput;

			do {

				// Main Menu
				System.out.println("Welcome to Save Our Planet!");
				System.out.println("Main Menu: \n");
				System.out.println("1. New Game");
				System.out.println("2. Quit \n");
				System.out.println("Please enter either 1 or 2: \n");

				userInput = menuScanner.nextInt();

				switch (userInput) {

				// if user has decided to create a new game
				case 1:

					// asks user for confirmation
					System.out.println("You have chosen to create a new game. Is this correct? (yes/no)");
					userConfirmation = menuScanner.next();

					if (userConfirmation.equalsIgnoreCase("yes")) {
						// moves user on to tutorial
//						tutorial();
						break;
					} else if (userConfirmation.equalsIgnoreCase("no")) {
						System.out.println("Choose an option");
					} else {
						System.out.println("Wrong input! Try again...");
					}
					break;

				// if user has decided to quit game
				case 2:

					// asks user for confirmation
					System.out.println("You have chosen to quit game. Is this correct? (yes/no)");
					userConfirmation = menuScanner.next();

					// user leaves the application
					if (userConfirmation.equalsIgnoreCase("yes")) {
						System.out.println("Goodbye!");
//						menuScanner.close();
						break;
					}
					break;
				// default statement
				default:
					System.out.println("Wrong input! Please try again...\n");
					break;
				}

			} while (true);
		} catch (

		InputMismatchException wrongInput) {
			System.out.println("Sorry, wrong input.\n");
			mainMenu();
		} finally {
			menuScanner.close();
		}

	}

	/**
	 * Displays tutorial for user
	 */
	public static void tutorial() {
		Scanner tutorialScanner = new Scanner(System.in);

		int choice;

		while (true) {
			System.out.println("Menu:");
			System.out.println("1. Rules");
			System.out.println("2. Start game");
			System.out.println("3. Exit");

			System.out.print("Enter your choice: ");
			choice = tutorialScanner.nextInt();

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
//		tutorialScanner.close();
		}
	}

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
			Thread.sleep(10); // pause  between characters
		}
		System.out.print(" ");
	}

	/**
	 * 
	 * @param players
	 */
	public static void displayLeaderboard(List<Player> players) {

	}

}
