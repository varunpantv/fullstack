package com.test.queue;

public class Queue {
	int queue[]=new int[5];
	int size;
	int front;
	int rear;
	
	public void enQueue(int data)
	{
		if (!isFull()){
			queue[rear]=data;
			rear=(rear+1)%5;
			size++;
		}
		else
		{
			System.out.println("The queue is full.");
		}
	}
	public int deQueue()
	{
		int data= queue[front];
		
		if (!isEmpty()){
			size --;
			front = (front+1)%5	;
		}
		else{
			System.out.println("The queue is empty");
		}
		return data;
	}
	public void show()
	{
		System.out.println("Elements:");
		for (int i=0;i<size;i++)
		{
			System.out.print(queue[(front+i)%5]+"	");
		}
		System.out.println("\nActual Array: ");
		for (int n:queue){
			System.out.print(n+"	");
		}
	}
	public int getSize()
	{
		return size;
	}
	public boolean isEmpty()
	{
		return getSize()== 0;
	}
	
	public boolean isFull()
	{
		return getSize()==5;
	}
}
