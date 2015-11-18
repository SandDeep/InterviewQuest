package com.rough;

public class P65 {

	int maxSum = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Node node = getTree();

		P65 test = new P65();
		int max = test.maxLeafPath(node);
		System.out.println(max);

		max = test.maxLeafPathSumUtil(node);
		System.out.println(test.maxSum);
	}

	private int maxLeafPathSumUtil(Node node) {
		if (node == null) {
			return 0;
		}

		int left = maxLeafPathSumUtil(node.lChild);
		int right = maxLeafPathSumUtil(node.rChild);

		int currSum = node.data + left + right;

		if (maxSum < currSum) {
			maxSum = currSum;
		}

		/*if (node.lChild == null) {
			return right + node.data;
		}
		if (node.rChild == null) {
			return left + node.data;
		}*/
		return Math.max(left, right) + node.data;
	}

	private int maxLeafPath(Node node) {
		if (node == null) {
			return 0;
		}

		int leftPath = maxLeafPath(node.lChild);
		int rightPath = maxLeafPath(node.rChild);

		int left = maxSumPath(node.lChild);
		int right = maxSumPath(node.rChild);

		int rootPath = node.data + left + right;

		return Math.max(rootPath, Math.max(leftPath, rightPath));
	}

	private int maxSumPath(Node node) {
		if (node == null) {
			return 0;
		}

		int left = maxSumPath(node.lChild);
		int right = maxSumPath(node.rChild);

		return node.data + (Math.max(left, right));
	}

	private static Node getTree() {
		Node root = new Node(-15);
		Node node2 = new Node(5);
		Node node3 = new Node(6);
		Node node4 = new Node(-8);
		Node node5 = new Node(1);
		Node node6 = new Node(3);
		Node node7 = new Node(9);
		Node node8 = new Node(2);
		Node node9 = new Node(6);
		Node node10 = new Node(0);
		Node node11 = new Node(4);
		Node node12 = new Node(-1);
		Node node13 = new Node(10);

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setlChild(node6);
		node3.setrChild(node7);

		node4.setlChild(node8);
		node4.setrChild(node9);

		node7.setrChild(node10);

		node10.setlChild(node11);
		node10.setrChild(node12);

		node12.setlChild(node13);

		return root;
	}
}
