package com.pkgG;

public class UnionFind {

	int[] parent = null;
	Subset[] subsets = null;

	public UnionFind(int vertices) {
		parent = new int[vertices];
		subsets = new Subset[vertices];
	}

	public static void main(String[] args) {
		GraphNew graph = new GraphNew(3, 3);

		// add Edge 0-1
		graph.edge[0] = new Edge(0, 1);

		// add Edge 1-2
		graph.edge[1] = new Edge(1, 2);

		// add Edge 2-0
		graph.edge[2] = new Edge(2, 0);

		System.out.println(graph);

		UnionFind unionFind = new UnionFind(3);

		// boolean status = unionFind.isCycle(graph);

		boolean status = unionFind.isCycleByRank(graph);

		if (status) {
			System.out.println("Graph contains cycle");
		} else {
			System.out.println("Graph doesn't contain cycle");
		}
	}

	public boolean isCycleByRank(GraphNew graph) {

		for (int i = 0; i < graph.getVertices(); i++) {
			subsets[i] = new Subset(i, 0);
		}

		for (int i = 0; i < graph.getEdges(); i++) {
			int x = findByCycle(graph.edge[i].getSrc());
			int y = findByCycle(graph.edge[i].getDest());

			if (x == y) {
				return true;
			}

			unionByRank(x, y);
		}
		return false;
	}

	public void unionByRank(int x, int y) {
		int xroot = findByCycle(x);
		int yroot = findByCycle(y);

		if (subsets[xroot].rank < subsets[yroot].rank) {
			subsets[xroot].setParent(yroot);
		} else if (subsets[xroot].rank > subsets[yroot].rank) {
			subsets[yroot].setParent(xroot);
		} else {
			subsets[yroot].setParent(xroot);
			subsets[xroot].setRank(subsets[xroot].getRank() + 1);
		}
	}

	public int findByCycle(int i) {
		if (subsets[i].parent != i) {
			return findByCycle(parent[i]);
		}
		return subsets[i].parent;
	}

	public boolean isCycle(GraphNew graph) {

		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}

		for (int i = 0; i < graph.getEdges(); i++) {
			int x = find(graph.edge[i].src);
			int y = find(graph.edge[i].dest);

			if (x == y) {
				return true;
			}

			union(x, y);
		}
		return false;
	}

	public void union(int x, int y) {
		int xset = find(x);
		int yset = find(y);
		parent[xset] = yset;
	}

	public int find(int i) {
		if (parent[i] == -1) {
			return i;
		}
		return find(parent[i]);
	}
}
