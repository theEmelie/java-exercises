/*
* Date: 2021-09-23.
* File Name: ArrayIntStack.Java
* Author: Emelie Åslund
*
*/

package ea224qb_assign2.excercise2;

/**
* Class Description: This class uses the AbstractIntCollection class and the 
* IntStack interface to create, remove and look at an array stack.
* 
* @version 1.0 Sept 23
* @author Emelie Åslund
*/
public class ArrayIntStack extends AbstractIntCollection implements IntStack {
	/* Add integer at top of stack. */
	public void push(int n) {
		if (size == values.length) {
			resize();
		}
		
		values[size] = n;
		size++;
	}
	
	/* Returns and removes integer at top of stack  */
	public int pop() throws IndexOutOfBoundsException {
		if (size <= 0) {
			throw new IndexOutOfBoundsException("Stack Empty");
		}
		
		size--;
		return values[size];
		
	}
	
	/* Returns without removing integer at top of stack */
	public int peek() throws IndexOutOfBoundsException {
		if (size <= 0) {
			throw new IndexOutOfBoundsException("Stack Empty");
		}
		
		return values[size-1];
	}
	
	// Already Implemented in parent
	/* Number of integers currently stored. */
//	public int size() {
//		return size;
//	}
	
	// Already Implemented in parent
	/* Returns true if collection is empty. */
//	public boolean isEmpty() {
//		return size == 0;
//	}
	
	// Already Implemented in parent
	/* String of type "[ 7 56 -45 68 ... ]" */
//	public String toString() {
//	}
}
