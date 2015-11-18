package com.pkg4;

import java.util.Arrays;

public class ArrayRotation {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
		int d = 2;

		// int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		// int d = 3;

		ArrayRotation rotation = new ArrayRotation();

		System.out.println(Arrays.toString(arr));

		// rotation.method1(arr, d);
		// rotation.method2(arr, d);
		// rotation.method3(arr, d);
		rotation.method4(arr, d);
	}

	/**
	 * Reversal algorithm : Time Complexity: O(n)
	 * 
	 * @param arr
	 * @param d
	 */
	public void method4(int[] arr, int d) {
		// Reverse [0-->d-1]
		reverse(arr, 0, d - 1);

		// Reverse [d --> n-1]
		reverse(arr, d, arr.length - 1);

		// Reverse all
		reverse(arr, 0, arr.length - 1);
	}

	public void reverse(int[] arr, int i, int j) {
		int mid = i + (j - i) / 2;

		for (int k = i; k <= mid; k++) {
			swap(arr, i, j);
			i++;
			j--;
		}
		System.out.println(Arrays.toString(arr));
	}

	private void swap(int[] arr, int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}

	/**
	 * A Juggling Algorithm : Time complexity: O(n) Auxiliary Space: O(1)
	 * 
	 * @param arr
	 * @param d
	 */
	public void method3(int[] arr, int d) {
		int gcd = findGCD(arr.length, d);
		System.out.println(gcd);

		for (int i = 0; i < gcd; i++) {
			leftRotateByN(arr, gcd, i);
		}
	}

	private void leftRotateByN(int[] arr, int gcd, int index) {
		int temp = arr[index];
		int i;

		for (i = index; i < arr.length - gcd;) {
			arr[i] = arr[i + gcd];
			i = i + gcd;
		}
		arr[i] = temp;
		System.out.println(Arrays.toString(arr));
	}

	public int findGCD(int a, int b) {
		if (b == 0)
			return a;
		else
			return findGCD(b, a % b);
	}

	/**
	 * Time complexity: O(n*d) Auxiliary Space: O(1)
	 * 
	 * @param arr
	 * @param d
	 */
	public void method2(int[] arr, int d) {
		leftRotate(arr, d);
	}

	private void leftRotate(int[] arr, int d) {
		for (int i = 0; i < d; i++) {
			int j = 0;
			int temp = arr[j];
			for (j = 0; j < arr.length - 1; j++) {
				arr[j] = arr[j + 1];
			}
			arr[j] = temp;
			System.out.println(Arrays.toString(arr));
		}

	}

	/**
	 * Time complexity O(n) Auxiliary Space: O(d)
	 * 
	 * @param arr
	 * @param d
	 */
	public void method1(int[] arr, int d) {
		int[] temp = new int[d];

		// Storing Temp values
		for (int i = 0; i < temp.length; i++) {
			temp[i] = arr[i];
		}

		// Shifting by d
		for (int i = 0; i < arr.length - d; i++) {
			arr[i] = arr[i + d];
		}

		for (int i = d, j = 0; i > 0; i--, j++) {
			arr[arr.length - i] = temp[j];
		}

		System.out.println(Arrays.toString(arr));
	}
}
