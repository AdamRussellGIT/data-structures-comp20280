package projectCode20280;

import java.util.Arrays;

public class SelectionSortRecursion 
{
	public static void selectionSort(int arr[], int i)
	{
		if (i >= arr.length - 1)
		{
			return;
		}
		
		int minIndex = i;
		
		for (int index = i + 1; index < arr.length; index++)
		{
			if (arr[index] < arr[minIndex])
			{
				minIndex = index;
			}
		}
		
		int temp = arr[i];
		arr[i] = arr[minIndex];
		arr[minIndex] = temp;
		
		selectionSort(arr, i + 1);
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
		selectionSort(anArray, size);
		long endTime = System.nanoTime();
		
		long timeTaken = endTime - startTime;
		
		System.out.println("After sorting :\n" + Arrays.toString(anArray));
		
		System.out.println("Time taken to sort (in nano seconds): " + timeTaken);
	}
}
