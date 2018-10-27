package com.test.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		System.out.println("Hello World... ");
		
		int a[]=new int[10];
System.out.println("Length:"+a.length);

List<Integer> c= new ArrayList<Integer>();

Random r=new Random();
for (int i=1;i<=100;i++){
	c.add(r.nextInt(1000));
}

/*c.add(1);
c.add(2);
//c.add("Navin");
c.add(5);*/

//c.remove(2);

//c.add(2,3);
System.out.println("C:"+c);
Collections.sort(c);
for (Integer o:c){
	System.out.println(o);
}
		/*//Collection<Integer> values=new ArrayList<>();
		List<Integer> values=new ArrayList<>();
		
		values.add(5);
		values.add(6);
		values.add(9);
		values.add(11);*/
		
		//values.add(8);
	}
}
