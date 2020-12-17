/**
 * 
 */
package day3assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author matthew
 *
 */
public class CharCounter {

	/**
	 * @param args A single command line argument consisting of the character to be
	 *             counted
	 */
	public static void main(String[] args) {

		char charToCount = 'a';
		try {
			charToCount = args[0].charAt(0);
		} catch (Exception e) {
			System.out.println(
					"If you want to count a particular letter, please put it as a single command line argument");
			e.printStackTrace();
		}
		System.out.println("Searching for character:  " + charToCount);

		String FILE_NAME = "text-to-search.txt";
		String FILE_DIRECTORY = "." + File.separator + "day3inputs";
		String pathToFile = FILE_DIRECTORY + File.separator + FILE_NAME;
		File f = new File(pathToFile);

		try (Reader fr = new FileReader(f);) {

			int currChar;
			int count = 0;
			/*
			 * the assignment before != evaluates to the latest character, or to -1 if the
			 * end of the file is reached.
			 */
			while ((currChar = fr.read()) != -1) {
				if ((char) (currChar) == charToCount)
					count++;
			}
			System.out.println("Done reading; found " + count + " occurrences of " + charToCount);
		} catch (FileNotFoundException e) {
			System.out.println("Check the file name!");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Problem reading the file...");
			e.printStackTrace();
		}
	}

}
