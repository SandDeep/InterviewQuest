package com.rough;

public class P25 {

	public static void main(String[] args) {
		P25 test = new P25();
		GraphNew graph = test.getGraph2();

		boolean status = isCyclic(graph);
		System.out.println(status);

		status = test.isCyclicSet(graph);
		System.out.println(status);
	}

	private boolean isCyclicSet(GraphNew graph) {
		int V = graph.vertices;
		int E = graph.edges;

		Subset[] subsets = new Subset[V];

		for (int i = 0; i < V; i++) {
			subsets[i] = new Subset(0, i);
		}

		for (int i = 0; i < E; i++) {
			int x = findSet(subsets, graph.edge[i].src);
			int y = findSet(subsets, graph.edge[i].dest);

			if (x == y) {
				return true;
			}

			unionSet(subsets, x, y);
		}
		return false;
	}

	private void unionSet(Subset[] subsets, int x, int y) {
		int xRoot = findSet(subsets, x);
		int yRoot = findSet(subsets, y);

		if (subsets[xRoot].rank < subsets[yRoot].rank) {
			subsets[xRoot].parent = yRoot;
		} else if (subsets[xRoot].rank > subsets[yRoot].rank) {
			subsets[yRoot].parent = xRoot;
		} else {
			subsets[yRoot].parent = xRoot;
			subsets[xRoot].rank++;
		}
	}

	private int findSet(Subset[] subsets, int i) {
		if (subsets[i].parent != i) {
			return findSet(subsets, subsets[i].parent);
		}
		return i;
	}

	private static boolean isCyclic(GraphNew graph) {
		int E = graph.edge.length;
		int V = graph.vertices;
		int[] parent = new int[V];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}

		for (int i = 0; i < E; i++) {
			int src = graph.edge[i].src;
			int dest = graph.edge[i].dest;

			int x = find(parent, src);
			int y = find(parent, dest);

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

	public GraphNew getGraph2() {
		GraphNew graph = new GraphNew(3, 3);

		graph.edge[0] = new Edge(0, 1);
		graph.edge[1] = new Edge(1, 2);
		graph.edge[2] = new Edge(2, 0);

		return graph;
	}
}

class Subset {
	int rank;
	int parent;

	public Subset() {
		this.rank = 0;
		this.parent = -1;
	}

	public Subset(int rank, int parent) {
		this.rank = rank;
		this.parent = parent;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "Subset [rank=" + rank + ", parent=" + parent + "]";
	}
}