package projectCode20280;

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
		queue.enqueue(3);
		System.out.println(queue);
		queue.enqueue(6);
		System.out.println(queue);
		queue.enqueue(14);
		System.out.println(queue);
		queue.dequeue();
		System.out.println(queue);
		System.out.println("Size is " + queue.size());
		System.out.println("First element is " + queue.first());
		queue.enqueue(60);
		System.out.println(queue);
	}

}
