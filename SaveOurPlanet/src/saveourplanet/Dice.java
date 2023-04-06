/**
 * 
 */
package saveourplanet;

import java.util.Random;

/**
 * @author kudzaivellem
 *
 */
public class Dice {

	/**
	 * instance var
	 */

	private int randomNumber;

	/**
	 * default constructor
	 */
	public Dice() {

	}

	/**
	 * constructor with args
	 * 
	 * @param numberOfDots
	 * @param randomNumber
	 */
	public Dice(int randomNumber) {
		super();
		this.randomNumber = randomNumber;
	}

	/**
	 * @return the numberOfDots
	 */
	public int getrandomNumber() {
		return randomNumber;
	}

	/**
	 * @param numberOfDots the numberOfDots to set
	 */
	public void setrandomNumber(int randomNumber) {
		this.randomNumber = randomNumber;
	}

	/**
	 * method to simulate dice roll
	 */
	public int rollDice() {

	
		Random random = new Random();
		int roll = random.nextInt(6) + 1;
		
		return roll; 


	}

	
}

