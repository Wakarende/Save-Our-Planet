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
	public void rollDice() {
		Random random = new Random();
		int die1 = random.nextInt(6) + 1;
		int die2 = random.nextInt(6) + 1;

		int roll = (die1 + die2);

		System.out.println("Dice 1: " + die1);
		System.out.println("Dice 2: " + die2);
		System.out.println("Total roll: " + roll);

	}

}

