package com.KeyGen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestClass {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		char mat[][] = new char[N][N];
		int sol[][] = new int[N][N];

		for (int i = 0; i < N; i++) {
			String[] input = br.readLine().split("\\s+");
			for (int j = 0; j < N; j++) {
				mat[i][j] = input[j].charAt(0);
			}
		}

		TestClass test = new TestClass();
		int moves = test.getPath(mat, 0, 0,sol);
		System.out.println(moves);
	}

	private int getPath(char[][] mat, int i, int j, int[][] sol) {

		if (isSafe(mat, i, j,sol)) {
			
			sol[i][j]=1;
			
			int north = 0;
			int south = 0;
			int east = 0;
			int west = 0;

			// North
			if (getDest(mat, i + 1, j)) {
				return 2;
			} else {
				north = getPath(mat, i + 1, j,sol);
			}

			// South
			if (getDest(mat, i - 1, j)) {
				return 2;
			} else {
				south = getPath(mat, i - 1, j,sol);
			}

			// East
			if (getDest(mat, i, j + 1)) {
				return 2;
			} else {
				east = getPath(mat, i, j + 1,sol);
			}

			// West
			if (getDest(mat, i, j - 1)) {
				return 2;
			} else {
				west = getPath(mat, i, j - 1,sol);
			}

			return 1 + Math.min(east, Math.min(west, Math.min(north, south)));
		}
		return Integer.MAX_VALUE;
	}

	private boolean getDest(char[][] mat, int i, int j) {
		int M = mat.length - 1;
		int N = mat[0].length - 1;

		if (i >= 0 && i <= M && j >= 0 && j <= N && mat[i][j] == 'E') {
			return true;
		}
		return false;
	}

	private boolean isSafe(char[][] mat, int i, int j, int[][] sol) {
		int M = mat.length - 1;
		int N = mat[0].length - 1;

		if (i >= 0 && i <= M && j >= 0 && j <= N && mat[i][j] == 'S') {
			return true;
		}

		else if (i >= 0 && i <= M && j >= 0 && j <= N && mat[i][j] == 'P' && sol[i][j]!=1) {
			return true;
		}
		return false;
	}
}
