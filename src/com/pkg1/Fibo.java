package com.pkg1;

public class Fibo {

	public int[] lookup = new int[500];

	public void initialize() {
		for (int i = 0; i < lookup.length; i++) {
			lookup[i] = -1;
		}
	}

	public static void main(String[] args) {

		int N = 45;
		Fibo fibbonaci = new Fibo();
		fibbonaci.initialize();

		long num=0;
		long current = System.currentTimeMillis();
		num = fibbonaci.fib(N);
		System.out.println(System.currentTimeMillis() - current + " : " + num);

		/*current = System.currentTimeMillis();
		num = fibbonaci.fibTD(N);
		System.out.println(System.currentTimeMillis() - current + " : "
				+ "TD : " + num);*/

		current = System.currentTimeMillis();
		num = fibbonaci.fibBU(N);
		System.out.println(System.currentTimeMillis() - current + " : "
				+ "BU : " + num);

	}

	int fibBU(int n) {
		int[] f = new int[n + 1];

		f[0] = 0;
		f[1] = 1;

		for (int i = 2; i <= n; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}

		return f[n];
	}

	int fibTD(int n) {
		if (lookup[n] == -1) {
			if (n <= 1) {
				return n;
			}
			return fibTD(n - 1) + fibTD(n - 2);
		} else {
			return lookup[n];
		}

	}

	int fib(int n) {
		if (n <= 1) {
			return n;
		}

		return fib(n - 1) + fib(n - 2);
	}

}
