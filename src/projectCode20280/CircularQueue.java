package projectCode20280;

/*
	CircularQueue implements the Queue<T> interface.
	It is an improvement on a regular LinkedQueue as it allows for faster access to
		elements near the end of the list, and also has quick access to items at both the
			beginning and end of the queue.
	Otherwise it performs in a very similar fashion to the LinkedQueue class.
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

	@Override
	public void enqueue(E e) {
		list.addLast(e);
	}

	@Override
	public E first() {
		return list.first();
	}
	
	public E front()
	{
		return first();
	}
	
	public E back()
	{
		return list.last();
	}

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
