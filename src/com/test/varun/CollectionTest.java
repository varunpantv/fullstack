package com.test.varun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
 class MyKey {
    private String name;
    private int id;
 
/*    public (int id, String name) {
        this.id = id;
        this.name = name;
    }
     */
    // standard getters and setters
  
    public MyKey(int i, String string2) {
		// TODO Auto-generated constructor stub
    	 this.id = i;
         this.name = string2;
	}

	@Override
    public int hashCode() {
        System.out.println("Calling hashCode()");
        return id;
    } 
  
    // toString override for pretty logging
 
    @Override
    public boolean equals(Object obj) {
        System.out.println("Calling equals() for key: " + obj);
        // generated implementation
        MyKey mk=(MyKey) obj;
        if (mk.id == this.id){
        	if (mk.name.equals(this.name))
        		return true;
        }else 
        	return false;
        
        return false;
    }
 
}
public class CollectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hello");
		
		HashMap hm=new HashMap<String, Integer>();
		Object st;
		st=hm.put("one", 1);
		System.out.println("st:"+st);
		hm.put("two", 2);
		hm.put("three", 3);
		st=hm.put("three", 33);
		System.out.println("st:"+st);
		hm.put("four", null);
		System.out.println("Hashmap:"+hm);
		//HashMap Overwrites the key
		Hashtable ht=new Hashtable<String, Integer>();
	
		ht.put("one", 1);
	
		ht.put("two", 2);
		ht.put("three", 3);
		st=(Integer) ht.put("three", 33);
	
		//ht.put("four", null);
		System.out.println("Hashtable:"+ht);
		
		List<String> al=new ArrayList<>(3);
		al.add("one");
		al.add("two");
		al.add("three");
		al.add("four");
		al.add("five");
		System.out.println(al);
		
		HashMap<MyKey, String> map = new HashMap<>();
	    MyKey k1 = new MyKey(1, "firstKey");
	    MyKey k2 = new MyKey(2, "secondKey");
	    MyKey k3 = new MyKey(2, "thirdKey");
	 
	    System.out.println("storing value for k1");
	    map.put(k1, "firstValue");
	    System.out.println("storing value for k2");
	    map.put(k2, "secondValue");
	    map.put(k2, "secondValue2");
	    System.out.println("storing value for k3");
	    map.put(k3, "thirdValue");
	 
	    System.out.println("---------------------");
	    System.out.println("retrieving value for k1");
	    String v1 = map.get(k1);
	    System.out.println("v1:"+v1);
	    System.out.println("retrieving value for k2");
	    String v2 = map.get(k2);
	    System.out.println("v2:"+v2);
	    System.out.println("retrieving value for k3");
	    String v3 = map.get(k3);
	    System.out.println("v3:"+v3);
	}

}
