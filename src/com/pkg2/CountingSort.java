package com.pkg2;

import java.util.Arrays;

public class CountingSort {

	final int RANGE = 10;
	final int RANGEG = 255;

	public static void main(String[] args) {
		int[] arr = { 1, 4, 1, 2, 9, 5, 2 };
		CountingSort sort = new CountingSort();
		sort.countSort(arr);

		char str[] = "geeksforgeeks".toCharArray();
		sort.countSortG(str);
	}

	private void countSort(int[] arr) {
		int[] count = new int[RANGE];
		int[] result = new int[arr.length+1];

		for (int i = 0; i < arr.length; i++) {
			count[arr[i]] += 1;
		}

		for (int i = 1; i < count.length; i++) {
			count[i] = count[i - 1] + count[i];
		}

		for (int i = 0; i < result.length; i++) {
			result[i] = -1;
		}

		for (int i = 0; i < arr.length; i++) {
			int index = count[arr[i]];
			count[arr[i]] -= 1;
			result[index] = arr[i];
		}
		System.out.println(Arrays.toString(result));
	}

	void countSortG(char[] str) {
		// The output character array that will have sorted str
		char[] output = new char[str.length];

		// Create a count array to store count of inidividul characters and
		// initialize count array as 0
		int[] count = new int[RANGEG + 1];
		;
		int i = 0;

		// Store count of each character
		for (i = 0; i < str.length; ++i)
			++count[str[i]];

		// Change count[i] so that count[i] now contains actual position of
		// this character in output array
		for (i = 1; i <= RANGE; ++i)
			count[i] += count[i - 1];

		// Build the output character array
		for (i = 0; i < str.length; ++i) {
			output[count[str[i]] - 1] = str[i];
			--count[str[i]];
		}

		// Copy the output array to str, so that str now
		// contains sorted characters
		for (i = 0; i < str.length; ++i)
			str[i] = output[i];

		System.out.println();
	}
}
