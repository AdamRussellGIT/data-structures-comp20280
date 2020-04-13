package projectCode20280;

/**
 * Realization of a circular FIFO queue as an adaptation of a
 * CircularlyLinkedList. This provides one additional method not part of the
 * general Queue interface. A call to rotate() is a more efficient simulation of
 * the combination enqueue(dequeue()). All operations are performed in constant
 * time.
 */

public class CircularQueue<E> implements Queue<E> {
	private CircularlyLinkedList<E> list;
	
	public CircularQueue()
	{
		list = new CircularlyLinkedList<>();
	}

	@Override
	public int size() {
		return list.size;
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	/**
	 * Adds an element to the queue
	 */
	@Override
	public void enqueue(E e) {
		list.addLast(e);
	}

	@Override
	public E first() {
		return list.first();
	}
	
	/**
	 * Returns but does not remove the element at the front of the queue
	 */
	public E front()
	{
		return first();
	}
	
	/**
	 * Returns but does not remove the element at the back of the queue
	 */
	public E back()
	{
		return list.last();
	}

	/**
	 * Removes an element from the queue and returns it.
	 */
	@Override
	public E dequeue() {
		return list.removeFirst();
	}
	
	@Override
	public String toString()
	{
		return list.toString();
	}
	
	public static void main(String[] args) {
		CircularQueue<Integer> queue = new CircularQueue<Integer>();	
		queue.enqueue(3);
		System.out.println(queue);
		queue.enqueue(6);
		System.out.println(queue);
		queue.enqueue(14);
		System.out.println(queue);
		System.out.println("Front is " + queue.front());
		System.out.println("Back is " + queue.back());
		queue.dequeue();
		System.out.println(queue);
		System.out.println("Size is " + queue.size());
		System.out.println("First element is " + queue.first());
		queue.enqueue(60);
		System.out.println(queue);
	}
}
