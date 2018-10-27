package com.test.gv;

import java.util.List;

public class Tree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println("Hello World");
			
			// Tree first = new Tree(" 1(2,4, 6) 2(3, 9) 4(5,7)  6(11,12 ) 5(13,16)   12(14, 23, 17) 16( 24,32 )");
			
	}
	private Node root;

    // do not add new properties

    public Tree(String treeData) {
        
    	Node n=null;
    	Node root=null;
    	int elementCount=0;
    	
    	System.out.println(treeData);
    	String pattern ="(|,|)";//"[0-9][(][)][ ][,]";//
  	   
 	    String [] tokens=treeData.split("(|,|)");

 	    String strToken="";
 	    for (int i=0;i<tokens.length;i++){
 	    	strToken=tokens[i];
 	    	System.out.println(tokens[i]);
 	    	//Numeric: Node
        	int x=0;
 	    	try{
 	    		 x=Integer.parseInt(strToken);
 	    		 
 	    	}
 	    	catch (Exception e){
 	    		System.out.println("Not a Numeric");
 	    	}
 	    	
 	    	if (x!=0){
 	    		System.out.println("It is a numeric");
 	    		n=new Node(x);
 	    		
 	    		if (0==elementCount){
 	    			root=n;
 	    		}
 	    		
 	    		elementCount++;
 	    	}
 	    	//2
 	    	//4
 	    	//6
 	    	//root
 	    	String children="";
 	    	if (strToken.equals("("))
 	    	{
 	    		strToken=tokens[i];i++;
 	    		while (!strToken.equals(")")){
 	    			children+=strToken;
 	    		}
 	    	}
 	    	
 	    	children.replace("\n", "");
 	    	
 	    	//2,4,6
 	    	
 	    	String childArr[]=children.split(",");
 	    	String nthChild="";
 	    	for (int j=0;j<childArr.length;j++){
 	    		nthChild=childArr[j];
 	    		root.appendChild(new Node(Integer.parseInt(nthChild)));
 	    		
 	    	}
 	    	//Left Paranthesis: Start of child Nodes
        	//In between Paranthesis: Split on ,: Child Nodes
        	//Righ Paranthesis: End of getting Child nodes
 	    	
 	    	
 	    }
 	    
        int length=treeData.length();
        
        char c;
        for (int i=0;i<length;i++){
        	
        	c = treeData.charAt(i);
        	
        	System.out.println(c);
        	
        //c:
        // ( 
        // )
        // space
        // ,
        	
        	if (c=='('){
        		
        	}
        	
        	else if (c==')'){
        		
        	}
        	else if (c==','){
        		
        	}
        	else if (c==' '){
        		
        	}else {
        		//Numeric
        		
        		root=new Node(c);
        	}
        	//Numeric: Node
        	//Left Paranthesis: Start of child Nodes
        	//In between Paranthesis: Split on ,: Child Nodes
        	//Righ Paranthesis: End of getting Child nodes
        	/*if (treeData.equals("")){
        		
        	}*/
        	
        	
        }
    }

    /**
      * Finds a node with a given id and return it's level.
      * The nodes at the bottom of the tree have a level of 1. 
      *
      * @param id The id of node
      * @return The level of the the node of that id, or -1 if a node is not found 
      */
    public int getLevelOfNodeWithId(int id) {
        // write your code here
    	return 0;
    }


    // write optional helper methods here
    

}
