package com.pkgS;

import java.util.HashMap;

/**
 * http://www.geeksforgeeks.org/find-the-largest-subarray-with-0-sum/
 * http://www.geeksforgeeks.org/find-if-there-is-a-subarray-with-0-sum/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P18 {

	public static void main(String[] args) {
		int[] arr = { 4, 2, -3, 1, 6 };

		P18 test = new P18();
		boolean status = test.printZeroSumSubarray(arr);

		if (status)
			System.out.println("Found a subarray with 0 sum");
		else
			System.out.println("No Subarray with 0 sum");

		int arr1[] = { 15, -2, 2, -8, 1, 7, 10, 23 };
		System.out.println("Length of the longest 0 sum subarray is "
				+ test.maxLen(arr));
	}

	private int maxLen(int[] arr) {

		HashMap<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int maxlen = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (arr[i] == 0) {
				maxlen = Math.max(maxlen, 1);
			}

			if (sum == 0) {
				maxlen = Math.max(maxlen, i + 1);
			}

			Integer val = map.get(sum);
			if (val != null) {
				maxlen = Math.max(maxlen, i - val);
			} else
				map.put(sum, i);
		}

		return maxlen;
	}

	private boolean printZeroSumSubarray(int[] arr) {

		HashMap<Integer, Integer> map = new HashMap<>();

		int sum = 0;
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];

			if (arr[i] == 0 || sum == 0 || map.get(sum) != null) {
				return true;
			}

			map.put(sum, i);
		}
		return false;
	}
}
