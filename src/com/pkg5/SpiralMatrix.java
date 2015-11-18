package com.pkg5;

public class SpiralMatrix {

	public static void main(String[] args) {
		int a[][] = { 
					{ 1, 2, 3, 4, 5, 6 }, 
					{ 7, 8, 9, 10, 11, 12 },
					{ 13, 14, 15, 16, 17, 18 }
				};
		
		int b[][] = { 
				{ 1, 2, 3, 4 }, 
				{ 5, 6, 7, 8 }, 
				{ 9, 10, 11, 12 },
				{ 13, 14, 15, 16 } };

		SpiralMatrix matrix=new SpiralMatrix();
		matrix.printSpiral(b);
	}

	private void printSpiral(int[][] arr) {
		int row = arr.length;
		int col = arr[0].length;
		
		int m = arr.length-1;
		int n = arr[0].length-1;

		int i = 0;
		int j = 0;

		while (i <= m && j <= n) {

			// Right
			for (int k = j; k <= n; k++) {
				System.out.print(arr[i][k] + " ");
			}
			i++;

			// Below
			for (int k = i; k <= m; k++) {
				System.out.print(arr[k][n] + " ");
			}
			n--;
			
			// Left
			if(i < m){
				for (int k = n; k >= j; k--) {
					System.out.print(arr[m][k] + " ");
				}
				m--;
			}

			// Up
			if(j < n){
				for (int k = m; k >= i; k--) {
					System.out.print(arr[k][j] + " ");
				}
				j++;
			}
		}
	}

}
