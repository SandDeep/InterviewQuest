package com.pkg1;

import java.util.Arrays;

public class IncreasingSeq {
	static int len = 0;

	public static void main(String[] args) {
		int k = 3;
		int n = 5;

		printSeq(n, k);
	}

	private static void printSeq(int n, int k) {
		int[] arr = new int[k];

		printSeqUtil(n, k, len, arr);
	}

	private static void printSeqUtil(int n, int k, int len, int[] arr) {
		if (len == k) {
			System.out.println(Arrays.toString(arr));
			return;
		}

		int i = (len == 0) ? 1 : arr[len - 1] + 1;

		len++;

		while (i <= n) {
			arr[len - 1] = i;
			printSeqUtil(n, k, len, arr);
			i++;
		}

		len--;
	}

}
