/**
 * 
 */
package day5assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author matthew
 *
 */
public class Generate3LetterStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<String> a = Arrays.asList("a");
		List<Character> alphabet = "abcdefghijklmnopqrstuvwxyz".chars().mapToObj(i -> (char) i)
				.collect(Collectors.toList());
		List<String> answer = new ArrayList<>();
		a.forEach(s -> {
			alphabet.forEach(letter2 -> {
				alphabet.forEach(letter3 -> {
					answer.add(s + letter2 + letter3);
				});
			});
		});

		System.out.println("Answer: ");
		for (String triplet : answer)
			System.out.println(triplet);
	}

}
