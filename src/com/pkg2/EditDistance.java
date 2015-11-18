package com.pkg2;

/**
 * E(i, j) = min( [E(i-1, j) + D], [E(i, j-1) + I], [E(i-1, j-1) + R if i,j
 * characters are not same] )
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class EditDistance {

	public static void main(String[] args) {
		char[] str1 = "SUNDAY".toCharArray();
		char[] str2 = "SATURDAY".toCharArray();

		/*
		 * char[] str1 = "Zeil".toCharArray(); char[] str2 =
		 * "trials".toCharArray();
		 */

		EditDistance distance = new EditDistance();

		/*
		 * int cost = distance.naiveEditDistance(str1, str2, str1.length,
		 * str2.length);
		 */

		int cost = distance.editDistance(str1, str2, str1.length, str2.length);
		System.out.println(cost);

	}

	int editDistance(char[] str1, char[] str2, int m, int n) {

		int[][] cost = new int[m + 1][n + 1];

		cost[0][0] = 0;

		for (int i = 1; i <= n; i++) {
			cost[0][i] = cost[0][i - 1] + 1;
		}

		for (int i = 1; i <= m; i++) {
			cost[i][0] = cost[i - 1][0] + 1;
		}

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {

				int diff = 1;
				if (str1[i - 1] == str2[j - 1]) {
					diff = 0;
				}
				int R = cost[i - 1][j - 1] + diff;

				int D = cost[i - 1][j] + 1;
				int I = cost[i][j - 1] + 1;

				cost[i][j] = min(R, I, D);
			}
		}
		return cost[m][n];
	}

	int naiveEditDistance(char[] str1, char[] str2, int m, int n) {

		if (m == 0 && n == 0) {
			return 0;
		}

		// n inserts
		if (m == 0) {
			return n;
		}

		// m delete
		if (n == 0) {
			return m;
		}

		int diff = 1;

		if (str1[m - 1] == str2[n - 1]) {
			diff = 0;
		}

		int R = naiveEditDistance(str1, str2, m - 1, n - 1) + diff;
		int D = naiveEditDistance(str1, str2, m - 1, n) + 1;
		int I = naiveEditDistance(str1, str2, m, n - 1) + 1;

		return min(R, D, I);
	}

	int min(int x, int y, int z) {
		if (x < y)
			return (x < z) ? x : z;
		else
			return (y < z) ? y : z;
	}
}
