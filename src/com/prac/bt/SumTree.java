package com.prac.bt;

import java.util.Arrays;
import java.util.HashMap;

public class SumTree {

	public static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	static int maxValue = 0;
	static int[] maxpath = new int[10];

	public static void main(String[] args) {
		Node root = getTree2();
		// convertToST(root);
		// toSumTree(root);
		// BTreeUtil.preorder(root);

		// verticalSum(root, 0);
		// System.out.println(map);

		int[] path = new int[BTreeUtil.getHeight(root)];
		maxSumPath(root, path, 0);
		System.out.println(maxValue);
	}

	static void maxSumPath(Node node, int[] path, int level) {
		if (node == null) {
			return;
		}
		path[level] = Integer.parseInt(node.data);

		if (node.lChild == null && node.rChild == null) {
			int sum = 0;
			for (int i = 0; i <= level; i++) {
				sum = sum + path[i];
			}
			if (sum > maxValue) {
				maxValue = sum;
				maxpath=Arrays.copyOf(path, level+1);
			}
			return;
		}
		maxSumPath(node.lChild, path, level + 1);
		maxSumPath(node.rChild, path, level + 1);
	}

	/**
	 * Vertical Sum in a given Binary Tree : If two nodes have the same
	 * Horizontal Distance (HD), then they are on same vertical line. The idea
	 * of HD is simple. HD for root is 0, a right edge (edge connecting to right
	 * subtree) is considered as +1 horizontal distance and a left edge is
	 * considered as -1 horizontal distance.
	 * 
	 * @param node
	 * @param hd
	 */
	static void verticalSum(Node node, int hd) {
		if (node == null) {
			return;
		}

		if (map.containsKey(hd)) {
			int value = map.get(hd) + Integer.parseInt(node.data);
			map.put(hd, value);
		} else {
			map.put(hd, Integer.parseInt(node.data));
		}
		verticalSum(node.lChild, hd - 1);
		verticalSum(node.rChild, hd + 1);

	}

	static int toSumTree(Node node) {
		if (node == null) {
			return 0;
		}

		int oldValue = Integer.parseInt(node.data);

		int newValue = toSumTree(node.lChild) + toSumTree(node.rChild);
		node.setData(newValue + "");

		return newValue + oldValue;
	}

	static void convertToST(Node root) {
		if (root == null)
			return;
		int l = convertRecu(root.lChild);
		int r = convertRecu(root.rChild);

		int num = l + r;
		root.setData(num + "");
	}

	static int convertRecu(Node node) {
		if (node == null) {
			return 0;
		}
		if (node.lChild == null && node.rChild == null) {
			int num = Integer.parseInt(node.data);
			node.setData("0");
			return num;
		}

		int l = convertRecu(node.lChild);
		int r = convertRecu(node.rChild);

		int num = l + r + Integer.parseInt(node.data);
		int nodeVal = l + r;
		node.setData(nodeVal + "");

		return num;
	}

	static Node getTree() {
		Node root = new Node("10");

		Node node2 = new Node("-2");
		Node node3 = new Node("6");
		Node node4 = new Node("8");
		Node node5 = new Node("-4");
		Node node6 = new Node("7");
		Node node7 = new Node("5");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setlChild(node6);
		node3.setrChild(node7);

		return root;
	}

	static Node getTree1() {
		Node root = new Node("1");

		Node node2 = new Node("2");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("6");
		Node node7 = new Node("7");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setlChild(node6);
		node3.setrChild(node7);

		return root;
	}

	static Node getTree2() {
		Node root = new Node("10");

		Node node2 = new Node("-2");
		Node node3 = new Node("7");
		Node node4 = new Node("8");
		Node node5 = new Node("4");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		return root;
	}
}
