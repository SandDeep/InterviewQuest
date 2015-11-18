package com.rough;

import java.util.Arrays;

public class P76 {

	public static void main(String[] args) {
		int freq[] = { 2, 1, 1, 3, 2, 3, 4, 5, 6, 7, 8, 9 };

		P76 test = new P76();
		int[] bitree = test.constructBITree(freq, freq.length);
		System.out.println(Arrays.toString(bitree));

		System.out.println("Sum of elements in arr[0..5] : "
				+ test.getSum(bitree, 5));

		test.updateBIT(bitree,freq.length,3,6);
		
		System.out.println("Sum of elements in arr[0..5] : "
				+ test.getSum(bitree, 5));
	}

	// to find parent , flip right most set bit.
	/*
	 * Get parent : 1. 2's complement 2. AND with the original number 3.
	 * Subtract from original number
	 */
	private int getSum(int[] bitree, int index) {
		int sum = 0;

		index++;

		while (index > 0) {
			sum += bitree[index];

			// Move index to parent node
			index -= index & (-index);
		}
		return sum;
	}

	private int[] constructBITree(int[] freq, int n) {
		int[] bitree = new int[n + 1];

		for (int i = 0; i < n; i++) {
			updateBIT(bitree, n, i, freq[i]);
		}
		return bitree;
	}

	/*
	 * Next Affected Node : 1. 2's complement 2. AND with the original number 3.
	 * Add from original number
	 */
	private void updateBIT(int[] bitree, int n, int i, int val) {
		int index = i + 1;

		while (index <= n) {
			bitree[index] += val;

			// Update index to that of parent
			index += (index & -index);
		}
	}
}
