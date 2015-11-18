package com.pkg1;

/**
 * to find the sum of contiguous subarray within a one-dimensional array of
 * numbers which has the largest sum.
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class KadaneAlgo {

	public static void main(String[] args) {
		int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };

		int sum = getContSub(arr);
		System.out.println(sum);
	}

	/**
	 * For covering case of an array having all negative number,first check it
	 * and then find min of them.
	 * 
	 * @param arr
	 * @return
	 */
	private static int getContSub(int[] arr) {
		int maxSoFar = 0;
		int maxEndingHere = 0;

		for (int i = 0; i < arr.length; i++) {
			maxEndingHere += arr[i];
			if (maxEndingHere < 0) {
				maxEndingHere = 0;
			} else if (maxSoFar < maxEndingHere) {
				maxSoFar = maxEndingHere;
			}
		}
		return maxSoFar;
	}
}
