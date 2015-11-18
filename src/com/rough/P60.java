package com.rough;

public class P60 {

	public static void main(String[] args) {
		String line = "Tushar Roy likes to code";
		String[] input = line.split("\\s+");
		int k = 10;

		P60 test = new P60();
		test.wordWrap(input, input.length, k);
	}

	private void wordWrap(String[] arr, int n, int k) {
		int[][] cost = geneateCostMatrix(arr, n, k);

		int[] mincost = new int[n];
		int[] path = new int[n];

		for (int i = n - 1; i >= 0; i--) {

			mincost[i] = cost[i][n - 1];
			path[i] = n;

			for (int j = n - 1; j > i; j--) {

				if (cost[i][j - 1] == Integer.MAX_VALUE) {
					continue;
				}
				if (mincost[i] > cost[i][j - 1] + mincost[j]) {
					mincost[i] = cost[i][j - 1] + mincost[j];
					path[i] = j;
				}
			}
		}

		// Arrangement
		int i = 0;
		int j =0;

		StringBuilder builder = new StringBuilder();
		do{
			j=path[i];
			for (int k1 = i; k1 < j; k1++) {
				builder.append(arr[k1] + " ");
			}
			builder.append("\n");
			i = j;
		}while (j < n) ;
		
		System.out.println(builder);
	}

	private int[][] geneateCostMatrix(String[] arr, int n, int k) {
		int[][] cost = new int[n][n];

		for (int i = 0; i < n; i++) {

			cost[i][i] = k - arr[i].length();

			for (int j = i + 1; j < n; j++) {
				cost[i][j] = cost[i][j - 1] - arr[j].length() - 1;
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = i; j < n; j++) {
				if (cost[i][j] < 0) {
					cost[i][j] = Integer.MAX_VALUE;
				} else {
					cost[i][j] *= cost[i][j];
				}
			}
		}
		return cost;
	}
}
