package projectCode20280;

/*
	The Array Queue implements the abstract Queue<T> class.
	The Queue has two pointers that act as the front and back of the queue.
	The pointers move through the array as items are enqueued and dequeued.
	The 'end of the array issue' is solved by using module to handle the size and pointers,
		creating a 'wrapping' effect.
*/

public class ArrayQueue<E> implements Queue<E> {
	//default capacity
	public static final int CAPACITY = 1000;
	
	private E[] data;
	
	private int front = 0;
	private int rear = 0;
	
	public ArrayQueue()
	{
		this(CAPACITY);
	}
	
	@SuppressWarnings({"unchecked"})
	public ArrayQueue(int CAPACITY)
	{
		data = (E[]) new Object[CAPACITY];
	}

	@Override
	public int size() {
		return ((rear - front) % CAPACITY);
	}

	@Override
	public boolean isEmpty() {
		if (front == rear)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}

	@Override
	public void enqueue(E e) {
		if (size() >= CAPACITY)
		{
			throw new RuntimeException("Queue full!");
		}
		
		else
		{
			//figure out where rear of array is (taking into account 'wrapping')
			rear = ((front + size()) % CAPACITY);
			data[rear] = e;
			//move rear pointer along
			rear++;
		}
	}

	@Override
	public E first() {
		return data[front];
	}

	@Override
	public E dequeue() {
		if (this.isEmpty())
		{
			System.out.println("ERROR: NOTHING TO DEQUEUE");
			return null;
		}
		
		else
		{
			E e = data[front];
		
			//move front to second item
			front = ((front + 1) % CAPACITY);
			return e;
		}
	}
	
	public String toString()
	{
		String s = "";
		
		for (int i = (front % CAPACITY); i < rear; i++)
		{
			s += (data[i] + ", ");
		}
		
		return s;
	}
	
	public static void main(String[] args) {
		ArrayQueue<Integer> stack = new ArrayQueue<Integer>();	
		stack.enqueue(3);
		System.out.println(stack);
		stack.enqueue(6);
		System.out.println(stack);
		stack.enqueue(14);
		System.out.println(stack);
		System.out.println("Size is " + stack.size());
		stack.dequeue();
		System.out.println(stack);
		System.out.println("First element in queue is " + stack.first());
		stack.enqueue(60);
		System.out.println(stack);
		stack.dequeue();
		System.out.println(stack);
		stack.dequeue();
		System.out.println(stack);
		stack.dequeue();
		System.out.println(stack);
		System.out.println("Size is " + stack.size());
		stack.dequeue();
		stack.enqueue(70);
		System.out.println(stack);
	}

}
