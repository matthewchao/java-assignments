/**
 * 
 */
package day1assignments;

import java.util.Random;

/**
 * @author matthew
 * 
 * 
 *         Represents one guessing game with the specified bounds and maximum
 *         number of moves
 */
class GuessingGame {

	/**
	 * @param args
	 */

	private static int guessAllowance = 5;
	private static int upperBound = 100;
	private static int tolerance = 10;
	private int secretNumber;
	private int guesses;
	private boolean won;

	GuessingGame() {
		Random r = new Random();
		secretNumber = r.nextInt(upperBound);
		guesses = guessAllowance;
		won = false;
//		System.out.format("The number is %d\n",secretNumber);
	}

	/**
	 * Updates the number of moves left
	 * 
	 * @param guess The integer that was guessed
	 * @return Whether the guess is within the tolerance of the actual secret
	 */
	boolean receiveGuess(int guess) {
		guesses--;
		won = (Math.abs(guess - secretNumber) <= tolerance);
		return won;
	}

	int getMoves() {
		return guesses;
	}

	boolean hasMoves() {
		return guesses > 0;
	}

	boolean getWon() {
		return won;
	}
}
