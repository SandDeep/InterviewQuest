package com.pkgS;

public class P9 {

	public static void main(String[] args) {
		int points[][] = { { -2, -3, 3 }, { -5, -10, 1 }, { 10, 30, -5 } };

		P9 test = new P9();
		int minInitial = test.findMin(points, 0, 0, 0, 0);
		System.out.println(minInitial);
	}

	private int findMin(int[][] points, int iRow, int jCol, int cost,
			int subsidy) {
		int m = points.length;
		int n = points[0].length;

		if (!isValid(points, iRow, jCol)) {
			return Integer.MAX_VALUE;
		}

		// Target Point
		if (points[iRow][jCol] == points[m - 1][n - 1]) {
			int routeCost = points[iRow][jCol] + cost;
			if (routeCost > 0) {
				return subsidy;
			} else {
				return subsidy + Math.abs(routeCost) + 1;
			}
		}

		int routeCost = points[iRow][jCol] + cost;
		if (routeCost < 0) {
			subsidy += Math.abs(routeCost);
		} else {
			cost = routeCost;
		}

		int forward = findMin(points, iRow, jCol + 1, cost, subsidy);
		int down = findMin(points, iRow + 1, jCol, cost, subsidy);
		return Math.min(forward, down);
	}

	private boolean isValid(int[][] arr, int i, int j) {

		int m = arr.length; // ROW
		int n = arr[0].length; // COL

		return i >= 0 && i < m && j >= 0 && j < n;
	}
}
