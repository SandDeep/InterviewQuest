package com.pkgG;

public class Nqueen {

	public static void main(String[] args) {
		Nqueen queen = new Nqueen();
		queen.solveNqueen(4);
	}

	private void solveNqueen(int N) {
		int[][] board = new int[N][N];

		if (NqueenUtil(0, board)) {
			printPath(board);
		}

	}

	private boolean NqueenUtil(int col, int[][] board) {
		int N = board.length;

		if (col == N) {
			return true;
		}

		for (int row = 0; row < N; row++) {
			if (isSafe(col, row, board)) {
				board[row][col] = 1;
				if (NqueenUtil(col + 1, board)) {
					return true;
				} else {
					board[row][col] = 0;
				}
			}
		}
		return false;
	}

	private boolean isSafe(int col, int row, int[][] board) {
		int N = board.length;

		// Checking for left line as we are moving rightwards so no need to
		// compare right line
		for (int i = col - 1; i >= 0; i--) {
			if (board[row][i] == 1) {
				return false;
			}
		}

		// Left Upward Diagonal
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		// Left Downward Diagonal
		for (int i = row, j = col; i < N && j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		return true;
	}

	public void printPath(int[][] sol) {
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
