package com.pkg2;

import java.util.Arrays;

/**
 * Complexity : Best case = Avg case = Worst case = O(n logn)
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		// int[] arr = { 7, 2, 1, 6, 8, 5, 3, 4 };
		// int[] arr = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
		// int[] arr = { 5, 3, 17, 10, 84, 19, 6, 22, 9 };
		int[] arr = { 84, 22, 19 };

		System.out.println(Arrays.toString(arr));
		heapSort(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void heapSort(int[] arr) {
		int size = arr.length;

		heapify(arr, size);

		for (int i = size - 1; i > 0; i--) {
			// System.out.println(arr[0]);
			swap(arr, 0, i);
			size = size - 1;
			heapify(arr, size);
		}
	}

	private static void heapify(int[] arr, int size) {

		int index = (size / 2) - 1;
		int lastIndex = size - 1;

		for (int i = index; i >= 0; i--) {
			maxHeapify(arr, i, lastIndex);
			//minHeapify(arr, i, lastIndex);
		}
	}

	public static void maxHeapify(int[] arr, int i, int lastIndex) {

		int lChildIndex = 2 * (i + 1) - 1;
		int rChildIndex = 2 * (i + 1) + 1 - 1;

		if ((lChildIndex <= lastIndex) && (rChildIndex <= lastIndex)) {

			int lChild = arr[lChildIndex];
			int rChild = arr[rChildIndex];

			int maxIndex = i;

			if (lChild > arr[i]) {
				maxIndex = lChildIndex;
			}

			if (rChild > arr[maxIndex]) {
				maxIndex = rChildIndex;
			}

			if (maxIndex != i) {
				swap(arr, i, maxIndex);
				maxHeapify(arr, maxIndex, lastIndex);
			}
		}

		// In case there is only one left child and no right child
		else if ((rChildIndex > lastIndex) && (lChildIndex <= lastIndex)) {
			int lChild = arr[lChildIndex];

			if (arr[i] < lChild) {
				swap(arr, i, lChildIndex);
			}
		}

	}

	public static void minHeapify(int[] arr, int i, int lastIndex) {

		int lChildIndex = 2 * (i + 1) - 1;
		int rChildIndex = 2 * (i + 1) + 1 - 1;

		if ((lChildIndex <= lastIndex) && (rChildIndex <= lastIndex)) {

			int lChild = arr[lChildIndex];
			int rChild = arr[rChildIndex];

			int minIndex = i;

			if (lChild < arr[i]) {
				minIndex = lChildIndex;
			}

			if (rChild < arr[minIndex]) {
				minIndex = rChildIndex;
			}

			if (minIndex != i) {
				swap(arr, i, minIndex);
				minHeapify(arr, minIndex, lastIndex);
			}
		}

		// In case there is only one left child and no right child
		else if ((rChildIndex > lastIndex) && (lChildIndex <= lastIndex)) {
			int lChild = arr[lChildIndex];

			if (arr[i] > lChild) {
				swap(arr, i, lChildIndex);
			}
		}

	}

	private static void swap(int[] arr, int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}
}
