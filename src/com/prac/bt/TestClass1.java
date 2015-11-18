package com.prac.bt;

import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass1 {
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

			int x1 = X;
			int y1 = Y;

			int x2 = X;
			int y2 = Y;

			int x3 = X;
			int y3 = Y;

			int x4 = X;
			int y4 = Y;

			int count = 0;
			boolean flag = true;

			while (count < P) {
				x1 = x1 + 1;
				y1 = y1 + 1;

				x2 = x2 + 1;
				y2 = y2 - 1;

				x3 = x3 - 1;
				y3 = y3 + 1;

				x4 = x4 - 1;
				y4 = y4 - 1;

				double d1 = Math
						.sqrt((x1 - U) * (x1 - U) + (y1 - V) * (y1 - V));
				double d2 = Math
						.sqrt((x2 - U) * (x2 - U) + (y2 - V) * (y2 - V));
				double d3 = Math
						.sqrt((x3 - U) * (x3 - U) + (y3 - V) * (y3 - V));
				double d4 = Math
						.sqrt((x4 - U) * (x4 - U) + (y4 - V) * (y4 - V));

				double min = Math.min(d1, Math.min(d2, Math.min(d3, d4)));

				if ((x1 >= U && y1 >= V) || (x2 >= U && y2 >= V)
						|| (x3 >= U && y3 >= V) || (x4 >= U && y4 >= V)) {
					System.out.println("Counter-Terrorists Win !");
					flag = false;
					break;
				} else {
					if (min == d1) {
						x2 = x1;
						y2 = y1;
						x3 = x1;
						y3 = y1;
						x4 = x1;
						y4 = y1;
					} else if (min == d2) {
						x1 = x2;
						y1 = y2;
						x3 = x2;
						y3 = y2;
						x4 = x2;
						y4 = y2;
					} else if (min == d3) {
						x1 = x2;
						y1 = y2;
						x2 = x3;
						y2 = y3;
						x4 = x3;
						y4 = y3;
					} else if (min == d4) {
						x1 = x4;
						y1 = y4;
						x2 = x4;
						y2 = y4;
						x3 = x4;
						y3 = y4;
					}
				}
				count++;
			}

			if (flag) {
				System.out.println("Terrorists Win !");
			}
		}

	}
}
