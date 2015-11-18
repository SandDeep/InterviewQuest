package com.pkg4;

import java.util.Arrays;

public class PossibleKString {

	public static void main(String[] args) {
		//char[] set = { 'a', 'b' };
		char[] set = { 'a', 'b','c','d' };
		int k = 1;

		char[] s = new char[k];
		printString(set, k, s, 0);
	}

	private static void printString(char[] set, int k, char[] s, int index) {
		if (k == 0) {
			System.out.println(Arrays.toString(s));
			return;
		}

		for (int i = 0; i < set.length; i++) {
			s[index] = set[i];
			printString(set, k - 1, s, index + 1);
		}
	}
}
