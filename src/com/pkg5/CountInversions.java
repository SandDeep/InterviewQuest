package com.pkg5;

/**
 * http://www.geeksforgeeks.org/check-instance-8-puzzle-solvable/
 * 
 * @author Deepesh
 * 
 */
public class CountInversions {

	public static void main(String[] args) {
		int[] arr = { 1, 20, 6, 4, 5 };

		CountInversions inversions = new CountInversions();
		// int count = inversions.mergesortInversion(arr, 0, arr.length - 1);

		int count = inversions.getInvCount(arr);

		System.out.println("Number of Inversions : " + count);
	}

	/**
	 * Time Complexity: O(n^2)
	 * 
	 * @param arr
	 * @return
	 */
	public int getInvCount(int[] arr) {
		int inversions = 0;

		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					inversions++;
				}
			}
		}
		return inversions;
	}

	/**
	 * Time Complexity: O(nlogn)
	 * http://www.geeksforgeeks.org/counting-inversions/
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 * @return
	 */
	public int mergesortInversion(int[] arr, int start, int end) {
		int inversions = 0;

		if (start < end) {
			int mid = start + (end - start) / 2;

			inversions = mergesortInversion(arr, start, mid);
			inversions += mergesortInversion(arr, mid + 1, end);

			inversions += merge(arr, start, mid, end);
		}

		return inversions;
	}

	private int merge(int[] arr, int start, int mid, int end) {
		int inversions = 0;

		int i = start;
		int j = mid + 1;
		int k = start;

		int[] temp = new int[arr.length];

		while (i <= mid && j <= end) {

			if (arr[i] <= arr[j]) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
				inversions += mid + 1 - i;
			}
		}

		while (i <= mid) {
			temp[k++] = arr[i++];
		}

		while (j <= end) {
			temp[k++] = arr[j++];
		}

		for (int l = start; l <= end; l++) {
			arr[l] = temp[l];
		}
		return inversions;
	}
}
