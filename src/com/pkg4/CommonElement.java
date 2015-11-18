package com.pkg4;

/**
 * http://www.geeksforgeeks.org/find-common-element-rows-row-wise-sorted-matrix/
 * @author Deepesh
 *
 */
public class CommonElement {

	public static void main(String[] args) {
		int mat[][] = { 
				{ 1, 2, 3, 4, 5 }, 
				{ 2, 4, 5, 8, 10 },
				{ 3, 5, 7, 9, 11 }, 
				{ 1, 3, 5, 7, 9 } };
		CommonElement element = new CommonElement();
		element.findCommonElement(mat);
	}

	private void findCommonElement(int[][] mat) {
		int M = mat.length;
		int N = mat[0].length;
		int common[] = new int[M];
		for (int i = 0; i < common.length; i++) {
			common[i] = N-1;
		}
		int minCol = N - 1;

		while (minCol >= 0) {

			int ele = mat[0][common[0]];
			int i = 1;
			// check for common element
			for (i = 1; i < common.length; i++) {
				if (ele != mat[i][common[i]]) {
					break;
				}
			}
			if (i == N - 1) {
				System.out.println("Common Element found : " + ele);
				return;
			}

			// Finding minimum element
			int j = 0;
			int min = Integer.MAX_VALUE;

			for (j = 0; j < common.length; j++) {
				if (mat[j][common[j]] < min) {
					min = mat[j][common[j]];
				}
			}

			for (int k = 0; k < common.length; k++) {
				if (mat[k][common[k]] != min) {
					common[k] -= 1;
				}
			}
			minCol--;
		}
	}
}
