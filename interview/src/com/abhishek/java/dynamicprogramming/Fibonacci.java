package com.abhishek.java.dynamicprogramming;

public class Fibonacci {
	private static int fibArray[] = new int[25];
	public static void main(String[]args) {
		for(int i=0;i<25;i++)
		{
			fibArray[i]=-1;
		}
		System.out.println(fib(7));
		
		System.out.println(fibEven(21));
		
	}
	private static long fibEven(int n) {
	long a=1,b=1;long sum=0; long sumEven=0;
	while(sum<=10000)
	{
		//int temp=a;
		
		
		if(sum%2==0)
		{
			sumEven+=sum;
		}
		sum=a+b;
		System.out.println(a+", "+b);
		
		b=a;
		a=sum;
		
	}
	return sumEven;
	}
	private static int fib(int n) {

		if(n<=1)
		{
			return n;
		}
		else if(fibArray[n]!=-1)
		{
			return fibArray[n];
		}
		
			fibArray[n] = fib(n-1)+fib(n-2);
			return fibArray[n];
		
	}
	

}
