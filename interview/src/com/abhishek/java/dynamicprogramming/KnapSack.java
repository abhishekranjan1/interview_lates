package com.abhishek.java.dynamicprogramming;

public class KnapSack {

	public static void main(String[] args) {
		 int[] wt = {1,3,4,5};
		 int[] val = {1,4,5,7};
		 int W=7;
		 System.out.println(countKnapsackValue(wt,val,W));
		

	}

	private static int countKnapsackValue(int[] wt, int[] val, int W) {
		int n= wt.length;
		
		int[][] K= new int[n+1][W+1];
		for(int i=0;i<=n;i++)
		{
			for(int w=0;w<=W;w++)
			{
				if(i==0||w==0)
				{
					K[i][w]=0;
				}
				else if(wt[i-1]<=w)
				{
					K[i][w]=Integer.max(val[i-1]+K[i-1][w-wt[i-1]],K[i-1][w]);
				}
				
				else
				{
					K[i][w]=K[i-1][w];
				}
			}
		}
		return K[n][W];
	}
		

}
