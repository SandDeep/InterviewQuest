package com.pkg2;

import java.util.Arrays;

/**
 * Time Complexity : O(n log(n))
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class MergeSort {

	static int[] output;

	public static void main(String[] args) {
		 int[] arr = { 7, 2, 1, 6, 8, 5, 3, 4 };
		// int[] arr = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
		//int arr[] = new int[10000000];
		//InsertionSort.populateArray(arr);
		System.out.println(Arrays.toString(arr));

		output = new int[arr.length];

		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	public static void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = start + (end - start) / 2;

			mergeSort(arr, start, mid);
			mergeSort(arr, mid + 1, end);

			merge(arr, start, mid, end);
		}
	}

	private static void merge(int[] arr, int start, int mid, int end) {

		for (int i = start; i <= end; i++) {
			output[i] = arr[i];
		}

		int i = start;
		int k = start;
		int j = mid + 1;

		while (i <= mid && j <= end) {
			if (output[i] <= output[j]) {
				arr[k] = output[i];
				i++;
			} else {
				arr[k] = output[j];
				j++;
			}
			k++;
		}

		while (i <= mid) {
			arr[k] = output[i];
			i++;
			k++;
		}

		while (j <= end) {
			arr[k] = output[j];
			j++;
			k++;
		}

	}
}
