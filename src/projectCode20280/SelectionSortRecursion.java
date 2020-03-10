package projectCode20280;

import java.util.Arrays;

public class SelectionSortRecursion 
{
	public static <E extends Comparable<E>> void selectionSort(E[] arr, int i)
	{
		if (i >= arr.length - 1)
		{
			return;
		}
		
		int minIndex = i;
		
		for (int index = i + 1; index < arr.length; index++)
		{
			if (arr[index].compareTo(arr[minIndex]) < 0 )
			{
				minIndex = index;
			}
		}
		
		E temp = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex] = temp;
		
		selectionSort(arr, i + 1);
	}
	
	public static <E extends Comparable<E>> void sort(E[] arr) 
    { 
        int n = arr.length; 
  
        // One by one move boundary of unsorted subarray 
        for (int i = 0; i < n-1; i++) 
        { 
            // Find the minimum element in unsorted array 
            int min_idx = i; 
            for (int j = i+1; j < n; j++) 
                if (arr[j].compareTo(arr[min_idx]) < 0) 
                    min_idx = j; 
  
            // Swap the found minimum element with the first 
            // element 
            E temp = arr[min_idx]; 
            arr[min_idx] = arr[i]; 
            arr[i] = temp; 
        } 
    } 
	
	public static void main(String[] args)
	{
		int size = 1000;
		Integer[] anArray = new Integer[size];
		
		for (int i = 0; i < size; i++)
		{
			anArray[i] = (int) (Math.random() * (1000 - 1)) + 1;
		}
		
		System.out.println("Before sorting :\n" + Arrays.toString(anArray));
		
		long startTime = System.currentTimeMillis();
		sort(anArray);
		long endTime = System.currentTimeMillis();
		
		long timeTaken = endTime - startTime;
		
		System.out.println("After sorting :\n" + Arrays.toString(anArray));
		
		System.out.println("Time taken to sort (in milli seconds): " + timeTaken);
	}
}
