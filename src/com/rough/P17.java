package com.rough;


public class P17 {

	public static void main(String[] args) {
		 int M[][] = 
			 {
				 {1, 2, 3, 4},
                 {5, 6, 7, 8},
                 {9, 10, 11, 12},
                 {13, 14, 15, 16},
                 {17, 18, 19, 20},
             };
		 
		 P17 test=new P17();
		 test.printMatrix(M);
		 test.printDiagnolOrder(M);
	}

	/**
	 * diagonal printing of matrix "matrix[ROW][COL]" always has "ROW + COL – 1"
	 * 
	 * @param arr
	 */
	private void printDiagnolOrder(int[][] arr) {
		int ROW = arr.length;
		int COL = arr[0].length;
		System.out.println();
		
		for (int line = 1; line <= ROW + COL - 1; line++) {
			int startCol = Math.max(0, line - ROW);

			int count = Math.min(line, Math.min(COL - startCol, ROW));

			for (int j = 0; j < count; j++) {
				int val = arr[Math.min(ROW, line) - j - 1][startCol + j];
				System.out.print(val+" ");
			}
			System.out.println();
		}
	}

	private void printMatrix(int[][] arr) {
		int ROW=arr.length;
		int COL=arr[0].length;
		
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
