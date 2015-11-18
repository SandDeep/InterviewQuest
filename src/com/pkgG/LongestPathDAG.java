package com.pkgG;

import java.util.Stack;

public class LongestPathDAG {

	int[] visited = null;
	int vertices = 0;

	public LongestPathDAG(int vertices) {
		this.vertices = vertices;
		this.visited = new int[vertices];
	}

	public static void main(String[] args) {
		int vertices = 6;
		Graph graph = new Graph(vertices);
		graph.addEdgeEnd(0, 1, 5, true);
		graph.addEdgeEnd(0, 2, 3, true);
		graph.addEdgeEnd(1, 3, 6, true);
		graph.addEdgeEnd(1, 2, 2, true);
		graph.addEdgeEnd(2, 4, 4, true);
		graph.addEdgeEnd(2, 5, 2, true);
		graph.addEdgeEnd(2, 3, 7, true);
		graph.addEdgeEnd(3, 5, 1, true);
		graph.addEdgeEnd(3, 4, -1, true);
		graph.addEdgeEnd(4, 5, -2, true);

		LongestPathDAG pathDAG = new LongestPathDAG(vertices);
		pathDAG.longestPath(graph, 1);
		pathDAG.shortestPath(graph, 1);
	}

	public void shortestPath(Graph graph, int s) {
		Stack<Integer> stack = new Stack<Integer>();

		int[] parent = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			parent[i] = -1;
			visited[i] = 0;
		}

		for (int i = 0; i < vertices; i++) {
			if (visited[i] != 1) {
				topologicalSort(graph, i, stack);
			}
		}

		int[] distance = new int[vertices];

		for (int i = 0; i < vertices; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[s] = 0;
		System.out.println("\n");

		while (!stack.isEmpty()) {
			int u = stack.pop();

			if (distance[u] != Integer.MAX_VALUE) {
				EdgeNode node = graph.arrayList[u].head;

				while (node != null) {
					int v = node.dest;
					if (distance[u] + node.weight < distance[v]) {
						distance[v] = distance[u] + node.weight;
						parent[v] = u;
					}
					node = node.next;
				}
			}
		}

		for (int i = 0; i < vertices; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				System.out.print("INF" + " ");
			} else {
				System.out.print(distance[i] + " ");
			}
		}
	}

	public void longestPath(Graph graph, int s) {
		Stack<Integer> stack = new Stack<Integer>();

		int[] parent = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			parent[i] = -1;
			visited[i] = 0;
		}

		for (int i = 0; i < vertices; i++) {
			if (visited[i] != 1) {
				topologicalSort(graph, i, stack);
			}
		}

		int[] distance = new int[vertices];
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Integer.MIN_VALUE;
		}

		distance[s] = 0;

		while (!stack.isEmpty()) {
			int u = stack.pop();

			if (distance[u] != Integer.MIN_VALUE) {
				EdgeNode edge = graph.arrayList[u].head;

				while (edge != null) {
					int v = edge.dest;

					if (distance[u] + edge.weight > distance[v]) {
						distance[v] = distance[u] + edge.weight;
						parent[v] = u;
					}
					edge = edge.next;
				}
			}
		}

		for (int i = 0; i < vertices; i++) {
			if (distance[i] == Integer.MIN_VALUE) {
				System.out.print("INF" + " ");
			} else {
				System.out.print(distance[i] + " ");
			}
		}
	}

	public void topologicalSort(Graph graph, int i, Stack<Integer> stack) {
		visited[i] = 1;

		EdgeNode node = graph.arrayList[i].head;

		while (node != null) {
			if (visited[node.dest] != 1) {
				topologicalSort(graph, node.dest, stack);
			}
			node = node.next;
		}
		stack.push(i);
	}
}
