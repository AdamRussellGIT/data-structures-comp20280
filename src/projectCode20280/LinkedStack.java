package projectCode20280;

/*
	The LinkedStack<E> class implements the Stack<T> interface.
	
	My LinkedStack class is made with a SinglyLinkedList as the underlying structure that holds
		the information contained in the stack.
	
	The addLast() and removeLast() methods of the SinglyLinkedList are used to implement the
		push() and pop() methods of the stack interface.
		
	
*/

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
		System.out.println("Push 3: ");
		stack.push(3);
		System.out.println(stack + "\n");
		
		System.out.println("Push 6: ");
		stack.push(6);
		System.out.println(stack + "\n");
		
		System.out.println("Push 14: ");
		stack.push(14);
		System.out.println(stack + "\n");
		
		System.out.println("Pop: ");
		stack.pop();
		System.out.println(stack + "\n");
		
		System.out.println("Size is " + (stack.size()) + "\n");
		System.out.println("Top is " + stack.top() + "\n");
		
		System.out.println("Push 60: ");
		stack.push(60);
		System.out.println(stack);
		

	}

}
