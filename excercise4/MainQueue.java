/*
* Date: 2021-09-28.
* File Name: MainQueue.Java
* Author: Emelie Åslund
*
*/

package ea224qb_assign2.excercise4;

import java.util.Iterator;

/**
* Class Description: This class creates queues, and able to enqueue and dequeue. 
* Also able to get the size of a queue, check if it is empty, and return first and last element in the queue.
* 
* @version 1.0 Sept 28
* @author Emelie Åslund
*/
public class MainQueue<E> implements Queue<E> {
	private ListItem<E> front;
	
	public MainQueue() {
		front = null;
	}
	
	/* Current queue size */
	public int size() {
		int count = 0;
		ListItem<E> node = front;
		
		if (node != null) {
			count++;
			while (node.next != null) {
				count++;
				node = node.next;
			}
		}
		return count;
	}
	
	/* True if queue is empty */
	public boolean isEmpty() {
		if (front == null) {
			return true;
		}
		return false;
	}
	
	/* Add element at end of queue */
	public void enqueue(E element) {
		ListItem<E> node = front;
		ListItem<E> newNode = new ListItem<E>(element);
		
		if (node != null) {
			while (node.next != null) {
				node = node.next;
			}
			node.next = newNode;
		} else {
			// Queue is empty, add element to front
			front = newNode;
		}
	}

	/* Return and remove first element */
	public E dequeue() throws NullPointerException {
		ListItem<E> node = front;
		
		if (front == null) {
			throw new NullPointerException("Queue is empty");
		} else {
			front = node.next;
		}
		return node.data;
	}
	
	/* Return (without removing) first element */
	public E first() throws NullPointerException {
		ListItem<E> node = front;
		
		if (front == null) {
			throw new NullPointerException("Queue is empty");
		}
		
		return node.data;
	}
	
	/* Return (without removing) last element */
	public E last() throws NullPointerException{
		ListItem<E> node = front;
		
		if (front == null) {
			throw new NullPointerException("Queue is empty");
		} else {
			while (node.next != null) {
				node = node.next;
			}
		}
		return node.data;
	}
	
	public String toString() {
		String retVal = "";
		ListItem<E> node = front;
		
		if (front != null) {
			retVal += node.data + " ";
			while (node.next != null) {
				node = node.next;
				retVal += node.data + " ";
			}
		}
		return retVal;
	}
	
	@Override
	public Iterator<E> iterator() {
		return null;
	}
	
	/**
	* Class Description: This is a main class that calls the different methods.
	* 
	* @author Emelie Åslund
	*/
	public static void main(String[] args) {
		MainQueue<Integer> queue = new MainQueue<Integer>();
		
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		
		queue.enqueue(5);
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue);
		
		queue.enqueue(64);
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue);
		
		queue.enqueue(55);
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue);
		
		queue.enqueue(21);
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue);
		
		queue.enqueue(23);
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue);
		
		queue.enqueue(87);
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue);
		
		System.out.println("First element in queue: " + queue.first());
		System.out.println("Last element in queue: "  + queue.last());
		
		int retVal = queue.dequeue();
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue);
		System.out.println("Dequeued element: " + retVal);
		
		retVal = queue.dequeue();
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue);
		System.out.println("Dequeued element: " + retVal);
		
		retVal = queue.dequeue();
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue);
		System.out.println("Dequeued element: " + retVal);
		
		retVal = queue.dequeue();
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue);
		System.out.println("Dequeued element: " + retVal);
		
		retVal = queue.dequeue();
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue);
		System.out.println("Dequeued element: " + retVal);
		
		retVal = queue.dequeue();
		System.out.println(queue.size());
		System.out.println(queue.isEmpty());
		System.out.println(queue);
		System.out.println("Dequeued element: " + retVal);
		
		try {
			retVal = queue.dequeue();
			System.out.println(queue.size());
			System.out.println(queue.isEmpty());
			System.out.println(queue);
			System.out.println("Dequeued element: " + retVal);
		} catch (Exception e) {
			System.out.println("Dequeueing an empty queue: " + e);
		}
		
	}

}
