package com.rough;

public class P24 {

	public static void main(String[] args) {
		P24 test = new P24();
		Graph graph = test.getGraph();

		boolean status = test.isCyclic(graph);
		System.out.println(status);

	}

	private boolean isCyclic(Graph graph) {
		int V = graph.vertices;

		boolean[] visited = new boolean[V];
		boolean[] recStack = new boolean[V];

		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				return dfs(graph, i, visited, recStack);
			}
		}

		return false;
	}

	private boolean dfs(Graph graph, int u, boolean[] visited,
			boolean[] recStack) {
		visited[u] = true;
		recStack[u] = true;

		EdgeNode node = graph.list[u].head;

		while (node != null) {
			int v = node.dest;

			if (!visited[v] && dfs(graph, v, visited, recStack)) {
				return true;
			}
			if (recStack[v]) {
				return true;
			}
		}
		recStack[u] = false;
		return false;
	}

	private void addEdge(Graph graph, int src, int dest, boolean directed) {
		EdgeNode node = new EdgeNode(dest);

		EdgeNode head = graph.list[src].head;

		if (head == null) {
			graph.list[src].head = node;
		} else {
			node.next = head;
			graph.list[src].head = node;
		}

		if (!directed) {
			node = new EdgeNode(src);
			head = graph.list[dest].head;

			if (head != null) {
				node.next = head;
				graph.list[dest].head = node;
			} else {
				graph.list[dest].head = node;
			}
		}
	}

	public Graph getGraph() {
		Graph graph = new Graph(4);
		addEdge(graph, 0, 1, true);
		addEdge(graph, 0, 2, true);
		addEdge(graph, 1, 2, true);
		addEdge(graph, 2, 0, true);
		addEdge(graph, 2, 3, true);
		addEdge(graph, 3, 3, true);

		return graph;
	}
}
