package com.pattern;

public class NaiveAlgo {

	public static void main(String[] args) {
		char[] txt = "ABCEABCDABCEABCD".toCharArray();
		char[] pat = "ABCD".toCharArray();

		NaiveAlgo algo = new NaiveAlgo();
		algo.search(txt, pat);
	}

	// Algo when all characters of Pattern is Different
	private void search(char[] txt, char[] pat) {
		int N = txt.length;
		int M = pat.length;

		int i = 0;
		while (i <= (N - M)) {
			int j;
			for (j = 0; j < pat.length;j++) {
				if (txt[i + j] != pat[j]) {
					break;
				}
			}
			if (j == M) {
				System.out.println("Pattern Found : " + i);
				i = i + M;
			} else if (j == 0) {
				i++;
			} else {
				i = i + j + 1;
			}
		}
	}
}
