package com.rough;

public class P37 {

	public static void main(String[] args) {
		P37 test = new P37();

		int arr1[] = { 20, 30, 2, 2, 2, 10 };
		//test.optimalStrategyOfGame(arr1, arr1.length);
		test.optimalStrategyOfGameDP(arr1, arr1.length);
	}

	public void optimalStrategyOfGameDP(int[] arr, int n) {
		int table[][] = new int[n][n];

		for (int gap = 0; gap < n; gap++) {
			for (int i = 0, j = gap; j < n; i++, j++) {

				// F(i+2, j)
				int x = ((i + 2) <= j) ? table[i + 2][j] : 0;

				// F(i+1, j-1)
				int y = ((i + 1) <= j - 1) ? table[i + 1][j - 1] : 0;

				// F(i, j-2)
				int z = ((i) <= j - 2) ? table[i][j - 2] : 0;

				table[i][j] = Math.max((arr[i] + Math.min(x, y)),
						(arr[j] + Math.min(y, z)));
			}
		}
		System.out.println(table[0][n - 1]);
	}

	public void optimalStrategyOfGame(int[] arr, int n) {

		int max = strategyUtil(arr, 0, n - 1);
		System.out.println(max);
	}

	public int strategyUtil(int[] arr, int i, int j) {
		if (i == j) {
			return arr[i];
		}

		if (i + 1 == j) {
			return Math.max(arr[i], arr[j]);
		}

		// UserMove - i
		int x = arr[i]
				+ Math.min(strategyUtil(arr, i + 2, j),
						strategyUtil(arr, i + 1, j - 1));

		// UserMove - j
		int y = arr[j]
				+ Math.min(strategyUtil(arr, i + 1, j - 1),
						strategyUtil(arr, i, j - 2));

		return Math.max(x, y);
	}
}
