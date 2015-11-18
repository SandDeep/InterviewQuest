package com.pkgG;

import java.util.Arrays;

public class Hamiltonian {

	static int index = 0;

	public static void main(String[] args) {
		int[][] graph = { { 0, 1, 0, 1, 0 }, { 1, 0, 1, 1, 1 },
				{ 0, 1, 0, 0, 1 }, { 1, 1, 0, 0, 1 }, { 0, 1, 1, 1, 0 }, };

		Hamiltonian hamiltonian = new Hamiltonian();
		hamiltonian.hamCycle(graph);
	}

	private void hamCycle(int[][] graph) {
		int V = graph.length;

		int[] path = new int[V];

		for (int i = 0; i < V; i++) {
			path[i] = -1;
		}
		/*
		 * Let us put vertex 0 as the first vertex in the path. If there is a
		 * Hamiltonian Cycle, then the path can be started from any point of the
		 * cycle as the graph is undirected
		 */
		boolean res = hamUtil(graph, path, 0, 0);
		System.out.println(Arrays.toString(path));
	}

	private boolean hamUtil(int[][] graph, int[] path, int i, int index) {
		int V = graph.length;

		if (index == V) {
			if (graph[i][0] == 1) {
				return true;
			}
			return false;
		}

		for (int j = 0; j < V; j++) {

			if (isSafe(graph, i, j, path)) {
				path[index] = i;

				if (hamUtil(graph, path, j, index + 1) == true) {
					return true;
				}

				path[index] = -1;
			}
		}

		return false;
	}

	private boolean isSafe(int[][] graph, int i, int j, int[] path) {

		if (graph[i][j] == 0) {
			return false;
		}

		for (int k = 0; k < path.length; k++) {
			if (path[k] == i) {
				return false;
			}
		}

		return true;
	}

}
