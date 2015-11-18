package com.pkg2;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = { 7, 2, 1, 6, 8, 5, 3, 4 };
		//int[] arr = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
		selectionSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void selectionSort(int[] arr) {
		int size = arr.length - 1;

		for (int i = 0; i < size; i++) {
			int smallIndex = i;

			for (int j = i; j < size; j++) {
				if (arr[j] < arr[smallIndex]) {
					smallIndex = j;
				}
			}

			if (smallIndex != i) {
				swap(arr, i, smallIndex);
			}
		}
	}

	private static void swap(int[] arr, int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}
}
