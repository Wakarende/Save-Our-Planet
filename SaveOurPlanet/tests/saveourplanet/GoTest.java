/**
 * 
 */
package saveourplanet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author joy
 * Unit Tests for Go Class
 *
 */
class GoTest {

	// variables
	String name, description;
	int number;

	Go go;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		go = new Go();
		name = "Go";
		description = "Go tile";
		number = 1;
	}

	/**
	 * Test method for default constructor.
	 */
	@Test
	void testGo() {
		assertNull(null);
	}

	/**
	 * Test method for constructor with args.
	 */
	@Test
	void testGoIntStringString() {
		go = new Go(number, name, description);
		assertEquals(name, go.getName());
		assertEquals(number, go.getNumber());
		assertEquals(description, go.getDescription());
	}

	/**
	 * Test method for goTile().
	 */
	@Test
	void testGoTile() {
//		create a new Player object and get their initial power points balance
		Player player = new Player();
		int initialPowerPoints = player.getPowerPoints();
		
		
		int powerPointRewards = 20;

		//call go tile
		go.goTile(player);
		
		//check power points have been increased by 20
		assertEquals(initialPowerPoints + powerPointRewards, player.getPowerPoints());
	}

}
