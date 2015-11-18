package com.pkgG;

import java.util.Arrays;
import java.util.Stack;

public class SCCAdv {

	static int time = 0;

	public static void main(String[] args) {
		Graph graph = getGraph4();

		SCCAdv scc = new SCCAdv();
		scc.printSCC(graph);
	}

	private void printSCC(Graph graph) {
		int[] dics = new int[graph.vertices];
		int[] low = new int[graph.vertices];
		int[] visited = new int[graph.vertices];
		boolean[] stackManager = new boolean[graph.vertices];
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < low.length; i++) {
			dics[i] = -1;
			low[i] = -1;
		}

		for (int i = 0; i < visited.length; i++) {
			if (visited[i] != 1) {
				dfsUtil(graph, visited, dics, low, i, stack, stackManager);
			}
		}
		System.out.println(Arrays.toString(low));
	}

	private void dfsUtil(Graph graph, int[] visited, int[] dics, int[] low,
			int u, Stack<Integer> stack, boolean[] stackManager) {

		visited[u] = 1;
		// System.out.print(u + " ");

		dics[u] = ++time;
		low[u] = time;
		stack.push(u);
		stackManager[u] = true;

		EdgeNode node = graph.arrayList[u].head;

		while (node != null) {
			int v = node.dest;

			if (dics[v] == -1) {
				dfsUtil(graph, visited, dics, low, v, stack, stackManager);

				// Tree Edge
				low[u] = Math.min(low[u], low[v]);
			}
			// Back Edge
			else if (stackManager[v] == true) {
				low[u] = Math.min(low[u], dics[v]);
			}

			node = node.next;
		}

		int w = 0;
		if (low[u] == dics[u]) {

			while (stack.peek() != u) {
				w = stack.pop();
				System.out.print(w + " ");
				stackManager[w] = false;
			}

			w = stack.pop();
			System.out.print(w + " " + "\n");
			stackManager[w] = false;
		}
	}

	public static Graph getGraph() {
		Graph graph = new Graph(5);

		graph.addEdgeEnd(1, 0, true);
		graph.addEdgeEnd(0, 2, true);
		graph.addEdgeEnd(2, 1, true);
		graph.addEdgeEnd(0, 3, true);
		graph.addEdgeEnd(3, 4, true);

		return graph;
	}

	public static Graph getGraph1() {
		Graph graph = new Graph(7);

		graph.addEdgeEnd(0, 1, true);
		graph.addEdgeEnd(1, 2, true);
		graph.addEdgeEnd(2, 0, true);
		graph.addEdgeEnd(1, 3, true);
		graph.addEdgeEnd(1, 4, true);

		graph.addEdgeEnd(1, 6, true);
		graph.addEdgeEnd(3, 5, true);
		graph.addEdgeEnd(4, 5, true);

		return graph;
	}

	public static Graph getGraph2() {
		Graph graph = new Graph(11);

		graph.addEdgeEnd(0, 1, true);
		graph.addEdgeEnd(0, 3, true);
		graph.addEdgeEnd(1, 2, true);
		graph.addEdgeEnd(1, 4, true);
		graph.addEdgeEnd(2, 0, true);
		graph.addEdgeEnd(2, 6, true);
		graph.addEdgeEnd(3, 2, true);
		graph.addEdgeEnd(4, 5, true);
		graph.addEdgeEnd(4, 6, true);
		graph.addEdgeEnd(5, 6, true);
		graph.addEdgeEnd(5, 7, true);
		graph.addEdgeEnd(5, 8, true);
		graph.addEdgeEnd(5, 9, true);

		graph.addEdgeEnd(6, 4, true);
		graph.addEdgeEnd(7, 9, true);
		graph.addEdgeEnd(8, 9, true);
		graph.addEdgeEnd(9, 8, true);

		return graph;
	}

	public static Graph getGraph3() {
		Graph graph = new Graph(10);

		graph.addEdgeEnd(0, 1, true);
		graph.addEdgeEnd(0, 2, true);
		graph.addEdgeEnd(0, 3, true);
		graph.addEdgeEnd(1, 2, true);
		graph.addEdgeEnd(2, 3, true);
		graph.addEdgeEnd(2, 4, true);
		graph.addEdgeEnd(2, 6, true);
		graph.addEdgeEnd(4, 5, true);
		graph.addEdgeEnd(6, 5, true);
		graph.addEdgeEnd(5, 7, true);
		graph.addEdgeEnd(5, 8, true);
		graph.addEdgeEnd(5, 9, true);
		graph.addEdgeEnd(7, 8, true);
		graph.addEdgeEnd(8, 9, true);

		return graph;
	}

	public static Graph getGraph4() {
		Graph g3 = new Graph(7);
		g3.addEdge(0, 1, true);
		g3.addEdge(1, 2, true);
		g3.addEdge(2, 0, true);
		g3.addEdge(1, 3, true);
		g3.addEdge(1, 4, true);
		g3.addEdge(1, 6, true);
		g3.addEdge(3, 5, true);
		g3.addEdge(4, 5, true);
		return g3;
	}
}
