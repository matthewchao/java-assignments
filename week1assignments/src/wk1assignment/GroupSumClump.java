/**
 * 
 */
package wk1assignment;

import java.util.ArrayList;
import java.util.List;

/**
 * @author matthew
 *
 */
public class GroupSumClump {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a1 = new int[] { 2, 4, 8 };
		int[] a2 = new int[] { 1, 2, 4, 8, 1 };
		int[] a3 = new int[] { 2, 4, 4, 8 };
		int[] a4 = new int[] { -2, -2, 3 };
		int[] a5 = new int[] { -1, -1, 3 };

		System.out.println(groupSumClump(10, a1));
		System.out.println(groupSumClump(14, a2));
		System.out.println(groupSumClump(14, a3));
		System.out.println(groupSumClump(-1, a4));
		System.out.println(groupSumClump(2, a5));

	}

	/**
	 * In one pass, creates an auxiliary array int[] b where "clumps" of a
	 * correspond to elements of b. Then solves the Subset Sum problem on b using a
	 * well-known algorithm. This reduction to the subset sum problem is possible
	 * because the constraint that "all or none" of a contiguous sequence of
	 * identical elements in a be used, is equivalent to a single element of b being
	 * used or unused.
	 * 
	 * @param target
	 * @param a
	 * @return
	 */
	private static boolean groupSumClump(int target, int[] a) {
		return subsetSum(target, clump(a));
	}

	/**
	 * Clumps and sums identical adjacent elements, E.g., [1,2,2,3] -> [1,4,3] E.g.,
	 * [1,2,3] -> [1,2,3] E.g., [1,1,1,1] -> [4]
	 * 
	 * @param a An array of integers whose clumps we will consolidate
	 * @return An array where each element x corresponds to an element x in a, or x
	 *         = y*k for some element y of which there are k sequential copies in a
	 */
	private static int[] clump(int[] a) {

		List<Integer> clumps = new ArrayList<>();
		Integer prev = null; // the last integer encountered
		for (int i = 0; i < a.length; i++) {
			if (Integer.valueOf(a[i]).equals(prev)) {
				int m = clumps.size();
				clumps.set(m - 1, clumps.get(m - 1) + prev);
			} else {
				clumps.add(a[i]);
				prev = a[i];
			}
		}
		return clumps.stream().mapToInt(Integer::intValue).toArray();
	}

	/**
	 * Implements the algorithm described here:
	 * https://en.wikipedia.org/wiki/Subset_sum_problem#Pseudo-polynomial_time_dynamic_programming_solution
	 * 
	 * @param target The number we are trying to sum up to, using a subset of a
	 * @param a      An array of ints representing a multiset of ints
	 * @return Whether there exists a subset of a, summing to target.
	 */
	private static boolean subsetSum(int target, int[] a) {

		int negSum = 0;
		int posSum = 0;
		for (int x : a) {
			negSum += Math.min(x, 0);
			posSum += Math.max(x, 0);
		}
		// the sum of any nonempty subset of a, lies in [negSum,posSum].
		if (target > posSum || target < negSum)
			return false;

		int N = a.length;
		int d = -negSum; // an offset because we can't use negative array indices
		boolean[][] qd = new boolean[N][posSum - negSum + 1];
//		 Define:   qd[i][x+d] = whether a nonempty subset of {a[0],...,a[i]} sums to x
		qd[0][a[0] + d] = true; // base case; trivially true because the subset {a[0]} of {a[0]} sums to a[0].

		for (int i = 1; i < N; i++) {
			for (int s = negSum; s <= posSum; s++) {
//				//the sum s is attainable using q[i]
				qd[i][s + d] = qd[i - 1][s + d]; // a subset before a[i] sums to s;
				qd[i][s + d] |= (a[i] == s); // a[i] alone sums to s;
				qd[i][s + d] |= (s - a[i] <= posSum) && (s - a[i] >= negSum) && qd[i - 1][s - a[i] + d]; // a[i] is used
																											// to
			}
		}

		return qd[N - 1][target + d];
	}

}
