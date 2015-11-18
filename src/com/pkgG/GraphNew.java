package com.pkgG;

import java.util.Arrays;

public class GraphNew {

	int vertices = 0;
	int edges = 0;
	Edge[] edge = null;

	public GraphNew(int vertices, int edges) {
		this.vertices = vertices;
		this.edges = edges;
		edge = new Edge[edges];
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
