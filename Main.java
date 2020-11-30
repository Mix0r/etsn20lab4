import java.io.BufferedReader;
import java.io.FileReader;

public class Main {

	public static void main(String[] args) {

		String pattern = "";
		for (int i = 0; i < args.length - 1; i++) {
			pattern += args[i];
			if (i != args.length - 1) {
				pattern += " ";
			}
		}
		
		String fileLocation = args[args.length - 1];

		try {
			String line = "";
			BufferedReader br = new BufferedReader(new FileReader(fileLocation));
			System.out.println("Pattern: " + pattern + "\n");

			while ((line = br.readLine()) != null) {
				Boolean found = false;			
				String tempLine = line.toLowerCase();
				
				if (args.length == 1) {
					System.out.println("here");
					String[] split = tempLine.split(" ");
					
					for (String word : split) {
						if (word.equals(pattern)) {
							found = true;
						}
					}
				} else {
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
