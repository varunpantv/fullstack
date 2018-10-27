package com.test.spreadsheet;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class mainCalculation {
	public static int column_size = 0;
	public static int row_size = 0;
	public static float [][]  value_Array = null;
	public static String [][]  expression_Array = null;
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
        System.out.print("Please enter matrix size information:");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        //to read first input line as total dimension information 
        String inputLine = in.readLine(); 
        //System.out.println ("Show me inputLine:" + inputLine);
        StringTokenizer st= new StringTokenizer (inputLine);
        if (st.countTokens() >=2) {
            try {
            	column_size = Integer.parseInt(st.nextToken());
            	row_size = Integer.parseInt(st.nextToken());
            	//initialize value_Array as  new int [row_size][column_size] and set default value as -1
            	value_Array = new float [row_size][column_size];
            	for (int i=0;i<row_size;i++) {
            		for (int j=0;j<column_size;j++) 
            			value_Array[i][j] = -1; 
            	}
               // System.out.println("Please enter matrix cell details:");
            	expression_Array = new String [row_size][column_size];
            	int total_cell = column_size * row_size;
            	for (int i=0;i<row_size;i++) {
            		for (int j=0;j<column_size;j++) 
            			expression_Array[i][j] = in.readLine().trim().toUpperCase(); 
            	}
            	System.out.println("Finish data entry. System will start data processing");
            	
            	//start processing the data values
            	for (int i=0;i<row_size;i++) {
            		for (int j=0;j<column_size;j++) { 
            		    String expression_String = expression_Array[i][j] ;
            		    if (value_Array[i][j] < 0) {
            		    	float result =processExpression(expression_String, i, j); 
            		    }
            		}	
            	}
            	
            	//Display results
            	displayResults();
            } catch (Exception e) {
            	e.printStackTrace();
            	System.out.println("dimension information is wrong");
            }
        }
        
        
	}
	
	//method for processing the expression
	public static float  processExpression(String expression_String, int i, int j) throws Exception{
		float result =0;
		StringTokenizer st = new StringTokenizer (expression_String);
		if (st.countTokens() > 1) {
			Stack dataStack = new Stack();
			while (st.hasMoreTokens()) {
				String node = st.nextToken();
				int node_type = checkNodeType(node);
				if (node_type == 1 ) {
					dataStack.push(String.valueOf(node));
				} else if (node_type == 2) {
				    float operrand_value=0;
					//need to parse out the node like A2 to map to value_Array [0][1];
					//A =  65  B=66
					int rowIndicator = ((int) node.charAt(0)) - 65;
					int columnIndicator = Integer.parseInt(node.substring(1, node.length()))-1;
					//get value from value_Array.If can get value, do assignment, else, you need to call processExpression 
					if (value_Array[rowIndicator][columnIndicator] >= 0) {
						operrand_value = value_Array[rowIndicator][columnIndicator];
					} else {
						operrand_value =  processExpression(expression_Array[rowIndicator][columnIndicator], rowIndicator, columnIndicator);
					}
					//to push the value
					System.out.println("processed value:" + operrand_value);
					dataStack.push(String.valueOf(operrand_value));
				} else {
					float operrand_value=0;
					//for operator, you need to pop out 2 values and then push the results
					float value2 = Float.parseFloat((String) dataStack.pop());
					float value1 = Float.parseFloat((String) dataStack.pop());
					if ("+".equals(node)) {
						operrand_value = value1 + value2;
					} else if ("-".equals(node)) {
						operrand_value = value1 - value2;
					} else if ("*".equals(node)) {
						operrand_value = value1 * value2;
					} else if ("/".equals(node)) {
						operrand_value = value1 / value2;
					}
					System.out.println(value1 + "###" + value2 + "###" + operrand_value);
					dataStack.push(String.valueOf(operrand_value));
				}
			}
			//after finish processing, you need to get the top value
			float final_value = Float.parseFloat((String)dataStack.pop());
			//assign back the value
			value_Array[i][j]=final_value;
			result = final_value;
		} else {
			String node = st.nextToken();
			int checkType = checkNodeType(node);
			if (checkType ==1) {
				result = Float.parseFloat(node);
    		    //value_Array[i][j]=result;
			} else if (checkType ==2) {
				//need to parse out the node like A2 to map to value_Array [0][1];
				//A =  65  B=66
				int rowIndicator = ((int) node.charAt(0)) - 65;
				int columnIndicator = Integer.parseInt(node.substring(1, node.length()))-1;
				//get value from value_Array.If can get value, do assignment, else, you need to call processExpression 
				System.out.println("Show me node:" + node + " with index value:" + rowIndicator + "#" + columnIndicator  );
				if (value_Array[rowIndicator][columnIndicator] >0) {
					result = value_Array[rowIndicator][columnIndicator];						
					System.out.println("can find mapped value:" + result);
				} else {
					result =  processExpression(expression_Array[rowIndicator][columnIndicator], rowIndicator, columnIndicator);
					System.out.println("to calculate mapped value:" + result + "for index:"+ rowIndicator + "#" + columnIndicator );
				}
			} else {
				//for this case, it means that value assignment is operator instead
				result = 0;	
			}
			//assign back the value
			value_Array[i][j]=result;
		}
		return result;
	}
	
	//type =1   normal result like 1,2,3,4
	//type =2   reference node like A1, B2  
	//type =3   operator like + - * / 
	public static int checkNodeType (String node) {
		int type =2;
		try {
			Float i = Float.parseFloat(node);
			//if can be parsed into integer. then it means this is type 1
			type = 1;
		} catch (Exception e) {
			if ("+".equals(node ) || "-".equals(node ) || "*".equals(node ) || "/".equals(node )  ) 
                type = 3;
		}
		return type;
	}
	
	//to display results in well format
	public static void displayResults() {
		System.out.println("################################");
		System.out.println(column_size + " " + row_size);
		for (int i=0;i<row_size;i++) {
    		for (int j=0;j<column_size;j++)  {
    		    //need to convert the value to well-format
    			System.out.println("Cell value at " + i + " " + j + ":" + String.format("%.5f", value_Array[i][j])); 
    			//System.out.println("Cell value at " + i + " " + j + ":" + value_Array[i][j]); 
    		}
    	}
		System.out.println("################################");
	}

}
