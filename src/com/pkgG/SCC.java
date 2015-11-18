package com.pkgG;

import java.util.Stack;

/**
 * Kosaraju’s algorithm : O(V+E)
 * 
 * @author Deepesh
 * 
 */
public class SCC {

	public static void main(String[] args) {
		Graph graph = new Graph(5);

		graph.addEdgeEnd(1, 0, true);
		graph.addEdgeEnd(0, 2, true);
		graph.addEdgeEnd(2, 1, true);
		graph.addEdgeEnd(0, 3, true);
		graph.addEdgeEnd(3, 4, true);

		SCC scc = new SCC();
		scc.printSCC(graph);
	}

	private void printSCC(Graph graph) {
		int[] visited = new int[graph.vertices];
		Stack<Integer> stack = new Stack<Integer>();

		for (int j = 0; j < visited.length; j++) {
			if (visited[j] != 1) {
				dfsUtil(graph, visited, stack, 0);
			}
		}

		graph = reverseGraph(graph);

		for (int i = 0; i < visited.length; i++) {
			visited[i] = 0;
		}

		System.out
				.println("\nFollowing are strongly connected components in given graph ");
		while (!stack.isEmpty()) {
			int v = stack.pop();

			if (visited[v] != 1) {
				dfsUtil(graph, visited, stack, v);
				System.out.println();
			}
		}
	}

	private Graph reverseGraph(Graph graph) {
		Graph transpose = new Graph(graph.vertices);

		for (int i = 0; i < graph.vertices; i++) {
			EdgeNode node = graph.arrayList[i].head;
			while (node != null) {
				transpose.addEdge(node.dest, i, true);
				node = node.next;
			}
		}
		return transpose;
	}

	private void dfsUtil(Graph graph, int[] visited, Stack<Integer> stack,
			int index) {

		visited[index] = 1;
		System.out.print(index + " ");

		EdgeNode node = graph.arrayList[index].head;

		while (node != null) {
			int v = node.dest;

			if (visited[v] != 1) {
				dfsUtil(graph, visited, stack, v);
			}
			node = node.next;
		}

		stack.push(index);
	}
}
