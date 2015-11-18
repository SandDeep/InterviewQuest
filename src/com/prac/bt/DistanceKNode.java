package com.prac.bt;

public class DistanceKNode {

	public static int distance = 0;

	public static void main(String[] args) {
		Node root = new Node("20");

		Node node2 = new Node("8");
		Node node3 = new Node("22");
		Node node4 = new Node("4");
		Node node5 = new Node("12");
		Node node6 = new Node("10");
		Node node7 = new Node("14");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node5.setlChild(node6);
		node5.setrChild(node7);

		printkdistanceNode(root, node7, 3);
	}

	public static int printkdistanceNode(Node root, Node target, int k) {
		if (root == null) {
			return -1;
		}

		if (root.getData().equals(target.getData())) {
			printkdistanceNodeDown(root, k);
			return 0;
		}

		int dl = printkdistanceNode(root.lChild, target, k);

		// Check if target node was found in left subtree
		if (dl != -1) {
			// If root is at distance k from target, print root
			// Note that dl is Distance of root's left child from target
			if (dl + 1 == k)
				System.out.println(root.getData());

			// Else go to right subtree and print all k-dl-2 distant nodes
			// Note that the right child is 2 edges away from left child
			else
				printkdistanceNodeDown(root.rChild, k - dl - 2);

			// Add 1 to the distance and return value for parent calls
			return 1 + dl;
		}

		// MIRROR OF ABOVE CODE FOR RIGHT SUBTREE
		// Note that we reach here only when node was not found in left subtree
		int dr = printkdistanceNode(root.rChild, target, k);
		if (dr != -1) {
			if (dr + 1 == k)
				System.out.println(root.getData());
			else
				printkdistanceNodeDown(root.lChild, k - dr - 2);
			return 1 + dr;
		}

		return -1;

	}

	public static void printkdistanceNodeDown(Node node, int k) {
		if (node == null || k < 0) {
			return;
		}
		if (k == 0) {
			System.out.println(node.data);
		}
		if (node.lChild != null) {
			printkdistanceNodeDown(node.lChild, k - 1);
		}
		if (node.rChild != null) {
			printkdistanceNodeDown(node.rChild, k - 1);
		}
	}

	public static Node getTree() {
		Node root = new Node("20");

		Node node2 = new Node("8");
		Node node3 = new Node("22");
		Node node4 = new Node("4");
		Node node5 = new Node("12");
		Node node6 = new Node("10");
		Node node7 = new Node("14");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node5.setlChild(node6);
		node5.setrChild(node7);

		return root;
	}
}
