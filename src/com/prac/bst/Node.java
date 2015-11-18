package com.prac.bst;

public class Node {

	public int data;
	public Node lChild;
	public Node rChild;

	public Node(int data) {
		lChild = null;
		rChild = null;
		this.data = data;
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


}
