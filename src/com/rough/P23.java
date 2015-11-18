package com.rough;

public class P23 {

	public static void main(String[] args) {
		Node root = getTree();

		P23 test = new P23();
		test.printKDistance(root, 12, 3);
	}

	private int printKDistance(Node node, int target, int k) {
		if (node == null) {
			return -1;
		}

		if (node.getData() == target) {
			printKDown(node, k);
			return 0;
		}

		int dl = printKDistance(node.lChild, target, k);
		if (dl != -1) {
			if (dl + 1 == k) {
				System.out.print(node.getData() + " ");
			} else {
				printKDown(node.rChild, k - dl - 2);
			}
			return dl + 1;
		}

		int dr = printKDistance(node.rChild, target, k);
		if (dr != -1) {
			if (dr + 1 == k) {
				System.out.print(node.getData() + " ");
			} else {
				printKDown(node.lChild, k - dr - 2);
			}
			return dr + 1;
		}

		return -1;
	}

	private void printKDown(Node node, int k) {
		if (node == null || k < 0) {
			return;
		}

		if (k == 0) {
			System.out.print(node.getData() + " ");
			return;
		}

		printKDown(node.lChild, k - 1);
		printKDown(node.rChild, k - 1);
	}

	public static Node getTree() {
		Node root = new Node(20);

		Node node2 = new Node(8);
		Node node3 = new Node(22);
		Node node4 = new Node(4);
		Node node5 = new Node(12);
		Node node6 = new Node(10);
		Node node7 = new Node(14);

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node5.setlChild(node6);
		node5.setrChild(node7);

		return root;
	}
}
