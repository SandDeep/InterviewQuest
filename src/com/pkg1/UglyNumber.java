package com.pkg1;

/**
 * Ugly numbers are numbers whose only prime factors are 2, 3 or 5. The sequence
 * 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, … shows the first 11 ugly numbers.
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class UglyNumber {

	public static void main(String[] args) {
		int n = 100;
		long cureent = System.currentTimeMillis();
		// int num = getNthUglyNumber(n);
		int num = getUglyNumber(n);
		System.out
				.println(num + " : " + (System.currentTimeMillis() - cureent));
	}

	/**
	 * Algorithmic Paradigm: Dynamic Programming[Tabulation (Bottom Up)] Time
	 * Complexity: O(n) Storage Complexity: O(n)
	 * 
	 * @param n
	 * @return
	 */
	public static int getUglyNumber(int n) {
		int[] ugly = new int[n];
		ugly[0] = 1;
		int i2 = 0;
		int i3 = 0;
		int i5 = 0;

		for (int i = 1; i < n; i++) {

			int nextmultiple2 = ugly[i2] * 2;
			int nextmultiple3 = ugly[i3] * 3;
			int nextmultiple5 = ugly[i5] * 5;

			ugly[i] = Math.min(nextmultiple2,
					Math.min(nextmultiple3, nextmultiple5));

			if (nextmultiple2 == ugly[i]) {
				i2++;
			}
			if (nextmultiple3 == ugly[i]) {
				i3++;
			}
			if (nextmultiple5 == ugly[i]) {
				i5++;
			}
		}

		return ugly[n - 1];
	}

	public static int getNthUglyNumber(int n) {
		int count = 1;
		int i = 1;

		while (count < n) {
			i++;

			if (isUgly(i) == 1) {
				count++;
			}

		}

		return i;
	}

	public static int isUgly(int i) {
		int num = i;
		num = divisble(num, 2);
		num = divisble(num, 3);
		num = divisble(num, 5);

		return (num == 1) ? 1 : 0;
	}

	public static int divisble(int num, int i) {
		while (num % i == 0) {
			num = num / i;
		}
		return num;
	}
}
