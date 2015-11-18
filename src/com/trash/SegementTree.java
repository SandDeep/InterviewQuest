package com.trash;

import java.util.Arrays;

public class SegementTree {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 7, 9, 11 };

		SegementTree tree = new SegementTree();
		int[] seg = tree.constructST(arr);
		System.out.println(Arrays.toString(seg));

		int sum = tree.getSum(arr, seg, 1, 3);
		System.out.println("Sum : " + sum);

		tree.updateValue(arr, seg, 1, 10);
		System.out.println("Updated Value : " + arr[1]);

		sum = tree.getSum(arr, seg, 1, 3);
		System.out.println("Sum : " + sum);
	}

	private void updateValue(int[] arr, int[] seg, int index, int value) {
		int N = arr.length;
		if (index < 0 || index > N - 1) {
			return;
		}

		int diff = value - arr[index];
		updateUtil(seg, 0, N - 1, index, diff, 0);
	}

	private void updateUtil(int[] seg, int ss, int se, int index, int diff,
			int i) {
		if (ss > index || se < index) {
			return;
		}

		seg[i] += diff;

		if (ss != se) {
			int mid = ss + (se - ss) / 2;
			updateUtil(seg, ss, mid, index, diff, 2 * i + 1);
			updateUtil(seg, mid + 1, se, index, diff, 2 * i + 2);
		}

	}

	private int getSum(int[] arr, int[] seg, int qs, int qe) {
		int N = arr.length;
		if (qs < 0 || qe > N - 1 || qs > qe) {
			return -1;
		}

		return getSumUtil(seg, 0, N - 1, qs, qe, 0);
	}

	private int getSumUtil(int[] seg, int ss, int se, int qs, int qe, int index) {
		if (ss >= qs && se <= qe) {
			return seg[index];
		}

		if (se < qs || ss > qe) {
			return 0;
		}

		int mid = ss + (se - ss) / 2;
		return getSumUtil(seg, ss, mid, qs, qe, 2 * index + 1)
				+ getSumUtil(seg, mid + 1, se, qs, qe, 2 * index + 2);
	}

	private int[] constructST(int[] arr) {

		int N = arr.length;
		int size = (int) (2 * Math.pow(2, Math.ceil(Math.log(N) / Math.log(2))) - 1);
		int[] seg = new int[size];

		costructUtil(arr, 0, N - 1, seg, 0);

		return seg;
	}

	private int costructUtil(int[] arr, int ss, int se, int[] seg, int i) {
		if (ss == se) {
			seg[i] = arr[ss];
			return seg[i];
		}

		if (ss > se) {
			return 0;
		}

		int mid = ss + (se - ss) / 2;
		seg[i] = costructUtil(arr, ss, mid, seg, 2 * i + 1)
				+ costructUtil(arr, mid + 1, se, seg, 2 * i + 2);
		return seg[i];
	}
}
