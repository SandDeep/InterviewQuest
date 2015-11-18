package com.pattern;

public class AnagramSearch {

	final public int SIZE = 256;

	public static void main(String[] args) {
		char[] txt = "BACDGABCDA".toCharArray();
		char[] pat = "ABCD".toCharArray();

		AnagramSearch anagramSearch = new AnagramSearch();
		anagramSearch.search(txt, pat);
	}

	private void search(char[] txt, char[] pat) {
		int M = pat.length;
		int N = txt.length;

		int txtArr[] = new int[SIZE];
		int patArr[] = new int[SIZE];

		// Finding Pattern Occurrence
		for (int i = 0; i < M; i++) {
			patArr[pat[i]] += 1;
		}

		// Finding Text Occurrence
		for (int i = 0; i < M; i++) {
			txtArr[txt[i]] += 1;
		}

		for (int i = M - 1; i < N; i++) {

			int j = 0;
			for (j = 0; j < M; j++) {
				if (txtArr[pat[j]] != patArr[pat[j]]) {
					break;
				}
			}

			if (j == M) {
				System.out.println("Pattern Found : " + Math.abs(i - M + 1));
			}
			// Adjusting Size
			if (i < N - 1) {
				txtArr[txt[i - M + 1]] -= 1;
				txtArr[txt[i + 1]] += 1;
			}

		}
	}
}
