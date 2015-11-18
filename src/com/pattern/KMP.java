package com.pattern;

/**
 * http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-
 * own-words/
 * http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class KMP {

	public static void main(String[] args) {
		// String txt = "bacbababaabcbab";
		// String pat = "abababca";

		String txt = "AABAACAADAABAAABAA";
		String pat = "AABA";

		KMP kmp = new KMP();
		kmp.findPattern(txt, pat);
	}

	private void findPattern(String txtArr, String patArr) {
		int[] lps = new int[patArr.length()];
		char[] txt = txtArr.toCharArray();
		char[] pat = patArr.toCharArray();
		computeLPSArray(pat, lps);

		int N = txt.length;
		int M = pat.length;

		int i = 0;
		int j = 0;

		while (i < N) {

			if (txt[i] == pat[j]) {
				i++;
				j++;
			}

			if (j == M) {
				int index = i - j;
				System.out.println("Pattern Found : " + index);
				j = lps[j - 1];
			} else if (i < N && (txt[i] != pat[j])) {

				if (j != 0) {

					// j is shifted to left by lps[j - 1] amount i.e. previous
					// amount
					j = lps[j - 1];
				} else {
					i++;
				}
			}
		}
	}

	private void computeLPSArray(char[] pat, int[] lps) {

		int len = 0;
		int j = 0;

		lps[0] = 0;
		j++;

		while (j < pat.length) {

			// value matches, so incr and loop for next
			if (pat[len] == pat[j]) {
				lps[j] = ++len;
				j++;
			} else {
				// a b a b a b c a

				// ^ ^
				// for j=6, at that len=4
				// no value match and it will recur for old pattern
				if (len != 0) {
					len = lps[len - 1];
				} else {
					// no option,move to next
					lps[j] = 0;
					j++;
				}
			}
		}
	}
}
