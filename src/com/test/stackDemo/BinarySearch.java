package com.test.stackDemo;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sortedArr[]={7,8,11,12,14,15,16,17,18};
		
		int low, high, mid=0;
		int item=8;
		low=0;
		high=sortedArr.length-1;
		//System.out.println("high"+high);
		mid=(low+high)/2;
		
		boolean found=false; 
		int pos=-1;
		while (mid >= low && mid <= high)
		{
			System.out.println("low: "+ low);
			System.out.println("high: "+ high);
			System.out.println("mid: "+ mid);
			System.out.println("--------------------");
			
			if(sortedArr[mid] == item)
			{
				found=true;
				pos=mid;
				break;
			}
			else
			{
				/*if (sortedArr[mid] < item){
					high=mid-1;
				}
				else 
				{
					low=mid+1;
				}*/
				if (sortedArr[mid] > item)
				{
					high=mid-1;
				}else 
				{
					low=mid+1;
				}
				
			}
			mid=(low+high)/2;
			
		}
		
		System.out.println("Hello...");
		if (found)
			System.out.println("Value: "+item+", found at position: "+pos);
		else 
			System.out.println("Value: "+ item+ " not found int the array.");
		
		int sum=recursionSum(sortedArr);
		System.out.println("Sum of the elements using recursion="+sum);
	}

	public static int recursionSum(int array[]){
		if (array.length==1)
			return array[0];
		else 
		{
			int arr[]=new int[array.length-1];
			
			for (int i=0;i<(array.length-1);i++)
			{
				arr[i]=array[i];
			}
			
			return (array[array.length-1])+recursionSum(arr);
		}
		
	
	}
}
