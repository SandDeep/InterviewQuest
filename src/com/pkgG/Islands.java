package com.pkgG;

/**
 * What is an island? A group of connected 1s forms an island.Time complexity:
 * O(ROW x COL)
 * 
 * @author Deepesh
 * 
 */
public class Islands {

	public static void main(String[] args) {
		int M[][] = { { 1, 1, 0, 0, 0 }, { 0, 1, 0, 0, 1 }, { 1, 0, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 }, { 1, 0, 1, 0, 1 } };

		int islands = findIslands(M);

		System.out.println("Number of Islands : " + islands);
	}

	private static int findIslands(int[][] m) {

		int count = 0;
		int V = m.length;
		int[][] visited = new int[V][V];
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited.length; j++) {
				visited[i][j] = -1;
			}
		}

		for (int i = 0; i < V; i++) {
			for (int j = 0; j < visited.length; j++) {
				if (visited[i][j] != 1 && m[i][j] == 1) {
					dfsUtil(m, i, j, visited);
					count++;
				}
			}
		}

		return count;
	}

	private static void dfsUtil(int[][] m, int x, int y, int[][] visited) {

		visited[x][y] = 1;

		int row[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
		int col[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

		for (int k = 0; k < 8; k++) {
			if (isSafe(m, x + row[k], y + col[k], visited)) {
				dfsUtil(m, x + row[k], y + col[k], visited);
			}
		}
	}

	private static boolean isSafe(int[][] m, int i, int y, int[][] visited) {

		if (i >= 0 && i < m.length && y >= 0 && y < m.length && m[i][y] == 1
				&& visited[i][y] != 1) {
			return true;
		}
		return false;
	}
}
