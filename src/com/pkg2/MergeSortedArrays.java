package com.pkg2;

/**
 * Complexity : nk(complexity to traverse elements) * logk (heapify a elements)
 * : nklogk
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class MergeSortedArrays {

	public static void main(String[] args) {

		int k = 3;
		int n = 4;
		int arr[][] = { { 1, 3, 5, 7 }, { 2, 4, 6, 8 }, { 0, 9, 10, 11 } };

		int output[][] = new int[k][n];

		merge(output, arr, k, n);

	}

	private static void merge(int[][] output, int[][] arr, int k, int n) {
		int[] index = new int[k];
		int[] heap = new int[k];

		int size = 0;

		for (int i = 0; i < heap.length; i++) {
			heap[i] = arr[i][size];
			index[i] += 1;
		}
		size++;

		for (int i = size; i < heap.length; i++) {

		}

		System.out.println();

	}
}
