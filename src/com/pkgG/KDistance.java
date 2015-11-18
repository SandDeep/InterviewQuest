package com.pkgG;

import java.util.Arrays;

public class KDistance {

	public static void main(String[] args) {
		int[][] graph = { { 0, 1, 1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 },
				{ 0, 0, 0, 0 } };

		int u = 0;
		int v = 3;
		int k = 2;

		int[] path = new int[k + 1];
		printPath(graph, u, v, k, path, 0);
	}

	private static void printPath(int[][] graph, int u, int v, int k,
			int[] path, int z) {
		if (k == 0 && u == v) {
			path[z] = v;
			System.out.println(Arrays.toString(path));
		}

		if (k < 0) {
			return;
		}
		for (int i = 0; i < graph.length; i++) {
			if (graph[u][i] == 1) {
				path[z] = u;
				printPath(graph, i, v, k - 1, path, z + 1);
			}
		}
	}
}
