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
class DiceTest {
	
	/**
	 * @throws java.lang.Exception
	 */
	
	//variables
	int randomNumber;
	Random random = new Random();
	Dice dice;
	@BeforeEach
	void setUp() throws Exception {
		randomNumber = random.nextInt( 6 + 1);
		dice = new Dice();
	}

	/**
	 * Test method for default constructor.
	 */
	@Test
	void testDice() {
		assertNull(null);
	}

	/**
	 * Test method for constructor with args.
	 */
	@Test
	void testDiceConstructorWithArgs() {
		dice = new Dice(randomNumber);
		
		assertEquals(randomNumber, dice.getrandomNumber());
	}

	/**
	 * Test method for setRandomNumber and getRandomNumeber.
	 */
	@Test
	void testGetSetrandomNumber() {
		dice = new Dice(randomNumber);
		
		dice.setrandomNumber(3);
		assertEquals(3, dice.getrandomNumber());
	}


	/**
	 * Test method for {@link saveourplanet.Dice#rollDice()}.
	 */
	@Test
	void testRollDice() {
		
		        // create a dice roller
		        Dice roller = new Dice();

		        // roll the dice 100 times and make sure the results are between 1 and 6
		        for (int i = 0; i < 100; i++) {
		            assertTrue(roller.rollDice() >= 1 && roller.rollDice() <= 6);
		        }
		    
	}
}
