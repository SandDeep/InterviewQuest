package com.trash;

/**
 * http://www.geeksforgeeks.org/print-all-prime-factors-of-a-given-number/
 * 
 * @author Deepesh
 * 
 */
public class PrimeFactor {

	public static void main(String[] args) {
		int n = 315;
		PrimeFactor factor = new PrimeFactor();
		factor.primeFactor(n);
	}

	private void primeFactor(int n) {
		while (n % 2 == 0) {
			System.out.print(2 + " ");
			n = n / 2;
		}

		for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
			while (n % i == 0) {
				System.out.print(i + " ");
				n = n / i;
			}
		}

		if (n > 2) {
			System.out.print(n + " ");
		}
	}
}
