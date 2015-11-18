package com.pkgS;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-17-palindrome-
 * partitioning/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P20 {

	public static void main(String[] args) {
		char[] str = "ababbbabbababa".toCharArray();

		P20 test = new P20();
		int cuts = test.getcuts(str, 0, str.length - 1);
		System.out.println("Min Cuts Possible : " + cuts);

		cuts = test.getcutsDP(str, str.length);
		System.out.println("Min Cuts Possible : " + cuts);
	}

	private int getcutsDP(char[] arr, int n) {
		boolean[][] P = new boolean[n][n];
		int[][] C = new int[n][n];

		// L==1
		for (int i = 0; i < n; i++) {
			P[i][i] = true;
			C[0][0] = 0;
		}

		for (int L = 2; L <= n; L++) {
			for (int i = 0; i < n - L + 1; i++) {
				int j = i + L - 1;

				if (L == 2) {
					P[i][j] = (arr[i] == arr[j]);
				} else {
					P[i][j] = (arr[i] == arr[j]) && P[i + 1][j - 1];
				}

				if (P[i][j]) {
					C[i][j] = 0;
				} else {
					C[i][j] = Integer.MAX_VALUE;

					for (int k = i; k <= j - 1; k++) {
						C[i][j] = Math.min(C[i][j], C[i][k] + C[k + 1][j] + 1);
					}
				}
			}
		}
		return C[0][n - 1];
	}

	private int getcuts(char[] str, int i, int j) {
		if (i == j) {
			return 0;
		}

		if (i + 1 == j) {
			return str[i] == str[j] ? 0 : 1;
		}

		if (isPalindrome(str, i, j)) {
			return 0;
		}

		int cuts = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			cuts = Math.min(cuts,
					getcuts(str, i, k) + 1 + getcuts(str, k + 1, j));
		}
		return cuts;
	}

	private boolean isPalindrome(char[] str, int i, int j) {
		while (i < j) {
			if (str[i++] != str[j--]) {
				return false;
			}
		}
		return true;
	}
}
