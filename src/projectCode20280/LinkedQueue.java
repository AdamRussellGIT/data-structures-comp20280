package projectCode20280;

public class LinkedQueue<E> implements Queue<E> {
	private DoublyLinkedList<E> list = new DoublyLinkedList<>();
	
	public LinkedQueue()
	{
		;
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
		LinkedQueue<Integer> stack = new LinkedQueue<Integer>();	
		stack.enqueue(3);
		System.out.println(stack);
		stack.enqueue(6);
		System.out.println(stack);
		stack.enqueue(14);
		System.out.println(stack);
		stack.dequeue();
		System.out.println(stack);
		System.out.println("Size is " + stack.size());
		System.out.println("First element is " + stack.first());
		stack.enqueue(60);
		System.out.println(stack);
	}

}
