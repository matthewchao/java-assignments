/**
 * 
 */
package wk1assignment;

import java.util.Scanner;
import java.util.function.Function;

/**
 * @author matthew
 *
 */
public class PerformOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		isOdd().apply(3);

		System.out.println("Enter a number of test cases;"
				+ " then enter each test case as the type (1-3) and the argument (integer):  ");
		Scanner scanner = new Scanner(System.in);

		int n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			int queryType = scanner.nextInt();
			int parameter = scanner.nextInt();

			if (queryType == 1) {
				System.out.println(isOdd().apply(parameter) ? "ODD" : "EVEN");
			} else if (queryType == 2) {
				System.out.println(isPrime().apply(parameter) ? "PRIME" : "COMPOSITE");
			} else {
				assert (queryType == 3);
				System.out.println(isPalindrome().apply(parameter) ? "PALINDROME" : "NOT PALINDROME");
			}
		}
		scanner.close();
		System.out.println("Goodbye!");
		

	}

	private static Function<Integer, Boolean> isOdd() {
		return (n -> (n % 2 == 1));
	}

	private static Function<Integer, Boolean> isPrime() {
		return n -> {
			if (n <= 0)
				throw new ArithmeticException("primality undefined for negative numbers");
			if (n == 1)
				return true;

			// if n is composite, then it has at least one factor at most sqrt(n)
			for (int d = 2; d * d <= n; d++) {
				if (n % d == 0)
					return false;
			}
			return true;
		};
	}

	private static Function<Integer, Boolean> isPalindrome() {
		return n -> {
			String stringRep = n.toString();
			int d = stringRep.length();
			for (int leftPtr = 0, rightPtr = d - 1; leftPtr < rightPtr; leftPtr++, rightPtr--) {
				if (stringRep.charAt(leftPtr) != stringRep.charAt(rightPtr))
					return false;
			}
			return true;
		};
	}
}
