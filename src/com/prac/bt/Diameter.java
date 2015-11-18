package com.prac.bt;

/**
 * The diameter of a tree (sometimes called the width) is the number of nodes on
 * the longest path between two leaves in the tree.O(n) Complexity
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class Diameter {

	public static void main(String[] args) {
		Node root = getTree1();

		// int diameter = getRootedTreeDiameter(root);
		// System.out.println("Diameter of Tree : " + diameter);

		int width = getTreeWidth(root);
		System.out.println("Width of Tree : " + width);
	}

	private static int getTreeWidth(Node node) {
		if (node == null) {
			return 0;
		} else {
			int lLeafedWidth = 0;
			int rLeafedWidth = 0;

			int rootedWidth = getHeight(node.lChild) + getHeight(node.rChild)
					+ 1;
			if (node.lChild != null) {
				lLeafedWidth = getRootedTreeDiameter(node.lChild);
			}

			if (node.rChild != null) {
				rLeafedWidth = getRootedTreeDiameter(node.rChild);
			}

			int heighestValue = Math.max(Math.max(lLeafedWidth, rLeafedWidth),
					rootedWidth);
			return heighestValue;

		}

	}

	private static int getRootedTreeDiameter(Node node) {
		int lChildHeight = 0;
		int rChildHeight = 0;

		if (node.lChild != null) {
			lChildHeight = getHeight(node.lChild);
		}
		if (node.rChild != null) {
			rChildHeight = getHeight(node.rChild);
		}

		return lChildHeight + rChildHeight + 1;
	}

	private static int getHeight(Node node) {
		if (node == null) {
			return 0;
		} else {
			int lHeight = 0;
			int rHeight = 0;
			// Left Child
			if (node.lChild != null) {
				lHeight = getHeight(node.lChild);
			}

			// Right Child
			if (node.rChild != null) {
				rHeight = getHeight(node.rChild);
			}

			return ((lHeight > rHeight) ? lHeight : rHeight) + 1;
		}

	}

	public static Node getTree1() {
		Node root = new Node("1");

		Node node2 = new Node("2");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("6");
		Node node7 = new Node("7");
		Node node8 = new Node("8");
		Node node9 = new Node("9");
		Node node10 = new Node("10");
		Node node11 = new Node("11");
		Node node12 = new Node("12");
		Node node13 = new Node("13");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node5.setlChild(node6);
		node5.setrChild(node7);

		node3.setrChild(node13);

		node13.setrChild(node8);

		node8.setlChild(node9);
		node8.setrChild(node10);

		node9.setlChild(node11);
		node9.setrChild(node12);

		return root;
	}

	public static Node getTree2() {
		Node root = new Node("1");

		Node node2 = new Node("2");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("6");
		Node node7 = new Node("7");
		Node node8 = new Node("8");
		Node node9 = new Node("9");
		Node node10 = new Node("10");
		Node node11 = new Node("11");
		Node node12 = new Node("12");
		Node node13 = new Node("13");
		Node node14 = new Node("14");
		Node node15 = new Node("15");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node4.setlChild(node6);
		node4.setrChild(node7);

		node7.setlChild(node8);
		node8.setlChild(node9);
		node8.setrChild(node10);

		node5.setrChild(node11);
		node11.setlChild(node12);
		node11.setrChild(node13);

		node13.setrChild(node14);

		node3.setrChild(node15);

		return root;
	}
}
