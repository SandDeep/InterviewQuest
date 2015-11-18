package com.pkg4;

import java.util.Arrays;

/**
 * Time complexity is O(n). Space complexity is O(1).
 * 
 * @author Deepesh
 * 
 */
public class DutchNationalFlag {

	/**
	 * 3-way Quick Sort
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int arr[] = { 0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
		int i = 0;
		int j = 0;
		int k = arr.length - 1;

		while (j <= k) {
			if (arr[j] == 0) {
				swap(arr, i, j);
				i++;
				j++;
			} else if (arr[j] == 1) {
				j++;
			} else if (arr[j] == 2) {
				swap(arr, j, k);
				k--;
			}
		}
		System.out.println(Arrays.toString(arr));

	}

	private static void swap(int[] arr, int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}
}
