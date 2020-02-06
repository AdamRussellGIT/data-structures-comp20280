package projectCode20280;

public class LinkedDeque<E> implements Deque<E> {
	private DoublyLinkedList<E> list = new DoublyLinkedList<>();
	
	public LinkedDeque()
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
	public E first() {
		return list.getFirst();
	}

	@Override
	public E last() {
		return list.getLast();
	}

	@Override
	public void addFirst(E e) {
		list.addFirst(e);
	}

	@Override
	public void addLast(E e) {
		list.addLast(e);
	}

	@Override
	public E removeFirst() {
		return list.removeFirst();
	}

	@Override
	public E removeLast() {
		return list.removeLast();
	}
	
	public String toString()
	{
		return list.toString();
	}
	
	public static void main(String[] args) {
		LinkedDeque<Integer> ld = new LinkedDeque<Integer>();
		ld.addFirst(1);
		System.out.println(ld.toString());
		ld.addFirst(2);
		System.out.println(ld.toString());
		ld.addLast(3);
		System.out.println(ld.toString());
		ld.removeFirst();
		System.out.println(ld.toString());
		ld.addLast(69);
		System.out.println(ld.toString());
		ld.addFirst(4);
		System.out.println(ld.toString());
		ld.removeFirst();
		System.out.println(ld.toString());
		ld.removeLast();
		System.out.println(ld.toString());
	}

}
