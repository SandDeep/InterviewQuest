package com.pkgG;

public class PrimMST {

	int vertices = 0;
	int[] mstSet = null;
	int[] parent = null;
	int[] key = null;

	public PrimMST(int vertices) {
		this.vertices = vertices;
		mstSet = new int[vertices];
		parent = new int[vertices];
		key = new int[vertices];

		for (int i = 0; i < vertices; i++) {
			mstSet[i] = 0;
			parent[i] = -1;
			key[i] = Integer.MAX_VALUE;
		}
	}

	public static void main(String[] args) {
		int graph[][] = { { 0, 2, 0, 6, 0 }, { 2, 0, 3, 8, 5 },
				{ 0, 3, 0, 0, 7 }, { 6, 8, 0, 0, 9 }, { 0, 5, 7, 9, 0 }, };

		PrimMST mst = new PrimMST(graph.length);
		mst.findMST(graph);
	}

	private void findMST(int[][] graph) {
		key[0] = 0;

		while (!isComplete()) {
			int u = findMinKeyIndex();

			for (int v = 0; v < vertices; v++) {
				if (mstSet[v] != 1 && graph[u][v] != 0 && graph[u][v] < key[v]) {
					key[v] = graph[u][v];
					parent[v] = u;
				}
			}
			mstSet[u] = 1;
		}
		primMST(graph);
	}

	private void primMST(int[][] graph) {
		for (int i = 0; i < graph.length; i++) {
			System.out.println(parent[i] + " - " + i + "    " + key[i]);
		}
	}

	private int findMinKeyIndex() {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int i = 0; i < vertices; i++) {
			if ((key[i] < min) && mstSet[i] != 1) {
				min = key[i];
				minIndex = i;
			}
		}
		return minIndex;
	}

	private boolean isComplete() {
		boolean status = true;
		for (int i = 0; i < mstSet.length; i++) {
			if (mstSet[i] == 0) {
				status = false;
				break;
			}
		}
		return status;
	}
}
