/**
 * 
 */
package saveourplanet;

import java.util.Scanner;

/**
 * @author kudzaivellem
 *
 */
public class Area extends Tile {

	private String areaName;
	private String areaDescription;
//	private boolean isOwned;
	private String ownerName;
	private int developmentLevel;
	private int buyingPrice;
	private int developmentPrice;

	/**
	 * default constructor
	 */
	public Area() {

	}

	/**
	 * constructor with args
	 * 
	 * @param areaName
	 * @param areaDescription
	 * @param isOwned
	 * @param developmentLevel
	 * @param buyingPrice
	 * @param developmentPrice
	 */
	public Area(String areaName, String areaDescription, String ownerName, int developmentLevel, int buyingPrice,
			int developmentPrice) {
		super();
		this.areaName = areaName;
		this.areaDescription = areaDescription;
		this.ownerName = ownerName;
//		this.isOwned = isOwned;
		this.developmentLevel = developmentLevel;
		this.buyingPrice = buyingPrice;
		this.developmentPrice = developmentPrice;
	}

	/**
	 * @return the areaName
	 */
	public String getAreaName() {
		return areaName;
	}

	/**
	 * @param areaName the areaName to set
	 */
	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 * @return the areaDescription
	 */
	public String getAreaDescription() {
		return areaDescription;
	}

	/**
	 * @param areaDescription the areaDescription to set
	 */
	public void setAreaDescription(String areaDescription) {
		this.areaDescription = areaDescription;
	}

	/**
	 * @return the isOwned
	 */
//	public boolean isOwned() {
//		return isOwned;
//	}

	/**
	 * @param isOwned the isOwned to set
	 */
//	public void setOwned(boolean isOwned) {
//		this.isOwned = isOwned;
//	}

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

	public void displayInfo() {
		System.out.println("Area name: " + this.areaName);
		System.out.println("Area description: " + this.areaDescription);
//		System.out.println("Area owned?: " + this.isOwned);
		System.out.println("Buying price: " + this.buyingPrice);
		System.out.println("Development level: " + this.developmentLevel);
		System.out.println("Development price: " + this.developmentPrice);
	}

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
