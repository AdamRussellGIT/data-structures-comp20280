package projectCode20280;

import java.util.LinkedList;
import java.util.Random;
import java.util.stream.Collectors;

/*
	Implementation of the HPQSort, with timing in nanoseconds.
*/

public class HPQSort
{
	public static void main(String[] args)
	{
		int n = 100;
		
		while (n < 1000)
		{
			LinkedList<Integer> sll = new Random().ints(0, 1000).distinct().limit(n).boxed().collect(Collectors.toCollection(LinkedList::new));
			HeapPriorityQueue<Integer, Integer> hpq = new HeapPriorityQueue<Integer, Integer>();
		
			long startTime = System.nanoTime();
			  
			  while (!sll.isEmpty())
			  {
				  int e = sll.removeFirst();
				  hpq.insert(e, e);
			  }
			  
			  while(!hpq.isEmpty()) 
			  {
				int e = hpq.removeMin().getKey();
				sll.addLast(e);
			  }
		
			long endTime = System.nanoTime();
		
			long elapsedTime = endTime - startTime;
		
			System.out.println(n + ", " + elapsedTime);
			
			n = (int) (n * 1.01);
		}
	}
}
