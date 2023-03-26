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
	private String ownerName;
	private int buyingPrice; // with power points MEDIUM
	private int developmentPrice; // with power points LARGE
	private int rentPrice; // with power points SMALL
	private int buyingReward; // with eco-points MEDIUM
	private int developmentReward; // with eco-points LARGE
	private int rentReward; // with eco-points SMALL
	

	// CONSTRUCTORS
	
	/**
	 * default constructor
	 */
	public Area() {

	}
	
	/**
	 * Constructor with arguments
	 * @param number
	 * @param name
	 * @param description
	 * @param ownerName
	 * @param buyingPrice
	 * @param developmentPrice
	 * @param rentPrice
	 * @param buyingReward
	 * @param developmentReward
	 * @param rentReward
	 */
	public Area(int number, String name, String description, String ownerName, int buyingPrice, int developmentPrice,
			int rentPrice, int buyingReward, int developmentReward, int rentReward) {
		super(number, name, description);
		this.ownerName = ownerName;
		this.buyingPrice = buyingPrice;
		this.developmentPrice = developmentPrice;
		this.rentPrice = rentPrice;
		this.buyingReward = buyingReward;
		this.developmentReward = developmentReward;
		this.rentReward = rentReward;
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
	 * @return the rentPrice
	 */
	public int getRentPrice() {
		return rentPrice;
	}

	/**
	 * @param rentPrice the rentPrice to set
	 */
	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
	}

	/**
	 * @return the buyingReward
	 */
	public int getBuyingReward() {
		return buyingReward;
	}

	/**
	 * @param buyingReward the buyingReward to set
	 */
	public void setBuyingReward(int buyingReward) {
		this.buyingReward = buyingReward;
	}

	/**
	 * @return the developmentReward
	 */
	public int getDevelopmentReward() {
		return developmentReward;
	}

	/**
	 * @param developmentReward the developmentReward to set
	 */
	public void setDevelopmentReward(int developmentReward) {
		this.developmentReward = developmentReward;
	}

	/**
	 * @return the rentReward
	 */
	public int getRentReward() {
		return rentReward;
	}

	/**
	 * @param rentReward the rentReward to set
	 */
	public void setRentReward(int rentReward) {
		this.rentReward = rentReward;
	}

	/**
	 * Method to display info about the area. Changes depending on whether or not the area is owned by another player. 
	 */
	public void displayInfo() {
		
		// displays info about the area
		System.out.println("Area name: " + this.getName());
		System.out.println("Area description: " + this.getDescription());
		
		// displays dynamic message depending on if the area is owned
		if (this.ownerName == null) {
			System.out.println("This area has not been purchased.");
			System.out.println("Buying price: " + this.buyingPrice);
		} else {
			System.out.println("This area is owned by " + this.ownerName);
			System.out.println("Development price: " + this.developmentPrice);
		}
		
	}

	/**
	 * Method to purchase and own an area.
	 */
	public void buyArea() {
		
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


	public void develop() {

	}

} // end of class

