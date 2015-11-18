package com.pkgG;

public class TestGraph {

	public static void main(String[] args) {
		TestGraph testGraph = new TestGraph();
		Graph graph = testGraph.getGraph2();
		// graph.printGraph();
		// graph.bfs(0);
		// graph.bipartite();
		graph.dfs(0);
		System.out.println(graph);
	}

	public Graph getGraph() {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1, false);
		graph.addEdge(0, 4, false);
		graph.addEdge(1, 2, false);
		graph.addEdge(1, 3, false);
		graph.addEdge(1, 4, false);
		graph.addEdge(2, 3, false);
		graph.addEdge(3, 4, false);

		return graph;
	}

	public Graph getGraph1() {
		Graph graph = new Graph(6);
		graph.addEdge(0, 1, false);
		graph.addEdge(0, 4, false);
		graph.addEdge(0, 5, false);
		graph.addEdge(1, 2, false);
		graph.addEdge(1, 4, false);
		graph.addEdge(2, 3, false);
		graph.addEdge(3, 4, false);

		return graph;
	}

	public Graph getGraph2() {
		Graph graph = new Graph(6);
		graph.addEdgeEnd(0, 1, false);
		graph.addEdgeEnd(0, 4, false);
		graph.addEdgeEnd(0, 5, false);
		graph.addEdgeEnd(1, 2, false);
		graph.addEdgeEnd(1, 4, false);
		graph.addEdgeEnd(2, 3, false);
		graph.addEdgeEnd(3, 4, false);

		return graph;
	}
}
