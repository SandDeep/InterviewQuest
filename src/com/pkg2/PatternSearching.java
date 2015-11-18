package com.pkg2;

import java.util.ArrayList;
import java.util.List;

/**
 * http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/
 * @author Deepesh
 *
 */
public class PatternSearching {

	public static void main(String[] args) {
		String txt = "AABAACAADAABAAABAA";
		String pat = "AABA";
		// String pat = "AABAACAABAA";
		char[] txtArr = txt.toCharArray();
		char[] patArr = pat.toCharArray();

		PatternSearching searching = new PatternSearching();

		/*
		 * List<Integer> index = searching.getIndexNaive(txtArr, patArr);
		 * System.out.println(index);
		 */

		searching.KMPSearch(txtArr, patArr);
		System.out.println();

	}

	private void KMPSearch(char[] txt, char[] pat) {
		int N = txt.length;
		int M = pat.length;

		int[] lps = new int[M];
		computeLPSArray(pat, lps);
		int j = 0;

		int i = 0;
		while (i < N) {

			if (pat[j] == txt[i]) {
				i++;
				j++;
			}

			if (j == M) {

				System.out.println("Found pattern at index" + (i - j));
				j = lps[j - 1];

			} else if (pat[j] != txt[i]) {

				if (j != 0) {
					j = lps[j - 1];
				} else {
					i = i + 1;
				}
			}
		}
	}

	private static void computeLPSArray(char[] pat, int[] lps) {
		int len = 0;
		lps[0] = 0;

		int i = 1;
		while (i < pat.length) {

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

	/**
	 * Number of comparisons in worst case is O(m*(n-m+1))
	 * 
	 * @param txtArr
	 * @param patArr
	 * @return
	 */
	public List<Integer> getIndexNaive(char[] txtArr, char[] patArr) {

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i <= txtArr.length - patArr.length; i++) {

			int j = 0;

			for (j = 0; j < patArr.length; j++) {

				if (txtArr[i + j] != patArr[j]) {
					break;
				}
			}
			if (j == patArr.length) {
				list.add(i);
			}

		}

		return list;
	}
}
