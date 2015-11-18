package com.pkg4;

import java.util.Arrays;

/**
 * Given an unsorted array of integers, sort the array into a wave like array.
 * An array ‘arr[0..n-1]’ is sorted in wave form if arr[0] >= arr[1] <= arr[2]
 * >= arr[3] <= arr[4] >= …..
 * 
 * @author Deepesh
 * 
 */
public class WaveForm {

	public static void main(String[] args) {

		int[] num = { 10, 90, 49, 2, 1, 5, 23 };

		System.out.println(Arrays.toString(num));
		WaveForm form = new WaveForm();
		form.sortWaveForm(num);
		System.out.println(Arrays.toString(num));
	}

	/**
	 * simple steps. 1) Traverse all even positioned elements of input array,
	 * and do following. ….a) If current element is smaller than previous
	 * element, swap previous and current. ….b) If current element is smaller
	 * than next element, swap next and current.
	 * 
	 * @param num
	 */
	private void sortWaveForm(int[] num) {

		for (int i = 0; i < num.length;) {

			if ((i > 1) && num[i] < num[i - 1]) {
				swap(num, i, i - 1);
			}

			if ((i < num.length - 1) && (num[i] < num[i + 1])) {
				swap(num, i, i + 1);
			}

			i += 2;
		}
	}

	private void swap(int[] arr, int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}
}
