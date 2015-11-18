package com.pkgG;

import java.util.LinkedList;
import java.util.Queue;

public class EdgeDisjointPath {

	public static void main(String[] args) {
		int[][] graph = 
			{ 
				{0, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 1, 0, 0, 0, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0}
            };
		
		EdgeDisjointPath path=new EdgeDisjointPath();
		int num=path.findDisjointPath(graph);
		System.out.println("Edge Disjoint Paths : " + num);
	}

	private int findDisjointPath(int[][] graph) {

		int V = graph.length;

		int[][] residual = new int[V][V];

		for (int i = 0; i < graph.length; i++) {
			for (int j = 0; j < graph.length; j++) {
				residual[i][j] = graph[i][j];
			}
		}

		int[] parent = new int[V];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}

		int maxFlow = 0;

		while (bfs(residual, parent, 0, V - 1)) {
			int pathFlow = Integer.MAX_VALUE;
			int t = residual.length - 1;

			System.out.print(t+" ");
			// Find Min Edge Weight in a Path
			for (int v = t; v > 0; v = parent[v]) {
				int u = parent[v];
				System.out.print(u+" ");
				pathFlow = Math.min(pathFlow, residual[u][v]);
			}
			
			System.out.print("\n");
			// Modifying Residual Graph
			for (int v = t; v > 0; v = parent[v]) {
				int u = parent[v];
				residual[u][v]-=pathFlow;
				residual[v][u]+=pathFlow;
			}
			
			maxFlow += pathFlow;
		}

		return maxFlow;
	}

	private boolean bfs(int[][] residual, int[] parent, int s, int t) {

		boolean[] visited = new boolean[residual.length];

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(s);
		visited[s] = true;

		while (!queue.isEmpty()) {
			int u = queue.poll();

			for (int v = 0; v < visited.length; v++) {
				if (visited[v] == false && residual[u][v] > 0) {
					parent[v] = u;
					visited[v] = true;
					queue.add(v);
				}
			}
		}

		return (visited[t] == true);
	}
}
