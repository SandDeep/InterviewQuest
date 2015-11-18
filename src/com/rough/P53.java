package com.rough;


/**
 * http://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
 * @author Deepesh.Maheshwari
 *
 */
public class P53 {

	static char[] str = new char[100];

	public static void main(String[] args) {

		P53 test = new P53();
		test.printParenthesis(3);
	}

	private void printParenthesis(int n) {
		if (n > 0) {
			printParenthesisUtil(0, n, 0, 0);
		}
	}

	private void printParenthesisUtil(int pos, int n, int open, int close) {

		if (close == n) {
			System.out.println(printChar(str));
			return;
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

	private String printChar(char[] str) {
		String res = "";

		for (int i = 0; i < str.length; i++) {
			if (str[i] == ' ') {
				break;
			}
			res += str[i] + " ";
		}
		return res;
	}
}
