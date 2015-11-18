package com.pkgS;

import java.util.HashMap;
import java.util.Map;

public class P4 {

	public static void main(String[] args) {
		int arr[] = { 1, 9, 3, 10, 4, 20, 2 };

		P4 test = new P4();
		int lcs = test.findLCS(arr, arr.length);
		System.out.println("Longest Consecutive Subsequence : " + lcs);
	}

	private int findLCS(int[] arr, int n) {
		Map<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			map.put(arr[i], true);
		}

		int res = 1;

		for (int i = 0; i < arr.length; i++) {

			// Starting Point
			if (map.get(arr[i] - 1) == null) {

				int j = arr[i];
				int count = 0;
				while (map.get(j) != null) {
					count++;
					j++;
				}

				if (res < count) {
					res = count;
				}
			}
		}

		return res;
	}
}
