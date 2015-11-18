package com.rough;

public class P45 {

	public static void main(String[] args) {
		INode root = new INode(20);
		root.lChild = new INode(8);
		root.lChild.lChild = new INode(4);
		root.lChild.rChild = new INode(12);
		root.lChild.rChild.lChild = new INode(10);
		root.lChild.rChild.rChild = new INode(14);
		root.rChild = new INode(22);
		root.rChild.rChild = new INode(25);

		P45 test = new P45();
		int lis = test.LISS(root);
		System.out.println("Size of the Largest Independent Set : " + lis);
	}

	private int LISS(INode node) {
		if (node == null) {
			return 0;
		}

		if (node.liss > 0) {
			return node.liss;
		}

		// Leaf Node
		if (node.lChild == null && node.rChild == null) {
			return 1;
		}

		// Exclude
		int exclude = LISS(node.lChild) + LISS(node.rChild);

		// Include
		int include = 1;

		if (node.lChild != null) {
			include += LISS(node.lChild.lChild) + LISS(node.lChild.rChild);
		}

		if (node.rChild != null) {
			include += LISS(node.rChild.lChild) + LISS(node.rChild.rChild);
		}

		node.liss = Math.max(include, exclude);
		return node.liss;
	}
}

class INode {
	int data;
	INode lChild;
	INode rChild;
	int liss;

	public INode(int data) {
		this.data = data;
		lChild = null;
		rChild = null;
		liss = 0;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public INode getlChild() {
		return lChild;
	}

	public void setlChild(INode lChild) {
		this.lChild = lChild;
	}

	public INode getrChild() {
		return rChild;
	}

	public void setrChild(INode rChild) {
		this.rChild = rChild;
	}

	public int getLiss() {
		return liss;
	}

	public void setLiss(int liss) {
		this.liss = liss;
	}

	@Override
	public String toString() {
		return "INode [data=" + data + ", lChild=" + lChild.data + ", rChild="
				+ rChild.data + ", liss=" + liss + "]";
	}

}