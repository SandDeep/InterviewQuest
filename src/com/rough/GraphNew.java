package com.rough;

import java.util.Arrays;

public class GraphNew {

	Edge[] edge;
	int vertices;
	int edges;

	public GraphNew(int vertices, int edge) {
		this.vertices = vertices;
		this.edges = edge;
		this.edge = new Edge[edges];
	}

	public Edge[] getEdge() {
		return edge;
	}

	public void setEdge(Edge[] edge) {
		this.edge = edge;
	}

	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public int getEdges() {
		return edges;
	}

	public void setEdges(int edges) {
		this.edges = edges;
	}

	@Override
	public String toString() {
		return "GraphNew [vertices=" + vertices + ", edges=" + edges
				+ ", edge=" + Arrays.toString(edge) + "]";
	}

}
