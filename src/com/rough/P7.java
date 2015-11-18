package com.rough;

public class P7 {

	public static void main(String[] args) {
		P7 test = new P7();

		NodeC root = getTree3();
		test.connect(root);
	}

	private void connect(NodeC node) {
		if (node == null) {
			return;
		}

		node.nextRight = null;

		coonectRecur(node);
	}

	private void coonectRecur(NodeC node) {
		if (node == null) {
			return;
		}

		if (node.nextRight != null) {
			coonectRecur(node.nextRight);
		}

		if (node.lChild != null) {
			if (node.rChild != null) {
				node.lChild.nextRight = node.rChild;
				node.rChild.nextRight = getNextRight(node);
			} else {
				node.lChild.nextRight = getNextRight(node);
			}

			coonectRecur(node.lChild);
		} else if (node.rChild != null) {
			node.rChild.nextRight = getNextRight(node);
			coonectRecur(node.rChild);
		} else {
			coonectRecur(getNextRight(node));
		}
	}

	private NodeC getNextRight(NodeC node) {
		NodeC temp = node.nextRight;

		while (temp != null) {
			if (temp.lChild != null) {
				return temp.lChild;
			} else if (temp.rChild != null) {
				return temp.rChild;
			}
			temp = temp.nextRight;
		}
		return null;
	}

	public static NodeC getTree3() {
		NodeC root = new NodeC(1);

		NodeC NodeC2 = new NodeC(2);
		NodeC NodeC3 = new NodeC(3);
		NodeC NodeC4 = new NodeC(4);
		NodeC NodeC5 = new NodeC(5);
		NodeC NodeC6 = new NodeC(6);
		NodeC NodeC7 = new NodeC(7);

		NodeC NodeC8 = new NodeC(8);
		NodeC NodeC9 = new NodeC(9);
		NodeC NodeC10 = new NodeC(10);
		NodeC NodeC11 = new NodeC(11);

		root.setlChild(NodeC2);
		root.setrChild(NodeC3);

		NodeC2.setlChild(NodeC4);
		NodeC2.setrChild(NodeC5);

		NodeC3.setlChild(NodeC6);
		NodeC3.setrChild(NodeC7);

		NodeC4.setlChild(NodeC8);
		NodeC4.setrChild(NodeC9);

		NodeC7.setlChild(NodeC10);
		NodeC7.setrChild(NodeC11);

		return root;
	}
}

class NodeC {
	NodeC lChild;
	NodeC rChild;
	NodeC nextRight;
	int data;

	public NodeC(int data) {
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

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}