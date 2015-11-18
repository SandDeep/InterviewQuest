package com.pkgG;

/**
 * Eulerian Cycle An undirected graph has Eulerian cycle if following two
 * conditions are true. ….a) All vertices with non-zero degree are connected. We
 * don’t care about vertices with zero degree because they don’t belong to
 * Eulerian Cycle or Path (we only consider all edges). ….b) All vertices have
 * even degree.
 * 
 * Eulerian Path An undirected graph has Eulerian Path if following two
 * conditions are true. ….a) Same as condition (a) for Eulerian Cycle ….b) If
 * zero or two vertices have odd degree and all other vertices have even degree.
 * Note that only one vertex with odd degree is not possible in an undirected
 * graph (sum of all degrees is always even in an undirected graph)
 * 
 * Time Complexity: O(V+E)
 * 
 * @author Deepesh
 * 
 */
public class Eulerian {

	public static void main(String[] args) {
		Graph graph = getGraph4();

		Eulerian eulerian = new Eulerian();
		int res = eulerian.isEulerian(graph);

		if (res == 0)
			System.out.println("Graph is not Eulerian\n");
		else if (res == 1)
			System.out.println("Graph has a Euler path\n");
		else
			System.out.println("Graph has a Euler cycle\n");
	}

	/*
	 * The function returns one of the following values 0 --> If graph is not
	 * Eulerian 1 --> If graph has an Euler path (Semi-Eulerian) 2 --> If graph
	 * has an Euler Circuit (Eulerian)
	 */
	private int isEulerian(Graph graph) {
		int V = graph.vertices;
		int[] degree = new int[V];

		int res = IsConnected(graph, degree);
		if (res == 0) {
			return 0;
		}

		int odd = 0;
		for (int i = 0; i < degree.length; i++) {
			if (degree[i] % 2 != 0) {
				odd++;
			}
		}

		if (odd > 2) {
			return 0;
		}

		// Note that odd count can never be 1 for undirected graph
		return (odd == 0) ? 2 : 1;
	}

	private int IsConnected(Graph graph, int[] degree) {

		int V = graph.vertices;
		int[] visited = new int[V];
		int[] parent = new int[V];

		int result = 1;

		for (int i = 0; i < degree.length; i++) {
			parent[i] = -1;
		}

		int i = 0;

		for (i = 0; i < V; i++) {
			if (getSize(graph, i) != 0) {
				break;
			}
		}

		if (i == V) {
			return 1;
		}
		dfsUtil(graph, degree, parent, visited, i);

		for (int j = 0; j < visited.length; j++) {
			if (visited[i] != 1) {
				result = 0;
				break;
			}
		}

		return result;
	}

	private int getSize(Graph graph, int i) {
		EdgeNode node = graph.arrayList[i].head;
		int count = 0;

		while (node != null) {
			count++;
			node = node.next;
		}
		return count;
	}

	private void dfsUtil(Graph graph, int[] degree, int[] parent,
			int[] visited, int u) {
		visited[u] = 1;

		int deg = 0;
		EdgeNode node = graph.arrayList[u].head;

		while (node != null) {
			int v = node.dest;
			deg++;

			if (visited[v] != 1) {
				parent[v] = u;
				dfsUtil(graph, degree, parent, visited, v);
			}
			node = node.next;
		}
		degree[u] = deg;
	}

	public static Graph getGraph() {
		Graph g1 = new Graph(5);
		g1.addEdge(1, 0, false);
		g1.addEdge(0, 2, false);
		g1.addEdge(2, 1, false);
		g1.addEdge(0, 3, false);
		g1.addEdge(3, 4, false);
		return g1;
	}

	public static Graph getGraph1() {
		Graph g1 = new Graph(5);
		g1.addEdge(1, 0, false);
		g1.addEdge(0, 2, false);
		g1.addEdge(2, 1, false);
		g1.addEdge(0, 3, false);
		g1.addEdge(3, 4, false);
		g1.addEdge(4, 0, false);
		return g1;
	}

	public static Graph getGraph3() {
		Graph g1 = new Graph(5);
		g1.addEdge(1, 0, false);
		g1.addEdge(0, 2, false);
		g1.addEdge(2, 1, false);
		g1.addEdge(0, 3, false);
		g1.addEdge(3, 4, false);
		g1.addEdge(1, 3, false);
		return g1;
	}

	public static Graph getGraph4() {
		Graph g1 = new Graph(3);
		g1.addEdge(0, 1, false);
		g1.addEdge(0, 2, false);
		g1.addEdge(1, 2, false);
		return g1;
	}

	public static Graph getGraph5() {
		Graph g1 = new Graph(3);
		return g1;
	}

}
