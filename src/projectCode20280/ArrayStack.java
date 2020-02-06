package projectCode20280;

public class ArrayStack<E> implements Stack<E> {
	public static final int CAPACITY = 1000;
	
	private E[] data;
	
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
	stack.push(14);
	System.out.println(stack);
	stack.pop();
	System.out.println(stack);
	System.out.println(stack.top());
	stack.push(60);
	System.out.println(stack);
	

	}

}
