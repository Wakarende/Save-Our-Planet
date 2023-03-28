/**
 * 
 */
package saveourplanet;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author joyki
 *
 */
class PlayerTest {

	//variables
	String username;
	int playerNumber, ecoPoints, powerPoints;
	int invalidPlayerNumberLow, invalidPlayerNumberHigh, invalidEcoPoints, invalidPowerPointsLow, invalidPowerPointsHigh;
	
	
	Player player;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		player  = new Player();
		username = "jk";
		playerNumber = 1;
		ecoPoints = 0;
		powerPoints = 80;
		invalidPlayerNumberHigh = 6;
		invalidPlayerNumberLow = -1;
		invalidEcoPoints = -1;
		invalidPowerPointsLow = -1;
		invalidPowerPointsHigh = 101;
	}

	/**
	 * Test method for default constructor.
	 */
	@Test
	void testPlayer() {
		assertNull(null);
	}

	/**
	 * Test method for constructor with args
	 */
	@Test
	void testPlayerConstructorWithArgs() {
		player = new Player(username, playerNumber, ecoPoints, powerPoints);
		assertEquals(username, player.getUsername());
		assertEquals(playerNumber, player.getPlayerNumber());
		assertEquals(ecoPoints, player.getEcoPoints());
		assertEquals(powerPoints, player.getPowerPoints());
	}

	/**
	 * Test method for getPlayerNumber and setPlayerNumber.
	 */
	@Test
	void testGetSetPlayerNumber() {
		player = new Player(username, playerNumber, ecoPoints, powerPoints);
		
		player.setPlayerNumber(3);
		assertEquals(3, player.getPlayerNumber());
	}



	/**
	 * Test method for getEcoPoints and setEcoPoints.
	 */
	@Test
	void testGetSetEcoPoints() {
		player = new Player(username, invalidPlayerNumberHigh, ecoPoints, invalidPowerPointsHigh);
		
		player.setEcoPoints(10);
		assertEquals(10, player.getEcoPoints());
	}


	/**
	 * Test method for {@link saveourplanet.Player#getPowerPoints()}.
	 */
	@Test
	void testGetSetPowerPoints() {
		player = new Player(username, playerNumber, ecoPoints, powerPoints);
		player.setPowerPoints(90);
		
		assertEquals(90, player.getPowerPoints());
	}
	/**
	 * Test method for addEcoPoints.
	 */
	@Test
	void testAddEcoPoints() {
		
		    int pointsToAdd = 10;
		    
		    player = new Player(username, playerNumber, ecoPoints, powerPoints);
		    
		    player.addEcoPoints(pointsToAdd);
		    
		    assertEquals(ecoPoints + pointsToAdd, player.getEcoPoints());
		
	}


	/**
	 * Test method for addPowerPoints.
	 */
	@Test
	void testAddPowerPoints() {
		int addPowerPoints = 10;
		
		player = new Player(username, playerNumber, ecoPoints, powerPoints);
		
		player.addPowerPoints(addPowerPoints);
		assertEquals(powerPoints + addPowerPoints, player.getPowerPoints());
		
		
	}

	/**
	 * Test method for minusPowerPoints.
	 */
	@Test
	void testMinusPowerPoints() {
		int minusPowerPoints =  10;
		player = new Player(username, playerNumber, ecoPoints, powerPoints);
		
		player.minusPowerPoints(minusPowerPoints);
		assertEquals(powerPoints - minusPowerPoints, player.getPowerPoints());
	}

}
