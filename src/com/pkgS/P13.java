package com.pkgS;

/**
 * http://www.geeksforgeeks.org/collect-maximum-points-in-a-grid-using-two-
 * traversals/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P13 {

	public static void main(String[] args) {
		int[][] nutritions = 
			{ 
				{ 3, 6, 8, 2 }, 
				{ 5, 2, 4, 3 },
				{ 1, 1, 20, 10 }, 
				{ 1, 1, 20, 10 }, 
				{ 1, 1, 20, 10 } 
			};
		
		
		P13 test=new P13();
		
		System.out.println("Maximum Nutritional Value : "+test.collect(nutritions) );
	}

	private int collect(int[][] nutritions) {
		int m = nutritions.length;
		int n = nutritions[0].length;
		
		int[][][]dp=new int[m][n][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					dp[i][j][k] = -1;
				}
			}
		}
		return collectutil(nutritions,0,0,n-1,dp);
	}

	private int collectutil(int[][] nutritions, int x, int y1, int y2,
			int[][][] dp) {

		int m = nutritions.length;
		int n = nutritions[0].length;

		// Invalid Co-ordinate
		if (!isValid(nutritions, x, y1) || !isValid(nutritions, x, y2)) {
			return Integer.MIN_VALUE;
		}

		// Destination Point
		if (x == m - 1 && y1 == 0 && y2 == n - 1)
			return nutritions[x][y1] + nutritions[x][y2];

		// If both traversals are at last row but not at their destination
		/*if (x == m - 1)
			return Integer.MIN_VALUE;*/

		if (dp[x][y1][y2] != -1) {
			return dp[x][y1][y2];
		}
		int temp = 0;

		// Same point
		if (y1 == y2) {
			temp = nutritions[x][y1];
		} else {
			temp = nutritions[x][y1] + nutritions[x][y2];
		}

		int max = Integer.MIN_VALUE;

		max = Math.max(max, collectutil(nutritions, x + 1, y1, y2, dp));
		max = Math.max(max, collectutil(nutritions, x + 1, y1, y2 - 1, dp));
		max = Math.max(max, collectutil(nutritions, x + 1, y1, y2 + 1, dp));
		max = Math.max(max, collectutil(nutritions, x + 1, y1 - 1, y2, dp));
		max = Math.max(max, collectutil(nutritions, x + 1, y1 - 1, y2 - 1, dp));
		max = Math.max(max, collectutil(nutritions, x + 1, y1 - 1, y2 + 1, dp));
		max = Math.max(max, collectutil(nutritions, x + 1, y1 + 1, y2, dp));
		max = Math.max(max, collectutil(nutritions, x + 1, y1 + 1, y2 - 1, dp));
		max = Math.max(max, collectutil(nutritions, x + 1, y1 + 1, y2 + 1, dp));

		return temp + max;
	}
	
	 private boolean isValid(int[][] arr, int i, int j) {

	        int m = arr.length;          //ROW
	        int n = arr[0].length;       //COL

	        return i >= 0 && i < m && j >= 0 && j < n ;
	    }
}
