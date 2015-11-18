package com.pkgS;

public class P10 {

	public static void main(String[] args) {
		int cost[][] = 	{ 
							{1, 2, 3},
							{4, 8, 2},
							{1, 5, 3} 
						};
		
		P10 test=new P10();
		//Recursive
		System.out.println(test.minCost(cost, 2, 2));
		
		//DP
		System.out.println(test.minCostDP(cost));
	}

	private int minCostDP(int[][] cost) {
		int m = cost.length;
		int n = cost[0].length;

		int res[][] = new int[m][n];

		res[0][0] = cost[0][0];
		// Row -->
		for (int i = 1; i < n; i++) {
			res[0][i] = res[0][i - 1] + cost[0][i];
		}

		// Col [down]
		for (int i = 1; i < m; i++) {
			res[i][0] = res[i - 1][0] + cost[i][0];
		}

		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				res[i][j] = cost[i][j]
						+ Math.min(res[i - 1][j - 1],
								Math.min(res[i - 1][j], res[i][j - 1]));
			}
		}
		return res[m - 1][n - 1];
	}

	private int minCost(int[][] cost, int iRow, int jCol) {
		if (iRow < 0 || jCol < 0) {
			return Integer.MAX_VALUE;
		}

		if (iRow == 0 && jCol == 0) {
			return cost[iRow][jCol];
		}
		int a = minCost(cost, iRow - 1, jCol);
		int b = minCost(cost, iRow, jCol - 1);
		int c = minCost(cost, iRow - 1, jCol - 1);

		return cost[iRow][jCol] + Math.min(a, Math.min(b, c));
	}
}
