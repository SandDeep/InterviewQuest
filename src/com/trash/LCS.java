package com.trash;

import java.util.Arrays;

public class LCS {

	public static void main(String[] args) {
		char X[] = "ABCDGH".toCharArray();
		char Y[] = "AEDFHR".toCharArray();

		// int len = lcs(X, Y, X.length, Y.length);
		int len = lcsDP(X, Y, X.length, Y.length);
		System.out.println(len);
	}

	public static int lcsDP(char[] x, char[] y, int m, int n) {

		int L[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {

				if (i == 0 || j == 0) {
					L[i][j] = 0;
					continue;
				}

				if (x[i - 1] == y[j - 1]) {
					L[i][j] = 1 + L[i - 1][j - 1];
				} else {
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
				}
			}
		}

		printResult(L, x, y, m, n);
		return L[m][n];
	}

	private static void printResult(int[][] l, char[] X, char[] Y, int m, int n) {
		int i = m;
		int j = n;
		int index = l[m][n];
		char arr[] = new char[index];

		while (i > 0 && j > 0) {

			if (X[i - 1] == Y[j - 1]) {
				arr[index - 1] = X[i - 1];
				i--;
				j--;
				index--;
			} else if (l[i - 1][j] > l[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}
		System.out.println(Arrays.toString(arr));
	}

	public static int lcs(char[] x, char[] y, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		if (x[m - 1] == y[n - 1]) {
			return 1 + lcs(x, y, m - 1, n - 1);
		}

		return Math.max(lcs(x, y, m - 1, n), lcs(x, y, m, n - 1));
	}
}
