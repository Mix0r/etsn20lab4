import java.io.BufferedReader;
import java.io.FileReader;

/*
 * Application that searches a given text file for a given pattern and prints lines that matches given pattern.
 * Application can receive 1 or more words to search for and only returns lines that matches given patterns,
 * non case-sensitive.
 * Usage: [word1] [wordN..] ... [fileLocation]
 * 
 * @author Anthony Bui
 */


public class Main {

	public static void main(String[] args) {

		// Load pattern(s) given
		String pattern = "";
		for (int i = 0; i < args.length - 1; i++) {
			pattern += args[i];
			if (i != args.length - 1) {
				pattern += " ";
			}
		}
		
		// Load txt file location
		String fileLocation = args[args.length - 1];

		try {
			String line = "";
			BufferedReader br = new BufferedReader(new FileReader(fileLocation));
			System.out.println("Pattern: " + pattern + "\n");

			// Loop through all lines, convert to lower case and compare with pattern.
			while ((line = br.readLine()) != null) {
				Boolean found = false;			
				String tempLine = line.toLowerCase();
				
				// If only one word was given, we can split all the words and compare
				if (args.length == 1) {
					String[] split = tempLine.split(" ");
					
					for (String word : split) {
						if (word.equals(pattern)) {
							// Match found, change variable so that we can print the line found
							found = true;
						}
					}
				} else {
					// If 2 or more words were given
					if (tempLine.contains(pattern)) {
						found = true;
					}
				}
				
				if (found) {
					System.out.println(line);
				}
			}
			
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
