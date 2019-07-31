package com.abhishek.java.dynamicprogramming;

public class CoinChange {

	public static void main(String args[]) 
    { 
        int coins[] = {1, 2, 3}; 
        //int m = arr.length; 
        int V = 5; 
        System.out.println(countWays(coins, V)); 
    }

	private static int countWays(int[] coins, int V) {
		
		int rows=coins.length;
		int[][] K = new int[rows+1][V+1];
		
		for(int i=0;i<=rows;i++)
		{
			for(int v=0;v<=V;v++)
			{
				if(i==0||v==0)
				{
					K[i][v]=0;
				}
				else if(coins[i-1]<=v)
				{
					K[i][v]=Integer.max(coins[i-1]+K[i-1][v-coins[i-1]],K[i-1][v]);
							
				}
				else
				{
					K[i][v]=K[i-1][v];
				}
			}
		}
		
		return K[rows][V];
	} 
}
