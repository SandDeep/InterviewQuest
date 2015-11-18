package com.pkgG;

public class BellmanFord {

	public static void main(String[] args) {
		GraphNew graph = getGraph(5, 8);

		BellmanFord bellmanFord = new BellmanFord();
		bellmanFord.shortestPath(graph, 0);
	}

	public void shortestPath(GraphNew graph, int s) {
		int vertices = graph.vertices;
		int edges = graph.edges;

		int[] distance = new int[vertices];
		for (int i = 0; i < distance.length; i++) {
			distance[i] = Integer.MAX_VALUE;
		}

		distance[s] = 0;

		for (int i = 1; i <= vertices - 1; i++) {
			for (int j = 0; j < edges; j++) {
				int u = graph.edge[j].src;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;

				if (distance[u] != Integer.MAX_VALUE
						&& (distance[u] + weight < distance[v])) {
					distance[v] = distance[u] + weight;
				}
			}
		}

		for (int j = 0; j < edges; j++) {
			int u = graph.edge[j].src;
			int v = graph.edge[j].dest;
			int weight = graph.edge[j].weight;

			if (distance[u] != Integer.MAX_VALUE
					&& (distance[u] + weight < distance[v])) {
				System.out.println("Graph contains negative weight cycle");
			}
		}

		printSol(distance, vertices);
	}

	private void printSol(int[] distance, int vertices) {
		System.out.println("Vertex   Distance from Source\n");
		for (int i = 0; i < vertices; i++) {
			System.out.println(i + "   " + distance[i]);
		}
	}

	public static GraphNew getGraph(int vertices, int edges) {
		GraphNew graph = new GraphNew(vertices, edges);

		// add edge 0-1
		graph.edge[0] = new Edge(0, 1, -1);

		// add edge 0-2
		graph.edge[1] = new Edge(0, 2, 4);

		// add edge 1-2
		graph.edge[2] = new Edge(1, 2, 3);

		// add edge 1-3
		graph.edge[3] = new Edge(1, 3, 2);

		// add edge 1-4
		graph.edge[4] = new Edge(1, 4, 2);

		// add edge 3-2
		graph.edge[5] = new Edge(3, 2, 5);

		// add edge 3-1
		graph.edge[6] = new Edge(3, 1, 1);

		// add edge 4-3
		graph.edge[7] = new Edge(4, 3, -3);

		return graph;
	}

}
