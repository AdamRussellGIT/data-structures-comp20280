package projectCode20280;

public class LinkedStack<E> implements Stack<E> {
	private SinglyLinkedList<E> list = new SinglyLinkedList<>();
	
	public LinkedStack()
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
	public void push(E e) {
		list.addLast(e);
	}

	@Override
	public E top() {
		return list.get(size()-1);
	}

	@Override
	public E pop() {
		E e = list.removeLast();
		return e;
	}
	
	public String toString()
	{
		return list.toString();
	}
	
	public static void main(String[] args) {
		LinkedStack<Integer> stack = new LinkedStack<Integer>();	
		stack.push(3);
		System.out.println(stack);
		stack.push(6);
		System.out.println(stack);
		stack.push(14);
		System.out.println(stack);
		stack.pop();
		System.out.println(stack);
		System.out.println(stack.size());
		System.out.println(stack.top());
		stack.push(60);
		System.out.println(stack);
		

	}

}
