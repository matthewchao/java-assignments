/**
 * 
 */
package day5assignments;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @author matthew
 *
 */
public class FridayThirteenth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDate d1 = LocalDate.of(2020, 12, 13);
		LocalDate d2 = LocalDate.of(2020, 3, 13);
		System.out.println(d1 + " was a Friday the thirteenth? " + isFridayThirteenth(d1));
		System.out.println(d2 + " was a Friday the thirteenth? " + isFridayThirteenth(d2));
	}

	private static boolean isFridayThirteenth(LocalDate d) {
		return d.getDayOfMonth() == 13 && d.getDayOfWeek() == DayOfWeek.FRIDAY;
	}
}
