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
public class DoubleNumbers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> l1 = Arrays.asList(1, 2, 3);
		List<Integer> l2 = Arrays.asList(6, 8, 6, 8, -1);
		List<Integer> l3 = Arrays.asList();
		System.out.println("Double of " + l1 + " is " + doubling(l1));
		System.out.println("Double of " + l2 + " is " + doubling(l2));
		System.out.println("Double of " + l3 + " is " + doubling(l3));

	}

	private static List<Integer> doubling(List<Integer> l) {
		return l.stream().map(x -> 2 * x).collect(Collectors.toList());
	}

}
