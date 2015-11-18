package com.prac.bt;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

class TestClass3 {

	public static int ways = 0;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			int m = Integer.parseInt(br.readLine());
			ways = 0;
			BigInteger fact1 = findFact(m);
			BigInteger fact2 = findFact(2 * m);
			BigInteger ans = fact2.divide((fact1.multiply(fact1)));
			System.out.println(ans);

			char[] path = new char[2 * m];
			findWays(m, path, 0, 0, 0);
			System.out.println(ways);
		}

	}

	private static void findWays(int m, char[] path, int x, int y, int i) {
		if (x == m && y == m) {
			ways++;
			System.out.println(Arrays.toString(path));
			return;
		}

		if (x == m) {
			path[i] = 'D';
			findWays(m, path, x, y + 1, i + 1);
		}

		else if (y == m) {
			path[i] = 'R';
			findWays(m, path, x + 1, y, i + 1);
		}

		else {
			// Moving Rightwards
			path[i] = 'R';
			findWays(m, path, x + 1, y, i + 1);

			// Moving Downwards
			path[i] = 'D';
			findWays(m, path, x, y + 1, i + 1);

		}
	}

	private static BigInteger findFact(int m) {
		BigInteger fact = BigInteger.valueOf(1L);

		for (int i = 1; i <= m; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		return fact;
	}

}
