/*
* Date: 2021-09-23.
* File Name: ArrayIntList.Java
* Author: Emelie Åslund
*
*/

package ea224qb_assign2.excercise2;

/**
* Class Description: This class uses the AbstractCollection class and the 
* IntList interface to add, add at, remove, get and index of array lists.
* 
* @version 1.0 Sept 21
* @author Emelie Åslund
*/
public class ArrayIntList extends AbstractIntCollection implements IntList {
	/* Add integer n to the end of the list. */
	public void add(int n) {
		if (size == values.length) {
			resize();
		}
		
		values[size] = n;
		size++;
	}
	
	/* Inserts integer n at position index. Shifts the element currently at that 
	 * position (if any) and any subsequent elements to the right.  */
	public void addAt(int n, int index) throws IndexOutOfBoundsException {
		if (index > size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds. Maximum is: " + size);
		}
		
		if (index == size) {
			add(n);
		} else {
			if (size == values.length) {
				resize();
			}
			for (int i = size; i > index; i--) {
				values[i] = values[i-1];
			}
			values[index] = n;
			size++;
		}
		
	}
	
	/* Remove integer at position index. */
	public void remove(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds. Maximum is: " + (int)(size-1));
		}
		
		for (int i = index; i < size; i++) {
			values[i] = values[i+1];
			//System.out.println(toString());
		}
		size--;
	}
	
	/* Get integer at position index. */
	public int get(int index) throws IndexOutOfBoundsException {
		if (index >= size || index < 0) {
			throw new IndexOutOfBoundsException("Index: " + index + " is out of bounds. Maximum is: " + (int)(size-1));
		}
		
		return values[index];
	}
	
	/* Number of integers currently stored. */
	public int size() {
		return size;
	}
	
	// Already Implemented in parent
//	/* Returns true if collection is empty. */
//	public boolean isEmpty() {
//		return size == 0;
//	}
//	
	/* Find position of integer n, otherwise return -1 */
	public int indexOf(int n) {
		for (int i = 0; i < size; i++) {
			if (n == values[i]) {
				return i;
			}
		}
		return -1;
	}
	
	// Already Implemented in parent
//	/* String of type "[ 7 56 -45 68 ... ]" */
//	public String toString() {
//		return "";
//		
//	}
}
