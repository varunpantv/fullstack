package com.test.queue;

public class Runner {

	public static void main(String[] args) {
		System.out.println("Hello there...");
		Queue q=new Queue();
	/*	q.enQueue(5);
		q.enQueue(2);
		q.enQueue(7);
		q.enQueue(3);*/
		//q.deQueue();
		q.deQueue();
		System.out.println("Queue is empty?:"+q.isEmpty());
		
		q.enQueue(9);
		q.enQueue(1);
		q.enQueue(1);
		q.enQueue(1);
		
		System.out.println("size:"+q.getSize());
		q.show();
		
		System.out.println("Queue is full?:"+q.isFull());
		
	}

}
