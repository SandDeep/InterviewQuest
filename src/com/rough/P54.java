package com.rough;

/**
 * http://comproguide.blogspot.in/2013/12/minimum-difference-between-two-sorted.
 * html linear time - O(n) and constant space O(1)
 * 
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P54 {

	public static void main(String[] args) {
		int[] array1 = { 3, 27, 45, 68, 70, 81, 99 };
		int[] array2 = { 9, 16, 25, 35, 74, 84 };

		P54 test = new P54();
		int min = test.getMinDiff(array1, array2);
		System.out.println(min);

		int arr[] = { 2, 3, 10, 6, 4, 8, 1 };
		int max = test.maxDiff(arr);
		System.out.println(max);
	}

	/**
	 * http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
	 * 
	 * @param arr
	 * @return
	 */
	private int maxDiff(int[] arr) {
		int maxDiff = Integer.MIN_VALUE;
		int min = arr[0];

		for (int i = 1; i < arr.length; i++) {
			maxDiff = Math.max(maxDiff, arr[i] - min);
			min = Math.min(min, arr[i]);
		}
		return maxDiff;
	}

	private int getMinDiff(int[] arr1, int[] arr2) {
		int globalMin = Integer.MAX_VALUE;

		int i = 0;
		int j = 0;
		while (i < arr1.length && j < arr2.length) {

			if (arr1[i] == arr2[j]) {
				return 0;
			}

			int diff = arr1[i] - arr2[j];

			if (Math.abs(diff) < globalMin) {
				globalMin = Math.abs(diff);
			}

			if (arr1[i] > arr2[j]) {
				j++;
			} else {
				i++;
			}

		}

		if (i < arr1.length) {
			j--;
			while (i < arr1.length) {

				int diff = arr1[i] - arr2[j];

				if (Math.abs(diff) < globalMin) {
					globalMin = Math.abs(diff);
				}

				i++;
			}
		}

		if (j < arr2.length) {
			i--;
			while (j < arr2.length) {

				int diff = arr1[i] - arr2[j];

				if (Math.abs(diff) < globalMin) {
					globalMin = Math.abs(diff);
				}

				j++;
			}
		}
		return globalMin;
	}
}
