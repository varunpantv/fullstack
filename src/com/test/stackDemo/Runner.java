package com.test.stackDemo;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Stack nums=new Stack();
		DStack nums=new DStack();
		/*System.out.println("Empty = "+nums.isEmpty());
		nums.push(15);
		nums.push(8);
		System.out.println("\nPeek:"+nums.peek());
		nums.push(10);
		nums.show();
		nums.push(7);
		//System.out.println("Pop:"+nums.pop());
		System.out.println("\nsize is:  "+nums.size());
		System.out.println("Empty = "+nums.isEmpty());
		System.out.println("-------------------");
		nums.show();*/
		
		nums.push(15);
		nums.show();
		nums.push(8);
		nums.show();
		nums.push(7);
		nums.show();
		nums.push(17);
		nums.show();
		nums.push(77);
		nums.show();
		nums.push(88);
		nums.show();
		nums.push(99);
		nums.show();
		
		System.out.println("Pop:"+nums.pop());
		nums.show();
		System.out.println("Pop:"+nums.pop());
		nums.show();
		System.out.println("Pop:"+nums.pop());
		nums.show();
		System.out.println("Pop:"+nums.pop());
		nums.show();
		System.out.println("Pop:"+nums.pop());
		nums.show();
		System.out.println(nums.size());
		System.out.println("Pop:"+nums.pop());
		nums.show();
	}

}
