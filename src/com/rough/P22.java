package com.rough;

public class P22 {

	public static void main(String[] args) {
		int arr[] = { 1, 5, 8, 9, 10, 17, 17, 20 };
		P22 test = new P22();

		int maxPrice = test.maxCutRod(arr, arr.length);
		// int maxPrice = test.maxCutRodDP(arr, arr.length);
		System.out.println("maxPrice : " + maxPrice);

		int maxProduct = test.maxProduct(10);
		System.out.println("maxProduct : " + maxProduct);

		int maxProd = test.maxProd(10);
		System.out.println("maxProd : " + maxProd);

		int val[] = { 60, 100, 120 };
		int wt[] = { 10, 20, 30 };
		int W = 50;
		// int maxWeight = test.knapSack(W, wt, val, val.length);
		int maxWeight = test.knapSackDP(W, wt, val, val.length);
		System.out.println("maxWeight : " + maxWeight);

	}

	private int knapSackDP(int W, int[] wt, int[] val, int n) {
		int K[][] = new int[n + 1][W + 1];

		for (int i = 0; i <= n; i++) {
			for (int w = 0; w <= W; w++) {
				if (i == 0 || w == 0) {
					K[i][w] = 0;
				} else if (wt[i - 1] <= w) {
					K[i][w] = Math.max(val[i - 1] + K[i - 1][w - wt[i - 1]],K[i - 1][w]);
				}else{
					K[i][w]=K[i-1][w];
				}
			}
		}
		return K[n][W];
	}

	private int knapSack(int w, int[] wt, int[] val, int n) {
		if (n == 0 || w == 0) {
			return 0;
		}

		if (wt[n - 1] > w) {
			return knapSack(w, wt, val, n - 1);
		}
		return Math.max(val[n - 1] + knapSack(w - wt[n - 1], wt, val, n - 1),
				knapSack(w, wt, val, n - 1));
	}

	private int maxProd(int n) {
		if (n == 2 || n == 3) {
			return n - 1;
		}
		int res = 1;
		if (n > 4) {
			res = res * 3;
			n -= 3;
		}
		return (n * res);
	}

	public int maxProduct(int n) {
		if (n == 0 || n == 1)
			return 0;

		int max = 0;

		// You must make at least one cut - thats why i<n not i<=n
		for (int i = 1; i < n; i++) {
			max = Math.max(max, Math.max(i * (n - i), i * maxProduct(n - i)));
		}
		return max;
	}

	public int maxCutRodDP(int[] arr, int n) {
		int[] val = new int[n + 1];
		val[0] = 0;

		for (int i = 1; i <= n; i++) {

			int max = Integer.MIN_VALUE;

			for (int j = 0; j < i; j++) {
				max = Math.max(max, arr[j] + val[i - 1 - j]);
			}
			val[i] = max;
		}

		return val[n];
	}

	public int maxCutRod(int[] arr, int n) {
		if (n <= 0) {
			return 0;
		}
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			max = Math.max(max, arr[i] + maxCutRod(arr, n - i - 1));
		}
		return max;
	}
}
