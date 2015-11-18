package com.prac.bt;

public class LargestBST {

	static int minRef = Integer.MAX_VALUE;
	static int maxRef = Integer.MIN_VALUE;
	static int maxSize = 0;
	static Node bstNode = null;
	static boolean isBst = false;

	public static void main(String[] args) {
		Node root = getTree();

		LargestBST bst = new LargestBST();
		bst.largetstBstUtil(root);
		System.out.println(maxSize);
		BTreeUtil.preorder(bstNode);
	}

	private int largetstBstUtil(Node node) {
		if (node == null) {
			isBst = true;
			return 0;
		}

		int min = Integer.MIN_VALUE;

		boolean leftFlag = false;
		boolean rightFlag = false;

		int ls = 0;
		int rs = 0;

		maxRef = Integer.MIN_VALUE;

		ls = largetstBstUtil(node.lChild);
		if (isBst == true && Integer.parseInt(node.getData()) > maxRef) {
			leftFlag = true;
		}

		min = minRef;

		minRef = Integer.MAX_VALUE;

		rs = largetstBstUtil(node.rChild);
		if (isBst == true && Integer.parseInt(node.getData()) < minRef) {
			rightFlag = true;
		}

		if (min < minRef) {
			minRef = min;
		}
		if (Integer.parseInt(node.getData()) < minRef) {
			minRef = Integer.parseInt(node.getData());
		}
		if (Integer.parseInt(node.getData()) > maxRef) {
			maxRef = Integer.parseInt(node.getData());
		}

		if (leftFlag == true && rightFlag == true) {
			if (ls + rs + 1 > maxSize) {
				maxSize = ls + rs + 1;
				bstNode=node;
			}
			return ls + rs + 1;
		} else {
			isBst = false;
			return 0;
		}
	}

	public static Node getTree() {

		Node root = new Node("50");
		Node node2 = new Node("10");
		Node node3 = new Node("60");
		Node node4 = new Node("5");
		Node node5 = new Node("20");

		Node node6 = new Node("55");
		Node node7 = new Node("70");
		Node node8 = new Node("45");
		Node node9 = new Node("65");
		Node node10 = new Node("80");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setlChild(node6);
		node3.setrChild(node7);

		node6.setlChild(node8);

		node7.setlChild(node9);
		node7.setrChild(node10);

		return root;

	}
}
