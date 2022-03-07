/*
* Date: 2021-09-23.
* File Name: CollectionMain.Java
* Author: Emelie Åslund
*
*/

package ea224qb_assign2.excercise2;

public class CollectionMain {
	
	public static void demoArrayIntList() {
		ArrayIntList arrList = new ArrayIntList();		
		
		System.out.println("---------------------------------");
		System.out.println("ADD METHOD");
		System.out.println("---------------------------------");
		// Add to array
		for (int i = 0; i < 9; i++) {
			arrList.add(i*i);
			System.out.println("Adding: " + i*i + " " + arrList);
		}
		
		System.out.println("---------------------------------");
		System.out.println("ADD AT METHOD");
		System.out.println("---------------------------------");
		arrList.addAt(21, 4);
		System.out.println("Adding 21 at index 4: " + arrList);
		arrList.addAt(8, 10);
		System.out.println("Adding 8 at index 10: " + arrList);
		arrList.addAt(231, 0);
		System.out.println("Adding 230 at index 0: " + arrList);
		
		try {
			arrList.addAt(1, 13);
		} catch (Exception e) {
			System.out.println("Trying to add at index 13 (non-existing), Exception Caught: " + e);
		}
		
		try {
			arrList.addAt(4, -1);
		} catch (Exception e) {
			System.out.println("Trying to add at index -1 (non-existing) Exception Caught: " + e);
		}
		System.out.println("---------------------------------");
		System.out.println("REMOVE METHOD");
		System.out.println("---------------------------------");
		System.out.println("Before removing from any indexes: " + arrList);
		
		// Remove index from array
		arrList.remove(0);
		System.out.println("Removing index 0 from list: " + arrList);
		
		arrList.remove(6);
		System.out.println("Removing index 6 from list: " + arrList);
		
		arrList.remove(9);
		System.out.println("Removing index 9 from list: " + arrList);
		
		try {
			arrList.remove(9);
		} catch (Exception e) {
			System.out.println("Trying to remove index 9 (non-existing), Exception Caught: " + e);
		}
		
		try {
			arrList.remove(-1);
		} catch (Exception e) {
			System.out.println("Trying to remove index -1 (non-existing), Exception Caught: " + e);
		}
		
		// Get index
		System.out.println("---------------------------------");
		System.out.println("GET METHOD");
		System.out.println("---------------------------------");
		System.out.println("Current Array List: " + arrList);
		System.out.println("Getting index 5: " + arrList.get(5));
		
		try {
			arrList.get(-1);
		} catch (Exception e) {
			System.out.println("Trying to get index -1 (non-existing), Exception Caught: " + e);
		}
		
		try {
			arrList.get(9);
		} catch (Exception e) {
			System.out.println("Trying to get index 9 (non-existing), Exception Caught: " + e);
		}
		
		// Get size of array
		System.out.println("---------------------------------");
		System.out.println("SIZE METHOD");
		System.out.println("---------------------------------");
		System.out.println("Current size of the array list: " + arrList.size());
		
		// Find position of n
		System.out.println("---------------------------------");
		System.out.println("INDEXOF METHOD");
		System.out.println("---------------------------------");
		System.out.println("Looking for value 0, should return 0. Returns: " + arrList.indexOf(0));
		System.out.println("Looking for value 16, should return 5. Returns: " + arrList.indexOf(16));
		System.out.println("Looking for value 64, should return 8. Returns: " + arrList.indexOf(64));
		System.out.println("Looking for value 2 (doesn't exist), should return -1. Returns: " + arrList.indexOf(2));
	}
	
	public static void demoArrayIntStack() {
		ArrayIntStack arrStack = new ArrayIntStack();
		
		System.out.println("---------------------------------");
		System.out.println("PUSH METHOD");
		System.out.println("---------------------------------");
		// Push index to stack
		for (int i = 0; i < 9; i++) {
			arrStack.push(i*i);
			System.out.println("Pushing: " + i*i + " " + arrStack);
			
		}
		System.out.println("---------------------------------");
		System.out.println("PEEK METHOD");
		System.out.println("---------------------------------");
		System.out.println("Peeking: " + arrStack.peek());
		
		System.out.println("---------------------------------");
		System.out.println("POP AND SIZE METHOD");
		System.out.println("---------------------------------");
		// Pop an index from stack, and see current size
		for (int i = 0; i < 9; i++) {
			System.out.println("Popping: " + arrStack.pop());
			System.out.println("Current Stack: " + arrStack);
			System.out.println("Current size: " + arrStack.size());
		}
		
		
		try {
			System.out.println("Popping: " + arrStack.pop());
		} catch(Exception e) {
			System.out.println("Trying to pop empty stack, Exception Caught: " + e);
		}
		
		try {
			System.out.println("Peeking: " + arrStack.peek());
		} catch(Exception e) {
			System.out.println("Trying to peek at empty stack, Exception Caught: " + e);
		}
		

	}

	public static void main(String[] args) {
		demoArrayIntList();
		demoArrayIntStack();

	}

}
