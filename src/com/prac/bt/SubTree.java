package com.prac.bt;

public class SubTree {

	public static void main(String[] args) {
		Node parentTree = getTree();
		Node childTree = getTree1();

		boolean status = isSubTree(parentTree, childTree);
		System.out.println(status);
	}

	private static boolean isSubTree(Node T, Node S) {
		if (S == null) {
			return true;
		}

		if (T == null) {
			return false;
		}
		if (areIdentical(T, S)) {
			return true;
		}

		return isSubTree(T.lChild, S.lChild) || isSubTree(T.rChild, S.rChild);

	}

	private static boolean areIdentical(Node parent, Node child) {
		if (parent == null && child == null) {
			return true;
		}

		if (parent == null || child == null) {
			return false;
		}

		return ((parent.getData().equals(child.getData()))
				&& areIdentical(parent.lChild, child.lChild) && areIdentical(
					parent.rChild, child.rChild));
	}

	public static Node getTree() {

		Node root = new Node("26");

		Node node2 = new Node("10");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("6");
		Node node6 = new Node("3");
		Node node7 = new Node("30");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setrChild(node6);

		node4.setrChild(node7);

		return root;

	}

	public static Node getTree1() {

		Node root = new Node("10");

		Node node2 = new Node("4");
		Node node3 = new Node("6");
		Node node4 = new Node("30");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setrChild(node4);

		return root;

	}
}
