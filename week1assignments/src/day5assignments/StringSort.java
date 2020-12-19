/**
 * 
 */
package day5assignments;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author matthew
 *
 */
public class StringSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> strings = Arrays.asList("a", "b", "ex", "hello", "world", "example", "emu", "verylongword");
		System.out.println("Original array:  "+strings);
		
		Comparator<String> compByLength = (s, t) -> (s.length() <= t.length() ? -1 : 1);
		Comparator<String> compByFirstChar = (s, t) -> (s.charAt(0) <= t.charAt(0) ? -1 : 1);
		Comparator<String> compByLeadingE = (s, t) -> (s.charAt(0) == 'e' ? -1 : 1);

		Collections.sort(strings, compByLength);
		System.out.println("By increasing length:  " + strings);
		
		Collections.sort(strings, compByLength.reversed());
		System.out.println("By decreasing length:  " + strings);
		
		Collections.sort(strings, compByFirstChar);
		System.out.println("By first character:  " + strings);
		
		Collections.sort(strings, compByLeadingE);
		System.out.println("By first character equalling 'e':  " + strings);
		
		Collections.sort(strings, (s1, s2) -> Utils.yourMethod(s1, s2));
		System.out.println("Again by first character equalling 'e':  " + strings);


	}

}

class Utils {
	public static int yourMethod(String s1, String s2) {
		if (s1.charAt(0) == 'e')
			return -1;
		return 1;
	}
}
