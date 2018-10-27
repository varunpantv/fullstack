package com.test.spreadsheet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class SpreadSheet {

	static double valuesArray[][]=null;
	static String expressionsArray[][]=null;
	
	static double defaultValue=-1;
	
	static int colSize=0;
	static int rowSize=0;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		FileReader in = new FileReader("C:\\Projects\\Full Stack\\inputs.txt");
		BufferedReader br=new BufferedReader(in);
		String rowCol="";
		
		System.out.println("Enter Columns and Rows:");
		
		rowCol=br.readLine();
		
		StringTokenizer stkn=new StringTokenizer(rowCol);
		
		
		if (stkn.countTokens() >= 2){
			colSize=Integer.parseInt(stkn.nextToken());
			rowSize=Integer.parseInt(stkn.nextToken());
			
			System.out.println(colSize+ " Columns and "+rowSize+" Rows");
			valuesArray=new double[rowSize][colSize];
			
			expressionsArray=new String[rowSize][colSize];
			
			for (int i=0;i<rowSize;i++){
				for (int j=0;j<colSize;j++){
					//System.out.println("i:"+i+", j:"+j);
					valuesArray[i][j]=defaultValue;
				}
			}
		}
		
		System.out.println("Enter Excel values columnwise:\n");
		
		for (int i=0;i<rowSize;i++){
			for (int j=0;j<colSize;j++){
				expressionsArray[i][j]=br.readLine().trim().toUpperCase(); 
			}
		}
		
		System.out.println("Initial Values: -");
		System.out.println("-----------------------");
		System.out.println("Values Array: ");
		displayResults();
		
		System.out.println("Expressions Array: ");
		displayExpressions();
		
		System.out.println("-----------------------");
		System.out.println("Processing Start...");
		
		String expressionString="";
		double result=0;
		
		for (int i=0;i<rowSize;i++){
			for (int j=0;j<colSize;j++){
				expressionString=expressionsArray[i][j];
				//if (valuesArray[i][j] == defaultValue) {
				if (valuesArray[i][j] < 0) {
					System.out.println("Processing...");
					result=processExpression(expressionString,i,j);
				}
			}
		}
		
		/*String node="A11";
		
		int nodeType=0;
		nodeType=checkNodeType(node);*/
		
		//System.out.println("Type:"+nodeType);
		
		System.out.println("Final Values: -");
		System.out.println("-----------------------");
		System.out.println("Values Array: ");
		displayResults();
		
		System.out.println("Expressions Array: ");
		displayExpressions();
		
		System.out.println("-----------------------");
	}
	
	//type =1   normal result like 1,2,3,4
	//type =2   reference node like A1, B2  
	//type =3   operator like + - * / 
	private static int checkNodeType(String node) {
		// TODO Auto-generated method stub
		int type=2;
		
		try{
			double f=Double.parseDouble(node);
			
			type=1;
		}catch (Exception e){
			if ("+".equals(node) || "-".equals(node) || "*".equals(node) || "/".equals(node)){
				type=3;
			}
			else if ("++".equals(node) || "--".equals(node)){
				type=3;
			}
			//else it is other like A2 etc
		}
		
		
		return type;
	}

	//Method to process the expression
	private static double processExpression(String expressionString, int i, int j) {
		// TODO Auto-generated method stub
		StringTokenizer st=new StringTokenizer(expressionString);
		double result=0;
		
		if (st.countTokens() > 1){
			System.out.println("Tokens > 1");
			
			Stack dataStack=new Stack();
			
			String node="";
			int checkType=0;
			
			while (st.hasMoreTokens()){
				node=st.nextToken();
				
				checkType=checkNodeType(node);
				
				if (checkType==1){
					dataStack.push(String.valueOf(node));
				}else if (checkType==3){//ie and operator
					//pop 2 elements from stack and apply the operator
					double operand_value=0;
					
					if ( "+".equals(node) || "-".equals(node) || "*".equals(node) || "/".equals(node)){
						double val2=Double.parseDouble((String)dataStack.pop());
						double val1=Double.parseDouble((String)dataStack.pop());
						
						if ("+".equals(node)){
							operand_value=val1+val2;
						}
						else if ("-".equals(node)){
							operand_value=val1-val2;
						}
						else if ("*".equals(node)){
							operand_value=val1*val2;
						}
						if ("/".equals(node)){
							operand_value=val1/val2;
						}
						System.out.println("Value1: "+val1+" "+node+" Value2: "+val2+", operand_value: "+operand_value);
					}
					else if ("++".equals(node) || "--".equals(node)){
						double val=Double.parseDouble((String)dataStack.pop());
						if ("++".equals(node)){
							operand_value=val+1;
						}
						else if ("--".equals(node)){
							operand_value=val-1;
						}
						System.out.println("Value: "+val);
					}
					
					dataStack.push(String.valueOf(operand_value));
				}else if (checkType==2){//now it is like A2
					//Ascii Value for A=65, A=>0, B=>1
					int rowIndicator=node.charAt(0)-65;
					int columnIndicator=Integer.parseInt(node.substring(1,node.length()))-1;
					
					double operand_value=0;
					
					if (valuesArray[rowIndicator][columnIndicator] != defaultValue){
					//if (valuesArray[rowIndicator][columnIndicator] >0){
						operand_value=valuesArray[rowIndicator][columnIndicator];
					}else{
						operand_value=processExpression(expressionsArray[rowIndicator][columnIndicator], rowIndicator, columnIndicator);
					}
					System.out.println("Processed value: "+operand_value);
					dataStack.push(String.valueOf(operand_value));
				}
				
			}
			//after finishing processing, you need to get the top value
			double final_value = Double.parseDouble((String)dataStack.pop());
			//assign back the value
			valuesArray[i][j]=final_value;
			result = final_value;
		}
		else{
			System.out.println("Tokens Not > 1");
			//Single value, Calculate result
			String node=st.nextToken();
			int checkType=checkNodeType(node);
			
			//type =1   normal result like 1,2,3,4
			//type =2   reference node like A1, B2  
			//type =3   operator like + - * / 
			if (checkType==1){
				result=Double.parseDouble(node);
			}else if (checkType==3){
				//operator
				result=0;
			}
			else if (checkType==2){
				// It can be like A2
				
				//Ascii Value for A=65, A=>0, B=>1
				int rowIndicator=node.charAt(0)-65;
				int columnIndicator=Integer.parseInt(node.substring(1,node.length()))-1;
				
				System.out.println("Showing node with row:"+rowIndicator+" column: "+columnIndicator);
				
				if (valuesArray[rowIndicator][columnIndicator]!=defaultValue){
				//if (valuesArray[rowIndicator][columnIndicator]>0){
					result=valuesArray[rowIndicator][columnIndicator];
					System.out.println("Able to find value: "+result);
				}else{
					result=processExpression(expressionsArray[rowIndicator][columnIndicator], rowIndicator, columnIndicator);
					System.out.println("Calculated the value: "+ result +", for row: "+rowIndicator+", column: "+columnIndicator);
				}
			}
			//assign back the result
			valuesArray[i][j]=result;
		}
		
		return result;
	}
	//to display results in well format
	public static void displayResults() {
		System.out.println("################################");
		System.out.println("Columns:"+colSize + " Rows:" + rowSize);
		for (int i=0;i<rowSize;i++) {
    		for (int j=0;j<colSize;j++)  {
    		    //need to convert the value to well-format
    			System.out.println("Cell value at " + i + " " + j + ":" + String.format("%.5f", valuesArray[i][j])); 
    			//System.out.println("Cell value at " + i + " " + j + ":" + valuesArray[i][j]); 
    		}
    	}
		System.out.println("################################");
	}
	
	public static void displayExpressions() {
		System.out.println("################################");
		System.out.println(colSize + " " + rowSize);
		for (int i=0;i<rowSize;i++) {
    		for (int j=0;j<colSize;j++)  {
    		    //need to convert the value to well-format
    			System.out.println("Expression at " + i + " " + j + ":" +expressionsArray[i][j]); 
    			//System.out.println("Cell value at " + i + " " + j + ":" + valuesArray[i][j]); 
    		}
    	}
		System.out.println("################################");
	}
	
	
	
}
