/**
 * 
 */
package saveourplanet;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author joyki
 *
 */
class ChanceTest {

	/**
	 * @throws java.lang.Exception
	 */
	
	//variables
	Chance chance;
	String name, description;
	int number;
	int powerPoints;
	@BeforeEach
	void setUp() throws Exception {
		chance =  new Chance();
		number = 4;
		name = "Chance";
		description = "You have pulled the 'Government Grant' card!";
		powerPoints = 12;
	}

	/**
	 * Test method for default Constructor.
	 */
	@Test
	void testChance() {
		assertNull(null);
	}

	/**
	 * Test method for.
	 */
	@Test
	void testChanceConstructorWithArgs() {
		chance = new Chance(number, name, description);
		assertEquals(number, chance.getNumber());
		assertEquals(name, chance.getName());
		assertEquals(description, chance.getDescription());
	}

	/**
	 * Test method for governmentGrant.
	 */
	@Test
	void testGovernmentGrant() {
		Player player = new Player("jk", 1, 0, 30);
		chance.governmentGrant(player);
		assertTrue(player.getPowerPoints() >=0);
		
	}

	/**
	 * Test method for governmentTax.
	 */
	@Test
	void testGovernmentTax() {
		Player player = new Player("test", 1, 0, 30);
	    chance.governmentTax(player);
	    assertTrue(player.getPowerPoints() >= 0);
	}

	/**
	 * Test method for {@link saveourplanet.Chance#sharingIsCaring(saveourplanet.Player, saveourplanet.Player)}.
	 */
//	@Test
//	void testSharingIsCaring() {
//		 // Create two players with initial PowerPoints balances
//	    Player p1 = new Player("Alice", 1, 0, 50);
//	    Player p2 = new Player("Bob", 2, 0, 51);
//
//	 
//	    Object powerPoints;
//		// Call the method with a randomly generated amount of PowerPoints
//	    chance.sharingIsCaring(p1, p2);
//	    
////	    int powerPoints = 10;
//	    // Check that PowerPoints were transferred correctly
////	    assertEquals(p1.getPowerPoints(), 50 - powerPoints);
////	    assertEquals( p2.getPowerPoints(), 51 + powerPoints);
//	}
	

	/**
	 * Test method for {@link saveourplanet.Chance#makeThemPay(saveourplanet.Player, saveourplanet.Player)}.
	 */
//	@Test
//	void testMakeThemPay() {
//		//create to player instances
//		Player p1 = new Player("jk", 1, 0, 50);
//		Player p2 = new Player("jj", 2, 0, 60);
//		
//		//get initial powerpoints of players
//		int p1InitialPowerPoints = p1.getPowerPoints();
//		int p2InitialPowerPoints = p2.getPowerPoints();
//		
//		//call make them pay method
//		chance.makeThemPay(p1, p2);
//		
//		
//		//compare if powerpoints have changed
//		assertEquals(p1InitialPowerPoints  - powerPoints, p1.getPowerPoints());
//		assertEquals(p2InitialPowerPoints + powerPoints, p2.getPowerPoints());
//		
//	}

	/**
	 * Test method for {@link saveourplanet.Chance#skipAGo(saveourplanet.Player)}.
	 */
//	@Test
//	void testSkipAGo() {
//		fail("Not yet implemented");
//	}

	/**
	 * Test method for {@link saveourplanet.Chance#pullChanceCard(saveourplanet.Player, saveourplanet.Player)}.
	 */
//	@Test
//	void testPullChanceCard() {
//		fail("Not yet implemented");
//	}

}
