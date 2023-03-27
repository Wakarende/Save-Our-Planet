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
	
	public ArrayList<Tile> gameBoard = new ArrayList<>(); 
	
	public Game() {
		
	}

	/*
	 * Public ArrayList to store the players of the game 
	 * Used to access and create the leaderboard
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


	
	/**
	 * Creates the areas and tiles through which the game will be played. 
	 * This includes four main fields - technology, recycling, energy and conservation.
	 * Other tiles (Go and Rest) are also included
	 */
	private void createBoard() {
		
		// Rest and Go tiles
		Tile rest = new Tile(2, "Rest", "You landed on the 'Rest' tile! Take a breather - you earned it...");
		Tile go = new Go(1, "Go", "You landed on the 'Go' tile! Pickup some PowerPoints to celebrate your progress! Lord knows you need it.");

		// Chance tiles
		Chance chance1 = new Chance(4, "Chance Card!", null);
		Chance chance2 = new Chance(7, "Chance Card!", null);
		Chance chance3 = new Chance(10, "Chance Card!", null);
		Chance chance4 = new Chance(12, "Chance Card!", null);
		Chance chance5 = new Chance(16, "Chance Card!", null);
		
		// Tiles belonging to the Technology field - least expensive
		Area clothesApp = new Area(3, "2nd-Hand Clothes App", "Invest in this innovative app and become a leading vintage fashionista!", null, 15, 30, 10, 3, 5, 2, "Partner with popular clothing brands to expand your app and its influence."); 
		Area socialMediaCamp = new Area(5, "Social-Media Campaign", "Utilise the power of social media to spread climate awareness!", null, 10, 25, 5, 2, 3, 1, "Run advertisements to increase engagement and improve your campaign's scalability.");

		// Tiles belonging to the Recycling field
		Area bottleFarm = new Area(6, "Bottle Farm", "Buy this bottle farm to improve recycling and waste.", null, 20, 40, 15, 4, 8, 3, "Franchise your bottle farm to open multiple locations and increase clients."); 
		Area foodBank = new Area(8, "Food Waste Bank", "Invest in this food waste bank and help combat unnecessary waste.", null, 25, 50, 20, 6, 10, 5, "Hire additional workers so that the bank can operate on a 24-hour cycle."); 
		Area supermarket = new Area(9, "Sustainable Supermarket", "Buy this trendy new supermaket and offer sustainable eating options!", null, 30, 60, 25, 8, 12, 7, "Work with local traders to reduce your carbon footprint and provide top-quality groceries."); 
		
		// Tiles belonging to the Energy field - most expensive
		Area solarFarm = new Area(11, "Solar Farm", "Utilise the power of the sun to create energy for your local community.", null, 40, 80, 25, 15, 17, 10, "Invest in research to optimise the farm and improve its solar technology."); 
		Area windFarm = new Area(13, "Wind Farm", "By buying this farm, you can invest in wind as a sustainable form of energy.", null, 60, 100, 30, 17, 20, 13, "Buy more wind turbines to allow your farm to maximise its potential in harnessing sustainable energy."); 
		
		// Tiles belonging to the Conservation field
		Area beach = new Area(14, "Beach", "Invest in a beach nourishment plan to protect our coasts!", null, 20, 40, 15, 4, 8, 3, "Hire volunteers to create a litter-picking program."); 
		Area sanctuary = new Area(15, "Wildlife Sanctuary", "Purchase this wildlife sanctuary to save endangered animals.", null, 25, 50, 20, 6, 10, 5, "Open the sanctuary to the public to educate people on wildlife conservation issues."); 
		Area forest = new Area(17, "Forest", "Invest in this tree-protection scheme to protect a local forest", null, 30, 60, 25, 8, 12, 7, "Hire tree-surgeons to combat disease and pests in your forest."); 
		
		// populate gameBoard with tiles
		gameBoard.add(go); 
		gameBoard.add(rest); 
		gameBoard.add(clothesApp); 
		gameBoard.add(chance1); 
		gameBoard.add(socialMediaCamp); 
		gameBoard.add(bottleFarm); 
		gameBoard.add(chance2); 
		gameBoard.add(foodBank); 
		gameBoard.add(supermarket); 
		gameBoard.add(chance3); 
		gameBoard.add(solarFarm); 
		gameBoard.add(chance4); 
		gameBoard.add(windFarm); 
		gameBoard.add(beach); 
		gameBoard.add(sanctuary); 
		gameBoard.add(chance5); 
		gameBoard.add(forest); 
		 
	}
	
	/**
	 * Method to call the opening main menu.
	 * User is given choice to start New Game (1) or Quit (2). 
	 * If choosing to start a New Game, the user is brought to the tutorial level. 
	 * If choosing to Quit the game, the user exits the application. 
	 * At each stage in their decision, the user is asked to confirm their choice. 
	 */
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
				scanner.nextLine(); 

				switch (userInput) {

				// New Game
				case 1:
					// asks for confirmation
					System.out.println("You have chosen to create a new game. Is this correct? (yes/no)");
					userConfirmation = scanner.nextLine();
					// user leaves the application
					if (userConfirmation.equalsIgnoreCase("yes")) {
						tutorial = true;
					}
					break;

				// Quit Game
				case 2:
					// asks for confirmation
					System.out.println("You have chosen to quit game. Is this correct? (yes/no)");
					userConfirmation = scanner.nextLine();
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

			System.out.print("Enter your choice: ");

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
				mainMenu(scanner);
				return;
			default:
				System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 3);

	}
	
	/**
	 * Quits the game
	 */
	private void quit() {
		// inform the user they have quit the game
		System.out.println("You have quit the game. Thank you for playing 'Save Our Planet'.");

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
	 * Shows players scores and sorts them accordingly. 
	 * @param players
	 */
	private void displayLeaderboard() {
		
		// sort Players array list
//		Collections.sort(players, new CompareByEcoPoints());
				
		// iterating through player array list and calculating the winner	
		for (int loop = 0; loop < players.size(); loop++) {
			System.out.println(loop+1 + ": " + players.get(loop).getUsername() + " with " + players.get(loop).getEcoPoints() + " EcoPoints"); 
		}
				
	}

	/**
	 * Start game method
	 */
	private void startGame(Scanner scanner) {
		System.out.println("\nStart game!");
		setUpPlayer(scanner);
		showAllPlayersInfo();  
//		this.initialisGameTiles();
//		List<Tile> allTiles = this.getAllTiles();

//		for (Player player : this.getPlayers()) {
////			player.landsOnTile(allTiles.get(0), scanner, this);
//		}
	}
	
	
	

	/**
	 * Sets up the players for the game. Prompts the user to give the amount of
	 * players and uses a for loop to create these players
	 * 
	 * @param scanner
	 */
	private void setUpPlayer(Scanner scanner) {

		int playerTotal = this.chooseAmountOfPlayers(scanner);

		// Use playerTotal int to decide how many times user can enter a name for a player
		// and to determine their player number.
		for (int loop = 1; loop <= playerTotal; loop++) {

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
		int playerTotal = 0;

		boolean correctAmountOfPlayers = false;

		do {

			// Ask user for number of players and save to int playerTotal
			System.out.print(
					"\nA minimum of 2 players and a maximum of 4 players is allowed to play this game.\nPlease enter the number of players you have for this game: ");
			playerTotal = scanner.nextInt();

			if (playerTotal >= 2 && playerTotal <= 4) {
				System.out.println("\nYou have chosen " + playerTotal + " players. Now let's set the usernames.");
				correctAmountOfPlayers = true;
			} else {
				System.out.println("\nNumber of players not allowed. Please try again.");
			}

		} while (correctAmountOfPlayers == false);

		return playerTotal;

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
		Player newPlayer = new Player(newUsername, playerNumber, 0, 100);

		newPlayer.displayBalance();

		// Add as a complete player in the array list
		players.add(newPlayer);
	}

	/**
	 * Method to show all the information of all players in the game
	 */
	private void showAllPlayersInfo() {

		for (Player player : players) {
			player.displayPlayerInfo();
		}
	}

	private void initialisGameTiles() {

		List<Tile> gameTiles = new ArrayList();

		
		
//		gameTiles.add(new Tile(1, "First", "first tile", 20, 20, 5, 5));
		this.setAllTiles(gameTiles);
	}

//	public void auctionTile(Tile tile, Player currentPlayer, Scanner scanner) {
//
//		int highestBid = 0;
//		boolean newPlayerHighestBid = false;
//
//		do {
//			for (Player player : this.getPlayers()) {
//
//				newPlayerHighestBid = false;
//
//				if (!(player.getUsername() == currentPlayer.getUsername())) {
//
//					boolean playerCanAffordTile = (player.getEcoPoints() > tile.getEcoPointsBuy()
//							|| player.getPowerPoints() > tile.getPowerPointsBuy());
//
//					if (playerCanAffordTile) {
//
//						int playerBid = player.buyTileInAuction(tile, scanner);
//
//						if (playerBid > highestBid) {
//							playerBid = highestBid;
//							newPlayerHighestBid = true;
//						}
//
//					}
//
//				}
//			}
//		} while (newPlayerHighestBid == false);
//	}
}
