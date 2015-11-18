package com.trash;

/**
 * http://www.geeksforgeeks.org/maximum-size-sub-matrix-with-all-1s-in-a-binary-matrix/
 * @author Deepesh
 *
 */
public class SubMatrix {

	public static void main(String[] args) {
		int M[][] =  {
				{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

		SubMatrix matrix = new SubMatrix();
		matrix.printMaxSubSquare(M);
	}

	private void printMaxSubSquare(int[][] arr) {
		int M = arr.length;
		int N = arr[0].length;

		int S[][] = new int[M][N];

		for (int i = 0; i < M; i++) {
			S[i][0] = arr[i][0];
		}

		for (int i = 0; i < N; i++) {
			S[0][i] = arr[0][i];
		}

		for (int i = 1; i < M; i++) {
			for (int j = 1; j < N; j++) {
				if (arr[i][j] == 1) {
					S[i][j] = Math.min(S[i - 1][j],
							Math.min(S[i][j - 1], S[i - 1][j - 1])) + 1;
				} else {
					S[i][j] = 0;
				}
			}
		}
		System.out.println();
	}
}
