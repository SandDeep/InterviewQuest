package com.rough;

public class P64 {

	public static void main(String[] args) {
		char[] arr1 = "ABCDGH".toCharArray();
		char[] arr2 = "AEDFHR".toCharArray();

		P64 test = new P64();
		int len = test.lcs(arr1, arr2, arr1.length, arr2.length);
		System.out.println("LCS : " + len);

		len = test.lcsDP(arr1, arr2);
		System.out.println("LCS : " + len);
	}

	private int lcsDP(char[] arr1, char[] arr2) {
		int m = arr1.length;
		int n = arr2.length;

		int res[][] = new int[m + 1][n + 1];

		for (int i = 0; i <=m; i++) {
			for (int j = 0; j <=n; j++) {

				if (i == 0 || j == 0) {
					res[i][j] = 0;
					continue;
				}

				if (arr1[i - 1] == arr2[j - 1]) {
					res[i][j] = res[i - 1][j - 1] + 1;
				} else {
					res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
				}

			}
		}
		return res[m][n];
	}

	private int lcs(char[] arr1, char[] arr2, int m, int n) {
		if (m == 0 || n == 0) {
			return 0;
		}

		if (arr1[m - 1] == arr2[n - 1]) {
			return lcs(arr1, arr2, m - 1, n - 1) + 1;
		}
		return Math.max(lcs(arr1, arr2, m - 1, n), lcs(arr1, arr2, m, n - 1));
	}
}
