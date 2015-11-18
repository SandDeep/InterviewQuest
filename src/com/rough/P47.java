package com.rough;

public class P47 {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 7, 9, 11 };

		P47 test = new P47();
		int segment[] = test.constructST(arr, arr.length);

		System.out.println("Sum of values in given range : "
				+ test.getSum(segment, arr.length, 1, 3));

		test.updateVal(arr, segment, arr.length, 1, 10);
		System.out.println("Sum of values in given range : "
				+ test.getSum(segment, arr.length, 1, 3));
	}

	private void updateVal(int[] arr, int[] segment, int n, int i, int newVal) {
		if (i < 0 || i > n - 1) {
			System.out.println("Invalid Input.");
			return;
		}

		int diff = arr[i] - newVal;
		arr[i] = newVal;

		updateUtil(segment, 0, n - 1, i, diff, 0);
	}

	private void updateUtil(int[] segment, int ss, int se, int index, int diff,
			int si) {
		if (index < ss || index > se) {
			return;
		}

		segment[si] += diff;

		if (ss != se) {
			int mid = ss + (se - ss) / 2;

			updateUtil(segment, ss, mid, index, diff, 2 * si + 1);
			updateUtil(segment, mid + 1, se, index, diff, 2 * si + 2);
		}
	}

	private int getSum(int[] segment, int n, int qs, int qe) {
		if (qs < 0 || qe > n - 1 || qs > qe) {
			System.out.println("Invalid Input.");
			return -1;
		}

		return getSumUtil(segment, 0, n - 1, qs, qe, 0);
	}

	private int getSumUtil(int[] segment, int ss, int se, int qs, int qe, int si) {
		// if segment of this node is part of given range
		if (ss >= qs && se <= qe) {
			return segment[si];
		}

		if (ss > qe || se < qs) {
			return 0;
		}

		int mid = ss + (se - ss) / 2;

		return getSumUtil(segment, ss, mid, qs, qe, 2 * si + 1)
				+ getSumUtil(segment, mid + 1, se, qs, qe, 2 * si + 2);
	}

	private int[] constructST(int[] arr, int n) {
		int size = (int) (2 * Math.pow(2, Math.ceil(Math.log(n) / Math.log(2)))) - 1;
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
		segment[si] = constructSTUtil(arr, ss, mid, segment, 2 * si + 1)
				+ constructSTUtil(arr, mid + 1, se, segment, 2 * si + 2);
		return segment[si];
	}
}
