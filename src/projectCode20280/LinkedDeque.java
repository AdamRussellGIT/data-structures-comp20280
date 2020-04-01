package projectCode20280;

/*
	Similar to a Queue, but allows access to both sides of the Queue.
	To do this we use a DoublyLinkedList.
	Implements the Dequeue<T> interface to allow provide all methods needed to access front and back of queue.
*/

public class LinkedDeque<E> implements Deque<E> {
	private DoublyLinkedList<E> list = new DoublyLinkedList<>();
	
	public LinkedDeque()
	{
		;
	}
	
	@Override
	public int size() {
		return list.size();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public E first() {
		return list.getFirst();
	}

	@Override
	public E last() {
		return list.getLast();
	}

	@Override
	public void addFirst(E e) {
		list.addFirst(e);
	}

	@Override
	public void addLast(E e) {
		list.addLast(e);
	}

	@Override
	public E removeFirst() {
		return list.removeFirst();
	}

	@Override
	public E removeLast() {
		return list.removeLast();
	}
	
	public String toString()
	{
		return list.toString();
	}
	
	public static void main(String[] args) {
		LinkedDeque<Integer> ld = new LinkedDeque<Integer>();
		System.out.println("Add 1 first: ");
		ld.addFirst(1);
		System.out.println(ld.toString());
		System.out.println("Add 2 first: ");
		ld.addFirst(2);
		System.out.println(ld.toString());
		System.out.println("Add 3 last: ");
		ld.addLast(3);
		System.out.println(ld.toString());
		System.out.println("Remove First: ");
		ld.removeFirst();
		System.out.println(ld.toString());
		System.out.println("Add 69 last: ");
		ld.addLast(69);
		System.out.println(ld.toString());
		System.out.println("Add 4 first: ");
		ld.addFirst(4);
		System.out.println(ld.toString());
		System.out.println("Remove First: ");
		ld.removeFirst();
		System.out.println(ld.toString());
		System.out.println("Remove Last: ");
		ld.removeLast();
		System.out.println(ld.toString());
	}

}
