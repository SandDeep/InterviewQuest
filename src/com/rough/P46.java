package com.rough;

/**
 * http://www.geeksforgeeks.org/mobile-numeric-keypad-problem/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P46 {

	public static void main(String[] args) {
		char keypad[][] = { { '1', '2', '3' }, { '4', '5', '6' },
				{ '7', '8', '9' }, { '*', '0', '#' } };
		P46 test = new P46();
		int count=0;
		count = test.getCount(keypad, 3);
		System.out.println("\nCount for numbers of length " + 3 + " : " + count);

		count = test.getCountDP(keypad, 50);
		System.out
				.println("\nCount for numbers of length " + 3 + " : " + count);
	}

	private int getCountDP(char[][] keypad, int n) {
		if (keypad == null || n <= 0) {
			return 0;
		}

		if (n == 1) {
			return 10;
		}

		int row[] = { 0, 0, -1, 0, 1 };
		int col[] = { 0, -1, 0, 1, 0 };

		int count[][] = new int[10][n + 1];

		// Number start with from any of ten position and length 0 || 1
		for (int i = 0; i <= 9; i++) {
			count[i][0] = 0;
			count[i][1] = 1;
		}

		for (int k = 2; k <= n; k++) {
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 3; j++) {
					if (keypad[i][j] != '*' && keypad[i][j] != '#') {
						int num = keypad[i][j] - '0';
						count[num][k] = 0;

						for (int move = 0; move < 5; move++) {
							int ro = i + row[move];
							int co = j + col[move];

							if (ro >= 0 && ro <= 3 && co >= 0 && co <= 2
									&& keypad[ro][co] != '*'
									&& keypad[ro][co] != '#') {
								int nextNum = keypad[ro][co] - '0';
								count[num][k] += count[nextNum][k - 1];
							}
						}
					}
				}
			}
		}

		int totalCount = 0;
		for (int i = 0; i < 10; i++) {
			totalCount += count[i][n];
		}
		return totalCount;
	}

	private int getCount(char[][] keypad, int N) {
		int row = keypad.length;
		int col = keypad[0].length;

		int count = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (keypad[i][j] != '*' && keypad[i][j] != '#') {
					count += getCountUtil(keypad, i, j, N, "");
				}
			}
		}
		return count;
	}

	private int getCountUtil(char[][] keypad, int i, int j, int N, String str) {
		int row = keypad.length - 1;
		int col = keypad[0].length - 1;

		// Out of Bound
		if (i < 0 || i > row || j < 0 || j > col || keypad[i][j] == '*'
				|| keypad[i][j] == '#') {
			return 0;
		}

		str = str + keypad[i][j];
		if (N == 1) {
			System.out.print(str + " ");
			return 1;
		}

		int count = 0;

		int R[] = { 0, 0, -1, 0, 1 };
		int C[] = { 0, -1, 0, 1, 0 };

		for (int move = 0; move < 5; move++) {
			count += getCountUtil(keypad, i + R[move], j + C[move], N - 1, str);
		}

		/*
		 * count += getCountUtil(keypad, i, j, N - 1, str); count +=
		 * getCountUtil(keypad, i + 1, j, N - 1, str); count +=
		 * getCountUtil(keypad, i - 1, j, N - 1, str); count +=
		 * getCountUtil(keypad, i, j + 1, N - 1, str); count +=
		 * getCountUtil(keypad, i, j - 1, N - 1, str);
		 */

		return count;
	}
}
