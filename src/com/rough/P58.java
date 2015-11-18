package com.rough;

import java.util.Arrays;

public class P58 {

	public static void main(String[] args) {
		String str1 = "AB";
		String str2 = "CD";

		P58 test = new P58();
		test.printInterleaving(str1, str2);
	}

	private void printInterleaving(String str1, String str2) {
		char[] res = new char[str1.length() + str2.length()];

		printUtil(str1.toCharArray(), str2.toCharArray(), 0, 0, 0, res);
	}

	private void printUtil(char[] arr1, char[] arr2, int i, int j, int k,
			char[] res) {

		int m = arr1.length;
		int n = arr2.length;
		if (i == m && j == n) {
			System.out.println(Arrays.toString(res));
			return;
		}

		if (i != m) {
			res[k] = arr1[i];
			printUtil(arr1, arr2, i + 1, j, k + 1, res);
		}

		if (j != n) {
			res[k] = arr2[j];
			printUtil(arr1, arr2, i, j + 1, k + 1, res);
		}

	}
}
