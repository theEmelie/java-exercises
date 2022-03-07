package ea224qb_assign2.excercise2;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CollectionTest {

	ArrayIntList arrList;
	ArrayIntStack arrStack;
	
	@BeforeEach
	void setUp() throws Exception {
		arrList = new ArrayIntList();
		arrStack = new ArrayIntStack();
	}
	
	@Test
	@DisplayName("Test to add element to end of array list")
	void testAdd() {
		arrList.add(101);
		assertEquals(arrList.get(0), 101);
		assertEquals(arrList.size(), 1);
		
		arrList.add(5);
		assertEquals(arrList.get(1), 5);
		assertEquals(arrList.size(), 2);
	}
	
	@Test
	@DisplayName("Add 200 elements")
	void testAddManyElements() {
		for (int i = 0; i < 200; i++) {
			arrList.add(i*i);
		}

		assertEquals(arrList.get(0), 0);
		assertEquals(arrList.get(50), 2500);
		assertEquals(arrList.get(100), 10000);
	}
	
	@Test
	@DisplayName("Test array list resizes automatically")
	void testAddResize() {
		
		for (int i = 0; i < 9; i++) {
			arrList.add(i*i);
		}
		assertEquals(arrList.get(8), 64);
		assertEquals(arrList.get(4), 16);
		assertEquals(arrList.get(0), 0);
		assertEquals(arrList.size(), 9);
	}
	

	@Test
	@DisplayName("Remove index from middle of array list")
	void testRemoveMiddleOfList() {
		
		for (int i = 0; i < 4; i++) {
			arrList.add(i*i);
		}
		
		arrList.remove(2);
		
		assertEquals(arrList.get(0), 0);
		assertEquals(arrList.get(1), 1);
		assertEquals(arrList.get(2), 9);
	}
	
	@Test
	@DisplayName("Remove index from start of array list")
	void testRemoveStartOfList() {
		
		for (int i = 0; i < 4; i++) {
			arrList.add(i*i);
		}
		
		arrList.remove(0);
		
		assertEquals(arrList.get(0), 1);
		assertEquals(arrList.get(1), 4);
		assertEquals(arrList.get(2), 9);
	}
	
	@Test
	@DisplayName("Remove index from end of array list")
	void testRemoveEndOfList() {
		
		for (int i = 0; i < 4; i++) {
			arrList.add(i*i);
		}
		
		arrList.remove(3);
		
		assertEquals(arrList.get(0), 0);
		assertEquals(arrList.get(1), 1);
		assertEquals(arrList.get(2), 4);
	}
	
	@Test
	@DisplayName("Remove index that doesnt exist in array list")
	void testRemoveNonExistingOfList() throws Exception {
		for (int i = 0; i < 4; i++) {
			arrList.add(i*i);
		}
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> arrList.remove(4));
	
		assertEquals(arrList.get(0), 0);
		assertEquals(arrList.get(1), 1);
		assertEquals(arrList.get(2), 4);
		assertEquals(arrList.get(3), 9);
		assertEquals("Index: 4 is out of bounds. Maximum is: 3", exception.getMessage());
	}
	
	@Test
	@DisplayName("Remove negative index in array list")
	void testRemoveNegativeOfList() throws Exception {
		for (int i = 0; i < 4; i++) {
			arrList.add(i*i);
		}
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> arrList.remove(-1));
	
		assertEquals(arrList.get(0), 0);
		assertEquals(arrList.get(1), 1);
		assertEquals(arrList.get(2), 4);
		assertEquals(arrList.get(3), 9);
		assertEquals("Index: -1 is out of bounds. Maximum is: 3", exception.getMessage());
	}
	
	@Test
	@DisplayName("Add n at first index")
	void testAddAtFirstIndex() {
		for (int i = 0; i < 4; i++) {
			arrList.add(i*i);
		}
	
		arrList.addAt(5, 0);
		assertEquals(arrList.get(0), 5);
		assertEquals(arrList.get(1), 0);
		assertEquals(arrList.get(2), 1);
		assertEquals(arrList.get(3), 4);
		assertEquals(arrList.get(4), 9);
	}
	
	@Test
	@DisplayName("Add n at middle index")
	void testAddAtMiddleIndex() {
		for (int i = 0; i < 4; i++) {
			arrList.add(i*i);
		}
	
		arrList.addAt(5, 2);
		assertEquals(arrList.get(0), 0);
		assertEquals(arrList.get(1), 1);
		assertEquals(arrList.get(2), 5);
		assertEquals(arrList.get(3), 4);
		assertEquals(arrList.get(4), 9);
	}
	
	@Test
	@DisplayName("Add n at last index")
	void testAddAtLastIndex() {
		for (int i = 0; i < 4; i++) {
			arrList.add(i*i);
		}
	
		arrList.addAt(5, 4);
		assertEquals(arrList.get(0), 0);
		assertEquals(arrList.get(1), 1);
		assertEquals(arrList.get(2), 4);
		assertEquals(arrList.get(3), 9);
		assertEquals(arrList.get(4), 5);
	}
	
	@Test
	@DisplayName("Add n at random index, must resize array list")
	void testAddAtRandomIndexMakeResize() {
		for (int i = 0; i < 8; i++) {
			arrList.add(i*i);
		}
	
		arrList.addAt(101, 6);
		
		assertEquals(arrList.get(0), 0);
		assertEquals(arrList.get(1), 1);
		assertEquals(arrList.get(2), 4);
		assertEquals(arrList.get(3), 9);
		assertEquals(arrList.get(4), 16);
		assertEquals(arrList.get(5), 25);
		assertEquals(arrList.get(6), 101);
		assertEquals(arrList.get(7), 36);
		assertEquals(arrList.get(8), 49);
		assertEquals(arrList.size(), 9);
	}
	
	@Test
	@DisplayName("Add n at non existing index")
	void testAddAtNonExistingIndex() throws Exception {
		for (int i = 0; i < 4; i++) {
			arrList.add(i*i);
		}
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> arrList.addAt(5, 5));
	
		assertEquals(arrList.get(0), 0);
		assertEquals(arrList.get(1), 1);
		assertEquals(arrList.get(2), 4);
		assertEquals(arrList.get(3), 9);
		assertEquals("Index: 5 is out of bounds. Maximum is: 4", exception.getMessage());
	}
	
	@Test
	@DisplayName("Add n at negative index")
	void testAddAtNegativeIndex() throws Exception {
		for (int i = 0; i < 4; i++) {
			arrList.add(i*i);
		}
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> arrList.addAt(5, -1));
	
		assertEquals(arrList.get(0), 0);
		assertEquals(arrList.get(1), 1);
		assertEquals(arrList.get(2), 4);
		assertEquals(arrList.get(3), 9);
		assertEquals("Index: -1 is out of bounds. Maximum is: 4", exception.getMessage());
	}
	
	@Test
	@DisplayName("Find position of index in the beginning of the array list")
	void testFindIndexOfBeginning() throws Exception {
		for (int i = 0; i < 4; i++) {
			arrList.add(i*i);
		}
	
		assertEquals(arrList.indexOf(0), 0);

	}
	
	@Test
	@DisplayName("Find position of index in the middle of the array list")
	void testFindIndexOfMiddle() throws Exception {
		for (int i = 0; i < 4; i++) {
			arrList.add(i*i);
		}
	
		assertEquals(arrList.indexOf(4), 2);

	}
	
	@Test
	@DisplayName("Find position of index in the end of the array list")
	void testFindIndexOfEnd() throws Exception {
		for (int i = 0; i < 4; i++) {
			arrList.add(i*i);
		}
	
		assertEquals(arrList.indexOf(9), 3);

	}
	
	@Test
	@DisplayName("Find position of index that doesn't exist the array list")
	void testFindIndexOfNonExisting() throws Exception {
		for (int i = 0; i < 4; i++) {
			arrList.add(i*i);
		}
	
		assertEquals(arrList.indexOf(3), -1);

	}
	
	@Test
	@DisplayName("Get non exisiting index")
	void testGetNonExistingIndex() throws Exception {
		for (int i = 0; i < 4; i++) {
			arrList.add(i*i);
		}
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> arrList.get(4));
	
		assertEquals(arrList.get(0), 0);
		assertEquals(arrList.get(1), 1);
		assertEquals(arrList.get(2), 4);
		assertEquals(arrList.get(3), 9);
		assertEquals("Index: 4 is out of bounds. Maximum is: 3", exception.getMessage());
	}
	
	@Test
	@DisplayName("Get negative index")
	void testGetNegativeIndex() throws Exception {
		for (int i = 0; i < 4; i++) {
			arrList.add(i*i);
		}
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> arrList.get(-1));
	
		assertEquals(arrList.get(0), 0);
		assertEquals(arrList.get(1), 1);
		assertEquals(arrList.get(2), 4);
		assertEquals(arrList.get(3), 9);
		assertEquals("Index: -1 is out of bounds. Maximum is: 3", exception.getMessage());
	}
	
	// Tests of ArrayInStack
	
	@Test
	@DisplayName("Push to stack")
	void testPush() {
		arrStack.push(101);
		assertEquals(arrStack.peek(), 101);
		
		arrStack.push(103);
		assertEquals(arrStack.peek(), 103);

	}
	
	@Test
	@DisplayName("Push to stack and resize array list")
	void testPushResize() {
		for (int i = 0; i < 9; i++) {
			arrStack.push(i*i);
			
		}
		assertEquals(arrStack.peek(), 64);
		assertEquals(arrStack.size(), 9);

	}
	
	@Test
	@DisplayName("Pop top of stack")
	void testPopTop() {
		for (int i = 0; i < 4; i++) {
			arrStack.push(i*i);
			
		}
		arrStack.pop();
		
		assertEquals(arrStack.peek(), 4);
	}
	
	@Test
	@DisplayName("Pop empty stack")
	void testPopEmptyStack() throws Exception {
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> arrStack.pop());
	
		assertEquals("Stack Empty", exception.getMessage());
	}
	
	@Test
	@DisplayName("Peek empty stack")
	void testPeekEmptyStack() throws Exception {
		
		Throwable exception = assertThrows(IndexOutOfBoundsException.class, () -> arrStack.peek());
	
		assertEquals("Stack Empty", exception.getMessage());
	}
	
	@Test
	@DisplayName("Check empty stack")
	void testIsEmpty() {
		
		assertEquals(arrStack.isEmpty(), true);
	}
	
	@Test
	@DisplayName("Check Not empty stack")
	void testIsNotEmpty() {
		
		for (int i = 0; i < 4; i++) {
			arrStack.push(i*i);		
		}
		
		assertEquals(arrStack.isEmpty(), false);
	}
	
}
