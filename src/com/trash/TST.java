package com.trash;

import java.util.ArrayList;
import java.util.List;

/**
 * http://www.sanfoundry.com/java-program-ternary-search-tree/
 * 
 * @author Deepesh
 * 
 */
public class TST {

	List<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		TST tst = new TST();

		TNode root = null;

		root = tst.insert(root, "cat");
		root = tst.insert(root, "cats");
		root = tst.insert(root, "up");
		root = tst.insert(root, "bug");
		root = tst.insert(root, "burger");
		root = tst.insert(root, "buffalo");
		root = tst.insert(root, "cater");

		// Search
		tst.search(root, "cat");

		// traverse
		tst.traverse(root);

		// prefix
		tst.prefixSearch(root, "ca");
	}

	private void prefixSearch(TNode node, String prefix) {
		if (node == null) {
			return;
		}

		TNode preRoot = prefixUtil(node, prefix.toCharArray(), 0);

		if (preRoot.isLeafNode()) {
			System.out.println(prefix);
		}
		prefixPrint(preRoot.eq, prefix, "");
		System.out.println();
	}

	private void prefixPrint(TNode node, String prefix, String str) {
		if (node == null) {
			return;
		}

		prefixPrint(node.left, prefix, str);

		str += node.data;
		if (node.isLeafNode()) {
			System.out.println(prefix + str);
		}

		prefixPrint(node.eq, prefix, str);
		str = "";
		prefixPrint(node.right, prefix, str);

	}

	private TNode prefixUtil(TNode node, char[] arr, int i) {
		if (node == null) {
			return null;
		}

		if (arr[i] < node.getData()) {
			return prefixUtil(node.left, arr, i);
		} else if (arr[i] > node.getData()) {
			return prefixUtil(node.right, arr, i);
		} else {
			if (i == arr.length - 1) {
				return node;
			} else {
				return prefixUtil(node.eq, arr, i + 1);
			}
		}
	}

	private void traverse(TNode node) {
		if (node == null) {
			return;
		}

		traverseUtil(node, "");
		System.out.println("TST : " + list);
	}

	private void traverseUtil(TNode node, String str) {
		if (node == null) {
			return;
		}

		traverseUtil(node.left, str);
		str += node.getData();

		if (node.isLeafNode()) {
			list.add(str);
		}
		traverseUtil(node.eq, str);
		str = "";
		traverseUtil(node.right, str);
	}

	private void search(TNode node, String data) {
		if (node == null || data.length() < 1) {
			return;
		}

		char arr[] = data.toCharArray();

		boolean status = searchUtil(node, arr, 0);
		System.out.println(status);
	}

	private boolean searchUtil(TNode node, char[] arr, int i) {
		if (node == null) {
			return false;
		}

		if (arr[i] < node.getData()) {
			return searchUtil(node.left, arr, i);
		} else if (arr[i] > node.getData()) {
			return searchUtil(node.right, arr, i);
		} else {
			if (node.isLeafNode() && i == arr.length - 1) {
				return true;
			} else if (i == arr.length - 1) {
				return false;
			} else {
				return searchUtil(node.eq, arr, i + 1);
			}
		}
	}

	private TNode insert(TNode root, String data) {
		char[] arr = data.toCharArray();

		root = insertUtil(root, arr, 0);

		return root;
	}

	private TNode insertUtil(TNode node, char[] word, int i) {
		if (node == null) {
			node = new TNode(word[i]);
		}

		if (word[i] < node.getData()) {
			node.setLeft(insertUtil(node.left, word, i));
		} else if (word[i] > node.getData()) {
			node.setRight(insertUtil(node.right, word, i));
		} else {
			if (i + 1 < word.length) {
				node.setEq(insertUtil(node.eq, word, i + 1));
			} else {
				node.setLeafNode(true);
			}
		}

		return node;
	}

}
