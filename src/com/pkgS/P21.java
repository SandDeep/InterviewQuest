package com.pkgS;

public class P21 {

	public static void main(String[] args) {
		char seq[] = "GEEKSFORGEEKS".toCharArray();
		char seq1[] = "SKEEGROFSKEEG".toCharArray();

		P21 test = new P21();
		int lps = test.getLPS(seq, 0, seq.length - 1);
		System.out.println("The length of the LPS :" + lps);

		lps = test.getLpsDP(seq, seq.length);
		System.out.println("The length of the LPS :" + lps);

		int lcs = test.getLCS(seq, seq1, seq.length, seq1.length);
		System.out.println("The length of the LCS :" + lcs);

		char X[] = "AGGTAB".toCharArray();
		char Y[] = "GXTXAYB".toCharArray();
		lcs = test.getLcsDP(seq, seq1, seq.length, seq1.length);
		System.out.println("The length of the LCS :" + lcs);
		lcs = test.getLcsDP(X, Y, X.length, Y.length);
		System.out.println("The length of the LCS :" + lcs);
	}

	private int getLcsDP(char[] arr1, char[] arr2, int m, int n) {

		int res[][] = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					continue;
				}
				if (arr1[i - 1] == arr2[j - 1]) {
					res[i][j] = 1 + res[i - 1][j - 1];
				} else {
					res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
				}
			}
		}
		return res[m][n];
	}

	private int getLCS(char[] arr1, char[] arr2, int m, int n) {

		if (m == 0 || n == 0) {
			return 0;
		}
		if (arr1[m - 1] == arr2[n - 1]) {
			return 1 + getLCS(arr1, arr2, m - 1, n - 1);
		} else {
			return Math.max(getLCS(arr1, arr2, m - 1, n),
					getLCS(arr1, arr2, m, n - 1));
		}
	}

	private int getLpsDP(char[] seq, int n) {
		int[][] L = new int[n][n];

		for (int i = 0; i < n; i++) {
			L[i][i] = 1;
		}

		for (int cl = 2; cl <= n; cl++) {
			for (int i = 0; i < n - cl + 1; i++) {
				int j = i + cl - 1;

				// L=1
				if (i == j) {
					L[i][j] = 1;
				}

				// L=2
				if (cl == 2 && seq[i] == seq[j]) {
					L[i][j] = 2;
				}

				if (seq[i] == seq[j]) {
					L[i][j] = 2 + L[i + 1][j - 1];
				} else {
					L[i][j] = Math.max(L[i + 1][j], L[i][j - 1]);
				}
			}
		}
		return L[0][n - 1];
	}

	private int getLPS(char[] seq, int left, int right) {
		if (left > right) {
			return Integer.MIN_VALUE;
		}

		// L=1
		if (left == right) {
			return 1;
		}

		// L=2
		if (left + 1 == right) {
			return (seq[left] == seq[right]) ? 2 : 1;
		}

		if (seq[left] == seq[right]) {
			return getLPS(seq, left + 1, right - 1) + 2;
		}
		return Math.max(getLPS(seq, left + 1, right),
				getLPS(seq, left, right - 1));
	}
}
