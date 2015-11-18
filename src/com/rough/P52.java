package com.rough;

public class P52 {

	public static void main(String[] args) {
		int arr[] = { 10, 12, 20, 30, 25, 40, 32, 31, 35, 50, 60 };
		P52 test = new P52();
		test.printUnsorted(arr, arr.length);
	}

	private void printUnsorted(int[] arr, int n) {
		int s = 0;
		int e = n - 1;
		for (int i = 0; i < n - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				s = i;
				break;
			}
		}

		for (int i = n - 1; i > 0; i--) {
			if (arr[i] < arr[i - 1]) {
				e = i;
				break;
			}
		}

		int min = arr[s];
		int max = arr[s];

		for (int i = s; i <= e; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}

			if (arr[i] > max) {
				max = arr[i];
			}
		}

		// Find the first element (if there is any) in arr[0..s-1] which is
		// greater than min
		for (int i = 0; i < s; i++) {
			if (arr[i] > min) {
				s = i;
				break;
			}
		}

		// Find the last element (if there is any) in arr[e+1..n-1] which is
		// smaller than max
		for (int i = e + 1; i < n; i++) {
			if (arr[i] < max) {
				e = i;
			}
		}
		System.out
				.println("The unsorted subarray which makes the given array sorted lies between the indexes : "
						+ s +"   "+ e);
	}
}
