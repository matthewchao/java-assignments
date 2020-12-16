/**
 * 
 */
package day2assignments;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author matthew
 *
 */
public class CommandLineAddition {

	final static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		System.out.format("Calculated a sum of %d from %d command line arguments.\n\n", sumCommandLineArgs(args),
				args.length);

		System.out.print("Now enter in a row of integers here to sum,\n(or press <Enter> to skip:   ");

		Integer[] inputNums = intArrayFromString(scanner.nextLine());

		if (inputNums == null) {
			System.out.println("Nothing to calculate!");
		} else {
			System.out.format("\nCalculated a sum of %d from numbers in standard input.\n", sumArray(inputNums));
		}
	}

	/**
	 * 
	 * @param line A string with space-separated integers representing an array
	 * @return An integer array, or null if the string has no numbers, or can't be
	 *         parsed.
	 */
	static Integer[] intArrayFromString(String line) {
		try {
			if (line.trim().isEmpty()) {
				return null;
			}
			return Arrays.stream(line.trim().split("\s+")).map(Integer::parseInt).toArray(Integer[]::new);
		} catch (Exception e) {
			System.out.println("Bad input: I asked for a single row of integers!");
			e.printStackTrace();
			return null;
		}
	}

	static int sumArray(Integer[] ints) {
		int ans = 0;
		for (int x : ints) {
			ans += x;
		}
		return ans;
	}

	static int sumCommandLineArgs(String[] args) {
		try {
			return Arrays.stream(args).map(Integer::parseInt).reduce(0, (tot, curr) -> tot + curr);
		} catch (Exception e) {
			System.out.println("Bad command line args!");
			e.printStackTrace();
			return 0;
		}
	}

}
