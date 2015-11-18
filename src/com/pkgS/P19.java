package com.pkgS;

public class P19 {

	static char[] str = new char[100];
	static String expr = "";

	public static void main(String[] args) {
		// String expr = "1*2+3*4";

		P19 test = new P19();
		int n = 15;
		test.printParenthesis(n);
	}

	private void printParenthesis(int n) {
		if (n > 0) {
			printParenthesisUtil(0, n, 0, 0);
		}
	}

	private void printParenthesisUtil(int pos, int n, int open, int close) {
		if (close == n) {
			printArray(n);
		} else {
			if (open > close) {
				str[pos] = '}';
				printParenthesisUtil(pos + 1, n, open, close + 1);
			}
			if (open < n) {
				str[pos] = '{';
				printParenthesisUtil(pos + 1, n, open + 1, close);
			}
		}
	}

	private void printArray(int n) {
		for (int i = 0; i < 2 * n; i++) {
			System.out.print(str[i] + " ");
		}
		System.out.println();
	}
}
