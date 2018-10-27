package com.test.gv;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Test");
		
		String str="2,4,6";
		String strArray[]=str.split(",");
		
		Node root=new Node(1);
		//System.out.println(strArray);
		List<Node> children=new ArrayList<Node>();
		for (int j=0;j<strArray.length;j++){
			System.out.println(strArray[j]);
		
 	    	//children.add(new Node(Integer.parseInt(strArray[j])));
			root.appendChild(new Node(Integer.parseInt(strArray[j])));
		}
		String line =" 1(2,4, 6) 2(3, 9) 4(5,7)  6(11,12 ) 5(13,16)   12(14, 23, 17) 16( 24,32 )";
		
		System.out.println("Line: "+line);
		//Tree first = 
			//	new Tree(" 1(2,4, 6) 2(3, 9) 4(5,7)  6(11,12 ) 5(13,16)   12(14, 23, 17) 16( 24,32 )");
		 //c:
        // ( 
        // )
        // space
        // ,
		//numeric
		
		//[0-9][(][)][ ][,]
	   
	    
		/*System.out.println(str.length());
		
		System.out.println(str.charAt(0));*/
		/*
		Node n=new Node(1);
		//n.appendChild(child);
		Tree first = 
		new Tree(" 1(2,4, 6) 2(3, 9) 4(5,7)  6(11,12 ) 5(13,16)   12(14, 23, 17) 16( 24,32 )");*/
		
		
	}

}
