package com.pkg4;

public class AllPrime {

	public static void main(String[] args) {
		int n = 100;

		AllPrime prime = new AllPrime();
		prime.sieveOfEratosthenes(n);
	}

	private void sieveOfEratosthenes(int n) {
		if (n < 2) {
			System.out.println("No Prime Numbers");
			return;
		}

		int[] prime = new int[n + 1];

		int next = 2;

		while (next * next <= n) {

			/* seive=examine in detail. */
			int seive = next;

			for (int i = seive * next; i <= n; i = seive * next) {
				prime[i] = -1;
				seive += 1;
			}

			for (int i = next + 1; i <= n; i++) {
				if (prime[i] != -1) {
					next = i;
					break;
				}
			}
		}

		for (int i = 2; i <= n; i++) {
			if (prime[i] != -1) {
				System.out.print(i + " ");
			}
		}
	}
}
