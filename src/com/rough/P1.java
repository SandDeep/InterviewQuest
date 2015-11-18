package com.rough;

import java.util.Arrays;
import java.util.Random;

public class P1 {

	public static void main(String[] args) {
		int[] arr = { 7, 2, 1, 6, 8, 5, 3, 4 };
		P1 p = new P1();
		System.out.println(Arrays.toString(arr));
		// p.quickSort(arr, 0, arr.length - 1);
		// p.mergeSort(arr, 0, arr.length - 1);
		// p.heapSort(arr, arr.length);
		// System.out.println(Arrays.toString(arr));

		int num = p.kthSmallest(arr, 0, arr.length - 1, 2);
		System.out.println("kthSmallest : " + num);
	}

	private int kthSmallest(int[] arr, int start, int end, int k) {
		if (k > 0 && k <= (end - start + 1)) {
			int pos = partition(arr, start, end);

			if (pos - start == k - 1) {
				return arr[pos];
			} else if (pos - start > k - 1) {
				return kthSmallest(arr, start, pos - 1, k);
			} else {
				return kthSmallest(arr, pos + 1, end, k - pos - 1 + start);
			}
		}

		return Integer.MAX_VALUE;
	}

	public void heapSort(int[] arr, int size) {

		heapify(arr, size);

		for (int i = size - 1; i > 0; i--) {
			swap(arr, i, 0);
			size = size - 1;
			heapify(arr, size);
		}
	}

	private void heapify(int[] arr, int size) {
		int index = size / 2 - 1;
		int lastIndex = size - 1;

		for (int i = index; i >= 0; i--) {
			minHeapify(arr, i, lastIndex);
		}
	}

	private void minHeapify(int[] arr, int start, int end) {
		int leftChild = 2 * start + 1;
		int rightChild = 2 * start + 2;

		if (leftChild <= end && rightChild <= end) {

			int minIndex = start;

			if (arr[minIndex] > arr[leftChild]) {
				minIndex = leftChild;
			}
			if (arr[minIndex] > arr[rightChild]) {
				minIndex = rightChild;
			}

			if (minIndex != start) {
				swap(arr, minIndex, start);
				minHeapify(arr, minIndex, end);
			}
		} else if (leftChild <= end && rightChild > end) {

			if (arr[start] > arr[leftChild]) {
				swap(arr, leftChild, start);
			}
		}

	}

	public void mergeSort(int[] arr, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int mid = startIndex + (endIndex - startIndex) / 2;
			mergeSort(arr, startIndex, mid);
			mergeSort(arr, mid + 1, endIndex);

			merge(arr, startIndex, mid, endIndex);
		}
	}

	public void merge(int[] arr, int start, int mid, int end) {
		int temp[] = new int[arr.length];
		int x = start;
		int y = mid + 1;
		int index = start;

		while (x <= mid && y <= end) {
			if (arr[x] <= arr[y]) {
				temp[index] = arr[x];
				x++;
			} else {
				temp[index] = arr[y];
				y++;
			}
			index++;
		}

		while (x <= mid) {
			temp[index++] = arr[x++];
		}
		while (y <= end) {
			temp[index++] = arr[y++];
		}

		for (int l = start; l <= end; l++) {
			arr[l] = temp[l];
		}
	}

	public void quickSort(int[] arr, int startIndex, int endIndex) {
		if (startIndex < endIndex) {
			int pIndex = partition(arr, startIndex, endIndex);
			quickSort(arr, startIndex, pIndex - 1);
			quickSort(arr, pIndex + 1, endIndex);
		}
	}

	public int partition(int[] arr, int startIndex, int endIndex) {
		int pivot = arr[endIndex];
		int pIndex = startIndex;

		for (int i = startIndex; i < endIndex; i++) {
			if (pivot > arr[i]) {
				swap(arr, pIndex, i);
				pIndex++;
			}
		}

		swap(arr, pIndex, endIndex);

		return pIndex;
	}

	public int Rpartition(int[] arr, int startIndex, int endIndex) {

		Random random = new Random();
		int pivotIndex = random.nextInt(endIndex - startIndex) + startIndex;
		swap(arr, pivotIndex, endIndex);

		int pivot = arr[endIndex];
		int pIndex = startIndex;

		for (int i = startIndex; i < endIndex; i++) {
			if (pivot > arr[i]) {
				swap(arr, pIndex, i);
				pIndex++;
			}
		}

		swap(arr, pIndex, endIndex);

		return pIndex;
	}

	public void swap(int[] arr, int x, int y) {
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
}
