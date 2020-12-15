/**
 * 
 */
package week1assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author matthew
 *
 */
public class StarPatterns {

	/**
	 * 
	 * @param n         The number of rows desired
	 * @param increment The amount by which a row exceeds the previous row
	 * @return An array whose element represent pyramid rows with increasing numbers
	 *         of stars
	 */
	static List<String> pyramid(int n, int increment) {
		if (n <= 0)
			return Collections.emptyList();
		String star = "*";

		List<String> ret = new ArrayList();

		ret.add(star);

		for (int i = 1; i < n; i++) {
			ret.add(ret.get(i - 1) + star.repeat(increment));
		}
		return ret;

	}

	static void printPyramid1(int n) {
		List<String> p = pyramid(n, 1);
		for (String row : p) {
			System.out.println(row);
		}
	}

	static void printPyramid2(int n) {
		List<String> p = pyramid(n,1);
		Collections.reverse(p);
		for (String row: p) {
			System.out.println(row);
		}
	}

	static private int BASE_PADDING = 2;
	static private String prefix = " ".repeat(BASE_PADDING);

	static void printPyramid3(int n) {
		// the last row gets 0 extra padding;
		// the second-to-last gets 1 extra padding;
		// ...
		// the first gets n-1 extra padding;

		List<String> orig = pyramid(n, 2);
		String space = " ";
		for (int i = 0; i < n; i++) {
			System.out.format("%s%s%s\n", prefix, space.repeat(n - 1 - i), orig.get(i));
		}

	}
	/*
	 *
	
	 */

	static void printPyramid4(int n) {
		// the last row gets 0 extra padding;
		// the second-to-last gets 1 extra padding;
		// ...
		// the first gets n-1 extra padding;

		List<String> orig = pyramid(n, 2);
		String space = " ";
		for (int i = n-1; i >=0 ; i--) {
			System.out.format("%s%s%s\n", prefix, space.repeat(n - 1 - i), orig.get(i));
		}

	}
	
	public static void main(String[] args) {
		System.out.println("1. ");
		StarPatterns.printPyramid1(5);
		
		System.out.println("2. ");
		StarPatterns.printPyramid2(5);
		
		System.out.println("3. ");
		StarPatterns.printPyramid3(5);
		
		System.out.println("4. ");
		StarPatterns.printPyramid4(5);
	}

}
