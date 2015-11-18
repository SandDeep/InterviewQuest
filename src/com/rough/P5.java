package com.rough;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P5 {

	public static void main(String[] args) {
		Node root = getTree4();
		P5 test = new P5();

		int height = test.getHeight(root);
		System.out.println(height);

		/*
		 * int arr[] = new int[height]; test.printLeaf(root, arr, 0);
		 * System.out.println(); test.levelOrder(root); System.out.println();
		 * test.spiralOrder(root);
		 */

		/*
		 * test.childSum(root); test.levelOrder(root);
		 * 
		 * int dia = test.diameter(root); System.out.println("Diameter : " +
		 * dia);
		 */
		// test.inorder(root);
		// test.preorder(root);

		// test.printAncestor(root, 7);

		// Node node = getLCA(root, 4, 5);
		// System.out.println("LCA : " + node.data);

		test.kDistance(root, 8, 2);

		boolean sta = test.isCousin(root, 7, 1);
		System.out.println(sta);
	}

	private boolean isCousin(Node root, int a, int b) {
		if (root == null) {
			return false;
		}

		if (level(root, a, 1) == level(root, b, 1) && !isSibling(root, a, b)) {
			return true;
		}
		return false;
	}

	private boolean isSibling(Node root, int a, int b) {
		if (root == null) {
			return false;
		}

		int left = -1;
		int right = -1;
		if (root.lChild != null) {
			left = root.lChild.data;
		}
		if (root.rChild != null) {
			right = root.rChild.data;
		}
		return (left == a && right == b) || (left == b || right == a)
				|| isSibling(root.lChild, a, b) || isSibling(root.rChild, a, b);
	}

	private int level(Node root, int a, int level) {
		if (root == null) {
			return 0;
		}
		if (root.data == a) {
			return level;
		}
		int l = level(root.lChild, a, level + 1);
		if (l != 0) {
			return l;
		}
		return level(root.rChild, a, level + 1);
	}

	public int kDistance(Node node, int target, int k) {
		if (node == null) {
			return -1;
		}

		if (node.data == target) {
			printKdistanceDown(node, k);
			return 0;
		}

		int dl = kDistance(node.lChild, target, k);

		if (dl != -1) {
			if (dl + 1 == k) {
				System.out.print(node.getData() + " ");
			} else {
				printKdistanceDown(node.rChild, k - dl - 2);
			}
			return dl + 1;
		}

		int dr = kDistance(node.rChild, target, k);
		if (dr != -1) {
			if (dr + 1 == k) {
				System.out.print(node.getData() + " ");
			} else {
				printKdistanceDown(node.lChild, k - dr - 2);
			}
			return dr + 1;
		}

		return -1;
	}

	private void printKdistanceDown(Node node, int k) {
		if (node == null || k < 0) {
			return;
		}
		if (k == 0) {
			System.out.print(node.getData() + " ");
		}
		printKdistanceDown(node.lChild, k - 1);
		printKdistanceDown(node.rChild, k - 1);
	}

	public static Node getLCA(Node node, int n1, int n2) {
		if (node == null) {
			return null;
		}

		if (node.data == n1 || node.data == n2) {
			return node;
		}

		Node left = getLCA(node.lChild, n1, n2);
		Node right = getLCA(node.rChild, n1, n2);

		if (left != null && right != null) {
			return node;
		}

		return (left != null) ? left : right;
	}

	public boolean printAncestor(Node node, int key) {
		if (node == null) {
			return false;
		}

		if (node.data == key) {
			return true;
		}

		if (printAncestor(node.lChild, key) || printAncestor(node.rChild, key)) {
			System.out.print(node.getData() + " ");
			return true;
		}
		return false;

	}

	public void preorder(Node root) {
		while (root != null) {
			if (root.lChild == null) {
				System.out.print(root.data + " ");
				root = root.rChild;
			} else {
				Node curr = root.lChild;
				while (curr.rChild != null && curr.rChild != root) {
					curr = curr.rChild;
				}
				if (curr.rChild == root) {
					curr.rChild = null;
					root = root.rChild;
				} else {
					curr.rChild = root;
					System.out.print(root.getData() + " ");
					root = root.lChild;
				}
			}
		}
	}

	public void inorder(Node node) {
		if (node == null) {
			return;
		}

		Node curr = node;
		Node pre = node;

		while (curr != null) {
			if (curr.lChild == null) {
				System.out.print(curr.data + " ");
				curr = curr.rChild;
			} else {
				pre = curr.lChild;

				while (pre.rChild != null && pre.rChild != curr) {
					pre = pre.rChild;
				}

				if (pre.rChild == null) {
					pre.rChild = curr;
					curr = curr.lChild;
				} else {
					pre.rChild = null;
					System.out.print(curr.getData() + " ");
					curr = curr.rChild;
				}
			}
		}
	}

	public int diameter(Node node) {
		if (node == null) {
			return 0;
		}
		int lHeight = 0;
		int rHeight = 0;

		if (node.lChild != null) {
			lHeight = getHeight(node.lChild);
		}
		if (node.rChild != null) {
			rHeight = getHeight(node.rChild);
		}

		int left = diameter(node.lChild);
		int right = diameter(node.rChild);
		int rootedHeight = 1 + lHeight + rHeight;

		return Math.max(rootedHeight, Math.max(left, right));
	}

	public void childSum(Node node) {
		if (node == null || (node.lChild == null && node.rChild == null)) {
			return;
		}

		childSum(node.lChild);
		childSum(node.rChild);

		int lData = 0;
		int rData = 0;

		if (node.lChild != null) {
			lData = node.lChild.getData();
		}
		if (node.rChild != null) {
			rData = node.rChild.getData();
		}

		int diff = lData + rData - node.getData();

		if (diff > 0) {
			node.setData(node.data + diff);
		} else if (diff < 0) {
			increment(node, -diff);
		}
	}

	public void increment(Node node, int diff) {
		if (node == null) {
			return;
		}
		if (node.lChild != null) {
			node.lChild.data = node.lChild.data + diff;
			increment(node.lChild, diff);
		} else if (node.rChild != null) {
			node.rChild.data = node.rChild.data + diff;
			increment(node.rChild, diff);
		}
	}

	public void spiralOrder(Node node) {
		boolean status = false;
		for (int i = 1; i <= getHeight(node); i++) {
			printSpiral(node, i, status);
			status = !status;
		}
	}

	public void printSpiral(Node node, int level, boolean b) {
		if (level == 1) {
			System.out.print(node.getData() + " ");
		} else {
			if (b) {
				printSpiral(node.lChild, level - 1, b);
				printSpiral(node.rChild, level - 1, b);
			} else {
				printSpiral(node.rChild, level - 1, b);
				printSpiral(node.lChild, level - 1, b);
			}
		}
	}

	public void levelOrder(Node node) {
		if (node == null) {
			return;
		}

		Queue<Node> queue = new LinkedList<Node>();

		queue.add(node);

		while (!queue.isEmpty()) {
			Node temp = queue.poll();

			System.out.print(temp.getData() + " ");
			if (temp.lChild != null) {
				queue.add(temp.lChild);
			}
			if (temp.rChild != null) {
				queue.add(temp.rChild);
			}
		}

	}

	public void printLeaf(Node node, int[] arr, int i) {
		if (node == null) {
			return;
		}

		arr[i++] = node.getData();

		if (node.lChild == null && node.rChild == null) {
			System.out.print(Arrays.toString(arr) + " , ");
		} else {
			printLeaf(node.lChild, arr, i);
			printLeaf(node.rChild, arr, i);
		}
	}

	public int getHeight(Node node) {
		if (node == null) {
			return 0;
		}

		int lHeight = getHeight(node.lChild);
		int rHeight = getHeight(node.rChild);

		return 1 + Math.max(lHeight, rHeight);
	}

	public static Node getTree1() {
		Node root = new Node(50);

		Node node2 = new Node(7);
		Node node3 = new Node(2);
		Node node4 = new Node(3);
		Node node5 = new Node(5);
		Node node6 = new Node(1);
		Node node7 = new Node(30);

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setlChild(node6);
		node3.setrChild(node7);

		return root;
	}

	public static Node getTree() {
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

	public static Node getTree2() {
		Node root = new Node(1);

		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node7 = new Node(7);

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node4.setlChild(node7);

		return root;
	}

	public static Node getTree3() {
		Node root = new Node(20);

		Node node2 = new Node(8);
		Node node3 = new Node(22);
		Node node4 = new Node(4);
		Node node5 = new Node(12);
		Node node6 = new Node(10);
		Node node7 = new Node(14);

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node5.setlChild(node6);
		node5.setrChild(node7);

		return root;
	}

	public static Node getTree4() {
		Node root = new Node(6);

		Node node2 = new Node(3);
		Node node3 = new Node(5);
		Node node4 = new Node(7);
		Node node5 = new Node(8);
		Node node6 = new Node(1);
		Node node7 = new Node(3);

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setlChild(node6);
		node3.setrChild(node7);

		return root;
	}

}
