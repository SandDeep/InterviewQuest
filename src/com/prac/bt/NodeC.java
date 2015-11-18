package com.prac.bt;

public class NodeC {

	public String data;
	public NodeC lChild;
	public NodeC rChild;
	public NodeC nextRight;

	public NodeC(String data) {
		this.data = data;
		lChild = null;
		rChild = null;
		nextRight = null;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public NodeC getlChild() {
		return lChild;
	}

	public void setlChild(NodeC lChild) {
		this.lChild = lChild;
	}

	public NodeC getrChild() {
		return rChild;
	}

	public void setrChild(NodeC rChild) {
		this.rChild = rChild;
	}

	public NodeC getNextRight() {
		return nextRight;
	}

	public void setNextRight(NodeC nextRight) {
		this.nextRight = nextRight;
	}

	@Override
	public String toString() {
		String status = "NULL";
		if (nextRight != null) {
			status = nextRight.getData();
		}
		String str = "NodeC [data=" + data + " , nextRight=" + status + "]";
		return str;
	}

}