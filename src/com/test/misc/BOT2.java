package com.test.misc;

public class BOT2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

			int arr[]=new int[69];
			
			for (int i=0;i<69;i++){
				arr[i]=i;
			}
			int chunks=69/20;
			int chunkno=0;
			int jobCount=0;
			
			String x="";
			System.out.println("chunks:"+chunks);
			for (int i=1;i<=69;i++){
				
				
				if (chunkno==chunks){
					for (int j=i;j<=69;j++){
						x=x+"	"+j;
					}
				}
				else
				{
					x=x+"	"+i;
				}
				
				if (i%20==0 || chunkno==chunks){
					chunkno++;
					
					
					//System.out.println("Job"+chunkno+": \n"+x);
					System.out.println("Job"+chunkno+" start: ");
					String b[]=x.split("	");
					for (int a=1;a<b.length;a++){
						System.out.print("var: "+b[a]+"	|	");
					}
					System.out.println();
					System.out.println("Job"+chunkno+" end: ");
					
					x="";
				}
				
				//System.out.println();
			}
	}

}
