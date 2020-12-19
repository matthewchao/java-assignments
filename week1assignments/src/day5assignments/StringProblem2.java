/**
 * 
 */
package day5assignments;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author matthew
 *
 */
public class StringProblem2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l = Arrays.asList(3,44,0);
		System.out.println("Result:  "+encode(l));
	}

	private static String encode(List<Integer> l) {
		return l.stream().map(n -> {
			return (n % 2 == 0 ? "e" : "o") + n;
		}).collect(Collectors.joining(","));
	}

}
