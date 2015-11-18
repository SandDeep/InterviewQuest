package com.pkg2;

/**
 * The longest Increasing Subsequence (LIS) problem is to find the length of the
 * longest subsequence of a given sequence such that all elements of the
 * subsequence are sorted in increasing order. For example, length of LIS for {
 * 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 * 
 * @author Deepesh.Maheshwari
 * 
 */
public class LIS {

	static int max = 1;

	/*
	 * http://codingtonic.blogspot.in/2015/02/longest-increasing-sub-sequence-dynamic.html
	 */
	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
		//int[] arr = {0,0,0,0,0,0,1,1,1,1,2,3,0,0,0,1,1,0,1,1,0,1,0,3};

		// lis(arr, arr.length);
		int maxlen = lisBT(arr, arr.length);
		System.out.println(maxlen);

	}

	private static int lisBT(int[] arr, int n) {

		int[] len = new int[n];

		for (int i = 0; i < len.length; i++) {
			len[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && (len[i] < len[j] + 1)) {
					len[i] = len[j] + 1;
				}
			}
		}

		int maxL = 1;

		for (int i : len) {
			if (i > maxL) {
				maxL = i;
			}
		}

		return maxL;
	}

	public static int lis(int[] arr, int n) {
		if (n == 1) {
			return 1;
		}

		int res = 1;
		int maxEndingHere = 1;

		for (int i = 1; i < n; i++) {

			res = lis(arr, i);

			if ((arr[i - 1] < arr[n - 1]) && (res + 1 > maxEndingHere)) {
				maxEndingHere = res + 1;
			}

		}

		if (maxEndingHere > max) {
			max = maxEndingHere;
		}

		return maxEndingHere;
	}

}
