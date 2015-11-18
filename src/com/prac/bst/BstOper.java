package com.prac.bst;

public class BstOper {

	static Node pre = new Node(-1);
	static Node suc = new Node(-1);

	public static void main(String[] args) {
		Node root = new Node(50);
		insert(root, 30);
		insert(root, 70);
		insert(root, 20);
		insert(root, 40);
		insert(root, 60);
		insert(root, 80);

		BSTreeUtil.inorder(root);
		System.out.println();

		// root = delete(root, 20);
		// root = delete(root, 30);
		// root = delete(root, 50);

		printGeneration(root, 40);
		System.out.println(pre.getData() + " : " + suc.getData());

		// int status = isBST(root);
		boolean status = isBSTU(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		System.out.println(status);
	}

	public static boolean isBSTU(Node node, int min, int max) {
		if (node == null) {
			return true;
		}

		if (min > node.getData() || max < node.getData()) {
			return false;
		}

		return isBSTU(node.lChild, min, node.getData() - 1)
				&& isBSTU(node.rChild, node.getData() + 1, max);
	}

	public static int isBST(Node node) {
		if (node == null) {
			return 1;
		}

		if ((node.lChild != null) && (maxVal(node.lChild) > node.getData())) {
			return 0;
		}

		if ((node.rChild != null) && (minVal(node.rChild) < node.getData())) {
			return 0;
		}

		if (isBST(node.lChild) != 1 || isBST(node.rChild) != 1) {
			return 0;
		}
		return 1;
	}

	public static int minVal(Node node) {
		while (node.lChild != null) {
			node = node.lChild;
		}
		return node.getData();
	}

	public static int maxVal(Node node) {
		while (node.rChild != null) {
			node = node.rChild;
		}
		return node.getData();
	}

	public static void printGeneration(Node node, int key) {
		if (node == null) {
			return;
		}

		if (node.getData() == key) {

			if (node.lChild != null) {
				Node tmp = node.lChild;
				while (tmp.rChild != null) {
					tmp = tmp.rChild;
				}
				pre = tmp;
			}

			if (node.rChild != null) {
				Node tmp = node.rChild;
				while (tmp.lChild != null) {
					tmp = tmp.lChild;
				}
				suc = tmp;
			}

			return;
		}

		if (key < node.getData()) {
			suc = node;
			printGeneration(node.lChild, key);
		} else if (key > node.getData()) {
			pre = node;
			printGeneration(node.rChild, key);
		}
	}

	public static Node delete(Node root, int key) {
		if (root == null) {
			return null;
		}
		if (key < root.getData()) {
			root.lChild = delete(root.lChild, key);
		} else if (key > root.getData()) {
			root.rChild = delete(root.rChild, key);
		} else {
			if (root.lChild == null) {
				return root.rChild;
			} else if (root.rChild == null) {
				return root.lChild;
			}

			Node tmp = minNode(root.rChild);

			// Copy the inorder successor's content to this node as this would
			// be leaf node only

			root.setData(tmp.getData());

			root.rChild = delete(root.rChild, tmp.getData());
		}
		return root;
	}

	private static Node minNode(Node node) {

		while (node.lChild != null) {
			node = node.lChild;
		}

		return node;
	}

	public static Node insert(Node node, int data) {
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

	public static Node search(Node node, int data) {
		if (node == null || node.getData() == data) {
			return node;
		} else if (data < node.getData()) {
			return search(node.lChild, data);
		}
		return search(node.rChild, data);
	}

	public static Node getTree2() {
		Node root = new Node(1);

		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setlChild(node6);
		node3.setrChild(node7);

		return root;
	}
}
