package com.pkg2;

import java.util.Arrays;
import java.util.Random;

/**
 * Average case complexity of Quicksort is O(n log(n)) and worst case complexity
 * of Quicksort is O(n²).Quicksort algorithm can be implemented in-place, which
 * means no additional space will be required. This makes it suitable to sort
 * large array of numbers.
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] arr = { 7, 2, 1, 6, 8, 5, 3, 4 };
		//int[] arr = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * Arrays.sort() method in Java use quicksort to sort array of primitives
	 * e.g. array of integers or float and uses Mergesort to sot objects e.g.
	 * array of String.
	 * 
	 * @param arr
	 * @param start
	 * @param end
	 */
	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int pivotIndex = partition(arr, start, end);
			quickSort(arr, start, pivotIndex - 1);
			quickSort(arr, pivotIndex + 1, end);
		}
	}

	public static int partition(int[] arr, int start, int end) {
		int pIndex = start;
		int pivot = arr[end];

		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				swap(arr, i, pIndex);
				pIndex++;
			}
		}

		// swap pIndex with pivot[last element]
		swap(arr, end, pIndex);

		return pIndex;
	}

	public static int RandomPartition(int[] arr, int start, int end) {
		// int pivotIndex = (int) (start + (Math.random() * end));

		Random random = new Random();
		int pivotIndex = random.nextInt(end - start) + start;
		swap(arr, end, pivotIndex);

		int pIndex = start;
		int pivot = arr[end];

		for (int i = 0; i < end; i++) {
			if (arr[i] <= pivot) {
				swap(arr, i, pIndex);
				pIndex++;
			}
		}

		// swap pIndex with pivot[last element]
		swap(arr, end, pIndex);

		return pIndex;
	}

	public static void swap(int[] arr, int mIndex, int nIndex) {
		int temp = arr[mIndex];
		arr[mIndex] = arr[nIndex];
		arr[nIndex] = temp;
	}
}
