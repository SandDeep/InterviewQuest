package com.rough;

import java.util.Arrays;

public class P28 {

	final int SIZE = 256;

	public static void main(String[] args) {
		P28 test = new P28();

		char mask[] = "mask".toCharArray();
		char str[] = "geeksforgeeks".toCharArray();
		test.removeDirtyChars(mask, str);

		// int arr[] = { 5, 20, 3, 2, 50, 80 };
		// int n = 78;

		int arr[] = { 1, 8, 30, 40, 100 };
		int n = 60;
		test.findPair(arr, n);

		int num[] = { 5, 34, 78, 2, 45, 1, 99, 23 };
		test.printTwoMaxNumbers(num);

		test.printExcelColumn(677);
	}

	private void printTwoMaxNumbers(int[] arr) {
		int max = arr[0];
		int secMax = arr[1];

		if (arr[0] < arr[1]) {
			max = arr[1];
			secMax = arr[0];
		}

		for (int i = 2; i < arr.length; i++) {
			/*
			 * if (arr[i] > max && arr[i] > secMax) { secMax = max; max =
			 * arr[i]; } else if (arr[i] < max && arr[i] > secMax) { secMax =
			 * arr[i]; }
			 */

			if (max < arr[i]) {
				secMax = max;
				max = arr[i];
			} else if (secMax < arr[i]) {
				secMax = arr[i];
			}
		}
		System.out.println("First Max Number: " + max);
		System.out.println("Second Max Number: " + secMax);
	}

	private void printExcelColumn(int n) {

		StringBuffer str = new StringBuffer();

		while (n > 0) {
			int rem = (n - 1) % 26;
			char x = (char) (rem + 'A');
			str.append(x);
			n = (n-1) / 26;
		}
		
		System.out.println(str.reverse());
	}

	private void findPair(int[] arr, int diff) {
		if (arr.length < 1) {
			return;
		}

		Arrays.sort(arr);
		int i = 0;
		int j = 1;

		while (i < arr.length && j < arr.length) {
			int temp = arr[j] - arr[i];

			if (i != j && temp == diff) {
				System.out.println("\nPair : [ " + arr[i] + " , " + arr[j]
						+ " ]");
				return;
			}

			else if (temp < diff) {
				j++;
			} else {
				i++;
			}
		}
		System.out.println("No Solution Exist.");
	}

	private void removeDirtyChars(char[] mask, char[] str) {
		int mPtr = 0;
		int index = 0;

		int[] count = new int[SIZE];
		countMaskArr(mask, count);

		while (mPtr < str.length) {
			char temp = str[mPtr];

			if (count[temp] == 0) {
				str[index++] = temp;
			}
			mPtr++;
		}

		for (int i = 0; i < index; i++) {
			System.out.print(str[i]);
		}
	}

	private void countMaskArr(char[] mask, int[] count) {
		for (int i = 0; i < mask.length; i++) {
			count[mask[i]] += 1;
		}
	}
}
