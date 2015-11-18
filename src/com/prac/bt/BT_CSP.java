package com.prac.bt;

public class BT_CSP {

	public static void main(String[] args) {
		Node root = new Node("50");

		Node node2 = new Node("7");
		Node node3 = new Node("2");
		Node node4 = new Node("3");
		Node node5 = new Node("5");
		Node node6 = new Node("1");
		Node node7 = new Node("30");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setlChild(node6);
		node3.setrChild(node7);

		System.out.println("Initial Tree : ");
		BTreeUtil.preorder(root);

		convertBTtoCSP(root);

		System.out.println("\nAfter Tree : ");
		BTreeUtil.preorder(root);

	}

	/**
	 * Time Complexity: O(n^2), Worst case complexity is for a skewed tree such
	 * that nodes are in decreasing order from root to leaf.
	 * 
	 * @param node
	 */
	public static void convertBTtoCSP(Node node) {
		if (node == null || (node.lChild == null && node.rChild == null)) {
			return;
		}

		convertBTtoCSP(node.lChild);
		convertBTtoCSP(node.rChild);

		int sum = 0;
		if (node.lChild != null) {
			sum += Integer.parseInt(node.lChild.data);
		}
		if (node.rChild != null) {
			sum += Integer.parseInt(node.rChild.data);
		}

		int diff = Integer.parseInt(node.data) - sum;

		if (diff == 0) {
			return;
		} else if (diff < 0) {
			node.setData(String.valueOf(Integer.parseInt(node.data)
					+ (diff * -1)));
			return;
		} else {
			if (node.lChild != null) {
				incNodeData(node.lChild, diff);
				return;
			} else if (node.rChild != null) {
				incNodeData(node.rChild, diff);
				return;
			}
		}
	}

	/**
	 * Increment Node data in all its child node to maintain consistency.
	 * 
	 * @param node
	 * @param diff
	 */
	public static void incNodeData(Node node, int diff) {
		node.setData(String.valueOf(Integer.parseInt(node.data) + diff));

		if (node.lChild == null && node.rChild == null) {
			return;
		} else if (node.lChild != null) {
			incNodeData(node.lChild, diff);
			return;
		} else if (node.rChild != null) {
			incNodeData(node.rChild, diff);
			return;
		}
	}
}
