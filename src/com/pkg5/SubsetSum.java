package com.pkg5;

public class SubsetSum {

	public static void main(String[] args) {
		int set[] = { 3, 34, 4, 12, 5, 2 };
		int sum = 9;

		SubsetSum subsetSum = new SubsetSum();

		// boolean status=subsetSum.isSubsetSum(set, set.length, sum);
		boolean status = subsetSum.isSubsetSumDP(set, set.length, sum);
		if (status) {
			System.out.println("Found a subset with given sum");
		} else {
			System.out.println("No subset with given sum");
		}
	}

	public boolean isSubsetSumDP(int[] set, int n, int sum) {

		boolean[][] subset = new boolean[sum + 1][n + 1];

		for (int i = 0; i <= n; i++) {
			subset[0][i] = true;
		}

		for (int i = 1; i <= sum; i++) {
			subset[i][0] = false;
		}

		for (int i = 1; i <= sum; i++) {
			for (int j = 1; j <= n; j++) {
				subset[i][j] = subset[i][j - 1];
				if (i >= set[j - 1]) {
					subset[i][j] = subset[i][j]
							|| subset[i - set[j - 1]][j - 1];
				}
			}
		}
		
		return subset[sum][n];
	}

	/**
	 * Time complexity of the above solution is exponential. The problem is
	 * in-fact NP-Complete
	 * 
	 * @return
	 */
	public boolean isSubsetSum(int[] arr, int n, int sum) {
		// Base Cases
		if (sum == 0) {
			return true;
		}

		if (sum > 0 && n == 0) {
			return false;
		}

		// If last element is greater than sum, then ignore it
		if (arr[n - 1] > sum) {
			return isSubsetSum(arr, n - 1, sum);
		}

		/*
		 * Check if sum can be obtained by any of the following (a) including
		 * the last element (b) excluding the last element
		 */
		return isSubsetSum(arr, n - 1, sum)
				|| isSubsetSum(arr, n - 1, sum - arr[n - 1]);
	}
}
