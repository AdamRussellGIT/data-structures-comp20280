package projectCode20280;

import java.util.Iterator;

/*
	DoublyLinkedList implements the List<T> interface.
	Very similar to a SinglyLinkedList, but in the DLL we also have 
		a link to the previous node, allowing traversal in both directions.
	Also allows direct access to the end of the list, making it more efficient
		in some cases.
*/


public class DoublyLinkedList<E> implements List<E> {
	Node<E> header;
	Node<E> trailer;
	int size = 0;
	
	private class Node<E> {
		private E element;
		
		private Node<E> next;
		private Node<E> prev;
		
		public Node(E e, Node<E> prev, Node<E> next)
		{
			this.element = e;
			this.next = next;
			this.prev = prev;
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
		
		public Node<E> getPrev()
		{
			return prev;
		}
		
		public void setPrev(Node<E> p)
		{
			prev = p;
		}
	}
	
	public DoublyLinkedList()
	{
		header = new Node<>(null, null, null);
		trailer = new Node<>(null, header, null);
		header.setNext(trailer);
		
	}
	
	/**
	 * Adds an element in between two specified nodes.
	 * @param e Element to be added
	 * @param predecessor Node before
	 * @param successor Node after
	 */
	private void addBetween(E e, Node<E> predecessor, Node<E> successor) {
		Node<E> newest = new Node<>(e, predecessor, successor);
		predecessor.setNext(newest);
		successor.setPrev(newest);
		size++;
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		if (size == 0)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}

	/**
	 * Returns but does not remove the element at position i
	 * 
	 * @param i Position of element to be retrieved
	 */
	@Override
	public E get(int i) {
		//check if its possible to get i
		if(isEmpty() || i > size()-1)
		{
			throw new RuntimeException("cannot get");
		}
		
		//depending on where i is, choose fastest path
		if(i < (size()-1/2))
		{
			Node<E> curr = header.getNext();
			
			//find correct position
			for(int k=0;k<i;k++)
			{
				curr = curr.getNext();
			}
			
			return curr.element;
		}
		
		else
		{
			Node<E> curr = trailer.getPrev();
			
			for(int k=size()-1;k>i;k--)
			{
				curr = curr.getPrev();
			}
			
			return curr.element;
		}
	}

	/**
	 * Adds an element e at position i.
	 * 
	 * @param i Position in list where element is to be added
	 * @param e Element to be added
	 */
	@Override
	public void add(int i, E e) {
		if(i > size()-1)
		{
			throw new RuntimeException("cannot add");
		}
		
		Node<E> curr = header.getNext();
		Node<E> prev = null;
		
		//find correct position
		for(int k=0;k<i;k++)
		{
			prev = curr;
			curr = curr.next;
		}
		
		//add in node
		addBetween(e, prev, curr);
	}

	/**
	 * Removes and returns element at position i
	 * 
	 * @param i Position of element to be removed
	 * @return E Element being removed
	 */
	@Override
	public E remove(int i) {
		if (isEmpty() || i > size()-1)
		{
			throw new RuntimeException("cannot delete");
		}
		
		Node<E> curr = header.getNext();
		Node<E> prev = header;
		
		//find the correct node to remove
		for (int k = 0; k < i; k++)
		{
			prev = curr;
			curr = curr.getNext();
		}
		
		E e = curr.element;
		prev.next = curr.next;
		size--;
		return e;
	}

	@Override
	public E removeFirst() {
		if(isEmpty())
		{
			return null;
		}
		
		else
		{
			return remove(0);
		}
	}

	@Override
	public E removeLast() {
		if(isEmpty())
		{
			return null;
		}
		
		else
		{
			return remove(size()-1);
		}
	}
	

	@Override
	public void addFirst(E e) {
		addBetween(e, header, header.getNext());
	}

	@Override
	public void addLast(E e) {
		addBetween(e, trailer.getPrev(), trailer);
	}
	
	private class ListIterator implements Iterator<E>
	{
		Node<E> curr;
		
		public ListIterator()
		{
			curr = header.getNext();
		}
		
		@Override
		public boolean hasNext()
		{
			return curr != trailer;
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
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("[");

		Node<E> walk = header.getNext();

		while (walk.getNext() != null)
		{
			sb.append(walk.getElement());
			sb.append(", ");
			walk = walk.getNext();
		}

		sb.replace(sb.length()-2, sb.length(), "");
		sb.append("]");

		return sb.toString();
    }
	
	public E first()
	{
		return header.getNext().getElement();
	}
	
	public E last()
	{
		return trailer.getPrev().getElement();
	}
	
	public static void main(String[] args) {
		   DoublyLinkedList<Integer> ll = new DoublyLinkedList<Integer>();
           ll.addFirst(0);
           ll.addFirst(1);
           ll.addFirst(2);
           System.out.println(ll);
           ll.addLast(-1);
           System.out.println(ll);
           
           ll.removeFirst();
           System.out.println(ll);
           
           System.out.println(ll.last());

           ll.removeLast();
           System.out.println(ll);
           
           for(Integer e: ll) {
                   System.out.println("value: " + e);
           }
	}

	
}
