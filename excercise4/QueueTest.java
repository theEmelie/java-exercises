package ea224qb_assign2.excercise4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueueTest {
	
	MainQueue<Integer> queue;
	
	@BeforeEach
	void setUp() throws Exception {
		queue = new MainQueue<Integer>(); // Create queue
	}

	@Test
	@DisplayName("Test to enqueue one element")
	void testEnqueueOneElement() {
		queue.enqueue(5); // Enqueue 5
		
		assertEquals(queue.size(), 1);
		assertEquals(queue.isEmpty(), false);
		
	}
	
	@Test
	@DisplayName("Test to enqueue 100 elements")
	void testEnqueueSeveralElements() {
		// Enqueue 100 elements
		for (int i = 0; i < 100; i++) {
			queue.enqueue(i);
		}
		
		int queueFirst = queue.first();
		
		assertEquals(queue.size(), 100);
		assertEquals(queue.isEmpty(), false);
		assertEquals(queueFirst, 0);
	}
	
	@Test
	@DisplayName("Test to dequeue one element")
	void testDequeueOneElement() {
		// Enqueue 10 elements
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
		}
		
		int queueLast = queue.last();
		
		queue.dequeue(); // Dequeue 0
		
		assertEquals(queue.size(), 9);
		assertEquals(queue.isEmpty(), false);
		assertEquals(queueLast, 9);
	}
	
	@Test
	@DisplayName("Test to dequeue several elements")
	void testDequeueSeveralElements() {
		// Enqueue 10 elements
		for (int i = 0; i < 10; i++) {
			queue.enqueue(i);
		}
		
		queue.dequeue(); // Dequeue 0
		queue.dequeue(); // Dequeue 1
		queue.dequeue(); // Dequeue 2
		queue.dequeue(); // Dequeue 3
		
		int queueLast = queue.last();
		int queueFirst = queue.first();
		
		assertEquals(queue.size(), 6);
		assertEquals(queue.isEmpty(), false);
		assertEquals(queueFirst, 4); // 4 is first in queue
		assertEquals(queueLast, 9); // 9 is last in queue
	}
	
	
	@Test
	@DisplayName("Test to dequeue 100 elements")
	void testDequeue100Elements() {
		// Enqueue 101 elements
		for (int i = 0; i <= 101; i++) {
			queue.enqueue(i);
		}
		
		// Dequeue 100 elements
		for (int i = 0; i <= 100; i++) {
			queue.dequeue();
		}
		
		int queueLast = queue.last();
		int queueFirst = queue.first();
		
		assertEquals(queue.size(), 1);
		assertEquals(queue.isEmpty(), false);
		assertEquals(queueFirst, 101); // 101 is first in queue
		assertEquals(queueLast, 101); // 101 is last in queue

	}
	
	@Test
	@DisplayName("Test to dequeue empty queue")
	void testDequeueEmptyQueue() throws Exception {
		// Enqueue 3 elements
		for (int i = 0; i < 3; i++) {
			queue.enqueue(i);
		}
		
		queue.dequeue(); // Dequeue first element
		queue.dequeue(); // Dequeue second element
		queue.dequeue(); // Dequeue last element
		// Dequeue empty queue
		Throwable exception = assertThrows(NullPointerException.class, () -> queue.dequeue());
		
		assertEquals(queue.size(), 0);
		assertEquals(queue.isEmpty(), true);
		assertEquals("Queue is empty", exception.getMessage());
	}
	
	@Test
	@DisplayName("Test to get first element in empty queue")
	void testToGetFirstElementEmptyQueue() throws Exception {
		queue.enqueue(5); // Enqueue 5
		
		queue.dequeue(); // Dequeue 5
		
		// Dequeue empty queue
		Throwable exception = assertThrows(NullPointerException.class, () -> queue.dequeue());
		// Get last element in empty queue
		assertThrows(NullPointerException.class, () -> queue.first());
		
		assertEquals(queue.size(), 0);
		assertEquals(queue.isEmpty(), true);
		assertEquals("Queue is empty", exception.getMessage());
		
	}
	
	@Test
	@DisplayName("Test to get last element in empty queue")
	void testToGetLastElementEmptyQueue() throws Exception {
		queue.enqueue(5); // Enqueue 5
		
		queue.dequeue(); // Dequeue 5

		// Dequeue empty queue
		Throwable exception = assertThrows(NullPointerException.class, () -> queue.dequeue());
		// Get last element in empty queue
		assertThrows(NullPointerException.class, () -> queue.last());
		
		assertEquals(queue.size(), 0);
		assertEquals(queue.isEmpty(), true);
		assertEquals("Queue is empty", exception.getMessage());
	}

}
