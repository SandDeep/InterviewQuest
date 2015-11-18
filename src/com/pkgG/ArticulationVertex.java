package com.pkgG;

/**
 * time complexity is same as DFS which is O(V+E) for adjacency list
 * representation of graph.
 * 
 * @author Deepesh
 * 
 */
public class ArticulationVertex {

	static int time = 0;

	public static void main(String[] args) {
		ArticulationVertex vertex = new ArticulationVertex();
		Graph graph = vertex.getGraph1();

		vertex.findAP(graph);
	}

	private void findAP(Graph graph) {
		int V = graph.vertices;

		int[] disc = new int[V];
		int[] low = new int[V];
		int[] visted = new int[V];
		int[] parent = new int[V];
		int[] ap = new int[V];

		for (int i = 0; i < parent.length; i++) {
			disc[i] = -1;
			low[i] = -1;
			parent[i] = -1;
			ap[i] = -1;
		}

		for (int i = 0; i < V; i++) {
			if (visted[i] != 1) {
				dfsUtil(graph, disc, low, visted, parent, ap, i);
			}
		}

		for (int i = 0; i < ap.length; i++) {
			if (ap[i] == 1) {
				System.out.print(i + " ");
			}
		}
	}

	private void dfsUtil(Graph graph, int[] disc, int[] low, int[] visted,
			int[] parent, int[] ap, int u) {

		visted[u] = 1;
		low[u] = disc[u] = ++time;
		System.out.println("DFS : " + u);
		int child = 0;
		EdgeNode node = graph.arrayList[u].head;

		while (node != null) {
			int v = node.dest;

			if (visted[v] != 1) {
				child++;
				parent[v] = u;
				dfsUtil(graph, disc, low, visted, parent, ap, v);

				// Tree Edge
				low[u] = Math.min(low[u], low[v]);

				// root and child count >2
				if (parent[u] == -1 && child > 1) {
					ap[u] = 1;
				}

				// If u is not root and low value of one of its child is more
				// than discovery value of u.
				if (parent[u] != -1 && low[v] >= disc[u]) {
					ap[u] = 1;
				}
			} else {
				// Back Edge
				low[u] = Math.min(low[u], disc[v]);
			}

			node = node.next;
		}

	}

	public Graph getGraph() {
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

	public Graph getGraph1() {
		Graph graph = new Graph(5);
		graph.addEdgeEnd(1, 0, false);
		graph.addEdgeEnd(0, 2, false);
		graph.addEdgeEnd(2, 1, false);
		graph.addEdgeEnd(0, 3, false);
		graph.addEdgeEnd(3, 4, false);

		return graph;
	}

	public Graph getGraph3() {
		Graph graph = new Graph(7);
		graph.addEdgeEnd(0, 1, false);
		graph.addEdgeEnd(1, 2, false);
		graph.addEdgeEnd(2, 0, false);
		graph.addEdgeEnd(1, 3, false);
		graph.addEdgeEnd(1, 4, false);
		graph.addEdgeEnd(1, 6, false);
		graph.addEdgeEnd(3, 5, false);
		graph.addEdgeEnd(4, 5, false);

		return graph;
	}
}
