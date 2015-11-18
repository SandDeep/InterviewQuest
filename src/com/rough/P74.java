package com.rough;

/**
 * http://www.geeksforgeeks.org/find-minimum-element-in-a-sorted-and-rotated-
 * array/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P74 {
	public static void main(String[] args) {
		P74 test = new P74();

		// int[] arr = { 11, 12, 15, 1, 18, 2, 5, 6, 8 };
		// int[] arr = { 20, 30, 40, 1, 2, 3, 4, 5, 7, 8, 9 };
		// int[] arr = { 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2 };
		//int[] arr = { 2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2 };
		int[] arr={1, 0, 1, 1, 1, 1, 1, 1, 1};
		int rotated = test.findRotationCountRecur(arr, 0, arr.length - 1);
		System.out.println("Array Rotation : " + rotated);

		rotated = test.findRotationCount(arr, arr.length);
		System.out.println("Array Rotation : " + rotated);

		int min = test.findMin(arr, 0, arr.length - 1);
		System.out.println("Min Element: " + min);
	}

	private int findMin(int[] arr, int low, int high) {
		
		if (high < low)
			return arr[0];

		if (low == high) {
			return arr[low];
		}

		// int mid = low + (high - low) / 2;
		int mid = (high + low) / 2;

		/*
		 * Check if element (mid+1) is minimum element. Consider the cases like
		 * {1, 1, 0, 1}
		 */
		if (mid < high && arr[mid] > arr[mid + 1]) {
			return arr[mid + 1];
		}

		// O(n) time : Special Case : {2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 2}
		if (arr[mid] == arr[low] && arr[mid] == arr[high]) {
			return Math.min(findMin(arr, low, mid - 1),
					findMin(arr, mid + 1, high));
		}

		if (low < mid && arr[mid - 1] > arr[mid]) {
			return arr[mid];
		}

		if (arr[high] > arr[mid]) {
			return findMin(arr, low, mid - 1);
		}
		return findMin(arr, mid + 1, high);
	}

	private int findRotationCount(int[] arr, int n) {
		int low = 0;
		int high = n - 1;

		while (low <= high) {
			// case 1
			if (arr[low] < arr[high]) {
				return low;
			}

			int N = arr.length;
			int mid = low + (high - low) / 2;

			int prev = (mid + N - 1) % N;
			int next = (mid + 1) % N;

			// case 2
			if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
				return mid;
			}

			// case 3
			else if (arr[mid] <= arr[high]) {
				high = mid - 1;
			}

			// case 4
			else if (arr[mid] >= arr[low]) {
				low = mid + 1;
			}
		}
		return -1;
	}

	private int findRotationCountRecur(int[] arr, int low, int high) {
		// case 1
		if (arr[low] <= arr[high]) {
			return low;
		}

		int N = arr.length;
		int mid = low + (high - low) / 2;

		int prev = (mid + N - 1) % N;
		int next = (mid + 1) % N;

		// case 2
		if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
			return mid;
		}

		// case 3
		else if (arr[mid] <= arr[high]) {
			return findRotationCountRecur(arr, low, mid - 1);
		}

		// case 4
		else {
			return findRotationCountRecur(arr, mid + 1, high);
		}
	}
}
