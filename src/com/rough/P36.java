package com.rough;

/**
 * Time Complexity: O(sum*n) Auxiliary Space: O(sum*n)
 * 
 * @author Deepesh
 * 
 */
public class P36 {

	public static void main(String[] args) {
		int[] arr = { 1, 5, 11, 5 };
		P36 test = new P36();

		test.partition(arr, arr.length);
	}

	public void partition(int[] arr, int n) {

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}

		// Odd
		if (sum % 2 != 0) {
			System.out.println("Partitioning not Possible.");
			return;
		}

		// boolean status = isPartitionable(arr, n, sum / 2);
		boolean status = isPartitionableDP(arr, n, sum / 2);
		System.out.println("Partitioning Status : " + status);
	}

	/**
	 * Note that this solution will not be feasible for arrays with big sum.
	 * 
	 * @return
	 */
	public boolean isPartitionableDP(int[] arr, int n, int sum) {

		boolean[][] pat = new boolean[sum + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			pat[0][i] = true;
		}

		for (int i = 1; i <= sum; i++) {
			pat[i][0] = false;
		}

		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				pat[i][j] = pat[i][j - 1];

				if (i >= arr[j - 1]) {
					pat[i][j] = pat[i][j] || pat[i - arr[j - 1]][j - 1];
				}
			}
		}
		return pat[sum][n];
	}

	public boolean isPartitionable(int[] arr, int n, int sum) {
		if (sum == 0) {
			return true;
		}

		if (n == 0 && sum != 0) {
			return false;
		}

		if (arr[n - 1] > sum) {
			return isPartitionable(arr, n - 1, sum);
		}

		return isPartitionable(arr, n - 1, sum)
				|| isPartitionable(arr, n - 1, sum - arr[n - 1]);
	}
}
