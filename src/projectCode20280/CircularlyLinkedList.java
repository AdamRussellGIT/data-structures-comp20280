package projectCode20280;

import java.util.Iterator;

public class CircularlyLinkedList<E> implements List<E> {
	Node<E> head = null;
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
		if (head == null)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}

	@Override
	public E get(int i) {
		if (head == null || (i < size-1))
		{
			throw new RuntimeException("cannot get");
		}
		
		Node<E> curr = head;
		
		for (int k = 0; k < i; k++)
		{
			curr = curr.getNext();
		}
		
		return curr.element;
	}

	@Override
	public void add(int i, E e) {
		if (head == null || i < (size-1))
		{
			throw new RuntimeException("cannot add");
		}
		
		Node<E> curr = head;
		Node<E> prev = null;
		
		for (int k = 0; k < i; k++)
		{
			prev = curr;
			curr = curr.getNext();
		}
		
		Node<E> newest = new Node<E>(e, curr);
		prev.setNext(newest);
	}

	@Override
	public E remove(int i) {
		if (head == null)
		{
			throw new RuntimeException("cannot delete");
		}
		
		if (i == 1)
		{
			this.removeFirst();
		}
		
		Node<E> curr = head;
		Node<E> prev = null;
		int k = 1;
		
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
		E e = prev.element;
		prev.next = curr.next;
		size--;
		return e;
	}

	@Override
	public E removeFirst() {
		if (size == 0)
		{
			throw new RuntimeException("cannot remove");
		}
		
		if (size == 1)
		{
			E e = head.getElement();
			head = null;
			size--;
			return e;
		}
		
		else
		{
			E e = head.getElement();
			Node<E> find = head;
			
			for (int k = 0; k < size-1; k++)
			{
				find = find.getNext();
			}
			head = head.getNext();
			find.setNext(head);
			size--;
			return e;
		}
	}

	@Override
	public E removeLast() {
		if (size == 0)
		{
			throw new RuntimeException("cannot remove");
		}
		
		if (size == 1)
		{
			E e = head.getElement();
			head = null;
			size--;
			return e;
		}
		
		else
		{
			Node<E> find = head;
		
			for (int k = 0; k < size-2; k++)
			{
				find = find.getNext();
			}
			E e = find.getElement();
			find.setNext(head);
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
			curr = head;
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
				return curr.getNext() != head.getNext();
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

	@Override
	public void addFirst(E e) {
		if (head == null)
		{
			Node<E> newest = new Node<E>(e, null);
			head = newest;
		}
		
		else
		{
			Node<E> find = head;
			
			for (int k = 0; k < size-1; k++)
			{
				find = find.getNext();
			}
			find.setNext(head);
			head = find;
		}
		size++;
	}

	@Override
	public void addLast(E e) {
		if (head == null)
		{
			Node<E> newest = new Node<E>(e, null);
			head = newest;
		}
		
		else
		{
			Node<E> newest = new Node<E>(e, head);
			
			Node<E> find = head;
			
			for (int k = 0; k < size-1; k++)
			{
				find = find.getNext();
			}
			
			find.setNext(newest);
			newest.setNext(head);
		}
		size++;
	}

	public void rotate() {
		head = head.getNext();
	}
	
	public String toString() {
		StringBuilder str = new StringBuilder();
		if (size == 0)
		{
			throw new RuntimeException("cannot print");
		}
		else if (size == 1)
		{
			str.append(head.getElement());
			return str.toString();
		}
		
		else
		{
			Node<E> curr = head;
			while (true) {
				str.append(curr.element);
				str.append(" ");
				curr = curr.getNext();
				if (curr == head) break;
			}
			return str.toString();
		}
	}
	
	
	public static void main(String[] args) {
		CircularlyLinkedList<Integer> ll = new CircularlyLinkedList<Integer>();
		
		for(int i = 10; i < 20; ++i) {
			ll.addLast(i);
		}

		System.out.println("Initial:\n" + ll);

		System.out.println("Removed " + ll.removeFirst());
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
