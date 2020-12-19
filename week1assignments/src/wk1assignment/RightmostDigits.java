/**
 * 
 */
package wk1assignment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author matthew
 *
 */
public class RightmostDigits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Integer> l = Arrays.asList(3, 33, 333, 20, -13, 3);
		System.out.println(rightmostDigits(l));

	}

	private static List<Integer> rightmostDigits(List<Integer> l) {
		return l.stream().map(n -> Math.abs(n) % 10).collect(Collectors.toList());
	}
}
