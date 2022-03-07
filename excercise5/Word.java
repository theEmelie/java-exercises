/*
* Date: 2021-09-29.
* File Name: Word.Java
* Author: Emelie Åslund
*
*/

package ea224qb_assign2.excercise5;

/**
* Class Description: This class compares two words, 
* get a hash value for a word, check if two words are equals and get the word.
* 
* @version 1.0 Sept 29
* @author Emelie Åslund
*/
public class Word implements Comparable<Word> {
	private String word;
	
	public Word(String str) {
		word = str.toLowerCase();
	}
	
	public String toString() {
		return word;
	}
	
	/* Compute a hash value for word */
	public int hashCode() {
		return word.hashCode();
	}
	
	/* True if two words are equal */
	public boolean equals(Object other) {
		String str = ((Word) other).getWord();
		
		return word.equals(str); 
	}

	/* Return word */
	public String getWord() {
		return word;
	}
	
	/* Compares two words lexicographically */
	public int compareTo(Word w) {
		return word.compareTo(w.getWord());
	}
	
//	public static void main(String[] args) { 
//		Word wordOne = new Word("hello");
//		Word wordTwo = new Word("hellos");
//		HashSet<Word> wordHashSet = new HashSet<Word>();
//		
//		wordHashSet.add(wordOne);
//		wordHashSet.add(wordTwo);
//		
//		System.out.println(wordHashSet);
//		
//		System.out.println(wordOne.compareTo(wordTwo));
//		System.out.println(wordOne.hashCode());
//		System.out.println(wordTwo.hashCode());
//	}
	
	
}
