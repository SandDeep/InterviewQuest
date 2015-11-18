package com.pattern;

public class Wildcard {

	public static void main(String[] args) {
		test("g*ks", "geeks"); // Yes
		/*test("ge?ks*", "geeksforgeeks"); // Yes
		test("g*k", "gee"); // No because 'k' is not in second
		test("*pqrs", "pqrst"); // No because 't' is not in first
		test("abc*bcd", "abcdhghgbcd"); // Yes
		test("abc*c?d", "abcd"); // No because second must have 2 instances of
									// 'c'
		test("*c*d", "abcd"); // Yes
		test("*?c*d", "abcd");*/
	}

	private static void test(String patArr, String txtArr) {
		char[] pat = patArr.toCharArray();
		char[] txt = txtArr.toCharArray();
		int M = pat.length;
		int N = txt.length;

		for (int i = 0; i <= N - M; i++) {
			int j = 0;
			for (j = 0; j < M; j++) {

				if (txt[i] == pat[j]) {
					i++;
					continue;
				}
				if (pat[j] == '?') {
					i++;
					continue;
				}
				if (pat[j] == '*') {
					while (txt[i] != pat[j+1] && j < M) {
						i++;
					}
					if (j == M) {
						System.out.println("Pattern Not Found");
						break;
					}
				}
			}
			if (j == M - 1) {
				System.out.println("Pattern Found : " + Math.abs(i - j));
			}
		}
	}
}
