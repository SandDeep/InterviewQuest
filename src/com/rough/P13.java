package com.rough;

public class P13 {

	int SIZE = 256;

	public static void main(String[] args) {
		P13 horsepool = new P13();

		char[] txt = "JIM_SAW_ME_IN_A_BARBER_SHOP".toCharArray();
		char[] pat = "BARBER".toCharArray();
		horsepool.findPattern(txt, pat);

		char[] txt1 = "AABAACAADAABAAABAA".toCharArray();
		char[] pat1 = "AABA".toCharArray();

		horsepool.findPatternKMP(txt1, pat1);
	}

	private void findPatternKMP(char[] txt, char[] pat) {
		int M = pat.length;
		int N = txt.length;

		int[] lps = new int[M];
		computeLPS(lps, pat, M);

		int i = 0;
		int j = 0;

		while (i <= N - M - 1) {

			if (txt[i] == pat[j]) {
				i++;
				j++;
			}

			if (j == M) {
				int index = i - M;
				System.out.println("Pattern Found : " + index);
				j=lps[j-1];
			} else if (txt[i] != pat[j]) {
				if (j != 0) {
					j=lps[j-1];
				} else {
					i++;
				}
			}
		}
	}

	private void computeLPS(int[] lps, char[] pat, int M) {

		int len = 0;
		lps[0] = 0;
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

		int[] occ = new int[SIZE];

		for (int i = 0; i < SIZE; i++) {
			occ[i] = M;
		}

		for (int i = 0; i < M - 1; i++) {
			int index = findRightMost(pat, i);
			occ[pat[i]] = M - 1 - index;
		}

		int i = M - 1;

		while (i < N) {
			int j = M - 1;

			int k = i;
			while (j >= 0) {
				if (txt[k] != pat[j]) {
					break;
				}
				k--;
				j--;
			}

			if (j == -1) {
				int index = i - (M - 1);
				System.out.println("Pattern Found : " + index);
				break;
			}

			else if (txt[i] != pat[j]) {
				i = i + occ[txt[i]];
			}
		}
	}

	private int findRightMost(char[] pat, int i) {
		int j = 0;

		for (j = pat.length - 2; j >= 0; j--) {
			if (pat[i] == pat[j]) {
				break;
			}
		}
		return j;
	}

}
