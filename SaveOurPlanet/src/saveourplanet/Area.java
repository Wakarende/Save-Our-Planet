/**
 * 
 */
package saveourplanet;

import java.util.Scanner;

/**
 * @author kudzaivellem, phil
 *
 */
public class Area extends Tile {

	// instance variables
	private boolean isAreaOwned;
	private String ownerName;
	private int developmentLevel;
	private int buyingPrice;
	private int developmentPrice;

	// CONSTRUCTORS
	
	/**
	 * default constructor
	 */
	public Area() {

	}
	
	/**
	 * Constructor with arguments for Area tile. 
	 * Uses Tile as superclass - inherited from Field as a result. 
	 * @param fieldName
	 * @param isFieldOwned
	 * @param number
	 * @param name
	 * @param description
	 * @param isAreaOwned
	 * @param ownerName
	 * @param developmentLevel
	 * @param buyingPrice
	 * @param developmentPrice
	 */
	public Area(String fieldName, boolean isFieldOwned, int number, String name, String description,
			boolean isAreaOwned, String ownerName, int developmentLevel, int buyingPrice, int developmentPrice) {
		super(fieldName, isFieldOwned, number, name, description);
		this.isAreaOwned = isAreaOwned;
		this.ownerName = ownerName;
		this.developmentLevel = developmentLevel;
		this.buyingPrice = buyingPrice;
		this.developmentPrice = developmentPrice;
	}

	/**
	 * @return the isAreaOwned
	 */
	public boolean isAreaOwned() {
		return isAreaOwned;
	}

	/**
	 * @param isAreaOwned the isAreaOwned to set
	 */
	public void setAreaOwned(boolean isAreaOwned) {
		this.isAreaOwned = isAreaOwned;
	}

	/**
	 * @return the developmentLevel
	 */
	public int getDevelopmentLevel() {
		return developmentLevel;
	}

	/**
	 * @param developmentLevel the developmentLevel to set
	 */
	public void setDevelopmentLevel(int developmentLevel) {
		this.developmentLevel = developmentLevel;
	}

	/**
	 * @return the buyingPrice
	 */
	public int getBuyingPrice() {
		return buyingPrice;
	}

	/**
	 * @param buyingPrice the buyingPrice to set
	 */
	public void setBuyingPrice(int buyingPrice) {
		this.buyingPrice = buyingPrice;
	}

	/**
	 * @return the developmentPrice
	 */
	public int getDevelopmentPrice() {
		return developmentPrice;
	}

	/**
	 * @param developmentPrice the developmentPrice to set
	 */
	public void setDevelopmentPrice(int developmentPrice) {
		this.developmentPrice = developmentPrice;
	}

	/**
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * @param ownerName the ownerName to set
	 */
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * Method to display info about the area. Changes depending on whether or not the area is owned by another player. 
	 */
	public void displayInfo() {
		
		// displays info about the area
		System.out.println("Area name: " + this.getName());
		System.out.println("Area description: " + this.getDescription());
		
		// displays dynamic message depending on if the area is owned
		if (this.isAreaOwned == false) {
			System.out.println("This area has not been purchased.");
			System.out.println("Buying price: " + this.buyingPrice);
		} else {
			System.out.println("This area is owned by " + this.getOwnerName());
			System.out.println("Development level: " + this.developmentLevel);
			System.out.println("Development price: " + this.developmentPrice);
		}
		
	}

	/**
	 * Method to purchase and own an area.
	 */
	public void ownArea() {
		
		Player player = new Player();
		Scanner scanner = new Scanner(System.in);
		String playerResponse;

		if (ownerName != null) {
			System.out.println("Area owned by: " + ownerName);
		} else {
			System.out.println("Area not owned. Would you like to buy it? ");
		}
		playerResponse = scanner.nextLine();
		if (playerResponse.equalsIgnoreCase("Yes") || playerResponse.equalsIgnoreCase("Y")) {
			System.out.println("This will cost you: " + this.buyingPrice + ". Do you want to proceeed? ");
			playerResponse = scanner.nextLine();
			if (playerResponse.equalsIgnoreCase("Yes") || playerResponse.equalsIgnoreCase("Y")) {
				player.minusPowerPoints(buyingPrice);
				ownerName = player.getUsername();
				System.out.println(ownerName + " now owns this area. " + player.getPowerPoints()
						+ " powerpoints and " + player.getEcoPoints() + " ecopoints remaining");
			}
		} else {
			System.out.println("You have chosen not to buy this area!");
		}
		scanner.close();
	}

	public void increaseDevelopmentLevel() {

	}

	public void develop() {

	}

} // end of class

