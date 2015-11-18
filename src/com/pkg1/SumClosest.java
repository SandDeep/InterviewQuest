package com.pkg1;

/**
 * Given a sorted array and a number x, find a pair in array whose sum is
 * closest to x.
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class SumClosest {

	public static void main(String[] args) {
		//int arr[] = { 10, 22, 28, 29, 30, 40 };
		///int x = 54;

		 int arr[] = { 1, 3, 4, 7, 10 };
	 int x = 15;
		//findPair(arr, x);
		findPairTricky(arr, x);
	}

	/**
	 * Complexity : O(n)
	 * 
	 * @param arr
	 * @param k
	 */
	public static void findPairTricky(int[] arr, int k) {
		int l = 0;
		int r = arr.length - 1;
		int diff = Integer.MAX_VALUE;

		int resultLeft = 0;
		int resultRight = arr.length - 1;

		while (l < r) {
			if (Math.abs(arr[l] + arr[r] - k) < diff) {
				diff = Math.abs(arr[l] + arr[r] - k);
				resultLeft = l;
				resultRight = r;
			}

			if (arr[l] + arr[r] > k) {
				r--;
			} else {
				l++;
			}
		}

		System.out.println(arr[resultLeft] + " : " + arr[resultRight]);
	}

	public static void findPair(int[] arr, int k) {
		int x1 = arr[0];
		int x2 = arr[1];

		int diff1 = 0;
		int diff2 = 0;

		for (int i = 2; i < arr.length; i++) {
			int sum1 = x1 + arr[i];
			int sum2 = x2 + arr[i];

			// x1 and sum
			if (sum1 <= k) {
				diff1 = k - sum1;
			} else {
				diff1 = Integer.MAX_VALUE;
			}

			// x2 and sum
			if (sum2 <= k) {
				diff2 = k - sum2;
			} else {
				diff2 = Integer.MAX_VALUE;
			}

			if (diff1 == diff2) {
				continue;
			}
			int selectedSum = Math.min(diff1, diff2);

			if (selectedSum == diff1) {
				x2 = arr[i];
			} else if (selectedSum == diff2) {
				x1 = x2;
				x2 = arr[i];
			}
		}

		System.out.println(x1 + " : " + x2);
	}
}
