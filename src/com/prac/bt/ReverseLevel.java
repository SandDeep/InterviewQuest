package com.prac.bt;

import java.util.Arrays;

public class ReverseLevel {

	static int index = 0;

	public static void main(String[] args) {
		Node root = getTree();

		String[] inorder = new String[10];
		populateArray(root, inorder, 1);
		System.out.println(Arrays.toString(inorder));
		index=inorder.length-1;
		reverse(root, inorder, 1);
		index=0;
		populateArray(root, inorder, 1);
		System.out.println(Arrays.toString(inorder));
	}

	private static void reverse(Node node, String[] inorder, int i) {
		if (node != null) {
			reverse(node.lChild, inorder, -i);
			if (i == -1) {
				node.setData(inorder[index--]);
			}
			reverse(node.rChild, inorder, -i);
		}
	}

	private static void populateArray(Node node, String[] inorder, int i) {
		if (node != null) {
			populateArray(node.lChild, inorder, -i);
			if (i == -1) {
				inorder[index++] = node.getData();
			}
			populateArray(node.rChild, inorder, -i);
		}
	}

	public static Node getTree() {
		Node root = new Node("a");

		Node node2 = new Node("b");
		Node node3 = new Node("c");
		Node node4 = new Node("d");
		Node node5 = new Node("e");
		Node node6 = new Node("f");
		Node node7 = new Node("g");
		Node node8 = new Node("h");
		Node node9 = new Node("i");
		Node node10 = new Node("j");
		Node node11 = new Node("k");
		Node node12 = new Node("l");
		Node node13 = new Node("m");
		Node node14 = new Node("n");
		Node node15 = new Node("o");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setlChild(node6);
		node3.setrChild(node7);

		node4.setlChild(node8);
		node4.setrChild(node9);

		node5.setlChild(node10);
		node5.setrChild(node11);

		node6.setlChild(node12);
		node6.setrChild(node13);

		node7.setlChild(node14);
		node7.setrChild(node15);

		return root;
	}
}
