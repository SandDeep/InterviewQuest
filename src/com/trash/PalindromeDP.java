package com.trash;

public class PalindromeDP {

	static int start = 0;
	static int maxlength = 1;

	public static void main(String[] args) {
		char[] seq = "GEEKS FOR GEEKS".toCharArray();
		// char[] seq = "ageegb".toCharArray();
		PalindromeDP dp = new PalindromeDP();
		int len = dp.getLPS(seq);
		System.out.println(len);

		// int lenDP = dp.LPSdp(seq);
		// System.out.println("DP : " + lenDP);

		char str[] = "forgeeksskeegfor".toCharArray();
		dp.longestPalSubstr(str);
	}

	/**
	 * Time complexity: O ( n^2 ) Auxiliary Space: O ( 1 )
	 * 
	 * @param str
	 */
	public void longestPalSubstr(char[] str) {

		int N = str.length;
		int low = 0;
		int high = 0;
		for (int i = 1; i < N - 1; i++) {

			// ODD
			low = i - 1;
			high = i + 1;
			findPalindrome(str, low, high);

			// EVEN
			low = i;
			high = i + 1;
			findPalindrome(str, low, high);

		}

		printSubString(str, start, maxlength);
	}

	private void findPalindrome(char[] str, int low, int high) {
		int length = 0;
		int N = str.length;

		while (low >= 0 && high <= N - 1 && str[low] == str[high]) {
			length = length + 2;
			low--;
			high++;
		}

		if (maxlength < length) {
			maxlength = length;
			start = low + 1;
		}
	}

	private void printSubString(char[] str, int start, int maxlength) {
		System.out.println("Max Length : " + maxlength);
		for (int i = start; i < start + maxlength; i++) {
			System.out.print(str[i]);
		}
	}

	/**
	 * Time complexity: O ( n^2 ) Auxiliary Space: O ( n^2 )
	 * 
	 * @param str
	 */
	public int LPSdp(char[] seq) {
		int N = seq.length;

		int[][] L = new int[N][N];

		for (int i = 0; i < N; i++) {
			L[i][i] = 1;
		}

		for (int cl = 2; cl <= N; cl++) {
			int j = 0;

			for (int i = 0; i < N - cl + 1; i++) {
				j = i + cl - 1;

				if (seq[i] == seq[j] & cl == 2) {
					L[i][j] = 2;
				} else if (seq[i] == seq[j]) {
					L[i][j] = 2 + L[i + 1][j - 1];
				} else {
					L[i][j] = Math.max(L[i][j - 1], L[i + 1][j]);
				}
			}
		}
		return L[0][N - 1];
	}

	/**
	 * Time complexity: O ( n^3 ) Auxiliary Space: O ( 1 )
	 * 
	 * @param str
	 */
	public int getLPS(char[] seq) {
		int N = seq.length;

		if (N < 1) {
			return 0;
		}
		if (N == 1) {
			return 1;
		}

		return lpsUtil(seq, 0, N - 1);
	}

	public int lpsUtil(char[] seq, int left, int right) {
		if (left > right) {
			return 0;
		}

		if (left == right) {
			return 1;
		}

		if (seq[left] == seq[right]) {
			return 2 + lpsUtil(seq, left + 1, right - 1);
		} else {
			return Math.max(lpsUtil(seq, left, right - 1),
					lpsUtil(seq, left + 1, right));
		}
	}
}
