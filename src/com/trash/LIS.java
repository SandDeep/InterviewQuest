package com.trash;

/* http://codingtonic.blogspot.in/2015/02/longest-increasing-sub-sequence-dynamic.html */
public class LIS {

	static int max = 0;

	public static void main(String[] args) {
		int arr[] = { 10, 4, 15, 12, 7, 12, 17, 14, 19, 5 };

		LIS lis = new LIS();
		lis.getLIS(arr, arr.length);
		System.out.println(max);

		int len = lis.getLISdp(arr, arr.length);
		System.out.println("DP : " + len);
	}

	/**
	 * Time Complexity: O(n^2)
	 * 
	 * @return
	 */
	private int getLISdp(int[] arr, int n) {
		int[] lis = new int[n];
		int[] p = new int[n];

		for (int i = 0; i < n; i++) {
			lis[i] = 1;
			p[i] = -1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && lis[j] + 1 > lis[i]) {
					lis[i] = lis[j] + 1;
					p[i] = j;
				}
			}
		}

		int max = 1;
		int maxEndingIndex = -1;
		for (int i = 0; i < n; i++) {
			if (lis[i] > max) {
				max = lis[i];
				maxEndingIndex = i;
			}
		}

		System.out.println("Max Ending Index : " + maxEndingIndex);
		while (maxEndingIndex != -1) {
			System.out.print(arr[maxEndingIndex] + " ");
			maxEndingIndex = p[maxEndingIndex];
		}
		return max;
	}

	/**
	 * Time Complexity: O(2^n)
	 * 
	 * @return
	 */
	private int getLIS(int[] arr, int n) {
		if (n == 1) {
			return 1;
		}

		int maxEnding = 1;
		int lis = 1;

		for (int i = 1; i < n; i++) {
			lis = getLIS(arr, i);
			if (arr[i - 1] <= arr[n - 1] && 1 + lis > maxEnding) {
				maxEnding = 1 + lis;
			}
		}

		if (max < maxEnding) {
			max = maxEnding;
		}

		return maxEnding;
	}
}
