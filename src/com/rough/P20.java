package com.rough;

public class P20 {

	public static void main(String[] args) {
		int a[] = { -2, -3, 4, -1, -2, 1, 5, -3 };
		P20 test = new P20();
		// int maxSum = test.getMaxSum(a, a.length);
		int maxSum = test.getMaxSumDP(a, a.length);
		System.out.println("Maximum contiguous sum is : " + maxSum);

		int arr[] = { 2, 3, 3, 5, 3, 4, 1, 7 };
		int k = 8;
		int maxRepeat = test.maxRepeating(arr, arr.length, k);
		System.out.println("The maximum repeating number is :" + maxRepeat);

		int arr1[] = { 4, 2, 4, 5, 2, 3, 1 };
		test.findRepeating(arr1, 5);

		int arr2[] = { 2, 3, 7, 9, 11, 2, 3, 11 };
		test.findNonRepeating(arr2, arr2.length);

	}

	private void findNonRepeating(int[] arr, int length) {
		int xor = arr[0];

		for (int i = 1; i < length; i++) {
			xor = xor ^ arr[i];
		}

		int setBitOn = xor & ~(xor - 1);
		int x = 0;
		int y = 0;

		for (int i = 0; i < length; i++) {
			if ((arr[i] & setBitOn) != 0) {
				x = x ^ arr[i];
			} else {
				y = y ^ arr[i];
			}
		}

		System.out.println(x + " : " + y);
	}

	private void findRepeating(int[] arr, int k) {
		int xor = arr[0];

		for (int i = 1; i < arr.length; i++) {
			xor = xor ^ arr[i];
		}

		for (int i = 1; i <= k; i++) {
			xor = xor ^ i;
		}

		int setBitOn = xor & ~(xor - 1);

		int x = 0;
		int y = 0;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i] & setBitOn) != 0) {
				x = x ^ arr[i];
			} else {
				y = y ^ arr[i];
			}
		}

		for (int i = 0; i <= k; i++) {
			if ((i & setBitOn) != 0) {
				x = x ^ i;
			} else {
				y = y ^ i;
			}
		}

		System.out.println(x + " : " + y);
	}

	/**
	 * We can use maximum quotient arr[i]/n instead of maximum value for
	 * printing multiple values
	 */
	private int maxRepeating(int[] arr, int n, int k) {
		for (int i = 0; i < arr.length; i++) {
			int index = arr[i] % k;
			arr[index] += k;
		}

		int maxIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > arr[maxIndex]) {
				maxIndex = i;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			arr[i] = arr[i] % k;
		}

		return maxIndex;
	}

	public int getMaxSumDP(int[] a, int n) {
		int maxSoFar = a[0];
		int curMax = a[0];

		for (int i = 1; i < n; i++) {
			curMax = Math.max(a[i], curMax + a[i]);
			maxSoFar = Math.max(maxSoFar, curMax);
		}
		return maxSoFar;
	}

	public int getMaxSum(int[] a, int n) {
		int sum = 0;
		int maxSum = 0;

		for (int i = 0; i < n; i++) {
			sum = sum + a[i];
			if (sum < 0) {
				sum = 0;
			}
			if (sum > maxSum) {
				maxSum = sum;
			}
		}
		return maxSum;
	}
}
