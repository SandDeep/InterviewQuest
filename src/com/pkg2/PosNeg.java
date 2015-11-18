package com.pkg2;

import java.util.Arrays;

public class PosNeg {

	public static void main(String[] args) {
		int[] num = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };

		reaarange(num);
	}

	private static void reaarange(int[] num) {
		int pivot = 0;
		int pIndex = 0;
		for (int i = 0; i < num.length; i++) {
			if (num[i] <= pivot) {
				swap(num, i, pIndex);
				pIndex++;
			}
		}

		int limit = pIndex;

		for (int i = 0; i < limit;) {
			swap(num, i, pIndex);
			i = i + 2;
			pIndex = pIndex + 2;
		}

		System.out.println(Arrays.toString(num));
	}

	private static void swap(int[] arr, int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}
}
