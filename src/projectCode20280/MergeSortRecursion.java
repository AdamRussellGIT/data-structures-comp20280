package projectCode20280;

import java.util.Arrays;

public class MergeSortRecursion 
{
	public static void mergeSort(int arr[], int i, int j)
	{
		if (i >= j)
		{
			return;
		}
		
		int mid = (i + j)/2;
		mergeSort(arr, i, mid);
		mergeSort(arr, mid+1, j);
		merge(arr, i, mid, j);
	}
	
	public static void merge(int arr[], int l, int m, int r)
	{
		int n1 = m - l + 1;
		int n2 = r - m;
		
		int[] left = new int[n1];
		int[] right = new int [n2];
		
		for (int a = 0; a < n1; a++)
		{
			left[a] = arr[l+a];
		}
		
		for (int b = 0; b < n2; b++)
		{
			right[b] = arr[m+1+b];
		}
		
		int i = 0;
		int j = 0;
		int k = l;
		
		while (i < n1 && j < n2)
		{
			if (left[i] <= right[j])
			{
				arr[k] = left[i];
				i++;
			}
			
			else
			{
				arr[k] = right[j];
				j++;
			}
			
			k++;
		}
		
		while (i < n1)
		{
			arr[k] = left[i];
			i++;
			k++;
		}
		
		while (j < n2)
		{
			arr[k] = right[j];
			j++;
			k++;
		}
	}
	
	public static void main(String[] args)
	{
		int size = 1000;
		int[] anArray = new int[size];
		
		for (int i = 0; i < anArray.length; i++)
		{
			anArray[i] = (int) (Math.random() * (1000 - 1)) + 1;
		}
		
		System.out.println("Before sorting :\n" + Arrays.toString(anArray));
		
		long startTime = System.currentTimeMillis();
		mergeSort(anArray, 0, anArray.length-1);
		long endTime = System.currentTimeMillis();
		
		long timeTaken = endTime - startTime;
		
		System.out.println("After sorting :\n" + Arrays.toString(anArray));
		
		System.out.println("Time taken to sort (in milli seconds): " + timeTaken);
	}
}
