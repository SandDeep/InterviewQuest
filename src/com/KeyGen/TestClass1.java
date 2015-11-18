package com.KeyGen;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestClass1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		char[] input = br.readLine().toCharArray();

		TestClass1 test = new TestClass1();
		int move = test.single(input, 0, N);
		System.out.println(move);
	}

	/*
	 * private int singleColored(char[] input, int n) {
	 * 
	 * int min = Integer.MAX_VALUE; int res = 0; for (int i = 0; i <
	 * input.length; i++) { res = single(input, i, n);
	 * 
	 * if (res < min) { min = res; } } return min; }
	 */

	private int single(char[] input, int i, int n) {
		if (mono(input)) {
			return 0;
		}

		// Same Color index
		int j = i;

		for (j = i + 1; j < input.length; j++) {
			if (input[j] != (input[j - 1])) {
				break;
			}
		}

		int m1 = single(input, j, n);

		int m2 = 0;
		if ((j - i) == 2 || (j - i) == 3) {
			m2 = 1 + single(input, j, n);
		}

		return Math.min(m1, m2);
	}

	private boolean mono(char[] input) {

		char c = input[0];

		for (int i = 1; i < input.length; i++) {
			if (input[i] != c) {
				return false;
			}
		}
		return true;
	}
}
