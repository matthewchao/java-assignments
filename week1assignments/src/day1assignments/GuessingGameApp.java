/**
 * 
 */
package day1assignments;

import java.util.Scanner;

/**
 * @author matthew
 *
 */
public class GuessingGameApp {

	/**
	 * @param args
	 */

	private static int getGuess() {
		Scanner scanner = new Scanner(System.in);
		int guess = 0;
		while (true) {
			try {
				String inputString = scanner.nextLine();
				guess = Integer.parseInt(inputString);
				if (guess < 1 || guess > 100) {
					System.out.print("Please follow the instructions and try again:   ");
				} else {
					scanner.close();
					return guess;
				}
			} catch (Exception exception) {
				System.out.print("I didn't quite understand, try that again:   ");
			}
		}
	}

	public static void main(String[] args) {

		GuessingGame g = new GuessingGame();
		System.out.println("Let's play a game!  Try to guess my secret number!");
		while (g.hasMoves()) {
			System.out.format("Enter a guess from 1-100 (%d guesses left):   ", g.getMoves());

			int guess = getGuess();

			if (g.receiveGuess(guess)) {
				break;
			} else {
				System.out.println("Not quite... ");
			}
		}

		if (g.getWon()) {
			System.out.println("You won! Goodbye");
		} else {
			System.out.println("YOu lost! Goodbye");
		}

	}

}
