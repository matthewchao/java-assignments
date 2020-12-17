/**
 * 
 */
package day3assignments;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author matthew
 *
 * Writes and appends 2 lines of text to a file in ./day3outputs,
 * creating the file (output.txt) if it's not already there.
 */
public class FileAppender {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String PATH_TO_DIRECTORY = "." + File.separator + "day3outputs";
		String FILE_NAME = "output.txt";
		String PATH_TO_FILE = PATH_TO_DIRECTORY + File.separator + FILE_NAME;
		File f = new File(PATH_TO_FILE);

		/*
		 * Passing true to the constructor turns on appending rather than overwriting.
		 */
		Writer fw = new FileWriter(f, true);
		String TEXT_TO_APPEND = "Hello, World!";
		// Prepend lineSeparator so that the second text gets appended with a new line
		String MORE_TEXT_TO_APPEND = System.lineSeparator()+"Still here?";
		try {
			fw.write(TEXT_TO_APPEND);
			fw.write(MORE_TEXT_TO_APPEND);
			System.out.println("Wrote both strings to the file!");
		} catch (Exception e) {
			System.out.println("Wasn't able to write to the file");
			e.printStackTrace();
		} finally {
			fw.flush();
			fw.close();
		}
	}

}
