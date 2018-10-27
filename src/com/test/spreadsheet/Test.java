package com.test.spreadsheet;

import java.util.StringTokenizer;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression_String="3 2";
		StringTokenizer st = new StringTokenizer (expression_String);
		
		System.out.println("Number of Tokens:"+st.countTokens());
		if (st.countTokens() > 1){
			while (st.hasMoreTokens()) {
				String node = st.nextToken();
				
				System.out.println("Node:"+node);
			}
		}
			String test="A24";
			System.out.println(test.charAt(0)-65);
			System.out.println(test.substring(1,test.length()));
	}

}
