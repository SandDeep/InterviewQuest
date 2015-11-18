package com.pkgG;

import java.util.Stack;

/**
 * Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of
 * vertices such that for every directed edge uv, vertex u comes before v in the
 * ordering. Topological Sorting for a graph is not possible if the graph is not
 * a DAG.
 * 
 * @author Deepesh
 * 
 */
public class TopologicalSort {

	int[] visited = null;
	int vertices = 0;

	public TopologicalSort(int vertices) {
		this.vertices = vertices;
		this.visited = new int[vertices];
	}

	public static void main(String[] args) {
		int vertices = 6;
		Graph graph = new Graph(vertices);
		graph.addEdgeEnd(5, 2, true);
		graph.addEdgeEnd(5, 0, true);
		graph.addEdgeEnd(4, 0, true);
		graph.addEdgeEnd(4, 1, true);
		graph.addEdgeEnd(2, 3, true);
		graph.addEdgeEnd(3, 1, true);

		TopologicalSort sort = new TopologicalSort(vertices);
		sort.topologicalSort(graph);
	}

	private void topologicalSort(Graph graph) {
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = vertices - 1; i >= 0; i--) {
			if (visited[i] != 1) {
				topologicalSortUtil(graph, stack, i);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
	}

	private void topologicalSortUtil(Graph graph, Stack<Integer> stack, int i) {
		visited[i] = 1;

		EdgeNode edge = graph.arrayList[i].head;

		while (edge != null) {
			if (visited[edge.dest] != 1) {
				topologicalSortUtil(graph, stack, edge.dest);
			}
			edge = edge.next;
		}
		stack.push(i);
	}
}
