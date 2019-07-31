package com.abhishek.java.sorting;

public class BubbleSorting {

	public static void main(String[] args) {
		int[] arr = {7,3,54,23,22};
		bubbleSort(arr);

	}
	
	public static void swap(int[] array, int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	public static void bubbleSort(int[] arr)
	{
		int n= arr.length;
		
		boolean isSorted = false;
		while(!isSorted) {	
		isSorted=true;
		for(int i=0;i<n-1;i++)
		{
			if(arr[i+1]<arr[i])
			{
				swap(arr,i,i+1);
				isSorted=false;
			}
		}
		n--;
		
		}
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]+", ");
		}
	}

}
