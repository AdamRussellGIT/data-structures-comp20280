package projectCode20280;

import java.util.Iterator;

/*
	The SinglyLinkedList<E> class implements the List<T> interface.
	
	Simply a collection of nodes containing information (specified by generic T) that are
		sequentially connected (e.g. each node has a pointer to the next node in the list).
		
	Contains an inner Node<E> class where a Node is defined with some basic getters and setters.
	
	
*/

public class SinglyLinkedList<E> implements List<E> {
	Node<E> head = null;
	int size = 0;
	private SinglyLinkedList<E> newll;

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
	
	/**
	 * Returns true if the list is empty, false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		if (head == null)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}

	/**
	 * Returns but does not remove the element stored at position i in the list.
	 * @param i Position of element being sought (0 for first element, 1 for second etc).
	 */
	@Override
	public E get(int i) {
		if (head == null || i > size)
		{
			throw new RuntimeException("cannot get");
		}
		
		Node<E> curr = head;
		Node<E> prev = null; 

		//find currect position by looping through, moving pointers
		for(int k=0;k<i;k++)
		{
			prev = curr;
			curr = curr.next;
		}
		
		return curr.element;
	}

	/**
	 * Adds an element at a certain position in the list.
	 * @param i Position the element is to be added.
	 * @param e Element to be added.
	 */
	@Override
	public void add(int i, E e) {
		if(i > size-1)
		{
			throw new RuntimeException("cannot add");
		}
		
		if (i == 0)
		{
			addFirst(e);
			return;
		}
		
		Node<E> curr = head;
		Node<E> prev = null;
		
		for(int k=0;k<i;k++)
		{
			prev = curr;
			curr = curr.next;
		}
		
		Node<E> newest = new Node<E>(e, curr.next);
		//insert in between the two nodes either side of i
		prev.next = newest;
		newest.next = curr;
		size++;
	}

	/**
	 * Removes AND Returns the element at position i.
	 * @param i Position of element to be removed and returned.
	 */
	@Override
	public E remove(int i) {
		if (head == null)
		{
			throw new RuntimeException("cannot delete");
		}
		
		if (i == 0)
		{
			E e = removeFirst();
			return e;
		}
		
		Node<E> curr = head;
		Node<E> prev = null;
		int k = 0;
		
		//find either end of list or correct position
		while (curr != null && k != i)
		{
			prev = curr;
			curr = curr.next;
			k++;
		}
		
		if (curr == null)
		{
			throw new RuntimeException("cannot delete");
		}
				
		E e = prev.getElement();
		prev.next = curr.next;
		size--;
		return e;
	}
	
	/**
	 * Inner Ierator Class used to print out the state of the SinglyLinkedList
	 */
	private class ListIterator implements Iterator<E>
	{
		Node<E> curr;
		
		public ListIterator()
		{
			curr = head;
		}
		
		@Override
		public boolean hasNext()
		{
			return curr != null;
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
	 * Returns the number of elements in the list
	 */
	@Override
	public int size() {
		return this.size;
	}	
	
	/**
	 * Removes AND Returns the first element of the list
	 */
	@Override
	public E removeFirst() {
		E temp = head.element;
		head = head.next;
		size--;
		return temp;
	}

	/**
	 * Removes AND Returns the last element of the list.
	 */
	@Override
	public E removeLast() {
		if (head.getNext() == null)
		{
			E e = head.getElement();
			head = null;
			size--;
			return e;
		}
		
		else
		{
			Node<E> curr = head;
			Node<E> prev = null;
		
			while(curr.next != null)
			{
				prev = curr;
				curr = curr.getNext();
			}
		
			E e = curr.element;
			prev.next = null;
			size--;
			return e;
		}
	}

	/**
	 * Adds an element to the start of the list
	 * @param e Element to be added
	 */
	@Override
	public void addFirst(E e) {
		head = new Node<E>(e, head);
		size++;
		
	}

	/**
	 * Adds an element to the end of the list
	 * @param e Element to be added
	 */
	@Override
	public void addLast(E e) {
		Node<E> newest = new Node<E>(e, null);
		Node<E> last = head;
		
		if (last == null)
		{
			head = newest;
		}
		
		else
		{
			//find the last node in the list
			while (last.getNext() != null)
			{
				last = last.getNext();
			}
			
			last.setNext(newest);
		}
		
		size++;
	}
	
	/**
	 * Reverses the order of elements in the list.
	 */
	public void reverse()
	{
		Node<E> temp = head;
		
		if (this.isEmpty())
		{
			return;
		}
		
		//add the elements of each gradually smaller list onto stack
		this.removeFirst();
		this.reverse();
		//add each element stored on stack as the last element of the list (reversing the order)
		this.addLast(temp.getElement());
		
	}
	
	/**
	 * Returns a copy of a SinglyLinkedList
	 * @return A new SinglyLinkedList
	 */
	public SinglyLinkedList<E> recursiveCopy()
	{	
		if (this.size == 0)
		{
			newll = new SinglyLinkedList<E>();
			return newll;
		}
		
		Node<E>temp = new Node<E>(this.removeFirst(), null);
		recursiveCopy();
		newll.addFirst(temp.getElement());
		this.addFirst(temp.getElement());
		
		return newll;
	}
	
	
	
	public String toString(){
        String retStr = "Contents:\n";

        Node<E> current = head;
        while(current != null){
            retStr += current.element + " ";
            current = current.getNext();

        }

        return retStr;
    }
	
	public static void main(String[] args) {
		String[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");

		SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
		for (String s : alphabet) {
			sll.addFirst(s);
			//sll.addLast(s);
		}
		System.out.println(sll.toString());
		System.out.println("Size is " + sll.size());
		
		sll.add(0,  "HI");

		System.out.println("Remove First: ");
		sll.removeFirst();
		System.out.println(sll.toString());
		
		System.out.println("Remove Last: ");
		sll.removeLast();
		System.out.println(sll.toString());

		System.out.println("Remove (0): ");
		sll.remove(0);
		System.out.println(sll.toString());
		
		System.out.println("Remove (1): ");
		sll.remove(1);
		System.out.println(sll.toString());
		
		System.out.println("Reverse: ");
		sll.reverse();
		System.out.println(sll.toString());
		
		SinglyLinkedList<String> sll2 = new SinglyLinkedList<String>();
		sll2 = sll.recursiveCopy();
		sll2.addFirst("Yo");
		sll.addFirst("bye");
		System.out.println("sll2 : \n" + sll2.toString());
		
		for (String s : sll) {
			System.out.print(s + ", ");
		}
	}


}
