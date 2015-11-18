package com.pkg5;

public class LargetstSubSquare {

	public static void main(String[] args) {
		int mat[][] = { { 'X', 'O', 'X', 'X', 'X', 'X' },
				{ 'X', 'O', 'X', 'X', 'O', 'X' },
				{ 'X', 'X', 'X', 'O', 'O', 'X' },
				{ 'O', 'X', 'X', 'X', 'X', 'X' },
				{ 'X', 'X', 'X', 'O', 'X', 'O' },
				{ 'O', 'O', 'X', 'O', 'O', 'O' } };

		LargetstSubSquare square = new LargetstSubSquare();
		int max = square.subSquare(mat);
		System.out.println(max);
	}

	private int subSquare(int[][] mat) {
		int N = mat.length;
		int max = 1;

		int[][] hor = new int[N][N];
		int[][] ver = new int[N][N];

		hor[0][0] = ver[0][0] = (mat[0][0] == 'X') ? 1 : 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (mat[i][j] == 'O') {
					hor[i][j] = 0;
					ver[i][j] = 0;
				} else {
					hor[i][j] = (j == 0) ? 1 : hor[i][j - 1] + 1;
					ver[i][j] = (i == 0) ? 1 : ver[i - 1][j] + 1;
				}
			}
		}

		for (int i = N - 1; i >= 1; i--) {
			for (int j = N - 1; j >= 1; j--) {
				int small = Math.min(hor[i][j], ver[i][j]);

				while (small > max) {

					if (ver[i][j - small + 1] >= small
							&& hor[i - small + 1][j] >= small) {
						max = small;
					}
					small--;
				}
			}
		}
		return max;
	}
}
