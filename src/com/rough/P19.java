package com.rough;

import java.util.Arrays;

public class P19 {

	public static void main(String[] args) {
		int[] arr = { 7, 2, 1, 6, 8, 5, 3, 4 };
		// int[] arr = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };

		P19 test = new P19();

		System.out.println(Arrays.toString(arr));
		test.heapSort(arr);
		System.out.println(Arrays.toString(arr));

		int mat[][] = { { 10, 20, 30, 40 }, { 15, 25, 35, 45 },
				{ 27, 29, 37, 48 }, { 32, 33, 39, 50 }, };
		test.printMatrix(mat);
		test.sortMatrix(mat);
	}

	private void sortMatrix(int[][] mat) {
		int ROW = mat.length;
		int COL = mat[0].length;

		int[] index = new int[ROW];

		int[] arr = new int[ROW];

	}

	private void heapSort(int[] arr) {
		int size = arr.length;

		heapify(arr, size);

		for (int i = size; i > 1;) {
			swap(arr, 0, i - 1);
			i--;
			heapify(arr, i);
		}
	}

	private void heapify(int[] arr, int size) {
		int n = size / 2 - 1;

		for (int i = n; i >= 0; i--) {
			minHeapify(arr, i, size);
		}
	}

	private void minHeapify(int[] arr, int i, int size) {

		int lChildIndex = 2 * i + 1;
		int rChildIndex = 2 * i + 2;

		if (lChildIndex <= size - 1 && rChildIndex <= size - 1) {
			int minIndex = i;

			if (arr[lChildIndex] < arr[minIndex]) {
				minIndex = lChildIndex;
			}

			if (arr[rChildIndex] < arr[minIndex]) {
				minIndex = rChildIndex;
			}

			if (minIndex != i) {
				swap(arr, minIndex, i);
				minHeapify(arr, minIndex, size);
			}
		} else if (lChildIndex <= size - 1 && rChildIndex >= size - 1) {
			if (arr[lChildIndex] < arr[i]) {
				swap(arr, lChildIndex, i);
			}
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	private void printMatrix(int[][] arr) {
		int ROW = arr.length;
		int COL = arr[0].length;

		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
