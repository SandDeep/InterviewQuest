package com.pkgS;

/**
 * http://www.geeksforgeeks.org/count-number-of-occurrences-in-a-sorted-array/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P1 {

	public static void main(String[] args) {
		int arr[] = { 1, 1, 2, 2, 2, 2, 3 };
		int x = 2;

		P1 test = new P1();

		int count = test.countOccurences(arr, x);
		System.out.println(count);
	}

	private int countOccurences(int[] arr, int x) {
		int start = getStartIndex(arr, x, 0, arr.length - 1);
		int last = getLastIndex(arr, x, start, arr.length - 1);

		System.out.println(start + " : " + last);
		return last - start + 1;
	}

	private int getStartIndex(int[] arr, int k, int left, int right) {
		if (left <= right) {

			int mid = (left + right) / 2;

			if (arr[mid] == k && (mid == 0 || k > arr[mid - 1])) {
				return mid;
			}

			if (k > arr[mid]) {
				return getStartIndex(arr, k, mid + 1, right);
			}
			return getStartIndex(arr, k, left, mid - 1);
		}
		return -1;
	}

	private int getLastIndex(int[] arr, int k, int left, int right) {
		if (left <= right) {

			int mid = (left + right) / 2;

			if (arr[mid] == k && (mid == arr.length - 1 || k < arr[mid + 1])) {
				return mid;
			}

			if (k < arr[mid]) {
				return getLastIndex(arr, k, left, mid - 1);
			}
			return getLastIndex(arr, k, mid + 1, right);
		}
		return -1;
	}
}
