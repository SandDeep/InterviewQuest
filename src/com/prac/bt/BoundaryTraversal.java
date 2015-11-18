package com.prac.bt;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Time Complexity: O(n) where n is the number of nodes in binary tree.
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class BoundaryTraversal {

	Queue<String> queue = new LinkedList<String>();
	Stack<String> stack = new Stack<String>();

	public static void main(String[] args) {
		Node root = getTree();

		BoundaryTraversal traversal = new BoundaryTraversal();

		// traversal.boundaryTraversal(root);

		// GeeksforGeeks
		traversal.printBoundary(root);
	}

	private void printBoundary(Node root) {
		if (root != null) {
			System.out.print(root.getData() + " ");

			// Print the left boundary in top-down manner.
			printBoundaryLeft(root.lChild);

			// Print all leaf nodes
			printLeaves(root.lChild);
			printLeaves(root.rChild);

			// Print the right boundary in bottom-up manner
			printBoundaryRight(root.rChild);

		}
	}

	void printBoundaryLeft(Node node) {
		if (node != null) {

			if (node.lChild != null) {
				System.out.print(node.getData() + " ");
				printBoundaryLeft(node.lChild);
			} else if (node.rChild != null) {
				System.out.print(node.getData() + " ");
				printBoundaryLeft(node.rChild);
			}
		}
	}

	void printLeaves(Node node) {
		if (node != null) {
			printLeaves(node.lChild);

			if (node.lChild == null && node.rChild == null) {
				System.out.print(node.getData() + " ");
			}

			printLeaves(node.rChild);
		}
	}

	void printBoundaryRight(Node node) {

		if (node != null) {

			if (node.rChild != null) {
				printBoundaryRight(node.rChild);
				System.out.print(node.getData() + " ");
			} else if (node.lChild != null) {
				printBoundaryRight(node.lChild);
				System.out.print(node.getData() + " ");
			}
		}
	}

	void boundaryTraversal(Node node) {
		storeLeftPart(node);
		printLeafNode(node);
		storeRightPart(node.rChild);

		// print Queue
		while (!queue.isEmpty()) {
			String data = queue.remove();
			System.out.print(data + " ");
		}

		// print Stack
		while (!stack.isEmpty()) {
			System.out.println(stack.peek() + " ");
			stack.pop();
		}
	}

	void storeLeftPart(Node node) {
		if (node == null) {
			return;
		}

		if (node.lChild == null && node.rChild == null) {
			return;
		}
		queue.add(node.getData());
		if (node.lChild != null) {
			storeLeftPart(node.lChild);
		} else if (node.rChild != null) {
			storeLeftPart(node.rChild);
		}
	}

	void printLeafNode(Node node) {
		if (node == null) {
			return;
		}
		if (node.lChild == null && node.rChild == null) {
			// System.out.println(node.getData());
			queue.add(node.getData());
		}
		printLeafNode(node.lChild);
		printLeafNode(node.rChild);
	}

	void storeRightPart(Node node) {
		if (node == null) {
			return;
		}

		if (node.lChild == null && node.rChild == null) {
			return;
		}
		stack.push(node.getData());

		if (node.rChild != null) {
			storeRightPart(node.rChild);
		} else if (node.lChild != null) {
			storeRightPart(node.lChild);
		}
	}

	public static Node getTree() {
		Node root = new Node("20");

		Node node2 = new Node("8");
		Node node3 = new Node("22");
		Node node4 = new Node("4");
		Node node5 = new Node("12");
		Node node6 = new Node("25");
		Node node7 = new Node("10");
		Node node8 = new Node("14");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setrChild(node6);

		node5.setlChild(node7);
		node5.setrChild(node8);

		return root;
	}
}
