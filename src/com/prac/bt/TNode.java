package com.prac.bt;

class TNode {

	public String data;
	public Node lChild;
	public Node rChild;
	public boolean rightThread;

	public TNode(String data) {
		lChild = null;
		rChild = null;
		this.data = data;
		rightThread = true;
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
		setRightThread(false);
	}

	public boolean isRightThread() {
		return rightThread;
	}

	public void setRightThread(boolean rightThread) {
		this.rightThread = rightThread;
	}

}
