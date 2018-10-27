package com.test.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class ArrayListExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> al=new ArrayList<String>();
		al.add("Jack");
		al.add("Tyler");
		al.add("Tyler");
		
		al.add(1,"Jill");
		Iterator<String> itr=al.iterator();
		
		while (itr.hasNext()){
			System.out.println(itr.next());
		}
	
		System.out.println(al.indexOf("Jack"));
		System.out.println(al.lastIndexOf("Tyler"));
		al.remove(3);
		Object strarr[]= al.toArray();
		System.out.println("----------------");
		for (int i=0;i<strarr.length;i++){
			System.out.println(strarr[i]);
		}
		System.out.println("----------------");
		for (int i=0;i<al.size();i++){
			System.out.println(al.get(i));
		}
	}

}
