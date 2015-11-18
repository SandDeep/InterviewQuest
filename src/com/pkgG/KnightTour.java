package com.pkgG;

public class KnightTour {

	public static void main(String[] args) {
		KnightTour tour = new KnightTour();
		long ts = System.currentTimeMillis();
		tour.solveKnightTour(9);
		System.out.println("Time to Collect History Data-------" + (System.currentTimeMillis() - ts)/(1000*60) +"\n");
	}

	private void solveKnightTour(int M) {

		int[][] sol = new int[M][M];
		for (int i = 0; i < sol.length; i++) {
			for (int j = 0; j < sol.length; j++) {
				sol[i][j] = -1;
			}
		}

		int[] moveX = { 2, 1, -1, -2, -2, -1, 1, 2 };
		int[] moveY = { 1, 2, 2, 1, -1, -2, -2, -1 };

		if (knightTourUtil(0, 0, sol, 0, moveX, moveY)) {
			printPath(sol);
		}
	}

	private boolean knightTourUtil(int i, int j, int[][] sol, int move,
			int[] moveX, int[] moveY) {

		int N = sol.length;

		if (move == N * N) {
			return true;
		}

		if (isSafe(i, j, sol)) {
			for (int k = 0; k < 8; k++) {
				int nextX = i + moveX[k];
				int nextY = j + moveY[k];

				sol[i][j] = move;
				if (knightTourUtil(nextX, nextY, sol, move + 1, moveX, moveY)) {
					return true;
				} else {
					sol[i][j] = -1;
				}

			}
		}
		return false;
	}

	private boolean isSafe(int i, int j, int[][] sol) {
		int M = sol.length - 1;

		if (i >= 0 && i <= M && j >= 0 && j <= M && sol[i][j] == -1) {
			return true;
		}
		return false;
	}

	private void printPath(int[][] sol) {
		int M = sol.length;
		int N = sol[0].length;

		for (int i = 0; i < M; i++) {
			System.out.print("[ ");
			for (int j = 0; j < N; j++) {
				System.out.print(sol[i][j] + " ");
			}
			System.out.print("]\n");
		}
	}

}
