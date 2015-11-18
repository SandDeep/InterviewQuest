package com.trash;

public class TNode {

	char data;
	boolean leafNode;
	TNode left;
	TNode eq;
	TNode right;

	public TNode(char data) {
		this.data = data;
		leafNode = false;
		left = null;
		right = null;
		eq = null;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public boolean isLeafNode() {
		return leafNode;
	}

	public void setLeafNode(boolean leafNode) {
		this.leafNode = leafNode;
	}

	public TNode getLeft() {
		return left;
	}

	public void setLeft(TNode left) {
		this.left = left;
	}

	public TNode getEq() {
		return eq;
	}

	public void setEq(TNode eq) {
		this.eq = eq;
	}

	public TNode getRight() {
		return right;
	}

	public void setRight(TNode right) {
		this.right = right;
	}

	/*@Override
	public String toString() {
		String leftData = null;
		String eqData = null;
		String RightData = null;

		if (eq == null) {
			eqData = new String("null");
		}

		if (left == null) {
			leftData = new String("null");
		}

		if (right == null) {
			RightData = new String("null");
		}
		return "TNode [data=" + data + ", leafNode=" + leafNode + ", left="
				+ leftData + ", eq=" + eqData + ", right=" + RightData + "]";
	}*/

}
