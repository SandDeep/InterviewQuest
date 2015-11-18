package com.pkgS;

public class P15 {

	public static void main(String[] args) {
		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };
		int W = 50;

		P15 test = new P15();
		int max = test.knapSack(val, wt, W, val.length - 1);
		System.out.println(max);

		int maxDP = test.knapSackDP(val, wt, W, val.length);
		System.out.println(maxDP);

	}

	private int knapSackDP(int[] val, int[] wt, int W, int n) {

		int[][] res = new int[n + 1][W + 1];

		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= W; w++) {
				if (w == 0 || i == 0) {
					res[i][w] = 0;
				}
				else if (wt[i - 1] <= w) {
					res[i][w] = Math.max(
							val[i - 1] + res[i - 1][w - wt[i - 1]],
							res[i - 1][w]);
				}
				else {
					res[i][w] = res[i - 1][w];
				}
			}
		}
		return res[n][W];
	}

	private int knapSack(int[] val, int[] wt, int W, int n) {

		if (W == 0 || n == 0) {
			return 0;
		}

		if (wt[n] > W) {
			return knapSack(val, wt, W, n - 1);
		}
		return Math.max(val[n] + knapSack(val, wt, W - wt[n], n - 1),
				knapSack(val, wt, W, n - 1));
	}
}
