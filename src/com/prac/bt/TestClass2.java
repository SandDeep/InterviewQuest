package com.prac.bt;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("\\s+");

			int P = Integer.parseInt(input[0]);
			int X = Integer.parseInt(input[1]);
			int Y = Integer.parseInt(input[2]);
			int U = Integer.parseInt(input[3]);
			int V = Integer.parseInt(input[4]);

			int status = findPath(X,Y,U, V);
			/*if (status) {
				System.out.println("Counter-Terrorists Win !");
			} else {
				System.out.println("Terrorists Win !");
			}*/
			System.out.println(status);
		}

	}

	private static int findPath(int x, int y, int u, int v) {
		int[][] points = new int[1000][1000];

		return 0;
	}
}
