/**
 * 
 */
package day5assignments;

import java.time.LocalDate;
import java.time.Year;

/**
 * @author matthew
 * 
 */
public class DaysInEachMonth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int year = 2020;
		System.out.println("For year " + year + ", the month lengths are as follows: ");
		report(year);
	}

	// Uses built-in methods to print the number of days in each month in a give year
	private static void report(int year) {
		LocalDate baseDate = LocalDate.of(year, 1, 1);
		for (int months = 0; months < 12; months++) {
			LocalDate shiftedDate = baseDate.plusMonths(months);
			System.out.println(shiftedDate.getMonth() + " has " + shiftedDate.lengthOfMonth() + " days.");
		}
	}
}
