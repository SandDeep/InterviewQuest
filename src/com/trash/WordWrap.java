package com.trash;

/**
 * http://www.geeksforgeeks.org/dynamic-programming-set-18-word-wrap/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class WordWrap {

	public static void main(String[] args) {
		// String line = "Geeks for Geeks presents word wrap problem";

		int l[] = { 3, 2, 2, 5 };
		int M = 6;
		WordWrap wrap = new WordWrap();
		wrap.solveWordWrap(l, l.length, M);
	}

	private void solveWordWrap(int[] l, int size, int M) {
		int[][] extras = new int[size + 1][size + 1];
		int[][] lc = new int[size + 1][size + 1];
		int c[] = new int[size + 1];
		int p[] = new int[size + 1];

		// Calculation of extra space
		for (int i = 1; i <= size; i++) {
			extras[i][i] = M - l[i - 1];
			for (int j = i + 1; j <= size; j++) {
				extras[i][j] = extras[i][j - 1] - l[j - 1];
			}
		}

		// Calculation of cost
		for (int i = 1; i <= size; i++) {
			for (int j = i; j <= size; j++) {
				if (extras[i][j] < 0) {
					lc[i][j] = Integer.MAX_VALUE;
				} else if (extras[i][j] >= 0 && j == size) {
					lc[i][j] = 0;
				} else {
					lc[i][j] = extras[i][j] * extras[i][j];
				}
			}
		}

		c[0] = 0;
		for (int j = 1; j <= size; j++) {
			c[j] = Integer.MAX_VALUE;
			for (int i = 1; i <= j; i++) {
				if (lc[i][j] != Integer.MAX_VALUE && c[i - 1] != Integer.MAX_VALUE && (c[i - 1] + lc[i][j]) < c[j]) {
					c[j] = c[i - 1] + lc[i][j];
					p[j] = i;
				}
			}
		}
		printSolution(p, size);
	}

	private int printSolution(int[] p, int n) {
		int k = 0;
		if (p[n] == 1) {
			k = 1;
		} else {
			k = printSolution(p, p[n] - 1) + 1;
		}

		System.out.println("Line Number " + k + " from word number " + p[n]
				+ " to " + n);
		return k;
	}
}
