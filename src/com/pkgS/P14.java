package com.pkgS;

public class P14 {

	public static void main(String[] args) {
		int arr[] = { 10, 20, 30, 50, 10, 70, 30 };

		P14 test = new P14();
		test.printMaxOfMin(arr, arr.length);
	}

	/**
	 * upper bounded by O(n^3).
	 *
	 * @param arr
	 * @param n
	 */
	private void printMaxOfMin(int[] arr, int n) {

		for (int k = 1; k <= n; k++) {
			int max = Integer.MIN_VALUE;
			for (int i = 0; i <= n - k; i++) {
				int min = arr[i];
				for (int j = i; j < i + k; j++) {
					min = Math.min(arr[j], min);
				}
				max = Math.max(max, min);
			}
			System.out.print(max + " ");
		}
	}
}
