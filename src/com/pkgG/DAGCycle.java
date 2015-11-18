package com.pkgG;

public class DAGCycle {

	int[] visited = null;
	int[] recurStack = null;

	public DAGCycle(int vertices) {
		visited = new int[vertices];
		recurStack = new int[vertices];
	}

	public static void main(String[] args) {
		int vertices = 4;
		Graph graph = new Graph(vertices);
		graph.addEdgeEnd(0, 1, true);
		graph.addEdgeEnd(0, 2, true);
		graph.addEdgeEnd(1, 2, true);
		graph.addEdgeEnd(2, 0, true);
		graph.addEdgeEnd(2, 3, true);
		graph.addEdgeEnd(3, 3, true);

		DAGCycle dagCycle = new DAGCycle(vertices);
		dagCycle.isCyclic(graph);

	}

	public void isCyclic(Graph graph) {

		for (int i = 0; i < graph.vertices; i++) {
			boolean cycle = isCyclicUtil(graph, i);
			if (cycle) {
				System.out.println("Cycle Detected.");
			}
		}
	}

	public boolean isCyclicUtil(Graph graph, int i) {
		if (visited[i] != 1) {
			visited[i] = 1;
			recurStack[i] = 1;

			EdgeNode edge = graph.arrayList[i].head;

			while (edge != null) {
				if (visited[edge.dest] != 1 && isCyclicUtil(graph, edge.dest)) {
					return true;
				} else if (recurStack[edge.dest] == 1) {
					return true;
				}
				edge=edge.next;
			}
		}
		recurStack[i] = 0;
		return false;
	}
}
