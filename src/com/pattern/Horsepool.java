package com.pattern;

/**
 * Time Complexity : O(n) + O(SIZE) ~=O(n) Also known as Boyer Moore Algorithm –
 * Bad Character Heuristic
 * 
 * @author Deepesh
 * 
 */
public class Horsepool {

	public int SIZE = 256;

	public static void main(String[] args) {
		char[] txt = "JIM_SAW_ME_IN_A_BARBER_SHOP".toCharArray();
		char[] pat = "BARBER".toCharArray();
		Horsepool horsepool = new Horsepool();
		horsepool.findPattern(txt, pat);
	}

	/**
	 * The Bad Character Heuristic may take O(mn) time in worst case. The worst
	 * case occurs when all characters of the text and pattern are same. For
	 * example, txt[] = “AAAAAAAAAAAAAAAAAA” and pat[] = “AAAAA”.
	 * 
	 * @param txt
	 * @param pat
	 */
	private void findPattern(char[] txt, char[] pat) {
		int M = pat.length;
		int N = txt.length;

		int[] arr = new int[SIZE];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = M;
		}

		for (int i = 0; i <= M - 2; i++) {
			int pos = findRightMostPosition(pat, i);
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
				System.out.println("Pattern found at : " + i);
				i++;
			} else {
				i = i + arr[txt[i + M - 1]];
			}
		}
	}

	private int findRightMostPosition(char[] pat, int i) {
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
