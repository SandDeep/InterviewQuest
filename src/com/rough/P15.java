package com.rough;

public class P15 {

	public static void main(String[] args) {
		 int M[][] =  
			 {
				 {0, 1, 1, 0, 1},
                 {1, 1, 0, 1, 0},
                 {0, 1, 1, 1, 0},
                 {1, 1, 1, 1, 0},
                 {1, 1, 1, 1, 1},
                 {0, 0, 0, 0, 0}
             };
		 P15 test=new P15();
		 test.maxSubmatrix(M);
	}

	private void maxSubmatrix(int[][] arr) {
		int ROW = arr.length;
		int COL = arr[0].length;

		int[][] sol = new int[ROW][COL];
		
		for (int i = 0; i < ROW; i++) {
			sol[i][0]=arr[i][0];
		}
		
		for (int i = 0; i < COL; i++) {
			sol[0][i]=arr[0][i];
		}
		
		for (int i = 1; i < ROW; i++) {
			for (int j = 1; j < COL; j++) {
				if(arr[i][j]==1){
					sol[i][j]=Math.min(sol[i-1][j-1], Math.min(sol[i-1][j], sol[i][j-1]))+1;
				}else{
					sol[i][j]=0;
				}
			}
		}
		System.out.println();
	}
}
