package com.rough;

import com.trash.TNode;

public class P11 {

	public static void main(String[] args) {
		P11 tst = new P11();

		TNode root = null;

		root = tst.insert(root, "cat");
		root = tst.insert(root, "cats");
		root = tst.insert(root, "up");
		root = tst.insert(root, "bug");
		root = tst.insert(root, "burger");
		root = tst.insert(root, "buffalo");
		root = tst.insert(root, "cater");
	}

	private TNode insert(TNode root, String word) {

		return insertUtil(root, word.toCharArray(), 0);
	}

	private TNode insertUtil(TNode node, char[] data, int i) {
		if (node == null) {
			node = new TNode(data[i]);
		}

		if (data[i] < node.getData()) {
			node.setLeft(insertUtil(node.getLeft(), data, i));
		} else if (data[i] > node.getData()) {
			node.setRight(insertUtil(node.getRight(), data, i));
		} else {
			if (i + 1 < data.length) {
				node.setEq(insertUtil(node.getEq(), data, i + 1));
			} else {
				node.setLeafNode(true);
			}
		}
		return node;
	}
}
