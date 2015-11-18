package com.pkg4;

public class RotatedPair {

	public static void main(String[] args) {
		int arr[] = { 11, 15, 6, 8, 9, 10 };
		int sum = 16;

		RotatedPair pair = new RotatedPair();
		boolean status = pair.pairInSortedRotated(arr, arr.length, sum);

		if (status) {
			System.out.println("Array has two elements with sum 16");
		} else {
			System.out.println("Array doesn't have two elements with sum 16 ");
		}
	}

	private boolean pairInSortedRotated(int[] arr, int n, int sum) {
		int j;
		for (j = 0; j < n - 1; j++) {
			if (arr[j] > arr[j + 1]) {
				break;
			}
		}

		int l = (j + 1) % n;
		int r = j;

		while (l != r) {
			if (arr[l] + arr[r] == sum) {
				return true;
			}

			// If current pair sum is less, move to the higher sum
			if (arr[l] + arr[r] < sum) {
				l = (l + 1) % n;
			} else {
				r = (n + r - 1) % n;
			}
		}
		return false;
	}
}
