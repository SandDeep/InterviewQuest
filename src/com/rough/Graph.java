package com.rough;

public class Graph {

	int vertices;
	AdjList[] list;

	public Graph(int vertices) {
		this.vertices = vertices;
		list = new AdjList[vertices];
		for (int i = 0; i < vertices; i++) {
			list[i] = new AdjList();
		}
	}

	public int getVertices() {
		return vertices;
	}

	public void setVertices(int vertices) {
		this.vertices = vertices;
	}

	public AdjList[] getList() {
		return list;
	}

	public void setList(AdjList[] list) {
		this.list = list;
	}

}
