package saveourplanet;

import java.util.List;
import java.util.Scanner;

public class Main {

	private static final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		Game game = new Game();
		
		// Ascii art
		game.asciiArt();

		// Start menu
//		game.mainMenu(scanner);
		
		
	
		scanner.close();

	}
}
