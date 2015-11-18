package com.pkgG;

import java.util.Arrays;

/**
 * Dijksra’s algorithm is a Greedy algorithm and time complexity is
 * O(VLogV).Dijkstra doesn’t work for Graphs with negative weight edges.
 * 
 *  100	 	-5000
 * |----->C------>| 
 * | 1    |		1 |
 * A----->B------>D
 * 
 * @author Deepesh
 * 
 */
public class Dijkstra {

	int[] sptSet = null;
	int[] distance = null;
	int[] parent = null;

	public Dijkstra(int vertices) {
		sptSet = new int[vertices];
		distance = new int[vertices];
		parent = new int[vertices];

		for (int i = 0; i < vertices; i++) {
			sptSet[i] = 0;
			parent[i] = -1;
			distance[i] = Integer.MAX_VALUE;
		}

	}

	public static void main(String[] args) {

		int[][] graph = { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
				{ 4, 0, 8, 0, 0, 0, 0, 11, 0 }, { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
				{ 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 0, 10, 0, 2, 0, 0 }, { 0, 0, 0, 14, 0, 2, 0, 1, 6 },
				{ 8, 11, 0, 0, 0, 0, 1, 0, 7 }, { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

		Dijkstra dijkstra = new Dijkstra(graph.length);
		dijkstra.solveDijkstra(graph);
	}

	private void solveDijkstra(int[][] graph) {
		distance[0] = 0;

		while (!isComplete()) {
			int u = findMinDistanceNode(graph);

			for (int v = 0; v < graph.length; v++) {
				if (sptSet[v] != 1 && graph[u][v] != 0
						&& (distance[u] + graph[u][v]) < distance[v]) {
					distance[v] = distance[u] + graph[u][v];
					parent[v] = u;
				}
			}
			sptSet[u] = 1;
		}

		System.out.println(Arrays.toString(distance));
	}

	private int findMinDistanceNode(int[][] graph) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int i = 0; i < distance.length; i++) {
			if ((distance[i] < min) && sptSet[i] != 1) {
				min = distance[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	private boolean isComplete() {
		boolean status = true;
		for (int i = 0; i < sptSet.length; i++) {
			if (sptSet[i] == 0) {
				status = false;
				break;
			}
		}
		return status;
	}
}
