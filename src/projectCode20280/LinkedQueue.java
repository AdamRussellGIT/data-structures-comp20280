package projectCode20280;

/*
	The LinkedQueue<E> class implements the Queue<T> interface.
	
	Here I implement a LinkedQueue using a DoublyLinkedList which ensures that 
		it is faster to enqueue items as we have access to the end of the list directly.
		If I was to use a SinglyLinkedList, it would take O(n) time to enqueue an item, 
			as we would have to traverse the list.
	All methods of the Queue interface are implemented using methods for my DoublyLinkedList class,
		which perform the required operations.
*/

public class LinkedQueue<E> implements Queue<E> {
	private DoublyLinkedList<E> list;
	
	public LinkedQueue()
	{
		list = new DoublyLinkedList<>();
	}

	@Override
	public int size() {
		return list.size;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public void enqueue(E e) {
		list.addLast(e);
	}

	@Override
	public E first() {
		return list.get(0);
	}

	@Override
	public E dequeue() {
		return list.removeFirst();
	}
	
	public String toString()
	{
		return list.toString();
	}
	
	public static void main(String[] args) {
		LinkedQueue<Integer> queue = new LinkedQueue<Integer>();
		System.out.println("Enqueue 3: ");
		queue.enqueue(3);
		System.out.println(queue);
		System.out.println("Enqueue 6: ");
		queue.enqueue(6);
		System.out.println(queue);
		System.out.println("Enqueue 14: ");
		queue.enqueue(14);
		System.out.println(queue);
		System.out.println("Dequeue: ");
		queue.dequeue();
		System.out.println(queue);
		System.out.println("Size is " + queue.size());
		System.out.println("First element is " + queue.first());
		System.out.println("Enqueue 60: ");
		queue.enqueue(60);
		System.out.println(queue);
	}

}
