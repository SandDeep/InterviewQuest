package com.pkgG;

import java.util.Arrays;

/**
 * If graph contain triangle, 3 colors turns out to be optimal solution.
 * http://mrsleblancsmath.pbworks.com/w/file/fetch/46119304/vertex%20coloring%20algorithm.pdf
 * 
 * @author Deepesh
 * 
 */
public class GraphColoring {

	public static void main(String[] args) {
		Graph graph = getGraph1();

		GraphColoring coloring = new GraphColoring();
		coloring.greedyColoring(graph);

		Graph graph2 = getGraph2();
		coloring.vertexColoring(graph2);
	}

	/**
	 * Welsh-Powell Algorithm - Vertex Coloring [Time Complexity - O(V(V+E))]
	 * 
	 * @param graph
	 */
	public void vertexColoring(Graph graph) {

		int[] visited = new int[graph.vertices];
		int[] degree = new int[graph.vertices];
		int[] color = new int[graph.vertices];

		for (int i = 0; i < degree.length; i++) {
			degree[i] = -1;
			color[i] = -1;
		}

		// Since, it is a connected graph, no need for loop checking
		dfsUtil(graph, visited, degree, 0);
		System.out.println(Arrays.toString(degree));

		int[] gPoints = new int[graph.vertices];
		for (int i = 0; i < gPoints.length; i++) {
			gPoints[i] = i;
		}

		Vertex[] vertexes = new Vertex[graph.vertices];
		for (int i = 0; i < vertexes.length; i++) {
			vertexes[i] = new Vertex(i, degree[i]);
		}
		quickSort(vertexes, 0, graph.vertices - 1);

		// System.out.println(Arrays.toString(vertexes));

		colorVertices(graph, vertexes, color, 0);
		System.out.println(Arrays.toString(color));
	}

	public void colorVertices(Graph graph, Vertex[] vertexes, int[] color,
			int colorName) {

		if (allColored(color) == true) {
			return;
		}

		int start = 0;
		for (start = 0; start < vertexes.length; start++) {
			if (vertexes[start].getName() != -1) {
				color[vertexes[start].getName()] = colorName;
				vertexes[start].setName(-1);
				start++;
				break;
			}
		}

		for (int i = start; i < color.length; i++) {
			int u = vertexes[i].getName();
			if (u == -1) {
				continue;
			}
			EdgeNode node = graph.arrayList[u].head;

			boolean flag = false;

			while (node != null) {
				int v = node.dest;

				if (color[v] == colorName) {
					flag = true;
					break;
				}
				node = node.next;
			}

			if (flag == false) {
				color[u] = colorName;
				vertexes[i].setName(-1);
			}
		}

		colorVertices(graph, vertexes, color, colorName + 1);
	}

	private boolean allColored(int[] color) {
		for (int i = 0; i < color.length; i++) {
			if (color[i] == -1) {
				return false;
			}
		}
		return true;
	}

	public void quickSort(Vertex[] vertexes, int start, int end) {
		if (start < end) {
			int pivotIndex = partition(vertexes, start, end);
			quickSort(vertexes, start, pivotIndex - 1);
			quickSort(vertexes, pivotIndex + 1, end);
		}
	}

	public int partition(Vertex[] vertexes, int start, int end) {
		int pIndex = start;
		int pivot = vertexes[end].getDegree();

		for (int i = start; i < end; i++) {
			if (vertexes[i].getDegree() >= pivot) {
				swap(vertexes, i, pIndex);
				pIndex++;
			}
		}

		// swap pIndex with pivot[last element]
		swap(vertexes, end, pIndex);

		return pIndex;
	}

	public void dfsUtil(Graph graph, int[] visited, int[] degree, int u) {
		visited[u] = 1;

		int count = 0;

		EdgeNode node = graph.arrayList[u].head;

		while (node != null) {
			count++;
			int v = node.dest;

			if (visited[v] != 1) {
				dfsUtil(graph, visited, degree, v);
			}

			node = node.next;
		}

		degree[u] = count;
	}

	public void swap(Vertex[] vertexes, int mIndex, int nIndex) {
		Vertex temp = vertexes[mIndex];
		vertexes[mIndex] = vertexes[nIndex];
		vertexes[nIndex] = temp;
	}

	public void greedyColoring(Graph graph) {
		int[] result = new int[graph.vertices];

		result[0] = 0;
		for (int i = 1; i < result.length; i++) {
			result[i] = -1;
		}

		boolean[] available = new boolean[graph.vertices];

		for (int i = 1; i < graph.vertices; i++) {

			EdgeNode node = graph.arrayList[i].head;

			// mark available colors
			while (node != null) {
				int v = node.dest;

				if (result[v] != -1) {
					available[result[v]] = true;
				}

				node = node.next;
			}

			// Search Available Color
			int j = 0;
			for (j = 0; j < available.length; j++) {
				if (available[j] == false) {
					break;
				}
			}

			result[i] = j;

			for (int k = 0; k < available.length; k++) {
				available[k] = false;
			}
		}

		for (int i = 0; i < result.length; i++) {
			System.out.println("Color " + i + " -- " + result[i]);
		}
	}

	public static Graph getGraph() {
		Graph g1 = new Graph(5);
		g1.addEdge(0, 1, false);
		g1.addEdge(0, 2, false);
		g1.addEdge(1, 2, false);
		g1.addEdge(1, 3, false);
		g1.addEdge(2, 3, false);
		g1.addEdge(3, 4, false);
		return g1;
	}

	public static Graph getGraph1() {
		Graph g1 = new Graph(5);
		g1.addEdge(0, 1, false);
		g1.addEdge(0, 2, false);
		g1.addEdge(1, 2, false);
		g1.addEdge(1, 4, false);
		g1.addEdge(2, 4, false);
		g1.addEdge(4, 3, false);
		return g1;
	}

	public static Graph getGraph2() {
		Graph g1 = new Graph(11);
		g1.addEdge(0, 1, false);
		g1.addEdge(0, 7, false);
		g1.addEdge(1, 3, false);
		g1.addEdge(3, 2, false);
		g1.addEdge(3, 8, false);
		g1.addEdge(3, 10, false);
		g1.addEdge(4, 5, false);
		g1.addEdge(4, 10, false);
		g1.addEdge(5, 6, false);
		g1.addEdge(6, 7, false);
		g1.addEdge(6, 10, false);
		g1.addEdge(7, 10, false);
		g1.addEdge(7, 9, false);
		g1.addEdge(7, 8, false);
		g1.addEdge(8, 9, false);
		g1.addEdge(9, 10, false);
		return g1;
	}
}

class Vertex {
	int name;
	int degree;

	public Vertex(int name, int degree) {
		this.name = name;
		this.degree = degree;
	}

	public int getName() {
		return name;
	}

	public void setName(int name) {
		this.name = name;
	}

	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	@Override
	public String toString() {
		return "Vertex [name=" + name + ", degree=" + degree + "]";
	}

}
