package com.pkg4;

public class Beewalk {

	int N = 0;
	static int count = 0;

	public Beewalk(int N) {
		this.N = N;
	}

	public static void main(String[] args) {
		Beewalk walk = new Beewalk(14);
		walk.beewalk(5);
	}

	private void beewalk(int move) {
		int[][] bee = new int[2 * N + 1][2 * N + 1];

		// beeUtil(bee, N - 1, N - 1, move);

		// Move diagnol Up-Right
		beeUtil(bee, N + 1, N - 1, move - 1);

		// Move Right
		beeUtil(bee, N + 1, N, move - 1);

		// Move diagnol Down-Right
		beeUtil(bee, N + 1, N + 1, move - 1);

		// Move diagnol Up-Left
		beeUtil(bee, N - 1, N - 1, move - 1);

		// Move Left
		beeUtil(bee, N - 1, N, move - 1);

		// Move diagnol Down-Left
		beeUtil(bee, N - 1, N + 1, move - 1);

		System.out.println(count);
	}

	public void beeUtil(int[][] bee, int X, int Y, int move) {
		if (X == N && Y == N) {
			count++;
			return;
		}

		if (X < 0 || X > (2 * N - 1) || Y < 0 || Y > (2 * N - 1) || move <= 0) {
			return;
		}

		// Move diagnol Up-Right
		beeUtil(bee, X + 1, Y - 1, move - 1);

		// Move Right
		beeUtil(bee, X + 1, Y, move - 1);

		// Move diagnol Down-Right
		beeUtil(bee, X + 1, Y + 1, move - 1);

		// Move diagnol Up-Left
		beeUtil(bee, X - 1, Y - 1, move - 1);

		// Move Left
		beeUtil(bee, X - 1, Y, move - 1);

		// Move diagnol Down-Left
		beeUtil(bee, X - 1, Y + 1, move - 1);

	}
}
