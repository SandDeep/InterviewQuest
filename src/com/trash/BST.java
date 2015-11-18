package com.trash;

public class BST {

	public static void main(String[] args) {
		BST bst = new BST();

		Node root = null;

		root = bst.insert(root, 60);
		root = bst.insert(root, 30);
		root = bst.insert(root, 70);
		root = bst.insert(root, 20);
		root = bst.insert(root, 40);
		root = bst.insert(root, 60);
		root = bst.insert(root, 80);
	}

	private Node insert(Node node, int data) {
		if (node == null) {
			return new Node(data);
		}

		if (data < node.getData()) {
			node.setlChild(insert(node.lChild, data));
		} else if (data > node.getData()) {
			node.setrChild(insert(node.rChild, data));
		}

		return node;
	}
}
