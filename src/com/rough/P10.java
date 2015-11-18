package com.rough;

public class P10 {

	int SIZE = 256;

	public static void main(String[] args) {
		char[] txt = "JIM_SAW_ME_IN_A_BARBER_SHOP".toCharArray();
		char[] pat = "BARBER".toCharArray();
		P10 horsepool = new P10();
		horsepool.findPattern(txt, pat);

		char[] txt1 = "AABAACAADAABAAABAA".toCharArray();
		char[] pat1 = "AABA".toCharArray();

		horsepool.findPatternKMP(txt1, pat1);
	}

	private void findPatternKMP(char[] txt, char[] pat) {
		int M = pat.length;
		int N = txt.length;

		int[] lps = new int[M];
		computeLPS(pat, M, lps);

		int i = 0;
		int j = 0;

		while (i <= N - M - 1) {
			if (txt[i] == pat[j]) {
				i++;
				j++;
			}

			if (j == M) {
				int index = i - M;
				System.out.println("Pattern : " + index);
				j = lps[j - 1];
			} else if (i < N && txt[i] != pat[j]) {
				if (j != 0) {
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
	}

	private void computeLPS(char[] pat, int M, int[] lps) {
		lps[0] = 0;
		int len = 0;

		int i = 1;

		while (i < M) {
			if (pat[i] == pat[len]) {
				len++;
				lps[i] = len;
				i++;
			} else {
				if (len != 0) {
					len = lps[len - 1];
				} else {
					lps[i] = 0;
					i++;
				}
			}
		}
	}

	private void findPattern(char[] txt, char[] pat) {
		int M = pat.length;
		int N = txt.length;

		int[] arr = new int[SIZE];

		for (int i = 0; i < SIZE; i++) {
			arr[i] = M;
		}

		for (int i = 0; i <= M - 2; i++) {
			int pos = findRight(pat, i);
			arr[pat[i]] = M - 1 - pos;
		}

		for (int i = 0; i <= N - M;) {
			int j = 0;

			for (j = M - 1; j >= 0; j--) {
				if (txt[i + j] != pat[j]) {
					break;
				}
			}

			if (j + 1 == 0) {
				System.out.println("Pattern Found : " + i);
				i++;
			} else {
				i = i + arr[txt[i + M - 1]];
			}

		}
	}

	private int findRight(char[] pat, int i) {
		int pos = -1;
		int M = pat.length;

		for (int j = 0; j <= M - 2; j++) {
			if (pat[i] == pat[j]) {
				pos = j;
			}
		}
		return pos;
	}
}
