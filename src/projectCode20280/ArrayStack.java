package projectCode20280;

/*
	The Array Stack implements the abstract Stack<T> class.
	The Stack has a pointer to the top of the stack: top.
	Items can only be pushed (inserted) or removed (popped) from the top of the stack.
*/

public class ArrayStack<E> implements Stack<E> {
	//default capacity
	public static final int CAPACITY = 1000;
	
	private E[] data;
	
	//t points to the top of the tack
	//it is an int referencing an index of the array used to represent the stack
	private int t = -1;
	
	public ArrayStack()
	{
		this(CAPACITY);
	}
	
	@SuppressWarnings({"unchecked"})
	public ArrayStack(int CAPACITY)
	{
		data = (E[]) new Object[CAPACITY];
	}

	@Override
	public int size() {
		return t + 1;
	}

	@Override
	public boolean isEmpty() {
		if(t == -1)
		{
			return true;
		}
		
		else
		{
			return false;
		}
	}

	@Override
	public void push(E e) {
		if (size() == CAPACITY)
		{
			throw new RuntimeException("Stack is full!");
		}
		
		else
		{
			t++;
			data[t] = e;
		}
	}

	@Override
	public E top() {
		return data[t];
	}

	@Override
	public E pop() {
		if (isEmpty())
		{
			return null;
		}
		
		else
		{
			E temp = data[t];
			t--;
			return temp;
		}
	}
	
	public String toString()
	{
		String s = "";
		
		for (int i = 0; i <= t; i++)
		{
			if (i == t)
			{
				s += data[i];
			}
			
			else
			{
				s += (data[i] + ", ");
			}
		}
		
		return s;
	}
	
	public static void main(String[] args) {
	ArrayStack<Integer> stack = new ArrayStack<Integer>();	
	stack.push(3);
	System.out.println(stack);
	stack.push(6);
	System.out.println(stack);
	System.out.println("Size is " + stack.size());
	stack.push(14);
	System.out.println(stack);
	stack.pop();
	System.out.println(stack);
	System.out.println("Size is " + stack.size());
	System.out.println("Top is " + stack.top());
	stack.push(60);
	System.out.println(stack);
	}

}
