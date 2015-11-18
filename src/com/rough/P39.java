package com.rough;

import java.util.Arrays;
import java.util.Random;

public class P39 {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

		P39 test = new P39();
		System.out.println(Arrays.toString(arr));
		test.shuffle(arr, arr.length);

		int gcd = test.findGCD(98, 56);
		System.out.println("GCD : " + gcd);

		int stream[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12 };
		test.selectKItems(stream, stream.length, 5);
	}

	private void selectKItems(int[] stream, int n, int k) {
		int arr[] = new int[k];

		for (int i = 0; i < k; i++) {
			arr[i] = stream[i];
		}

		Random random = new Random();
		for (int i = k; i < n; i++) {
			int index = random.nextInt(n);

			if (index < k) {
				 arr[index]=stream[i];
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}

	/**
	 * The idea is, GCD of two numbers doesn’t change if smaller number is
	 * subtracted from a bigger number.
	 * 
	 * @return
	 */
	private int findGCD(int a, int b) {
		if (a == b) {
			return a;
		}
		if (a > b) {
			return findGCD(a - b, b);
		}
		return findGCD(a, b - a);
	}

	private void shuffle(int[] arr, int n) {

		Random random = new Random();
		for (int i = n - 1; i > 0; i--) {
			int j = random.nextInt(i);
			swap(arr, i, j);
		}
		System.out.println(Arrays.toString(arr));
	}

	public void swap(int[] arr, int mIndex, int nIndex) {
		int temp = arr[mIndex];
		arr[mIndex] = arr[nIndex];
		arr[nIndex] = temp;
	}
}
