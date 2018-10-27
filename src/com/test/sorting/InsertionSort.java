package com.test.sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Aloha");
		
		int arr[]={5,4,3,2,1,5,4,4,3,3,3};
		
		long sTime,eTime;
		sTime=System.currentTimeMillis();
		System.out.println("Start time:"+sTime);
		
		insertionSort(arr);
		
		eTime=System.currentTimeMillis();
		System.out.println("End time:"+eTime);
		System.out.println("Time Taken:"+(eTime-sTime)+ " ms");
	}
	public static void printArray(int arr[]){
		int len=arr.length;
		
		for (int i=0;i<len;i++)
			System.out.print(arr[i]+"     ");
		
		System.out.println("\n---------------");
	}
	
	private static void insertionSort(int[] arr) {
		// TODO Auto-generated method stub
		
	}
	
	
}
