/**
 * 
 */
package day2assignments;

import java.util.Scanner;

/**
 * @author matthew
 *
 */
public class ArrayMaximum {
    static final Scanner scanner = new Scanner(System.in);


	public static int[][] readMatrixFromInput(int m, int n) {

		System.out.println("Enter the elements of the matrix, " + "one per line:");
		int[][] matrix = new int[m][n];

		try {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					matrix[i][j] = scanner.nextInt();
				}
			}
		} catch (Exception e) {
			System.out.println("uh oh: ");
			e.printStackTrace();

		}
		return matrix;
	}

	public static void main(String[] args) {
		System.out.print("Enter the number of rows, and the number of columns," + " separated by a space:  ");

		int m = scanner.nextInt();
		int n = scanner.nextInt();

		int[][] matrix = readMatrixFromInput(m, n);
		int[] ans = locateMax(matrix, m, n);

		System.out.format("The maximum occurs at (%d,%d).\n", ans[0], ans[1]);

	}

	/**
	 * 
	 * @param matrix A 2D array of numbers
	 * @param m      The number of rows in the array
	 * @param n      The number of columns in the array
	 * @return A 2-element array ans where (ans[0],ans[i]) are coordinates of any
	 *         maximum of the array. Specifically it finds the maximum that occurs
	 *         'earliest' where earliest means in the earliest row,
	 *         or if there is a tie in one row, in the earliest column.
	 *         Returns {-1,-1} if the matrix does not have at least m rows
	 *         or at least n columns per row
	 */
	static int[] locateMax(int[][] matrix, int m, int n) {
		int ans[] = new int[2];

		ans[0] = 0;
		ans[1] = 0;
		int runningMaxVal = Integer.MIN_VALUE;

		try {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (matrix[i][j] > runningMaxVal) {
						runningMaxVal = matrix[i][j];
						ans[0] = i;
						ans[1] = j;
					}
				}
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Bad input; matrix does not have at least m rows " + "or at least n rows per column");
			e.printStackTrace();
			ans[0] = -1;
			ans[1] = -1;

		}

		return ans;
	}
}
