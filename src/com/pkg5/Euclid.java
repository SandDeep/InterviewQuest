package com.pkg5;

public class Euclid {

	public static void main(String[] args) {
		Euclid euclid = new Euclid();
		int gcd = euclid.findGCD(400, 124);
		System.out.println(gcd);

		gcd = euclid.euclidGCD(400, 124);
		System.out.println(gcd);

		gcd = euclid.findGCDShort(400, 124);
		System.out.println(gcd);
	}

	private int euclidGCD(int a, int b) {
		while (b != 0) {
			int rem = a % b;
			a = b;
			b = rem;
		}
		return a;
	}

	private int findGCDShort(int a, int b) {
		return (b == 0) ? a : findGCDShort(b, a % b);
	}

	private int findGCD(int a, int b) {
		int dividend = (a >= b) ? a : b;
		int divisor = (a >= b) ? b : a;

		while (divisor != 0) {
			int remainder = dividend % divisor;
			dividend = divisor;
			divisor = remainder;
		}
		return dividend;
	}
}
