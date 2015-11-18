package com.rough;

/**
 * http://www.geeksforgeeks.org/find-the-element-that-appears-once-in-a-sorted-
 * array/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P77 {

	public static void main(String[] args) {
		int arr[] = { 1, 1, 3, 3, 4, 5, 5, 7, 7, 8, 8 };

		P77 test = new P77();

		test.findElement(arr, 0, arr.length - 1);

	}

	private void findElement(int[] arr, int low, int high) {
		if (low > high) {
			return;
		}

		if (low == high) {
			System.out.println("Missing Element : " + arr[low]);
			return;
		}

		int mid = (low + high) / 2;

		// EVEN
		if (mid % 2 == 0) {
			if (arr[mid] == arr[mid + 1]) {
				findElement(arr, mid + 2, high);
			} else {
				findElement(arr, low, mid);
			}
		}

		// ODD
		else {
			if (arr[mid] == arr[mid - 1]) {
				findElement(arr, mid + 1, high);
			} else {
				findElement(arr, low, mid - 1);
			}
		}

	}
}
