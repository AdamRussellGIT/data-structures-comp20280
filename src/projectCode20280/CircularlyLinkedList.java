package projectCode20280;

/*
	The CircularlyLinkedList class implements the List<T> abstract class.
	The CircularlyLinkedList is a type of linked list that has no end,
		what would be the end simply links to what would be the start of the list.
	It implements an inner Node<E> class to hold the data.
	A tail pointer is used to keep track of the connect between the end and the start of the circle.
	This tail also allows for a rotate() method, meaning we can change the entry point for the list.
*/

import java.util.Iterator;

public class CircularlyLinkedList<E> implements List<E> {
	Node<E> tail = null;
	int size = 0;
	
	private class Node<E> {
		private E element;
		
		private Node<E> next;
		
		public Node(E e, Node<E> next)
		{
			this.element = e;
			this.next = next;
		}
		
		public E getElement()
		{
			return element;
		}
		
		public Node<E> getNext()
		{
			return next;
		}
		
		public void setNext(Node<E> n)
		{
			next = n;
		}
		
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (tail == null)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}

	/**
	 * Returns, but does not remove, the element stored at position i in the list.
	 * 
	 * @param i Position of element to return
	 */
	@Override
	public E get(int i) {
		if (tail == null || (i > size-1))
		{
			throw new RuntimeException("cannot get");
		}
		
		Node<E> curr = tail.getNext();
		
		//start at tail, walk 'i' steps
		for (int k = 0; k < i; k++)
		{
			curr = curr.getNext();
		}
		
		return curr.element;
	}
	

	/**
	 * Add an element at the given position in the list
	 * 
	 * @param i Position to add the specified element
	 * @param e element to be added
	 */
	@Override
	public void add(int i, E e) {
		if (tail == null || i > (size-1))
		{
			throw new RuntimeException("cannot add");
		}
		
		//used to walk 'i' steps
		Node<E> curr = tail.getNext();
		Node<E> prev = null;
		
		for (int k = 0; k < i; k++)
		{
			prev = curr;
			curr = curr.getNext();
		}
		
		//insert newest element (node)
		Node<E> newest = new Node<E>(e, curr);
		prev.setNext(newest);
		size++;
	}

	/**
	 * Removes and returns the element at position i in the list.
	 * 
	 * @param i Position of element to be remove
	 * @return Element removed
	 */
	@Override
	public E remove(int i) {
		if (tail == null)
		{
			throw new RuntimeException("cannot delete");
		}

		Node<E> curr = tail.getNext();
		Node<E> prev = null;

		for (int k = 0; k < i; k++)
		{
			prev = curr;
			curr = curr.getNext();
		}

		
		//if element at i is null, or reach end of list before i
		if (curr == null)
		{
			throw new RuntimeException("cannot delete");
		}
		
		E e = prev.element;
		prev.next = curr.next;
		size--;
		return e;
	}

	/**
	 * Removes and returns the first element in the list
	 * 
	 * @return Element that was at the front of the list
	 */
	@Override
	public E removeFirst() {
		if (size == 0)
		{
			throw new RuntimeException("cannot remove");
		}
		
		if (size == 1)
		{
			E e = tail.getElement();
			tail = null;
			size--;
			return e;
		}
		
		else
		{
			E e = tail.getNext().getElement();
			//skip pointer over first element
			tail.setNext(tail.getNext().getNext());
			size--;
			return e;
		}
	}

	/**
	 * Removes and returns the last element in the list
	 * 
	 * @return Element that was last in the list
	 */
	@Override
	public E removeLast() {
		if (size == 0)
		{
			throw new RuntimeException("cannot remove");
		}
		
		if (size == 1)
		{
			E e = tail.getElement();
			tail = null;
			size--;
			return e;
		}
		
		else
		{
			Node<E> find = tail;
		
			//need to find node to reconnect to new tail
			while (find.getNext() != tail)
			{
				find = find.getNext();
			}
			E e = tail.getElement();
			find.setNext(tail.getNext());
			tail = find;
			size--;
			return e;
		}
	}

	private class ListIterator implements Iterator<E>
	{
		Node<E> curr;
		boolean first = true;
		
		public ListIterator()
		{
			curr = tail.getNext();
		}
		
		@Override
		public boolean hasNext()
		{	
			if (first)
			{
				first = false;
				return true;
			}
			
			else
			{
				return curr != tail.getNext();
			}
			
		}
		
		@Override
		public E next()
		{
			E res = (E) curr.getElement();
			curr = curr.getNext();
			return res;
		}
	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();	
	}

	/**
	 * Adds and element to the start of the list
	 * 
	 * @param e Element to be added
	 */
	@Override
	public void addFirst(E e) {
		Node<E> newest = new Node<E>(e, null);
		
		if (tail == null)
		{
			tail = newest;
			tail.setNext(tail);
		}
		
		else
		{
			Node<E> find = tail;
			
			//find node to connect to new node that is now tail
			for (int k = 0; k < size-1; k++)
			{
				find = find.getNext();
			}
			find.setNext(newest);
			newest.setNext(tail);
		}
		size++;
	}

	/**
	 * Adds element to the end of the list
	 * 
	 * @param e Element to be added
	 */
	@Override
	public void addLast(E e) {
		if (tail == null)
		{
			Node<E> newest = new Node<E>(e, null);
			tail = newest;
			tail.setNext(tail);
		}
		
		else
		{
			Node<E> newest = new Node<E>(e, null);
			
			newest.setNext(tail.getNext());
			tail.setNext(newest);
			tail = newest;
		}
		size++;
	}
	
	/**
	 * Return first element of list
	 * 
	 * @return first element of list
	 */
	public E first()
	{
		if (this.isEmpty())
		{
			return null;
		}

		else {
			return tail.getNext().getElement();
		}
	}
	
	/**
	 * Returns last element of list
	 * 
	 * @return Last element of list
	 */
	public E last()
	{
		return tail.getElement();
	}

	//make new entry point in list
	public void rotate() {
		tail = tail.getNext();
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		Node<E> walk = tail.getNext();

		do
		{
			sb.append(walk.getElement());
			sb.append(", ");
			walk = walk.getNext();
		} while (walk != tail.getNext());

		sb.replace(sb.length()-2, sb.length(), "");
		sb.append("]");

		return sb.toString();
	}
	
	
	public static void main(String[] args) {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
		
		for(int i = 10; i < 20; ++i) {
			ll.addLast(i);
		}

		System.out.println("Initial:\n" + ll);

		ll.removeFirst();
		System.out.println("Removed First:\n" + ll);

		ll.removeLast();
		System.out.println("Removed Last:\n" + ll);

		ll.rotate();
		System.out.println("Rotated:\n" + ll);

		ll.removeFirst();
		ll.rotate();
		System.out.println("Removed First and Rotated:\n" + ll);

		ll.removeLast();
		ll.rotate();
		System.out.println("Removed Last and Rotated:\n" + ll);

		for (Integer e : ll) {
			System.out.println("value: " + e);
		}

	}
}
