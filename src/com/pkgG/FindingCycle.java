package com.pkgG;

import java.util.ArrayList;

/**
 * Finding Cycle for Undirected Graph
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class FindingCycle {

	ArrayList<ArrayList<Integer>> backedge;
	int[] parent;

	public FindingCycle() {
		backedge = new ArrayList<ArrayList<Integer>>();
	}

	public static void main(String[] args) {
		FindingCycle cycle = new FindingCycle();
		Graph graph = cycle.getGraph2();

		GraphState[] discovered = new GraphState[graph.vertices];
		for (int i = 0; i < discovered.length; i++) {
			discovered[i] = GraphState.UNDISCOVERED;
		}

		cycle.detectCycle(graph, discovered, 0);
		System.out.println(cycle.backedge);
	}

	public void detectCycle(Graph graph, GraphState[] discovered, int index) {
		System.out.println("EdgeNode " + index + " , Parent Node : "
				+ parent[index]);
		discovered[index] = GraphState.DISCOVERED;

		EdgeNode node = graph.arrayList[index].getHead();

		while (node != null) {

			if (discovered[node.getDest()] == GraphState.UNDISCOVERED) {
				parent[node.getDest()] = index;
				detectCycle(graph, discovered, node.getDest());
			}

			// Discovered but not processed
			else if (discovered[node.getDest()] != GraphState.PROCESSED) {
				processEdge(graph, index, discovered, node.getDest());
			}
			node = node.next;
		}

		discovered[index] = GraphState.PROCESSED;
	}

	private void processEdge(Graph graph, int x, GraphState[] discovered, int y) {
		if (parent[x] != y) {
			System.out.println("Found BackEdge : " + x + " --> " + y);
			ArrayList<Integer> tempList = new ArrayList<Integer>();
			tempList.add(x);
			tempList.add(y);

			backedge.add(tempList);
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

		parent = new int[6];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}
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

		parent = new int[6];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}
		return graph;
	}
}
