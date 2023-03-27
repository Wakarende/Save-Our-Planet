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
	private List<Player> players = new ArrayList<>();

	private List<String> playerUsernames = new ArrayList<>();

	private List<Tile> allTiles = new ArrayList<>();

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<String> getPlayerUsernames() {
		return playerUsernames;
	}

	public void addToPlayerUsernames(String newUsername) {
		this.playerUsernames.add(newUsername);
	}

	public List<Tile> getAllTiles() {
		return allTiles;
	}

	public void setAllTiles(List<Tile> allTiles) {
		this.allTiles = allTiles;
	}

	/**
	 * Create Ascii art at beginning of game
	 */
	public void asciiArt() {
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

	public void mainMenu(Scanner scanner) {

		try {

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
				System.out.print("Please enter either 1 or 2: ");

				// record the user's decision in the scanner
				userInput = scanner.nextInt();

				switch (userInput) {

				// New Game
				case 1:
					// asks for confirmation
					System.out.println("You have chosen to create a new game. Is this correct? (yes/no)");
					userConfirmation = scanner.next();
					// user leaves the application
					if (userConfirmation.equalsIgnoreCase("yes")) {
						tutorial = true;
					}
					break;

				// Quit Game
				case 2:
					// asks for confirmation
					System.out.println("You have chosen to quit game. Is this correct? (yes/no)");
					userConfirmation = scanner.next();
					// user leaves the application
					if (userConfirmation.equalsIgnoreCase("yes")) {
						tutorial = false;
					}
					break;

				// Default statement
				default:
					System.out.println("Wrong input! Please try again...\n");
					break;
				}

			} while (userConfirmation.equalsIgnoreCase("no"));

			// use the boolean to decide which module of the game the player is moving on to
			if (tutorial == true) {
				tutorial(scanner);
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
	private void tutorial(Scanner scanner) {

		int choice;

		do {
			System.out.println("Menu:");
			System.out.println("1. Rules");
			System.out.println("2. Start game");
			System.out.println("3. Exit");

			System.out.print("\nEnter your choice: ");
			choice = scanner.nextInt();

			switch (choice) {
			case 1:
				displayRules();
				break;
			case 2:
				startGame(scanner);
				break;
			case 3:
				System.out.println("Exiting Tutorial!");
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 3);

	}

	/**
	 * Quits the game/application.
	 */
	private void quit() {
		// inform the user they have quit the game
		System.out.println("You have quit the game. Thank you for playing 'Save Our Planet'!");
	}

	/**
	 * Displays game rules
	 */
	private void displayRules() {
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
	private void slowPrint(String str) throws InterruptedException {
		for (char c : str.toCharArray()) {
			System.out.print(c);
			Thread.sleep(10); // pause between characters
		}
		System.out.print(" ");
	}

	/**
	 * Shows players scores and sorts them accordingly
	 * 
	 * @param players
	 */
	private void displayLeaderboard(List<Player> players) {

	}

	/**
	 * Method Start game method
	 */
	private void startGame(Scanner scanner) {
		System.out.println("\nStart game!");
		setUpPlayer(scanner);
		showAllPlayersInfo();
		this.initialisGameTiles();
		List<Tile> allTiles = this.getAllTiles();
		
		int initialAmountOfPlayers = this.players.size();

		// Continue game until there is only one player left standing
				do {
		for (Player player : this.getPlayers()) {
			
			System.out.println("\nIt is the turn of: " + player.getUsername() + ". Please enter a character to proceed. ");
			scanner.next();
			player.landsOnTile(allTiles.get(0), scanner, this);
		}
		} while(initialAmountOfPlayers == this.players.size());
	}

	/**
	 * Sets up the players for the game. Prompts the user to give the amount of
	 * players and uses a for loop to create these players
	 * 
	 * @param scanner
	 */
	private void setUpPlayer(Scanner scanner) {

		int playerTot = this.chooseAmountOfPlayers(scanner);

		// Use playerTot int to decide how many times user can enter a name for a player
		// and to determine their player number.
		
		for (int loop = 1; loop <= playerTot; loop++) {

			System.out.println("\nCreating a new player...");
			this.createPlayer(scanner, loop);
		}
		
	}

	/**
	 * Prompts user to choose amount of players and keeps them in a loop until they
	 * choose the right amount of players
	 * 
	 * @return amount of players chosen
	 */
	private int chooseAmountOfPlayers(Scanner scanner) {

		// Confirm there are enough players to meet requirements for game (between 2 and
		// 4)
		int playerTot = 0;

		boolean correctAmountOfPlayers = false;

		do {

			// Ask user for number of players and save to int playerTot
			System.out.print(
					"\nA minimum of 2 players and a maximum of 4 players is allowed to play this game.\nPlease enter the number of players you have for this game: ");
			playerTot = scanner.nextInt();

			if (playerTot >= 2 && playerTot <= 4) {
				System.out.println("\nYou have chosen " + playerTot + " players. Now let's set the usernames.");
				correctAmountOfPlayers = true;
			} else {
				System.out.println("\nNumber of players not allowed. Please try again.");
			}

		} while (correctAmountOfPlayers == false);

		return playerTot;

	}

	/**
	 * Creates a player, validating that their username - making sure it's within
	 * the character limits and hasn't been chosen yet. Also sets the player's
	 * initial score
	 * 
	 * @return
	 */
	private void createPlayer(Scanner scanner, int playerNumber) {

		// Needs to be calculated each new loop
		List<String> currentPlayerUsernames = this.getPlayerUsernames();

		// Setting userName, validation is inside setter method
		String newUsername = Player.createUsername(currentPlayerUsernames, scanner);

		// And add to the list of existing player names
		this.addToPlayerUsernames(newUsername);

		System.out.println("\nYou are player number: " + playerNumber);

		// Finally creating the player
		Player newPlayer = new Player(newUsername, playerNumber, 100, 100);

		newPlayer.displayBalance();

		// Add as a complete player in the array list
		players.add(newPlayer);

	}

	private void showAllPlayersInfo() {

		for (Player player : players) {
			player.displayPlayerInfo();
		}
	}

	private void initialisGameTiles() {

		List<Tile> gameTiles = new ArrayList();

		gameTiles.add(new Tile(1, "First", "first tile", 20, 20, 5, 5));
		this.setAllTiles(gameTiles);
	}

	public void auctionTile(Tile tile, Player currentPlayer, Scanner scanner) {

		int highestBid = 0;
		boolean newPlayerHighestBid = false;

		do {
			for (Player player : this.getPlayers()) {

				newPlayerHighestBid = false;

				if (!(player.getUsername() == currentPlayer.getUsername())) {

					boolean playerCanAffordTile = (player.getEcoPoints() > tile.getEcoPointsBuy()
							|| player.getPowerPoints() > tile.getPowerPointsBuy());

					if (playerCanAffordTile) {

						int playerBid = player.buyTileInAuction(tile, scanner);

						if (playerBid > highestBid) {
							playerBid = highestBid;
							newPlayerHighestBid = true;
						}

					}

				}
			}
		} while (newPlayerHighestBid == false);
	}
	
	/**
	 * Ends a game by deleting the current player from the list - thereby
	 * stopping the do while loop in the start game method
	 */
	public void endGame(Player player) {
		
		this.players.remove(player);
		
		System.out.println("\nGame has ended because "+ player.getUsername() + " is broke\n"
				+ "Their final totals are  " + player.getEcoPoints() + " ecopoints and " + player.getPowerPoints() + " power points");
		
		
	}
}
