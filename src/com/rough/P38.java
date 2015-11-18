package com.rough;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to
 * -form-a-palindrome/
 * 
 * @author Deepesh
 * 
 */
public class P38 {

	public static void main(String[] args) {
		String str = "abcde";
		P38 test = new P38();
		// int insertions = test.findMinInsertion(str.toCharArray(),
		// 0,str.length() - 1);
		int insertions = test.findMinInsertionDP(str.toCharArray(),
				str.length());
		System.out.println(insertions);

		test.findMinIns(str.toCharArray(), str.length());
	}

	private void findMinIns(char[] arr, int n) {
		char[] rev = new char[n];

		int index = 0;
		for (int i = n - 1; i >= 0; i--) {
			rev[index++] = arr[i];
		}

		int lcs = findLCS(arr, rev, n, n);

		int insertions = n - lcs;
		System.out.println(insertions);
	}

	private int findLCS(char[] X, char[] Y, int m, int n) {
		int[][] L = new int[n + 1][m + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					L[i][j] = 0;
				}

				else if (X[i - 1] == Y[j - 1]) {
					L[i][j] = L[i - 1][j - 1] + 1;
				}

				else
					L[i][j] = Math.max(L[i - 1][j], L[i][j - 1]);
			}
		}
		return L[m][n];

	}

	public int findMinInsertionDP(char[] arr, int n) {

		int table[][] = new int[n][n];

		for (int gap = 1; gap < n; ++gap) {
			for (int l = 0, h = gap; h < n; ++l, ++h) {
				table[l][h] = (arr[l] == arr[h]) ? table[l + 1][h - 1] : (Math
						.min(table[l + 1][h], table[l][h - 1]) + 1);
			}
		}
		return table[0][n - 1];
	}

	public int findMinInsertion(char[] arr, int l, int h) {
		// Base Cases
		if (l > h) {
			return Integer.MAX_VALUE;
		}
		if (l == h) {
			return 0;
		}

		if (l + 1 == h) {
			return (arr[l] == arr[h]) ? 0 : 1;
		}

		return (arr[l] == arr[h]) ? findMinInsertion(arr, l + 1, h - 1) : Math
				.min(findMinInsertion(arr, l + 1, h),
						findMinInsertion(arr, l, h - 1)) + 1;
	}
}
