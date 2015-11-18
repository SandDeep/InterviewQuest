package com.pkg2;

public class LCS {

	public static void main(String[] args) {
		char[] arr1 = "ABCDGH".toCharArray();
		char[] arr2 = "AEDFHR".toCharArray();

		// int comlen = lcsnative(arr1, arr2, arr1.length, arr2.length);
		int comlen = lcs(arr1, arr2, arr1.length, arr2.length);
		System.out.println(comlen);
	}

	public static int lcs(char[] arr1, char[] arr2, int m, int n) {
		int[][] len = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {

			for (int j = 0; j <= n; j++) {

				if (i == 0 || j == 0) {
					len[i][j] = 0;
				} else if (arr1[i - 1] == arr2[j - 1]) {
					len[i][j] = 1 + len[i - 1][j - 1];
				} else {
					len[i][j] = Math.max(len[i - 1][j], len[i][j - 1]);
				}
			}
		}

		int index = len[m][n];

		char[] lcs = new char[index];

		int i = m, j = n;

		while (i > 0 && j > 0) {
			if (arr1[i - 1] == arr2[j - 1]) {
				lcs[index - 1] = arr1[i - 1];
				i--;
				j--;
				index--;
			} else if (len[i - 1][j] > len[i][j - 1]) {
				i--;
			} else {
				j--;
			}
		}

		System.out.println(new String(lcs));
		return len[m][n];
	}

	public static int lcsnative(char[] arr1, char[] arr2, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		if (arr1[m - 1] == arr2[n - 1]) {
			return 1 + lcs(arr1, arr2, m - 1, n - 1);
		} else {
			return Math.max(lcs(arr1, arr2, m - 1, n),
					lcs(arr1, arr2, m, n - 1));
		}

	}
}
