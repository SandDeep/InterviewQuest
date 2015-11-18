package com.pkgG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ShortestPath {

	int[] visited = null;
	int vertices = 0;

	public ShortestPath(int vertices) {
		this.vertices = vertices;
		this.visited = new int[vertices];
	}

	public static void main(String[] args) {

		int vertices = 8;
		ShortestPath pathDAG = new ShortestPath(vertices);
		Graph graph = pathDAG.getGraph();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			do {

				// Display menu graphics
				System.out.println("============================");
				System.out.println("|   NETWORK OPERATION   |");
				System.out.println("============================");
				System.out.println("| Options:                 |");
				System.out.println("|        1. Find Path       |");
				System.out.println("|        2. Delete Node      |");
				System.out.println("|        3. Exit           |");
				System.out.println("============================");
				System.out.println(" Select option: ");

				int option = Integer.parseInt(br.readLine());

				switch (option) {
				case 1:
					System.out
							.println("Enter Source and Destination with comma separation. e.g. 1 , 5");
					String[] input = br.readLine().split(",");
					if (input.length < 2) {
						System.out.println("Please enter appropriate options.");
						break;
					}

					int src = Integer.parseInt(input[0]);
					int dest = Integer.parseInt(input[1]);

					System.out.println("Finding Shortest Path.");
					pathDAG.shortestPath(graph, src, dest);
					break;

				case 2:
					System.out.println("Enter Node to delete");
					int node = Integer.parseInt(br.readLine());
					graph.deleteNode(node);
					break;

				case 3:
					System.out.println("Exiting.");
					System.exit(1);

				default:
					System.out.println("Please Enter Appropriate Option.");
					break;
				}
			} while (true);

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}

	public void shortestPath(Graph graph, int src, int dest) {
		Stack<Integer> stack = new Stack<Integer>();

		int[] parent = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			parent[i] = -1;
			visited[i] = 0;
		}

		for (int i = 0; i < vertices; i++) {
			if (visited[i] != 1) {
				topologicalSort(graph, i, stack);
			}
		}

		int[] distance = new int[vertices];

		for (int i = 0; i < vertices; i++) {
			distance[i] = Integer.MAX_VALUE;
		}
		distance[src] = 0;
		System.out.println("\n");

		while (!stack.isEmpty()) {
			int u = stack.pop();

			if (distance[u] != Integer.MAX_VALUE) {
				EdgeNode node = graph.arrayList[u].head;

				while (node != null) {
					int v = node.dest;
					if (distance[u] + node.weight < distance[v]) {
						distance[v] = distance[u] + node.weight;
						parent[v] = u;
					}
					node = node.next;
				}
			}
		}

		for (int i = 0; i < vertices; i++) {
			if (distance[i] == Integer.MAX_VALUE) {
				System.out.print("INF" + " ");
			} else {
				System.out.print(distance[i] + " ");
			}
		}

		tracePath(parent, src, dest);
	}

	private void tracePath(int[] parent, int src, int dest) {
		int index = parent[dest];
		Stack<Integer> stack = new Stack<>();
		stack.push(dest);

		if (index == -1) {
			System.out.println("Path not Possible.");
		}
		while (index != -1 && index != src) {
			index = parent[index];
			stack.push(index);
		}

		System.out.println("Shortest Path : ");
		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " -> ");
		}
		System.out.println("NULL");
	}

	public void topologicalSort(Graph graph, int i, Stack<Integer> stack) {
		visited[i] = 1;

		EdgeNode node = graph.arrayList[i].head;

		while (node != null) {
			if (visited[node.dest] != 1) {
				topologicalSort(graph, node.dest, stack);
			}
			node = node.next;
		}
		stack.push(i);
	}

	private Graph getGraph() {
		Graph graph = new Graph(vertices);
		graph.addEdgeEnd(0, 2, 7, true);
		graph.addEdgeEnd(0, 3, 2, true);
		graph.addEdgeEnd(1, 2, 8, true);
		graph.addEdgeEnd(2, 3, 1, true);
		graph.addEdgeEnd(2, 6, 5, true);
		graph.addEdgeEnd(3, 4, 3, true);
		graph.addEdgeEnd(3, 5, 5, true);
		graph.addEdgeEnd(3, 6, 3, true);
		graph.addEdgeEnd(4, 5, 1, true);
		graph.addEdgeEnd(5, 7, 9, true);
		graph.addEdgeEnd(6, 7, 5, true);

		return graph;
	}
}
