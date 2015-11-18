package com.pkgG;

/**
 * Overall time complexity is O((V+E)*(V+E)) which can be written as O(E2) for a
 * connected graph.
 * 
 * @author Deepesh
 * 
 */
public class FlueryEulerianPath {

	static int index = 0;

	public static void main(String[] args) {
		Graph graph = getGraph2();

		FlueryEulerianPath path = new FlueryEulerianPath();
		path.printEulerPath(graph);
	}

	private void printEulerPath(Graph graph) {
		int odd = 0;
		int[] list = new int[graph.vertices];

		int V = graph.vertices;

		for (int i = 0; i < V; i++) {
			if (getSize(graph, i) % 2 != 0) {
				list[odd] = i;
				odd++;
			}
		}

		if (odd == 0) {
			eulerUtil(graph, 0);
		} else if (odd == 2) {
			eulerUtil(graph, list[0]);
		} else {
			System.out.println("No Euler Path\n");
			return;
		}
	}

	private void eulerUtil(Graph graph, int u) {
		EdgeNode node = graph.arrayList[u].head;

		while (node != null) {
			int v = node.dest;

			if (v != -1 && isSafeNextEdge(graph, u, v)) {
				System.out.println(u + " -- " + v);
				removeEdge(graph, u, v);
				eulerUtil(graph, v);
			}
			node = node.next;
		}
	}

	private boolean isSafeNextEdge(Graph graph, int u, int v) {

		int edgeCount = getSize(graph, u);

		if (edgeCount == 1) {
			return true;
		}

		int[] visited = new int[graph.vertices];

		dfs(graph, u, visited);
		int count1 = getReachableV(visited);

		// Remove Edge u-v
		removeEdge(graph, u, v);

		dfs(graph, u, visited);
		int count2 = getReachableV(visited);

		// Add Edge Back u-v
		graph.addEdge(u, v, false);

		return (count1 > count2) ? false : true;
	}

	private void removeEdge(Graph graph, int u, int v) {
		EdgeNode node = graph.arrayList[u].head;

		while (node != null) {
			if (node.dest == v) {
				node.setDest(-1);
				break;
			}
			node = node.next;
		}

		node = graph.arrayList[v].head;

		while (node != null) {
			if (node.dest == u) {
				node.setDest(-1);
				break;
			}
			node = node.next;
		}
	}

	private int getReachableV(int[] visited) {
		int count = 0;
		for (int i = 0; i < visited.length; i++) {
			if (visited[i] == 1) {
				count++;
			}
		}

		// Reverting changes in visited array
		for (int i = 0; i < visited.length; i++) {
			visited[i] = 0;
		}
		return count;
	}

	private void dfs(Graph graph, int u, int[] visited) {
		visited[u] = 1;

		EdgeNode node = graph.arrayList[u].head;

		while (node != null) {
			int v = node.dest;
			if (v != -1 && visited[v] != 1) {
				dfs(graph, v, visited);
			}
			node = node.next;
		}
	}

	private int getSize(Graph graph, int i) {
		EdgeNode node = graph.arrayList[i].head;
		int count = 0;

		while (node != null) {
			if (node.dest != -1) {
				count++;
			}
			node = node.next;
		}
		return count;
	}

	public static Graph getGraph() {
		Graph g1 = new Graph(4);
		g1.addEdge(0, 1, false);
		g1.addEdge(0, 2, false);
		g1.addEdge(1, 2, false);
		g1.addEdge(2, 3, false);
		return g1;
	}

	public static Graph getGraph1() {
		Graph g1 = new Graph(3);
		g1.addEdge(0, 1, false);
		g1.addEdge(1, 2, false);
		g1.addEdge(2, 0, false);
		return g1;
	}

	public static Graph getGraph2() {
		Graph g1 = new Graph(5);
		g1.addEdge(1, 0, false);
		g1.addEdge(0, 2, false);
		g1.addEdge(2, 1, false);
		g1.addEdge(0, 3, false);
		g1.addEdge(3, 4, false);
		g1.addEdge(3, 2, false);
		g1.addEdge(3, 1, false);
		g1.addEdge(2, 4, false);
		return g1;
	}
}
