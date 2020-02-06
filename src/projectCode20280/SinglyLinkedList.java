package projectCode20280;

import java.util.Iterator;

public class SinglyLinkedList<E> implements List<E> {
	Node<E> head = null;
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
		if (head == null || i < size)
		{
			throw new RuntimeException("cannot get");
		}
		
		Node<E> curr = head;
		Node<E> prev = null; 

		for(int k=0;k<i;k++)
		{
			prev = curr;
			curr = curr.next;
		}
		
		return curr.element;
	}

	@Override
	public void add(int i, E e) {
		if(i < size-1)
		{
			throw new RuntimeException("cannot add");
		}
		
		Node<E> curr = head;
		Node<E> prev = null;
		
		for(int k=0;k<i;k++)
		{
			prev = curr;
			curr = curr.next;
		}
		
		Node<E> newest = new Node<E>(e, curr.next);
		prev.next = newest;
		newest.next = curr;
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
		return e;
	}
	
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

	@Override
	public int size() {
		return this.size;
	}	
	

	@Override
	public E removeFirst() {
		E temp = head.element;
		head = head.next;
		return temp;
	}

	@Override
	public E removeLast() {
		Node<E> curr = head;
		Node<E> prev = null;
		
		while(curr.next != null)
		{
			prev = curr;
			curr = curr.getNext();
		}
		
		E e = curr.element;
		prev.next = null;
		return e;
	}

	@Override
	public void addFirst(E e) {
		head = new Node<E>(e, head);
		size++;
		
	}

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
			while (last.getNext() != null)
			{
				last = last.getNext();
			}
			
			last.setNext(newest);
		}
		
		size++;
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
		sll.addFirst("Hello");
		System.out.println(sll);
		sll.addFirst("Kiddie");
		sll.addLast("Bye");
		System.out.println(sll);
		for (String s : alphabet) {
			sll.addFirst(s);
			sll.addLast(s);
		}
		System.out.println(sll.toString());

		sll.removeFirst();
		System.out.println(sll.toString());
		
		sll.removeLast();
		System.out.println(sll.toString());

		sll.remove(2);
		System.out.println(sll.toString());
		
		for (String s : sll) {
			System.out.print(s + ", ");
		}
	}


}
