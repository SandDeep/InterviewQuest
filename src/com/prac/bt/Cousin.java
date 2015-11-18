package com.prac.bt;

/**
 * Time Complexity of the above solution is O(n) as it does at most three
 * traversals of binary tree.
 * 
 * @author Deepesh
 * 
 */
public class Cousin {

	public static void main(String[] args) {

		Node root = new Node("1");

		Node node2 = new Node("2");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("6");
		Node node7 = new Node("7");
		Node node8 = new Node("8");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setrChild(node8);

		node8.setlChild(node6);
		node8.setrChild(node7);

		int status = areCousins(root, node4, node8);
		System.out.println(status);
	}

	private static int areCousins(Node root, Node node1, Node node2) {
		if ((level(root, node1, 0) == level(root, node2, 0))
				&& (!isSibling(root, node1, node2))) {
			return 1;
		}
		return 0;
	}

	private static boolean isSibling(Node root, Node node1, Node node2) {
		if (node1 == null || node2 == null) {
			return false;
		}

		if (root.lChild != null && root.rChild != null) {
			return (root.lChild.getData() == node1.getData() && root.rChild
					.getData() == node1.getData())
					|| (root.lChild.getData() == node2.getData() && root.rChild
							.getData() == node1.getData())
					|| isSibling(root.lChild, node1, node2)
					|| isSibling(root.rChild, node1, node2);

		}
		return false;
	}

	public static int level(Node root, Node child, int level) {

		if (root == null || child == null) {
			return 0;
		}

		if (root.data.equals(child.data)) {
			return level;
		}

		// Return level if Node is present in left subtree
		if (root.lChild != null) {
			int l = level(root.lChild, child, level + 1);
			if (l != 0) {
				return l;
			}
		}

		// Else search in right subtree
		return level(root.rChild, child, level + 1);
	}

}
