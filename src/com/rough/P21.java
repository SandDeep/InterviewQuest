package com.rough;

public class P21 {

	public static void main(String[] args) {
		int n = 2, k = 10;
		int min = eggDrop(n, k);
		System.out.println(min);
	}

	private static int eggDrop(int n, int k) {
		if (k == 0 || k == 1) {
			return n;
		}

		if (n == 1) {
			return k;
		}

		int min = Integer.MAX_VALUE;
		int res = 0;

		for (int i = 1; i <= k; i++) {
			res = Math.max(eggDrop(n - 1, i - 1), eggDrop(n, k - i));
			if (res < min) {
				min = res;
			}
		}
		return min + 1;
	}
}
