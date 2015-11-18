package com.rough;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class P9 {

	public static void main(String[] args) {
		P9 test = new P9();

		Graph graph = test.getGraph1();

		test.bfs(graph);
		test.dfs(graph);

		boolean status = isCyclic(graph);
		System.out.println("isCyclic : " + status);

		GraphNew graph1 = test.getGraph2();
		status = isCyclicSet(graph1);
		System.out.println("isCyclic : " + status);

		Graph graph2 = test.getGraph4();
		test.topological(graph2);
	}

	private void topological(Graph graph) {
		int vertices = graph.vertices;
		boolean visited[] = new boolean[vertices];

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < vertices; i++) {
			if (!visited[i]) {
				topoUtil(graph, i, visited, stack);
			}
		}

		int distance[] = new int[vertices];

		for (int i = 0; i < vertices; i++) {
			distance[i] = Integer.MIN_VALUE;
		}

		int s = 1;
		distance[s] = 0;

		while (!stack.isEmpty()) {
			int u = stack.pop();

			if (distance[u] != Integer.MIN_VALUE) {
				EdgeNode node = graph.list[u].head;

				while (node != null) {
					int v = node.dest;

					if (distance[u] + node.weight > distance[v]) {
						distance[v] = distance[u] + node.weight;
					}
					node = node.next;
				}
			}
		}

		for (int i = 0; i < vertices; i++) {
			if (distance[i] == Integer.MIN_VALUE) {
				System.out.print("INF" + " ");
			} else {
				System.out.print(distance[i] + " ");
			}
		}
	}

	private void topoUtil(Graph graph, int u, boolean[] visited,
			Stack<Integer> stack) {
		visited[u] = true;

		EdgeNode node = graph.list[u].head;

		while (node != null) {
			EdgeNode temp = node;
			int v = temp.dest;

			if (!visited[v]) {
				visited[v] = true;
				topoUtil(graph, v, visited, stack);
			}
			node = node.next;
		}
		stack.push(u);
	}

	private static boolean isCyclicSet(GraphNew graph) {
		int V = graph.vertices;
		int[] parent = new int[V];

		for (int i = 0; i < V; i++) {
			parent[i] = -1;
		}

		for (int i = 0; i < V; i++) {
			int x = find(parent, graph.edge[i].src);
			int y = find(parent, graph.edge[i].dest);

			if (x == y) {
				return true;
			}

			union(parent, x, y);
		}

		return false;
	}

	private static void union(int[] parent, int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);

		parent[xset] = yset;
	}

	private static int find(int[] parent, int i) {
		if (parent[i] == -1) {
			return i;
		}
		return find(parent, parent[i]);
	}

	private static boolean isCyclic(Graph graph) {
		int vertices = graph.vertices;

		boolean[] visited = new boolean[vertices];
		boolean[] recStack = new boolean[vertices];

		for (int i = 0; i < vertices; i++) {
			if (isCyclicUtil(graph, i, visited, recStack)) {
				return true;
			}
		}
		return false;
	}

	private static boolean isCyclicUtil(Graph graph, int i, boolean[] visited,
			boolean[] recStack) {
		visited[i] = true;
		recStack[i] = true;

		EdgeNode node = graph.list[i].head;

		while (node != null) {
			EdgeNode temp = node;
			int v = temp.dest;

			if (!visited[v] && isCyclicUtil(graph, v, visited, recStack)) {
				return true;
			} else if (recStack[v]) {
				return true;
			}
		}

		recStack[i] = false;
		return false;
	}

	private void dfs(Graph graph) {
		int vertices = graph.vertices;
		boolean visited[] = new boolean[vertices];
		int parents[] = new int[vertices];

		for (int i = 0; i < parents.length; i++) {
			parents[i] = -1;
		}

		for (int i = 0; i < vertices; i++) {
			if (!visited[i]) {
				dfsUtil(graph, 0, visited, parents);
			}
		}

	}

	private void dfsUtil(Graph graph, int i, boolean[] visited, int[] parents) {
		visited[i] = true;
		parents[i] = -1;

		System.out.print(i + " ");
		EdgeNode node = graph.list[i].head;

		while (node != null) {
			EdgeNode temp = node;
			int dest = temp.dest;

			if (!visited[dest]) {
				visited[dest] = true;
				parents[dest] = i;
				dfsUtil(graph, dest, visited, parents);
			}
			node = node.next;
		}
	}

	private void bfs(Graph graph) {
		int vertices = graph.vertices;
		boolean visited[] = new boolean[vertices];
		int parents[] = new int[vertices];

		for (int i = 0; i < parents.length; i++) {
			parents[i] = -1;
		}

		for (int i = 0; i < vertices; i++) {
			if (!visited[i]) {
				bfsUtil(graph, 0, visited, parents);
			}
		}

	}

	private void bfsUtil(Graph graph, int i, boolean[] visited, int[] parents) {

		Queue<Integer> queue = new LinkedList<Integer>();
		parents[i] = -1;
		visited[0] = true;
		queue.add(i);

		while (!queue.isEmpty()) {
			int index = queue.poll();
			System.out.print(index + " ");
			EdgeNode node = graph.list[index].head;

			while (node != null) {
				EdgeNode temp = node;
				int dest = temp.dest;

				if (!visited[dest]) {
					visited[dest] = true;
					parents[dest] = index;
					queue.add(dest);
				}
				node = node.next;
			}
		}
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

	private void addEdge(Graph graph, int src, int dest, int weight,
			boolean directed) {
		EdgeNode newnode = new EdgeNode(dest);
		newnode.setWeight(weight);

		EdgeNode head = graph.list[src].head;

		if (head == null) {
			graph.list[src].head = newnode;
		} else {
			newnode.next = head;
			graph.list[src].head = newnode;
		}

		if (!directed) {
			newnode = new EdgeNode(src);
			newnode.setWeight(weight);
			head = graph.list[dest].head;

			if (head != null) {
				newnode.next = head;
				graph.list[dest].head = newnode;
			} else {
				graph.list[dest].head = newnode;
			}
		}
	}

	public Graph getGraph() {
		Graph graph = new Graph(5);
		addEdge(graph, 0, 1, false);
		addEdge(graph, 0, 4, false);
		addEdge(graph, 1, 2, false);
		addEdge(graph, 1, 3, false);
		addEdge(graph, 1, 4, false);
		addEdge(graph, 2, 3, false);
		addEdge(graph, 3, 4, false);

		return graph;
	}

	public Graph getGraph1() {
		Graph graph = new Graph(4);
		addEdge(graph, 0, 1, true);
		addEdge(graph, 0, 2, true);
		addEdge(graph, 1, 2, true);
		addEdge(graph, 2, 0, true);
		addEdge(graph, 2, 3, true);
		addEdge(graph, 3, 3, true);

		return graph;
	}

	public Graph getGraph3() {
		Graph graph = new Graph(6);
		addEdge(graph, 5, 2, true);
		addEdge(graph, 5, 0, true);
		addEdge(graph, 4, 0, true);
		addEdge(graph, 4, 1, true);
		addEdge(graph, 2, 3, true);
		addEdge(graph, 3, 1, true);

		return graph;
	}

	public Graph getGraph4() {
		Graph graph = new Graph(6);
		addEdge(graph, 0, 1, 5, true);
		addEdge(graph, 0, 2, 3, true);
		addEdge(graph, 1, 3, 6, true);
		addEdge(graph, 1, 2, 2, true);
		addEdge(graph, 2, 4, 4, true);
		addEdge(graph, 2, 5, 2, true);
		addEdge(graph, 2, 3, 7, true);
		addEdge(graph, 3, 5, 1, true);
		addEdge(graph, 3, 4, -1, true);
		addEdge(graph, 4, 5, -2, true);

		return graph;
	}

	public GraphNew getGraph2() {
		GraphNew graph = new GraphNew(3, 3);

		graph.edge[0] = new Edge(0, 1);
		graph.edge[1] = new Edge(1, 2);
		graph.edge[2] = new Edge(2, 0);

		return graph;
	}
}
