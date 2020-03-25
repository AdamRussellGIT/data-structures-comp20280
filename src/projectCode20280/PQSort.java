package projectCode20280;

import java.util.Random;
import java.util.stream.Collectors;
import java.util.LinkedList;

public class PQSort 
{
	public PQSort()
	{
		
	}
	
	public static void fillRandom(SinglyLinkedList<Integer> ll, int n)
	{
		Random rnd = new Random();
		
		for (int i = 0; i < n; i++)
		{
			ll.addLast(rnd.nextInt());
		}
	}
	
	public static Integer removeMin(LinkedList<Integer> ll)
	{
		int min_idx = 0;
		Integer min_val = ll.get(min_idx);
		
		for (int i = 1; i < ll.size(); i++)
		{
			Integer curr = ll.get(i);
			
			if (curr < min_val)
			{
				min_val = curr;
				min_idx = i;
			}
		}
		
		ll.remove(min_idx);
		
		return min_val;
	}
	
	public static void main(String[] args)
	{
		int n = 100;
		
		while (n < 1000)
		{
			LinkedList<Integer> sll = new Random().ints(0, 1000).distinct().limit(n).boxed().collect(Collectors.toCollection(LinkedList::new));
			LinkedList<Integer> worksll = new LinkedList<Integer>();
		
			long startTime = System.nanoTime();
		
			while (!sll.isEmpty())
			{
				worksll.addLast(sll.removeFirst());
			}
		
			while (!worksll.isEmpty())
			{
				sll.addLast(removeMin(worksll));
			}
		
			long endTime = System.nanoTime();
		
			long elapsedTime = endTime - startTime;
		
			System.out.println(n + ", " + elapsedTime);
			
			n = (int) (n * 1.01);
		}
	}
}
