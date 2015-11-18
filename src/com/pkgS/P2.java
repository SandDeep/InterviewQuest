package com.pkgS;

public class P2 {

	public static void main(String[] args) {
		char[] digits = "121".toCharArray();
		P2 test = new P2();

		int count = test.countDecoding(digits, digits.length);
		System.out.println(count);

		test.countDecodingDP(digits, digits.length);
	}

	private void countDecodingDP(char[] digits, int n) {
		int res[] = new int[n + 1];
		res[0] = 1;
		res[1] = 1;

		for (int i = 2; i <= n; i++) {
			if (digits[i - 1] > '0') {
				res[i] = res[i - 1];
			}

			if (digits[i - 2] == '1' || (digits[i - 2] == '2' && digits[i - 1] < '7')) {
				res[i] += res[i - 2];
			}
		}
		System.out.println(res[n]);
	}

	private int countDecoding(char[] digits, int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		int count = 0;

		if (digits[n - 1] > '0') {
			count = countDecoding(digits, n - 1);
		}

		if (digits[n - 2] == '1'
				|| (digits[n - 2] == '2' && digits[n - 1] < '7')) {
			count += countDecoding(digits, n - 2);
		}
		return count;
	}
}
