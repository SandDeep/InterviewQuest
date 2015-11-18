package com.pkgG;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {

	int vertices;
	AdjList[] arrayList;
	int[] degree;

	boolean[] discovered;
	ColorRange[] color;
	boolean isBipartite = false;

	int[] entry;
	int[] exit;
	int[] parent;
	int time;

	public Graph(int vertices) {
		this.vertices = vertices;
		degree = new int[vertices];
		arrayList = new AdjList[vertices];

		for (int i = 0; i < arrayList.length; i++) {
			arrayList[i] = new AdjList();
		}

		discovered = new boolean[vertices];

		entry = new int[vertices];
		exit = new int[vertices];

		parent = new int[vertices];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = -1;
		}

	}

	public void addEdge(int src, int dest, boolean directed) {
		EdgeNode tmpNode = new EdgeNode(dest);

		EdgeNode nextNode = arrayList[src].getHead();

		if (nextNode != null) {
			tmpNode.setNext(nextNode);
			arrayList[src].setHead(tmpNode);
		} else {
			arrayList[src].setHead(tmpNode);
		}

		degree[src] += 1;

		// Graph is undirected
		if (!directed) {
			tmpNode = new EdgeNode(src);
			nextNode = arrayList[dest].getHead();

			if (nextNode != null) {
				tmpNode.setNext(nextNode);
				arrayList[dest].setHead(tmpNode);
			} else {
				arrayList[dest].setHead(tmpNode);
			}

			degree[dest] += 1;
		}
	}

	// Overloaded Function
	public void addEdgeEnd(int src, int dest, int weight, boolean directed) {
		EdgeNode tmpNode = new EdgeNode(dest);
		tmpNode.setWeight(weight);

		EdgeNode nextNode = arrayList[src].getHead();

		if (nextNode != null) {
			tmpNode.setNext(nextNode);
			arrayList[src].setHead(tmpNode);
		} else {
			arrayList[src].setHead(tmpNode);
		}

		degree[src] += 1;

		// Graph is undirected
		if (!directed) {
			tmpNode = new EdgeNode(src);
			tmpNode.setWeight(weight);

			nextNode = arrayList[dest].getHead();

			if (nextNode != null) {
				tmpNode.setNext(nextNode);
				arrayList[dest].setHead(tmpNode);
			} else {
				arrayList[dest].setHead(tmpNode);
			}

			degree[dest] += 1;
		}
	}

	public void addEdgeEnd(int src, int dest, boolean directed) {
		EdgeNode tmpNode = new EdgeNode(dest);

		EdgeNode nextNode = arrayList[src].getHead();

		if (nextNode != null) {
			while (nextNode.next != null) {
				nextNode = nextNode.next;
			}
			nextNode.setNext(tmpNode);
		} else {
			arrayList[src].setHead(tmpNode);
		}

		degree[src] += 1;

		// Graph is undirected
		if (!directed) {
			tmpNode = new EdgeNode(src);
			nextNode = arrayList[dest].getHead();

			if (nextNode != null) {
				while (nextNode.next != null) {
					nextNode = nextNode.next;
				}
				nextNode.setNext(tmpNode);
			} else {
				arrayList[dest].setHead(tmpNode);
			}

			degree[dest] += 1;
		}
	}

	public void printGraph() {

		for (int i = 0; i < arrayList.length; i++) {
			System.out.println("Adjacency list of vertex : " + i);
			EdgeNode head = arrayList[i].getHead();
			System.out.print("Head -> ");
			while (head != null) {
				System.out.print(head.getDest() + " -> ");
				head = head.next;
			}
			System.out.println("NULL\n");
		}
	}

	public void bfs(int nodeNumber) {
		boolean[] processed = new boolean[this.vertices];

		int[] p = new int[vertices];
		for (int i = 0; i < p.length; i++) {
			p[i] = -1;
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(nodeNumber);
		discovered[nodeNumber] = true;

		while (!queue.isEmpty()) {
			int i = queue.poll();
			System.out.println("EdgeNode " + i + " , Parent Node : " + p[i]);
			EdgeNode node = arrayList[i].getHead();
			processed[i] = true;

			while (node != null) {
				if (processed[node.getDest()] == false) {
					processEdge(i, node.getDest());
				}
				if (discovered[node.getDest()] == false) {
					discovered[node.getDest()] = true;
					queue.add(node.getDest());
					p[node.getDest()] = i;
				}
				node = node.next;
			}
		}
	}

	private void processEdge(int x, int y) {
		System.out.println("Processed Edge : " + x + " --> " + y);
		if (color[x] == color[y]) {
			isBipartite = false;
			System.out.println("Warning: Not Bipartite Due To : " + x + " , "
					+ y);
			return;
		}
		color[y] = complementColor(color, x);
	}

	/**
	 * A graph is bipartite if it can be colored without conflicts while using
	 * only two colors.
	 * 
	 * @return
	 */
	public void bipartite() {
		color = new ColorRange[vertices];
		for (int i = 0; i < color.length; i++) {
			color[i] = ColorRange.UNCOLORED;
		}

		for (int i = 0; i < vertices; i++) {
			if (discovered[i] == false) {
				color[i] = ColorRange.BLUE;
				bfs(i);
			}
		}
	}

	public ColorRange complementColor(ColorRange[] color, int index) {
		if (color[index] == ColorRange.BLUE) {
			return ColorRange.RED;
		} else if (color[index] == ColorRange.RED) {
			return ColorRange.BLUE;
		} else {
			return ColorRange.UNCOLORED;
		}
	}

	public void dfs(int index) {
		GraphState[] state = new GraphState[vertices];

		for (int i = 0; i < state.length; i++) {
			state[i] = GraphState.UNDISCOVERED;
		}

		dfsUtil(index, state);
	}

	public void dfsUtil(int index, GraphState[] state) {
		state[index] = GraphState.DISCOVERED;
		entry[index] = ++time;

		System.out.println("EdgeNode " + index + " , Parent Node : "
				+ parent[index]);

		EdgeNode node = arrayList[index].getHead();
		while (node != null) {
			if (state[node.getDest()] == GraphState.UNDISCOVERED) {
				parent[node.getDest()] = index;
				processEdgeDFS(index, node.getDest(), state);
				dfsUtil(node.getDest(), state);
			}

			// Edge Discovered but not processed.
			else if (state[node.getDest()] != GraphState.PROCESSED) {
				processEdgeDFS(index, node.getDest(), state);
			}
			node = node.next;
		}

		exit[index] = ++time;
		state[index] = GraphState.PROCESSED;
	}

	// Finding Cycles
	private void processEdgeDFS(int x, int y, GraphState[] state) {
		// System.out.println("Processed Edge : " + x + " --> " + y);
		if (parent[x] != y && state[y] != GraphState.UNDISCOVERED) {
			System.out.println("Cycle from " + y + " to " + x);
		}
	}

	public void deleteNode(int node) {
		if (node >= arrayList.length) {
			System.out.println("Node not Available.");
			return;
		}

		// Delete Node
		arrayList[node].setHead(null);

		for (int i = 0; i < arrayList.length; i++) {
			System.out.println("Adjacency list of vertex : " + i);

			EdgeNode head = arrayList[i].getHead();
			System.out.print("Head -> ");

			while (head != null) {
				System.out.print(head.getDest() + " -> ");
				if (head.getDest() == node) {
					if (head.next != null) {
						head.setDest(head.next.getDest());
					} 
					// Node to be deleted ins last node
					else {
						
					}
				}
				head = head.next;
			}
			System.out.println("NULL\n");
		}
	}

	
}

enum ColorRange {
	RED, BLUE, UNCOLORED;
}