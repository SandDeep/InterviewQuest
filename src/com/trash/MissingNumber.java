package com.trash;

/**
 * Time Complexity: O(n)
 * 
 * In method 1, if the sum of the numbers goes beyond maximum allowed integer,
 * then there can be integer overflow and we may not get correct answer. Method
 * 2 has no such problems.
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class MissingNumber {

	public static void main(String[] args) {
		int a[] = { 1, 2, 4, 5, 6 };
		// int missing = getMissingNumber(a);
		int missing = getXORMissingNumber(a);
		System.out.println(missing);
	}

	public static int getXORMissingNumber(int[] a) {
		/* For xor of all the elements in array */
		int x1 = a[0];

		for (int i = 1; i < a.length; i++) {
			x1 = x1 ^ a[i];
		}

		/* For xor of all the elements from 1 to n+1 */
		int x2 = 1;

		for (int i = 2; i <= a.length + 1; i++) {
			x2 = x2 ^ i;
		}

		return (x1 ^ x2);
	}

	public static int getMissingNumber(int[] a) {
		int N = a.length;

		int sumN = (N + 1) * (N + 2) / 2;

		int sum = 0;
		for (int i = 0; i < a.length; i++) {
			sum += a[i];
		}
		return sumN - sum;
	}
}
