package com.pkg2;

public class LarSubarray {

	public static void main(String[] args) {
		int[] arr = { 1, 56, 58, 57, 90, 92, 94, 93, 91, 45 };
		int len = findSubLength(arr);
		System.out.println(len);
	}

	private static int findSubLength(int[] arr) {
		int max = 0;

		for (int i = 0; i < arr.length - 1; i++) {

			for (int j = i + 1; j < arr.length; j++) {

				if (((j - i) == (max(arr, i, j) - min(arr, i, j)))) {
					if (max < (j - i)) {
						max = j - i;
					}
				}
			}
		}

		return max + 1;
	}

	private static int min(int[] arr, int i, int j) {
		int min = arr[i];
		for (int k = i; k <= j; k++) {
			if (arr[k] < min) {
				min = arr[k];
			}
		}
		return min;
	}

	private static int max(int[] arr, int i, int j) {
		int max = arr[i];
		for (int k = i; k <= j; k++) {
			if (arr[k] > max) {
				max = arr[k];
			}
		}
		return max;
	}
}
