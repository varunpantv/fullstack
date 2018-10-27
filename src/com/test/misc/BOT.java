package com.test.misc;

public class BOT {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="";
		int len=159;
		
		int chunks=len/50;
		int chunkno=0;
		System.out.println("chunks:"+chunks);
		for (int i=1;i<=len;i++){
			
			if (chunkno == chunks)
			{
				System.out.println("I am here.. i:"+i);
				for (int j=i;j<=len;j++){
					str=str+"	"+j;
				}
			}else{
					str=str+"	"+i;
			}
			//|| ((i-50) <=50)
			
			if (i%50 == 0  || chunkno == chunks){
				chunkno++;
							
				System.out.println("str: "+str);
				System.out.println("------------------------");
				str="";
				
				
			}
			
			
		/*	if ((len-i) <= 50){
				
			}*/
			
			
		}
		//System.out.println("Remaining:"+ str);
		
		
	}

}
