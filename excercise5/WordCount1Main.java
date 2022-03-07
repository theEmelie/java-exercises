/*
* Date: 2021-09-29.
* File Name: WordCount1Main.Java
* Author: Emelie Åslund
*
*/

package ea224qb_assign2.excercise5;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.HashSet;

/**
* Class Description: This is a main class that calls the different methods in Word.
* 
* @version 1.0 Sept 29
* @author Emelie Åslund
*/
public class WordCount1Main {

	public static void main(String[] args) {
		Word word;
		HashSet<Word> wordHashSet = new HashSet<Word>();
		TreeSet<Word> wordTreeSet = new TreeSet<Word>();
		
		try {
			FileReader fileReader = new FileReader("words.txt");
			Scanner sc = new Scanner(fileReader);
			
			while (sc.hasNext()) {
				String str = sc.next();
				word = new Word(str);
				wordHashSet.add(word);
				wordTreeSet.add(word);
			}
			
			System.out.println("Hash set size: " + wordHashSet.size());
			System.out.println("Tree set size: " + wordTreeSet.size());
			
			String treeStr = "";
			String hashStr = "";
			
			// Iterate the words in TreeSet
			for (Word w : wordTreeSet) {
				treeStr += w.getWord() + ", ";
			}
			
			System.out.println(treeStr);
			
			// Iterate the words in HashSet
			for (Word w : wordHashSet) {
				hashStr += w.getWord() + ", ";
			}
			
			System.out.println(hashStr);
			
			sc.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
