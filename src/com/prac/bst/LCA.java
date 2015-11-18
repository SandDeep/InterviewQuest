package com.prac.bst;

public class LCA {

	public static void main(String[] args) {
		Node root = new Node(20);
		root = BstOper.insert(root, 8);
		root = BstOper.insert(root, 22);
		root = BstOper.insert(root, 4);
		root = BstOper.insert(root, 12);
		root = BstOper.insert(root, 10);
		root = BstOper.insert(root, 14);

		// Node lcaNode = getLCA(root, 12, 21);
		// System.out.println(lcaNode.getData());

		Node btLCA = findLCA(BstOper.getTree2(), 2, 7);
		System.out.println(btLCA.getData());
	}

	private static Node findLCA(Node node, int n1, int n2) {
		if (node == null) {
			return node;
		}

		if (node.getData() == n1 || node.getData() == n2) {
			return node;
		}

		Node lNode = findLCA(node.lChild, n1, n2);
		Node rNode = findLCA(node.rChild, n1, n2);

		if (lNode != null && rNode != null) {
			return node;
		}

		return lNode != null ? lNode : rNode;
	}

	public static Node getLCA(Node node, int n1, int n2) {
		if (node == null) {
			return null;
		}

		if (n1 < node.getData() && n2 < node.getData()) {
			return getLCA(node.lChild, n1, n2);
		} else if (n1 > node.getData() && n2 > node.getData()) {
			return getLCA(node.rChild, n1, n2);
		}

		return node;
	}
}
