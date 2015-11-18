package com.pkg1;

import java.util.Arrays;

public class ClosestPair {

	public static void main(String[] args) {
		int ar1[] = { 1, 4, 5, 7 };
		int ar2[] = { 10, 20, 30, 40 };
		int x = 50;

		int[] merge = new int[ar1.length + ar2.length];
		int[] status = new int[ar1.length + ar2.length];

		mergeArray(ar1, ar2, merge, status);
		System.out.println("Merge Array : " + Arrays.toString(merge));
		System.out.println("Status Array : " + Arrays.toString(status));

		findPair(merge, status, x);
	}

	private static void findPair(int[] merge, int[] status, int k) {
		int l = 0;
		int r = merge.length - 1;

		int resultX1 = 0;
		int resultX2 = 0;

		int diff = Integer.MAX_VALUE;

		while (l < r) {
			if (Math.abs(merge[l] + merge[r] - k) < diff) {
				if (status[l] != status[r]) {
					resultX1 = l;
					resultX2 = r;
					diff = Math.abs(merge[l] + merge[r] - k);
				}

			}

			if (merge[l] + merge[r] < k) {
				l++;
			} else {
				r--;
			}
		}

		System.out.println(merge[resultX1] + " : " + merge[resultX2]);
	}

	private static void mergeArray(int[] ar1, int[] ar2, int[] merge,
			int[] status) {
		int m = ar1.length;
		int n = ar2.length;
		int i = 0;
		int j = 0;

		int index = 0;

		while (i < m && j < n) {

			if (ar1[i] <= ar2[j]) {
				merge[index] = ar1[i];
				status[index] = 1;
				index++;
				i++;
			} else {
				merge[index] = ar2[j];
				status[index] = 2;
				index++;
				j++;
			}

		}

		while (i < m) {
			merge[index] = ar1[i];
			status[index] = 1;
			i++;
			index++;
		}

		while (j < n) {
			merge[index] = ar2[j];
			status[index] = 2;
			index++;
			j++;
		}
	}
}
