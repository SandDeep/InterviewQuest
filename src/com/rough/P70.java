package com.rough;

public class P70 {

	public static void main(String[] args) {
		int arr[] = { 3, 1, 1, 2, 2, 1 };

		P70 test = new P70();
		int isPossible = test.findPartition(arr, arr.length);
		if (isPossible == 1)
			System.out.println("Can be divided into two subsets of equal sum");
		else
			System.out
					.println("Can not be divided into two subsets of equal sum");
	}

	private int findPartition(int[] arr, int n) {
		int S = 0;
		for (int i : arr) {
			S += i;
		}

		S = 8;

		int[][] res = new int[n + 1][S + 1];

		// Top - Bottom
		for (int i = 0; i <= n; i++) {
			res[i][0] = 1;
		}

		// ---> Left- Right
		for (int i = 1; i <= S; i++) {
			res[0][i] = 0;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= S; j++) {
				res[i][j] = res[i - 1][j];
				if (j >= arr[i - 1]) {
					res[i][j] = Math.max(res[i][j], res[i - 1][j - arr[i - 1]]);
				}
			}
		}
		return res[n][S];
	}
}
