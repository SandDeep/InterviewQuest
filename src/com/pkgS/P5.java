package com.pkgS;

public class P5 {

	public static void main(String[] args) {
		char mat[][] = { { 'a', 'c', 'd' }, { 'h', 'b', 'e' },
				{ 'i', 'g', 'f' } };
		P5 test = new P5();
		int count = test.findPath(mat, mat.length);
		System.out.println(count);
	}

	private int findPath(char[][] mat, int n) {

		// tool matrices to recur for adjacent cells.
		int x[] = { 0, 1, 1, -1, 1, 0, -1, -1 };
		int y[] = { 1, 0, 1, 1, -1, -1, 0, -1 };

		
		return 0;
	}
}
