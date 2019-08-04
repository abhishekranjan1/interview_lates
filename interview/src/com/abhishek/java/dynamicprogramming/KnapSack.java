package com.abhishek.java.dynamicprogramming;

public class KnapSack {

	public static void main(String[] args) {
		 int[] wt =  {0,1,3,4,5};
		 int[] val = {0,1,4,5,7};
		 int W=7;
		 System.out.println(countKnapsackValue(wt,val,W));
	}

	private static int countKnapsackValue(int[] wt, int[] val, int W) {
		int N= wt.length;
		
		int[][] K= new int[N][W+1];
		for(int i=0;i < N;i++)
		{
			for(int w=0;w<=W;w++)
			{
			 if(i==0||w==0)   K[i][w]=0;
			 else {
				 if(wt[i]<=w)    K[i][w]=Integer.max(val[i]+K[i-1][w-wt[i]],K[i-1][w]);
				 
				 else   K[i][w]=K[i-1][w]; 
			 }
			}
		}
		for(int i=0; i< N; i++) {
			for(int j=0; j< W+1;j++) {
				System.out.print(K[i][j]+" ");
				
			}
			System.out.println();
		}
		return K[N-1][W];
	}
		

}
