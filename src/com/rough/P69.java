package com.rough;

public class P69 {
	int maxsum = Integer.MIN_VALUE;
	Node targetNode = null;

	public static void main(String[] args) {
		Node root = getTree();
		P69 test = new P69();
		int height = test.getHeight(root);
		System.out.println("Height : " + height);

		int sum = test.maxSumPath(root);
		System.out.println(sum);

		test.maxSumPathUpDown(root);
	}

	private void maxSumPathUpDown(Node node) {
		if (node == null) {
			return;
		}

		maxSumUtil(node, 0);
		System.out.println("Max Sum : " + maxsum + " --> " + targetNode);
		printPath(node);
	}

	private boolean printPath(Node node) {
		if (node == null) {
			return false;
		}

		if ((node.data == targetNode.data) || printPath(node.getlChild())
				|| printPath(node.getrChild())) {
			System.out.println(node.data);
			return true;
		}

		return false;
	}

	private void maxSumUtil(Node node, int currSum) {
		if (node == null) {
			return;
		}

		currSum += node.data;

		// Leaf Node
		if (node.lChild == null && node.rChild == null) {
			if (currSum > maxsum) {
				maxsum = currSum;
				targetNode = node;
			}
		}

		maxSumUtil(node.lChild, currSum);
		maxSumUtil(node.rChild, currSum);
	}

	private int getHeight(Node node) {
		if (node == null) {
			return 0;
		}
		return Math.max(getHeight(node.lChild), getHeight(node.rChild)) + 1;
	}

	private int maxSumPath(Node node) {
		if (node == null) {
			return 0;
		}
		int left = maxSumPath(node.lChild);
		int right = maxSumPath(node.rChild);

		return node.data + ((left >= right) ? left : right);
	}

	private static Node getTree() {
		Node root = new Node(10);
		Node node2 = new Node(-2);
		Node node3 = new Node(7);
		Node node4 = new Node(8);
		Node node5 = new Node(-4);

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		return root;
	}
}
