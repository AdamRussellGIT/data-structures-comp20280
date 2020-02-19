package projectCode20280;

import java.util.Arrays;

public class BubbleSortRecursive 
{
	public static void bubbleSort(int arr[], int n)
	{
		if (n == 1)
		{
			return;
		}
		
		for (int i = 0; i < n-1; i++)
		{
			if (arr[i] > arr[i+1])
			{
				//swap arr[i] and arr[i+1]
				int temp = arr[i];
				arr[i] = arr[i+1];
				arr[i+1] = temp;
			}
		}
		
		bubbleSort(arr, n-1);
	}
	
	public static void main(String[] args)
	{
		int size = 10;
		int[] anArray = new int[size];
		
		for (int i = 0; i < size; i++)
		{
			anArray[i] = (int) (Math.random() * (1000 - 1)) + 1;
		}
		
		System.out.println("Before sorting :\n" + Arrays.toString(anArray));
		
		long startTime = System.nanoTime();
		bubbleSort(anArray, size);
		long endTime = System.nanoTime();
		
		long timeTaken = endTime - startTime;
		
		System.out.println("After sorting :\n" + Arrays.toString(anArray));
		
		System.out.println("Time taken to sort (in nano seconds): " + timeTaken);
	}
}
