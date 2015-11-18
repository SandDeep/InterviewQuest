package com.pkgG;

import com.pkg2.HeapSort;

/**
 * Time Complexity: O(nLogn), assuming that a O(nLogn) sorting algorithm for
 * sorting arr[] and dep[].
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class Platforms {

	public static void main(String[] args) {
		int[] arr = { 900, 940, 950, 1100, 1500, 1800 };
		int[] dep = { 910, 1200, 1120, 1130, 1900, 2000 };

		int platforms = findPlatform(arr, dep);
		System.out.println("Minimum Platforms : " + platforms);
	}

	private static int findPlatform(int[] arr, int[] dep) {

		//MergeSort.mergeSort(arr, 0, arr.length - 1);
		// MergeSort.mergeSort(dep, 0, dep.length - 1);

		HeapSort.heapSort(arr);
		HeapSort.heapSort(dep);
		
		int platforms = 0;
		int minPlatform = 0;

		int i = 0;
		int j = 0;

		while (i < arr.length && j < dep.length) {

			if (arr[i] < dep[j]) {
				platforms++;
				if (platforms > minPlatform) {
					minPlatform = platforms;
				}
				i++;
			} else {
				platforms--;
				j++;
			}
		}
		return minPlatform;
	}
}
