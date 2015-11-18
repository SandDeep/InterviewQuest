package com.rough;

public class P8 {

	static Node pre = null;
	static Node suc = null;

	public static void main(String[] args) {
		P8 test = new P8();

		Node root = null;

		root = test.insert(root, 50);
		root = test.insert(root, 30);
		root = test.insert(root, 20);
		root = test.insert(root, 40);
		root = test.insert(root, 70);
		root = test.insert(root, 60);
		root = test.insert(root, 80);

		test.inorder(root);

		Node node = test.search(root, 70);
		System.out.println("\n" + node.getData());

		// root = test.delete(root, 20);
		// root = test.delete(root, 30);
		// root = test.delete(root, 50);

		test.findPreSuc(root, 60);
		System.out.println("Pre : " + pre.getData());
		System.out.println("Suc : " + suc.getData());

		System.out.println("is BST : " + test.isBst(root));
	}

	private boolean isBst(Node node) {
		return isBstUtil(node,Integer.MIN_VALUE,Integer.MAX_VALUE);
	}

	private boolean isBstUtil(Node node, int min, int max) {
		if (node == null) {
			return true;
		}

		if (min > node.data || max < node.data) {
			return false;
		}

		return isBstUtil(node.lChild, min, node.data - 1)
				&& isBstUtil(node.rChild, node.data + 1, max);
	}

	private void findPreSuc(Node root, int key) {
		if (root == null) {
			return;
		}

		if (root.getData() == key) {

			// Predecessor
			if (root.lChild != null) {
				Node temp = root.lChild;
				while (temp.rChild != null) {
					temp = temp.rChild;
				}
				pre = temp;
			}

			// Successor
			if (root.rChild != null) {
				Node temp = root.rChild;
				while (temp.lChild != null) {
					temp = temp.lChild;
				}
				suc = temp;
			}
		}

		else if (key < root.data) {
			suc = root;
			findPreSuc(root.lChild, key);
		} else {
			pre = root;
			findPreSuc(root.rChild, key);
		}
	}

	public Node delete(Node node, int key) {
		if (node == null) {
			return null;
		}

		if (key < node.data) {
			node.lChild = delete(node.lChild, key);
		} else if (key > node.data) {
			node.rChild = delete(node.rChild, key);
		} else {
			if (node.lChild == null) {
				return node.rChild;
			} else if (node.rChild == null) {
				return node.lChild;
			}

			Node temp = getMinValueNode(node.rChild);
			node.setData(temp.getData());
			node.rChild = delete(node.rChild, temp.data);
		}
		return node;
	}

	public Node getMinValueNode(Node node) {
		while (node.lChild != null) {
			node = node.lChild;
		}
		return node;
	}

	public Node search(Node node, int key) {
		if (node.data == key || node == null) {
			return node;
		}

		if (key < node.getData()) {
			return search(node.lChild, key);
		}
		return search(node.rChild, key);
	}

	public Node insert(Node node, int data) {
		if (node == null) {
			return new Node(data);
		}

		if (data < node.data) {
			node.setlChild(insert(node.lChild, data));
		} else if (data > node.data) {
			node.setrChild(insert(node.rChild, data));
		}
		return node;
	}

	public void inorder(Node root) {
		if (root != null) {
			inorder(root.lChild);
			System.out.print(root.getData() + " ");
			inorder(root.rChild);
		}
	}
}
