package com.rough;

public class P75 {

	public static void main(String[] args) {
		P75 test = new P75();

		int arr1[] = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
		int no = 3;
		System.out.println("Index of the element is "
				+ test.pivotedBinarySearch(arr1, arr1.length, no));

		int arr2[] = { 0, 1, 1, 1, 1, 1, 1, 1, 1 };
		no = 0;
		System.out.println("Index of the element is "
				+ test.pivotedBinarySearch(arr2, arr2.length, no));
	}

	private int pivotedBinarySearch(int[] arr, int n, int num) {
		int pivot = findPivot(arr, 0, n - 1);

		// Array is not rotated
		if (pivot == -1) {
			return binarySearch(arr, 0, n - 1, num);
		}

		if (num == arr[pivot]) {
			return pivot;
		}

		if (arr[0] <= num) {
			return binarySearch(arr, 0, pivot - 1, num);
		}
		return binarySearch(arr, pivot + 1, n - 1, num);
	}

	private int binarySearch(int[] arr, int left, int right, int num) {
		if (left > right) {
			return -1;
		}

		int mid = (left + right) / 2;

		if (arr[mid] == num) {
			return mid;
		}

		if (num < arr[mid]) {
			return binarySearch(arr, left, mid - 1, num);
		}
		return binarySearch(arr, mid + 1, right, num);
	}

	private int findPivot(int[] arr, int low, int high) {
		if (low > high) {
			return -1;
		}

		if (low == high) {
			return low;
		}

		int mid = (low + high) / 2;

		if (mid < high && arr[mid] > arr[mid + 1]) {
			return mid + 1;
		}

		if (low < mid && arr[mid] < arr[mid - 1]) {
			return mid;
		}

		if (arr[mid] < arr[high]) {
			return findPivot(arr, low, mid - 1);
		}
		return findPivot(arr, mid + 1, high);
	}
}
