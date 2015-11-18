package com.rough;

import com.prac.bt.Node;

public class P57 {

	public static void main(String[] args) {
		Node root = getTree();

		P57 test = new P57();
		int maxBST = test.getBSTSize(root);
		System.out.println(maxBST);
	}

	private int getBSTSize(Node node) {
		if (node == null) {
			return 0;
		}

		MinMax stat = getMaxSize(node);
		return stat.getHeight();
	}

	private MinMax getMaxSize(Node node) {
		if (node == null) {
			return new MinMax();
		}

		MinMax left = getMaxSize(node.lChild);
		MinMax right = getMaxSize(node.rChild);

		MinMax m = new MinMax();

		int data = Integer.parseInt(node.getData());

		if (left.isBST() == false || right.isBST() == false
				|| (data < left.getMax() || data > right.getMin())) {
			m.setBST(false);
			m.setHeight(Math.max(left.getHeight(), right.getHeight()));
			return m;
		}

		m.setBST(true);
		m.setHeight(left.getHeight() + right.getHeight() + 1);

		m.min = (null == node.lChild) ? data : left.getMin();
		m.max = (null == node.rChild) ? data : right.getMax();

		return m;
	}

	public static Node getTree() {
		Node root = new Node("25");

		Node node2 = new Node("18");
		Node node3 = new Node("50");
		Node node4 = new Node("19");
		Node node5 = new Node("20");
		Node node6 = new Node("35");
		Node node7 = new Node("60");

		Node node8 = new Node("15");
		Node node9 = new Node("18");
		Node node10 = new Node("25");
		Node node11 = new Node("20");
		Node node12 = new Node("40");
		Node node13 = new Node("55");
		Node node14 = new Node("70");
		Node node15 = new Node("25");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setlChild(node6);
		node3.setrChild(node7);

		node4.setrChild(node8);

		node5.setlChild(node9);
		node5.setrChild(node10);

		node6.setlChild(node11);
		node6.setrChild(node12);

		node11.setrChild(node15);

		node7.setlChild(node13);
		node7.setrChild(node14);

		return root;
	}
}

class MinMax {

	boolean isBST;
	int height;
	int min;
	int max;

	public MinMax() {
		isBST = true;
		height = 0;
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
	}

	public boolean isBST() {
		return isBST;
	}

	public void setBST(boolean isBST) {
		this.isBST = isBST;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	@Override
	public String toString() {
		return "MinMax [isBST=" + isBST + ", height=" + height + ", min=" + min
				+ ", max=" + max + "]";
	}

}