package com.test.varun;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class SpreadSheet {

	static Cell cellsArray[][]=null;
	
	static int colSize=0;
	static int rowSize=0;
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		/*FileReader in =null;
		if (args.length==0)
		{
			in = new FileReader("C:\\Projects\\Full Stack\\inputs_4.txt");
			System.out.println("No commandline param");
		}
		else
		{
			System.out.println("Input file: "+ args[0]);
			in = new FileReader(args[0]);
		}
		
		
		BufferedReader br=new BufferedReader(in);*/
		
		
		String rowCol="";
		
		System.out.println("Enter Columns and Rows:");
		
		rowCol=br.readLine();
		
		StringTokenizer stkn=new StringTokenizer(rowCol);
		
		
		if (stkn.countTokens() >= 2){
			colSize=Integer.parseInt(stkn.nextToken());
			rowSize=Integer.parseInt(stkn.nextToken());
			
			System.out.println(colSize+ " Columns and "+rowSize+" Rows");
			
			cellsArray=new Cell[rowSize][colSize];
			
			for (int i=0;i<rowSize;i++){
				for (int j=0;j<colSize;j++){
					//System.out.println("i:"+i+", j:"+j);
					cellsArray[i][j]=new Cell();
					//cellsArray[i][j].setEvaluated(false);
				}
			}
		}
		
		System.out.println("Enter Excel values columnwise:\n");
		
		for (int i=0;i<rowSize;i++){
			for (int j=0;j<colSize;j++){
				cellsArray[i][j].setExpression(br.readLine().trim().toUpperCase());
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
				expressionString=cellsArray[i][j].getExpression();
				if (false == cellsArray[i][j].isEvaluated()) {
					System.out.println("Processing...");
					result=processExpression(expressionString,i,j,null);
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
	private static double processExpression(String expressionString, int i, int j, Set history) {
		// TODO Auto-generated method stub
		
		 if(null == history)
		 {
			 history = new HashSet();
		 }
		
		if (null!=history && history.contains(expressionString)){
			System.out.println("CYCLE FOUND");
			
			System.out.println("Expression:"+expressionString);
			
			System.out.println("History:\n---");
			Iterator<String> it = history.iterator();
		     while(it.hasNext()){
		        System.out.println(it.next());
		     }
		     System.out.println("---------------------------------------");
		     
		 	System.out.println("History: "+history);
		 	
		 	System.out.println("Expression String: "+expressionString);
			System.exit(1);
		}else
		{
			history.add(expressionString);
		}
			
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
				
				if (1==checkType){
					dataStack.push(String.valueOf(node));
				}else if (3==checkType){//ie and operator
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
				}else if (2==checkType){//now it is like A2
					//Ascii Value for A=65, A=>0, B=>1
					int rowIndicator=node.charAt(0)-65;
					int columnIndicator=Integer.parseInt(node.substring(1,node.length()))-1;
					
					double operand_value=0;
					
					if (cellsArray[rowIndicator][columnIndicator].isEvaluated()){
						operand_value=cellsArray[rowIndicator][columnIndicator].getValue();
					}else{
						operand_value=processExpression(cellsArray[rowIndicator][columnIndicator].getExpression(), rowIndicator, columnIndicator,history);
					}
					System.out.println("Processed value: "+operand_value);
					dataStack.push(String.valueOf(operand_value));
				}
				
			}
			//after finishing processing, you need to get the top value
			double final_value = Double.parseDouble((String)dataStack.pop());
			//assign back the value
			cellsArray[i][j].setValue(final_value);
			cellsArray[i][j].setEvaluated(true);
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
			if (1==checkType){
				result=Double.parseDouble(node);
			}else if (3==checkType){
				//operator
				result=0;
			}
			else if (2==checkType){
				// It can be like A2
				
				//Ascii Value for A=65, A=>0, B=>1
				int rowIndicator=node.charAt(0)-65;
				int columnIndicator=Integer.parseInt(node.substring(1,node.length()))-1;
				
				System.out.println("Showing node with row:"+rowIndicator+" column: "+columnIndicator);
				
				if (cellsArray[rowIndicator][columnIndicator].isEvaluated()){
					result=cellsArray[rowIndicator][columnIndicator].getValue();
					System.out.println("Able to find value: "+result);
				}else{
					
					try{
						result=processExpression(cellsArray[rowIndicator][columnIndicator].getExpression(), rowIndicator, columnIndicator,history);
					}
					catch(StackOverflowError  e){
						System.out.println("Cycle");
						 System.exit(1);
					}
					System.out.println("Calculated the value: "+ result +", for row: "+rowIndicator+", column: "+columnIndicator);
				}
				
			}
			//assign back the result
			cellsArray[i][j].setValue(result);
			cellsArray[i][j].setEvaluated(true);
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
    			System.out.println("Cell value at " + i + " " + j + ":" + String.format("%.5f", cellsArray[i][j].getValue()));
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
    			System.out.println("Expression at " + i + " " + j + ":" +cellsArray[i][j].getExpression());
    		}
    	}
		System.out.println("################################");
	}
	
	
	
}
