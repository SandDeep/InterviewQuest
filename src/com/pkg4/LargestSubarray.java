package com.pkg4;

public class LargestSubarray {

	public static void main(String[] args) {
		//int arr[] = { 1, 0, 0, 1, 0, 1, 1 };
		int arr[] = { 1, 0, 1, 1, 1, 0, 0 };

		LargestSubarray subarray = new LargestSubarray();
		int maxSize = subarray.findSubArray(arr, arr.length);
		System.out.println("MaxSize : " + maxSize);
	}

	private int findSubArray(int[] arr, int n) {
		int sumLeft[] = new int[n];

		sumLeft[0] = (arr[0] == 0) ? -1 : 1;

		int max = sumLeft[0];
		int min = sumLeft[0];

		for (int i = 1; i < sumLeft.length; i++) {
			sumLeft[i] = sumLeft[i - 1] + ((arr[i] == 0) ? -1 : 1);

			if (sumLeft[i] < min) {
				min = sumLeft[i];
			}

			if (sumLeft[i] > max) {
				max = sumLeft[i];
			}
		}

		int[] hash = new int[max - min + 1];

		for (int i = 0; i < hash.length; i++) {
			hash[i] = -1;
		}
		int maxSize = -1;
		int startIndex = -1;

		for (int i = 0; i < n; i++) {

			// Case 1: when the subArray starts from index 0
			if (sumLeft[i] == 0) {
				maxSize = i + 1;
				startIndex = 0;
			}

			// Case 2: fill hash table value. If already filled, then use it
			if (hash[sumLeft[i] - min] == -1) {
				hash[sumLeft[i] - min] = i;
			} else {
				if ((i - hash[sumLeft[i] - min]) > maxSize) {
					maxSize = i - hash[sumLeft[i] - min];
					startIndex = hash[sumLeft[i] - min] + 1;
				}
			}

		}

		if (maxSize == -1)
			System.out.println("No such subarray");
		else {
			int end = startIndex + maxSize - 1;
			System.out.println(startIndex + " to " + end);
		}
		return maxSize;
	}
}
