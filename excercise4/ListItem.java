/*
* Date: 2021-09-28.
* File Name: ListeItem.Java
* Author: Emelie Åslund
*
*/

package ea224qb_assign2.excercise4;

/**
* Class Description: A class managing an item in a linked list
* 
* @version 1.0 Sept 28
* @author Emelie Åslund
*/
public class ListItem<E> {
	ListItem<E> next;
	E data;
	
	ListItem(E d) {
		data = d;
		next = null;
	}
}
