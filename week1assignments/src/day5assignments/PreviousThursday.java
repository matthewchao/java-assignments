/**
 * 
 */
package day5assignments;

import java.time.DateTimeException;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * @author matthew
 *
 */
public class PreviousThursday {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalDate d = LocalDate.of(2020, 12, 19);
		System.out.println("Starting at date "+d+", a "+d.getDayOfWeek());
		
		System.out.println("The previous Thursday is: "+prevThursday(d));
		
	}
	
	/**
	 * @param d A date
	 * @return The most recent date (strictly) before d which is a Thursday
	 * @throws DateTimeException
	 */
	private static LocalDate prevThursday(LocalDate d) throws DateTimeException {
		for (int days = 1; days<=7; days++) {
			if (d.minusDays(days).getDayOfWeek()==DayOfWeek.THURSDAY) {
				return d.minusDays(days);
			}
			
		}
		
		throw new DateTimeException("Impossible situation: given date doesn't have Thursday in previous 7 days");
	}
	
	

}

