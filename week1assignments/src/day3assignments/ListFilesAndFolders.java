/**
 * 
 */
package day3assignments;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

/**
 * @author matthew
 *
 */
public class ListFilesAndFolders {
	static String FILE_PATH = "."; // A file path (absolute, or relative to the project root

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		File f = new File(FILE_PATH);

		System.out.println("I am at:  " + f.getAbsolutePath() + "");
		System.out.println("The files and folders at my level are:  " + Arrays.toString(f.list()));

		System.out.println("The files and folders at my level, and below, are:");
		/*
		 * Found here: https://stackoverflow.com/a/24006711/5418498 with the only change
		 * being that we skip the filter because we are also listing directories
		 * and not just files
		 */
		try {
			Files.walk(Paths.get(FILE_PATH)).forEach(System.out::println);
			System.out.println("Finished!");
		} catch(UncheckedIOException e) {
			System.out.println("Uh oh! Try a different path whose files you have access to");
			e.printStackTrace();
		}

	}

}
