/*
* Date: 2021-09-28.
* File Name: Queue.Java
* Author: Emelie Åslund
*
*/

package ea224qb_assign2.excercise4;

/**
* Interface Description: This interface is calling methods that are in MainQueue.
* 
* @version 1.0 Sept 28
* @author Emelie Åslund
*/
public interface Queue<E> extends Iterable<E> {
	/* Current queue size*/
	int size();
	
	/* True if queue is empty*/
	boolean isEmpty();
	
	/* Add element at end of queue */
	void enqueue(E element);
	
	/* Return and remove first element */
	E dequeue();
	
	/* Return (without removing) first element */
	E first();
	
	/* Return (without removing) last element */
	E last();
}
