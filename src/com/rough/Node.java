package com.rough;

public class Node {

	int data;
	Node lChild;
	Node rChild;

	public Node(int data) {
		this.data = data;
		lChild = null;
		rChild = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public Node getlChild() {
		return lChild;
	}

	public void setlChild(Node lChild) {
		this.lChild = lChild;
	}

	public Node getrChild() {
		return rChild;
	}

	public void setrChild(Node rChild) {
		this.rChild = rChild;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

}
