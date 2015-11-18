package com.pkg2;

public class CostPath {

	public static void main(String[] args) {
		int[][] cost = { { 1, 2, 3 }, { 4, 8, 2 }, { 1, 5, 3 } };

		int m = 2;
		int n = 2;

		//int amt = new CostPath().minCostPath(cost, m, n);
		int amt = new CostPath().minCost(cost, m, n);
		System.out.println("Min Cost Path : " + amt);
	}

	private int minCost(int[][] cost, int m, int n) {

		int[][] tc = new int[3][3];

		tc[0][0] = cost[0][0];

		for (int i = 1; i <= m; i++) {
			tc[i][0] = tc[i - 1][0] + cost[i][0];
		}

		for (int j = 1; j <= n; j++) {
			tc[0][j] = tc[0][j - 1] + cost[0][j];
		}
		
		for (int i = 1; i <= m; i++)
			for (int j = 1; j <= n; j++)
				tc[i][j] = min(tc[i - 1][j - 1], tc[i - 1][j], tc[i][j - 1])
						+ cost[i][j];

	     return tc[m][n];
	}

	int minCostPath(int[][] cost, int i, int j) {

		// Integer.MAX_VALUE for case like [(0,1),(1,0)]
		if (i < 0 || j < 0) {
			return Integer.MAX_VALUE;
		}

		System.out.println("Current Pos : " + i + " , " + j + " == "
				+ cost[i][j]);

		if (i == 0 && j == 0) {
			return cost[i][j];
		}

		int u = minCostPath(cost, i - 1, j);
		int l = minCostPath(cost, i, j - 1);
		int dl = minCostPath(cost, i - 1, j - 1);
		return cost[i][j] + min(u, l, dl);
	}

	int min(int x, int y, int z) {
		if (x < y)
			return (x < z) ? x : z;
		else
			return (y < z) ? y : z;
	}
}
