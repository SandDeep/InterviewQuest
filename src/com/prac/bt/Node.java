package com.prac.bt;

public class Node {

	public String data;
	public Node lChild;
	public Node rChild;

	public Node(String data) {
		lChild = null;
		rChild = null;
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
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
