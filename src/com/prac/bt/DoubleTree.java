package com.prac.bt;

/**
 * To create Double tree of the given tree, create a new duplicate for each
 * node, and insert the duplicate as the left child of the original node.Time
 * Complexity: O(n) where n is the number of nodes in the tree.
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class DoubleTree {

	public static void main(String[] args) {
		Node root = new Node("1");

		Node node2 = new Node("2");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("5");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		BTreeUtil.inorder(root);
		doubleTree(root);
		System.out.println("");
		BTreeUtil.inorder(root);
	}

	public static void doubleTree(Node node) {
		if (node == null) {
			return;
		}

		doubleTree(node.lChild);
		doubleTree(node.rChild);

		Node oldNode = node.lChild;
		node.lChild = new Node(node.data);
		node.lChild.lChild = oldNode;
	}

	public static void buildDoubleTree(Node node) {

		if (node == null) {
			return;
		}

		Node replicaNode = new Node(node.data);

		if (node.lChild == null) {
			node.lChild = replicaNode;
		} else {
			Node tNode = node.lChild;
			node.lChild = replicaNode;
			replicaNode.lChild = tNode;
		}

		buildDoubleTree(replicaNode.lChild);
		buildDoubleTree(node.rChild);

	}
}
