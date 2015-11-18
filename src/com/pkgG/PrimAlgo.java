package com.pkgG;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class PrimAlgo {

	public static void main(String[] args) {
		PrimAlgo prim = new PrimAlgo();
		Graph graph = prim.getGraph();

		prim.primBST(graph);
	}

	private void primBST(Graph graph) {
		int[] p = new int[graph.vertices];
		int[] key = new int[graph.vertices];
		for (int i = 0; i < p.length; i++) {
			p[i] = -1;
			key[i]=Integer.MAX_VALUE;
		}
		Queue<HeapNode> queue = new PriorityQueue<HeapNode>();
		HeapNode[] heapNodes=new HeapNode[graph.vertices];
		
		for (int i = 0; i < graph.vertices; i++) {
			
		}
		populateQueue(queue, graph, 0);
		System.out.println();
		while (!queue.isEmpty()) {
			HeapNode heapNode = queue.poll();
			EdgeNode node = graph.arrayList[heapNode.getVertex()].getHead();
			while (node != null) {
				int weight=node.getWeight();
				
			}
		}
	}

	private void populateQueue(Queue<HeapNode> queue, Graph graph, int i) {
		queue.add(new HeapNode(i, 0));

		int[] disc = new int[graph.vertices];
		for (int j = 0; j < disc.length; j++) {
			disc[j] = -1;
		}
		Queue<Integer> bfsQueue = new LinkedList<Integer>();
		bfsQueue.add(i);
		disc[i] = 0;

		while (!bfsQueue.isEmpty()) {
			int index = bfsQueue.poll();
			EdgeNode node = graph.arrayList[index].getHead();
			while (node != null) {
				if (disc[node.getDest()] == -1) {
					disc[node.getDest()] = 0;
					bfsQueue.add(node.getDest());
					queue.add(new HeapNode(node.getDest(), Integer.MAX_VALUE));
				}
				node = node.next;
			}
		}
	}

	private int extractMin(int[] weight, int length, int[] discovered) {
		int index = (length / 2) - 1;

		minHeapify(weight, index, length);
		int min = weight[0];
		swap(weight, 0, length - 1);
		return min;
	}

	private void minHeapify(int[] weight, int i, int length) {
		int lChild = 2 * i;
		int rChild = 2 * i + 1;

		if (lChild <= length && rChild <= length) {
			int minIndex = i;

			if (weight[lChild] < weight[minIndex]) {
				minIndex = lChild;
			}

			if (weight[rChild] < weight[minIndex]) {
				minIndex = rChild;
			}

			if (minIndex != i) {
				swap(weight, minIndex, length);
			}
		} else if ((lChild <= length && rChild >= length)) {
			int minIndex = i;
			if (weight[lChild] < weight[minIndex]) {
				swap(weight, lChild, minIndex);
			}
		}
	}

	private static void swap(int[] arr, int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}

	public Graph getGraph() {
		Graph graph = new Graph(6);
		graph.addEdgeEnd(0, 1, 4, false);
		graph.addEdgeEnd(0, 4, 8, false);
		graph.addEdgeEnd(1, 2, 8, false);
		graph.addEdgeEnd(1, 4, 11, false);
		graph.addEdgeEnd(2, 3, 4, false);
		graph.addEdgeEnd(2, 5, 2, false);
		graph.addEdgeEnd(3, 5, 6, false);
		graph.addEdgeEnd(3, 4, 1, false);
		graph.addEdgeEnd(4, 5, 7, false);

		return graph;
	}
}

class HeapNode implements Comparable<HeapNode> {
	int vertex;
	int key;

	public HeapNode() {
		vertex = 0;
		key = 0;
	}

	public HeapNode(int vertex, int key) {
		this.vertex = vertex;
		this.key = key;
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + key;
		result = prime * result + vertex;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HeapNode other = (HeapNode) obj;
		if (vertex != other.vertex)
			return false;
		return true;
	}

	@Override
	public int compareTo(HeapNode o) {
		return this.key - o.key;
	}

	@Override
	public String toString() {
		return "HeapNode [vertex=" + vertex + ", key=" + key + "]";
	}

}