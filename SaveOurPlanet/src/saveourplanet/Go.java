/**
 * 
 */
package saveourplanet;

/**
 * @author joyki
 *
 */
public class Go extends Tile {
	
	/**
	 * Default constructor
	 */
	public Go() {}

	/**
	 * Constructor with args
	 * @param number
	 * @param name
	 * @param description
	 */
	public Go(int number, String name, String description) {
		super(number, name, description);
		// TODO Auto-generated constructor stub
	}
	
	
	
	/**
	 * Method that adds powerpoints every time the player lands on the Go tile.
	 * @param player
	 */
	public static void goTile(Player player) {
		int powerPointRewards = 20;
		
		player.addPowerPoints(powerPointRewards);
		System.out.println(" Your powerpoints have been increased by: " + powerPointRewards);
		
	}
	
	
	
	

}
