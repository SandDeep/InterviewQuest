package com.rough;

public class P48 {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 2, 7, 9, 11 };

		P48 test = new P48();
		int[] segement = test.constructST(arr, arr.length);

		int qs = 3;
		int qe = 5;

		System.out.println(test.RMQ(segement, arr.length, qs, qe));
	}

	private int RMQ(int[] segement, int n, int qs, int qe) {
		if (qs < 0 || qe > n - 1) {
			System.out.println("Invalid Input.");
			return -1;
		}

		return RmqUtil(segement, 0, n - 1, qs, qe, 0);
	}

	private int RmqUtil(int[] segement, int ss, int se, int qs, int qe, int si) {
		if (ss >= qs && se <= qe) {
			return segement[si];
		}

		if (ss > qe || se < qs) {
			return Integer.MAX_VALUE;
		}

		int mid = ss + (se - ss) / 2;

		return Math.min(
				RmqUtil(segement, ss, mid, qs, qe, 2 * si + 1),
				RmqUtil(segement, mid + 1, se, qs, qe, 2 * si + 2)
				);
	}

	private int[] constructST(int[] arr, int n) {

		int size = (int) (2 * Math.pow(2, Math.ceil(Math.log(n) / Math.log(2))) - 1);
		int[] segment = new int[size];

		constructSTUtil(arr, 0, n - 1, segment, 0);
		return segment;
	}

	private int constructSTUtil(int[] arr, int ss, int se, int[] segment, int si) {

		if (ss == se) {
			segment[si] = arr[ss];
			return segment[si];
		}

		int mid = ss + (se - ss) / 2;

		segment[si] = Math.min(
				constructSTUtil(arr, ss, mid, segment, 2 * si + 1),
				constructSTUtil(arr, mid + 1, se, segment, 2 * si + 2));
		return segment[si];
	}
}
