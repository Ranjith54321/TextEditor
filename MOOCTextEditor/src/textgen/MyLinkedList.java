package textgen;

import java.util.AbstractList;


/** A class that implements a doubly linked list
 * 
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {
	LLNode<E> head;
	LLNode<E> tail;
	int size;

	/** Create a new empty LinkedList */
	public MyLinkedList() {
		// TODO: Implement this method
		this.head = new LLNode<E>(null);
		this.tail = new LLNode<E>(null);
		head.next = tail;
		tail.prev = head;
		this.size = 0;
	}

	/**
	 * Appends an element to the end of the list
	 * @param element The element to add
	 */
	public boolean add(E element ) 
	{
		// TODO: Implement this method
		if(element==null) {
			throw new NullPointerException();
		}
		LLNode<E> new_node = new LLNode<E>(element);
		tail.prev.next = new_node;
		new_node.prev = tail.prev;
		new_node.next = tail;
		tail.prev = new_node;
		size++;
		return true;
	}

		public void addFront(E element) {
			LLNode<E> n = new LLNode<E>(element);
			n.next = head.next;
			n.prev = n.next.prev;
			n.next.prev = n;
			head.next = n;
		}
	/** Get the element at position index 
	 * @throws IndexOutOfBoundsException if the index is out of bounds. */
	public E get(int index)
	{
		// TODO: Implement this method.
		if(index>=size() || index<0) {
			throw new IndexOutOfBoundsException();
		}
		else {
			LLNode<E> p = head;
			int i=0;
			for(i=0;i<=index;i++) {
				p = p.next;
			}
			return p.data;
		}
		//return null;
	}

	/**
	 * Add an element to the list at the specified index
	 * @param The index where the element should be added
	 * @param element The element to add
	 */
	public void add(int index, E element ) 
	{
		// TODO: Implement this method
		if(element == null)
			throw new NullPointerException();
		else if((index<0 || index>=size) && size!=0)
			throw new IndexOutOfBoundsException();
		LLNode<E> n = new LLNode<E>(element);
		LLNode<E> p = head;
		for(int i=0;i<index;i++) {
			p = p.next;
		}
		n.next = p.next;
		p.next = n;
		n.next.prev = n;
		n.prev = p;
		size++;
	}


	/** Return the size of the list */
	public int size() 
	{
		return size;
	}

	/** Remove a node at the specified index and return its data element.
	 * @param index The index of the element to remove
	 * @return The data element removed
	 * @throws IndexOutOfBoundsException If index is outside the bounds of the list
	 * 
	 */
	public E remove(int index)
	{
		if(index>=size() || index<0) {
			throw new IndexOutOfBoundsException();
		}
		LLNode<E> n = head;
		for(int i=0;i<=index;i++) {
			n = n.next;
		}
		n.prev.next = n.next;
		n.next.prev = n.prev;
		size--;
		return n.data;
		//return null;
	}

	/**
	 * Set an index position in the list to a new element
	 * @param index The index of the element to change
	 * @param element The new element
	 * @return The element that was replaced
	 * @throws IndexOutOfBoundsException if the index is out of bounds.
	 */
	public E set(int index, E element) 
	{
		// TODO: Implement this method
		if(index>=size() || index<0) {
			throw new IndexOutOfBoundsException();
		}
		if(element==null) {
			throw new NullPointerException();
		}
		LLNode<E> n = head;
		for(int i=0;i<index;i++) {
			n = n.next;
		}
		n.data = element;
		return element;
	}
}

class LLNode<E> 
{
	LLNode<E> prev;
	LLNode<E> next;
	E data;

	// TODO: Add any other methods you think are useful here
	// E.g. you might want to add another constructor
	public LLNode() {
		this.data = null;
		this.prev = null;
		this.next = null;
	}
	public LLNode(E e) 
	{
		this.data = e;
		this.prev = null;
		this.next = null;
	}

}
