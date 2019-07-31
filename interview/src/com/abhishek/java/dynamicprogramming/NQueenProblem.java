package com.abhishek.java.dynamicprogramming;

public class NQueenProblem {

	public static void main(String[] args) {
		//final int N =4;
		int[][] board = {{-1,-1,-1,-1},
						 {-1,-1,-1,-1},
						 {-1,-1,-1,-1},
						 {-1,-1,-1,-1}};		
		if (solveNQUtil(board, 0) == false) 
        { 
            System.out.print("Solution does not exist");  
        } 
		else
			printBoard(board);

	}
	
	public static boolean solveNQUtil(int[][] board, int col)
	{
		int N = board.length;
		//Base case if all queens are placed return true;
		if(col>=N)
		{
			return true;
		}
		for(int i=0;i<N;i++)
		{
			if(isSafe(board,i,col))
			{
				//Place the Queen
				board[i][col]=1;
				/*Once the queen is placed move to the next column and look for the safe position. If no safe position is found then we need to backtrack 
				 * and replace the queen from the current location to the next row to restart the process  
				 */
				if(solveNQUtil(board,col+1)==true)
				{
					return true;
				}
				//If no safe position is found in the next column for the queen, backtrack the placed queen
				board[i][col]=-1;
			}
		}
		// If no position was found then return false;
		return false;
	}
	
	
	static boolean isSafe(int[][] board, int row, int col)
	{
		
		 int N = board.length;
		 int i,j;
		//Same row previous columns
		for(j=0;j<col;j++)
		{
			if(board[row][j]==1) return false;
		}
		//Check for the queen in upper left diagonal
		for(i=row,j=col;i>=0 && j>=0;i--,j--)
		{
			if(board[i][j]==1) return false;
		}
		//Check for the queen in lower left diagonal
		for(i=row,j=col;i<N && j>=0;i++,j--) 
		{
			if(board[i][j]==1) return false;
		}
		return true;
	}
	
	static void printBoard(int[][] board)
	{
		int n= board.length;
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print("| "+board[i][j]+" | ");
			}
			System.out.println();
			System.out.println("----------------------------");
		}
	}

}
