package com.pkgG;


public class KruskalMST {

	Subset[] subsets = null;

	public KruskalMST(int vertices) {
		subsets = new Subset[vertices];
		for (int i = 0; i < vertices; i++) {
			subsets[i] = new Subset(i, 0);
		}
	}

	public static void main(String[] args) {
		GraphNew graph = getGraph(4, 5);
		//GraphNew graph = getGraph1(9, 14);

		KruskalMST mst = new KruskalMST(4);
		mst.kruskalMST(graph);

	}

	public void kruskalMST(GraphNew graph) {
		quickSort(graph.edge, 0, graph.edge.length - 1);

		int[] mstSet = new int[graph.getEdges()];

		for (int i = 0; i < graph.edges; i++) {
			if (mstSetCheck(mstSet) == (graph.getVertices() - 1)) {
				printMSTEdge(graph, mstSet);
				return;
			}

			if (!isCyclic(graph, i)) {
				mstSet[i] = 1;
			}
		}

	}

	public void printMSTEdge(GraphNew graph, int[] mstSet) {
		System.out.println("\nMST Path");
		for (int i = 0; i < mstSet.length; i++) {
			if (mstSet[i] == 1) {
				System.out.println(graph.edge[i]);
			}
		}
	}

	public boolean isCyclic(GraphNew graph, int i) {

		int x = find(graph.edge[i].getSrc());
		int y = find(graph.edge[i].getDest());

		if (x == y) {
			return true;
		}

		union(x, y);
		return false;
	}

	public void union(int x, int y) {
		if (subsets[x].getRank() < subsets[y].getRank()) {
			subsets[y].setParent(x);
		} else if (subsets[x].getRank() > subsets[y].getRank()) {
			subsets[x].setParent(y);
		} else {
			subsets[y].setParent(x);
			subsets[x].setRank(subsets[x].getRank() + 1);
		}
	}

	public int find(int i) {
		if (subsets[i].getParent() != i) {
			return find(subsets[i].getParent());
		}
		return i;
	}

	public int mstSetCheck(int[] mstSet) {
		int count = 0;
		for (int i = 0; i < mstSet.length; i++) {
			if (mstSet[i] == 1) {
				count++;
			}
		}
		return count;
	}

	public void quickSort(Edge[] edges, int start, int end) {
		if (start < end) {
			int pivotIndex = partition(edges, start, end);
			quickSort(edges, start, pivotIndex - 1);
			quickSort(edges, pivotIndex + 1, end);
		}
	}

	public int partition(Edge[] edges, int start, int end) {

		int pivot = edges[end].getWeight();
		int pivotIndex = start;

		for (int i = start; i < end; i++) {
			if (edges[i].getWeight() <= pivot) {
				swap(edges, i, pivotIndex);
				pivotIndex++;
			}
		}

		swap(edges, pivotIndex, end);

		return pivotIndex;
	}

	public static void swap(Edge[] arr, int mIndex, int nIndex) {
		Edge temp = arr[mIndex];
		arr[mIndex] = arr[nIndex];
		arr[nIndex] = temp;
	}

	public static GraphNew getGraph(int vertices, int edges) {
		GraphNew graph = new GraphNew(vertices, edges);

		// add edge 0-1
		graph.edge[0] = new Edge(0, 1, 10);

		// add edge 0-2
		graph.edge[1] = new Edge(0, 2, 6);

		// add edge 0-3
		graph.edge[2] = new Edge(0, 3, 5);

		// add edge 1-3
		graph.edge[3] = new Edge(1, 3, 15);

		// add edge 2-3
		graph.edge[4] = new Edge(2, 3, 4);
		return graph;
	}

	public static GraphNew getGraph1(int vertices, int edges) {
		GraphNew graph = new GraphNew(vertices, edges);

		// add edge 0-1
		graph.edge[0] = new Edge(0, 1, 4);

		// add edge 0-7
		graph.edge[1] = new Edge(0, 7, 8);

		// add edge 1-2
		graph.edge[2] = new Edge(1, 2, 8);

		// add edge 1-7
		graph.edge[3] = new Edge(1, 7, 11);

		// add edge 2-3
		graph.edge[4] = new Edge(2, 3, 7);

		// add edge 2-5
		graph.edge[5] = new Edge(2, 5, 4);

		// add edge 2-8
		graph.edge[6] = new Edge(2, 8, 2);

		// add edge 3-4
		graph.edge[7] = new Edge(3, 4, 9);

		// add edge 3-5
		graph.edge[8] = new Edge(3, 5, 14);

		// add edge 4-5
		graph.edge[9] = new Edge(4, 5, 10);

		// add edge 5-6
		graph.edge[10] = new Edge(5, 6, 2);

		// add edge 6-8
		graph.edge[11] = new Edge(6, 8, 6);

		// add edge 6-7
		graph.edge[12] = new Edge(6, 7, 1);

		// add edge 7-8
		graph.edge[13] = new Edge(7, 8, 7);

		return graph;
	}
}
