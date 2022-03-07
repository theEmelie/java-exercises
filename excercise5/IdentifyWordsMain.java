/*
* Date: 2021-09-29.
* File Name: IdentifyWordsMain.Java
* Author: Emelie Åslund
*
*/

package ea224qb_assign2.excercise5;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
* Class Description: This class reads in a file, then create a new file, 
* remove all non-alphabetical characters and then write to the newly created file.
* 
* @version 1.0 Sept 29
* @author Emelie Åslund
*/
public class IdentifyWordsMain {
	public static void main(String[] args) {
		String currentLine = "";
		String filteredLine = "";
		
		try {
			FileReader fileReader = new FileReader("HistoryOfProgramming.txt"); // Read file
			FileWriter fileWriter = new FileWriter("words.txt"); // Write to file
			Scanner sc = new Scanner(fileReader);
			
			while(sc.hasNextLine()) {
				currentLine = sc.nextLine(); 
				filteredLine = currentLine.replaceAll("[^a-zA-Z ]", ""); // Remove non-alphabetical characters
				if (filteredLine != "") {
					filteredLine += "\r\n";
					fileWriter.write(filteredLine);
				}
			}
			
			sc.close();
			fileWriter.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
