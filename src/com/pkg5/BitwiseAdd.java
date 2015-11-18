package com.pkg5;

/**
 * http://www.geeksforgeeks.org/add-two-numbers-without-using-arithmetic-
 * operators/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class BitwiseAdd {

	public static void main(String[] args) {
		BitwiseAdd bit = new BitwiseAdd();
		int sum = bit.add(15, 132);
		System.out.println(sum);
	}

	private int add(int x, int y) {

		while (y != 0) {

			/* Bitwise AND of x and y gives all carry bits */
			int carry = x & y;

			/*
			 * Sum of two bits can be obtained by performing XOR (^) of the two
			 * bits
			 */
			x = x ^ y;

			/*
			 * Calculate (x & y) << 1 and add it to x ^ y to get the required
			 * result.
			 */
			y = carry << 1;
		}
		return x;
	}
}
