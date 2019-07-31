package com.abhishek.java.hp;

public class EvenFibonacci {
	
	public static void main(String[] Args)
	{
		System.out.println(callEvenFib(9));
	}

	private static int callEvenFib(int n) {
		int sum =0;int evenSum=0;
		 if(n<=1)
			 return n;
		 else
		 {
			 sum = (callEvenFib(n-1)+callEvenFib(n-2));
			 if(sum%2==0)
			 {
				 evenSum=evenSum+sum;
			 }
			 return evenSum;
		 }
	}

}
