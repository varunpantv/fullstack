
public class Multiples {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Hao");
		
		/*int i=1000;
		System.out.println("i:"+i+", sum:"+getSum(i));*/
		
		//Fibonacci();
	}
	
	public static int getSum(int n){
		
		int sum=0;
		for (int i=1;i<n;i++){
			if ((i%3 == 0) || (i%5 == 0)){
				sum +=i;
				System.out.println("i:"+i);
			}
		}
		return sum;
	}
	
	public static int Fibonacci (int n){
		/*
		if (n==1)
			return 1;
		if (n==2)
			*/
		return 0;
	}
	

}
