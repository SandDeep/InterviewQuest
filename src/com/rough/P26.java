package com.rough;

public class P26 {

	public static void main(String[] args) {
		int x = 29;
		int y = 13;

		int sum = getSum(x, y);
		int diff = getDiff(x, y);
		System.out.println(sum + " : " + diff);
	}

	private static int getDiff(int x, int y) {

		while (y != 0) {
			int borrow = (~x) & y;
			x = x ^ y;
			y = borrow << 1;
		}
		return x;
	}

	private static int getSum(int x, int y) {

		while (y != 0) {
			int carry = x & y;
			x = x ^ y;
			y = carry << 1;
		}
		return x;
	}
}
