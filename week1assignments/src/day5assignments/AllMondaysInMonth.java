/**
 * 
 */
package day5assignments;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author matthew
 *
 */
public class AllMondaysInMonth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int month = 12;
		System.out.println("The mondays in this month are: ");
		for (LocalDate d: allMondays(month)) {
			System.out.println(d);
		}

	}

	
	private static List<LocalDate> allMondays(int month) {
		List<LocalDate> ans = new ArrayList<>();
		
		LocalDate systemClockDate = LocalDate.now();
		
		LocalDate baseDate = LocalDate.of(systemClockDate.getYear(),month, 1);
		for (int days = 0; days < baseDate.lengthOfMonth(); days++) {
			LocalDate shiftedDate = baseDate.plusDays(days);
			if (shiftedDate.getDayOfWeek()==DayOfWeek.MONDAY) {
				ans.add(shiftedDate);
			}
		}
		
		return ans;
	}
}
