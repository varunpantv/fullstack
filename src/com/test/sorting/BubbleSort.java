package com.test.sorting;

public class BubbleSort {

	public static void main(String args[]){
		System.out.println("hii");
		int arr[]={5,4,3,2,1,5,4,4,3,3,3};//{8, 22, 7, 9, 31, 5, 13};//{5, 5,	4,     4 ,    4,    3,     3,     3,     3 , 2,	1 };//
		
		long sTime,eTime;
		sTime=System.currentTimeMillis();
		System.out.println("Start time:"+sTime);
		
		bubbleSort(arr);
		
		eTime=System.currentTimeMillis();
		System.out.println("End time:"+eTime);
		System.out.println("Time Taken:"+(eTime-sTime)+ " ms");
		
		int barr[]={5,4,3,2,1,5,4,4,3,3,3};
		
		System.out.println("\nOptimized Bubble Sort.....");
		sTime=System.currentTimeMillis();
		System.out.println("Start time:"+sTime);
		
		optimizedBubbleSort(barr);
		eTime=System.currentTimeMillis();
		System.out.println("End time:"+eTime);
		System.out.println("Time Taken:"+(eTime-sTime)+ " ms");
		//arrays are passed by reference
		/*for (int i=0;i<arr.length;i++){
			System.out.print(arr[i]+"    ");
		}*/
		
		System.out.println("Recursive Bubble Sort:");
		sTime=System.currentTimeMillis();
		System.out.println("Start time:"+sTime);
		
		int carr[]={5,4,3,2,1,5,4,4,3,3,3};
		System.out.println("Array before sort: -");
		System.out.println("-------------------");
		printArray(carr);
		
		recursiveBubbleSort(carr, carr.length);
		
		System.out.println("Array after sort: -");
		System.out.println("-------------------");
		printArray(carr);
		
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
	
	
	public static void bubbleSort(int arr[]){
		int len=arr.length;
		int temp=0;
		
		System.out.println("Array before sort: -");
		System.out.println("-------------------");
		for (int i=0;i<len;i++)
			System.out.print(arr[i]+"     ");
		
		for (int i=0;i<len;i++){
		
			for (int j=0;j<(len-i-1);j++)
			{
				if (arr[j] > arr[j+1] ){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			System.out.println("\nAfter pass: "+i);
			printArray(arr);
		}
		System.out.println();
		
		System.out.println("Array after sort: -");
		System.out.println("-------------------");
		for (int i=0;i<len;i++)
			System.out.print(arr[i]+"     ");
		
		System.out.println();
	}
	
	public static void recursiveBubbleSort(int arr[],int n){
		// Base case
        if (n == 1)
            return;
        
        // One pass of bubble sort. After
        // this pass, the largest element
        // is moved (or bubbled) to end.
        int temp=0;
        for (int i=0;i<n-1;i++){
        	if (arr[i] > arr[i+1] ){
				temp=arr[i];
				arr[i]=arr[i+1];
				arr[i+1]=temp;
				
			}
        }
        
        // Largest element is fixed,
        // recur for remaining array
        recursiveBubbleSort(arr, n-1);
		
	}
	public static void optimizedBubbleSort(int arr[]){
		int temp=0;
		
		System.out.println("Array before sort: -");
		System.out.println("-------------------");
		printArray(arr);
		
		int len=arr.length;
		boolean swapped=false;
		
		//0 to 10
		
		//0 to 10-i-1
		
		
		for (int i=0;i<len;i++){
		
			for (int j=0;j<(len-i-1);j++)
			{
				swapped=false;
				if (arr[j] > arr[j+1] ){
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
					swapped=true;
				}
			}
			System.out.println("\nAfter pass: "+i);
			printArray(arr);
			
			if(false==swapped)
				break;
		}
		System.out.println();
		
		System.out.println("Array after sort: -");
		System.out.println("-------------------");
		printArray(arr);
		
		System.out.println();
	}
}
