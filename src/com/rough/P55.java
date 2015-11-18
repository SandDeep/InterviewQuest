package com.rough;

/**
 * http://www.geeksforgeeks.org/given-two-sorted-arrays-number-x-find-pair-whose
 * -sum-closest-x/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P55 {

	public static void main(String[] args) {
		int arr1[] = { 1, 4, 5, 7 };
		int arr2[] = { 10, 20, 30, 40 };
		int k = 32;

		P55 test = new P55();
		test.findClosestPair(arr1, arr2, k);
		
		//int arr[] = {1, 6, 4, 10, 2, 5};
	}

	private void findClosestPair(int[] arr1, int[] arr2, int k) {
		int l = 0, i = 0;
		int r = arr2.length - 1, j = arr2.length - 1;
		int min = Integer.MAX_VALUE;

		while (i < arr1.length && j >= 0) {
			int diff = arr2[j] + arr1[i] - k;

			if (Math.abs(diff) < min) {
				min = Math.abs(diff);
				l = i;
				r = j;
			}

			if (diff == 0) {
				break;
			}

			if (diff < 0) {
				i++;
			} else {
				j--;
			}
		}

		System.out.println(min);
		System.out.println(l + "  " + r);
	}
}
