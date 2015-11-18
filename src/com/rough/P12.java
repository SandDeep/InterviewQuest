package com.rough;

public class P12 {

	static Node pre = null;
	static Node suc = null;

	public static void main(String[] args) {
		P12 test = new P12();

		Node root = null;

		root = test.insert(root, 50);
		root = test.insert(root, 30);
		root = test.insert(root, 20);
		root = test.insert(root, 40);
		root = test.insert(root, 70);
		root = test.insert(root, 60);
		root = test.insert(root, 80);

		// Delete
		test.inorder(root);

		// root = test.delete(root, 20);
		// root = test.delete(root, 30);
		// root = test.delete(root, 50);

		// System.out.println();
		// test.inorder(root);

		test.findPreSuc(root, 30);
		System.out.println("\nPre : " + pre.getData());
		System.out.println("Suc : " + suc.getData());

		System.out.println("is BST : " + test.isBst(root));

	}

	public boolean isBst(Node node) {
		if (node == null) {
			return true;
		}

		return isBstUtil(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBstUtil(Node node, int min, int max) {
		if (node == null) {
			return true;
		}

		if (node.data < min || node.data > max) {
			return false;
		}

		return isBstUtil(node.lChild, min, node.data - 1)
				&& isBstUtil(node.rChild, node.data + 1, max);
	}

	public void findPreSuc(Node node, int data) {
		if (node == null) {
			return;
		}

		if (data == node.getData()) {
			Node temp = null;

			if (node.lChild != null) {
				temp = node.lChild;
				while (temp.rChild != null) {
					temp = temp.rChild;
				}
				pre = temp;
			}

			if (node.rChild != null) {
				temp = node.rChild;
				while (temp.lChild != null) {
					temp = temp.lChild;
				}
				suc = temp;
			}
		}
		if (data < node.getData()) {
			suc = node;
			findPreSuc(node.lChild, data);
		} else if (data > node.getData()) {
			pre = node;
			findPreSuc(node.rChild, data);
		}
	}

	public Node delete(Node node, int data) {
		if (node == null) {
			return node;
		}

		if (data < node.data) {
			node.setlChild(delete(node.lChild, data));
		} else if (data > node.data) {
			node.setrChild(delete(node.rChild, data));
		} else {
			if (node.lChild == null) {
				return node.rChild;
			}
			if (node.rChild == null) {
				return node.lChild;
			}

			Node suc = getMinNode(node.rChild);
			node.setData(suc.data);

			node.setrChild(delete(node.rChild, suc.data));
		}
		return node;
	}

	public Node getMinNode(Node node) {
		while (node.lChild != null) {
			node = node.lChild;
		}
		return node;
	}

	public void inorder(Node root) {
		if (root != null) {
			inorder(root.lChild);
			System.out.print(root.data + " ");
			inorder(root.rChild);
		}
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
}
