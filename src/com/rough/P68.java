package com.rough;

import java.util.Arrays;

/**
 * http://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-
 * matrix/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P68 {

	public static void main(String[] args) {
		int m = 3;
		int n = 3;

		int count = getPossiblePath(0, 0, m, n);
		System.out.println(count);

		count = getPossiblePathDP(0, 0, m, n);
		System.out.println(count);

		int mat[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

		int m1 = mat.length;
		int n1 = mat[0].length;

		int[] path = new int[m1 + n1 - 1];

		printPossiblePath(mat, 0, 0, path, 0);
	}

	private static void printPossiblePath(int[][] mat, int i, int j,
			int[] path, int index) {
		int m = mat.length;
		int n = mat[0].length;

		if (i == m - 1 && j == n - 1) {
			path[index] = mat[i][j];
			System.out.println(Arrays.toString(path));
		}

		if (i > m - 1 || j > n - 1) {
			return;
		}

		path[index] = mat[i][j];

		// Forward
		printPossiblePath(mat, i, j + 1, path, index + 1);

		// Downward
		printPossiblePath(mat, i + 1, j, path, index + 1);
	}

	private static int getPossiblePathDP(int i, int j, int m, int n) {

		int[][] res = new int[m][n];

		for (int k = 0; k < m; k++) {
			res[0][k] = 1;
		}

		for (int k = 0; k < n; k++) {
			res[k][0] = 1;
		}
		for (int x = 1; x < m; x++) {
			for (int y = 1; y < n; y++) {
				res[x][y] = res[x - 1][y] + res[x][y - 1];
			}
		}
		return res[m - 1][n - 1];
	}

	private static int getPossiblePath(int i, int j, int m, int n) {
		if (i == m - 1 || j == n - 1) {
			return 1;
		}

		return getPossiblePath(i + 1, j, m, n)
				+ getPossiblePath(i, j + 1, m, n);
	}
}
