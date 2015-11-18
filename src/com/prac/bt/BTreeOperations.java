package com.prac.bt;

import java.util.Stack;

public class BTreeOperations {

	public static void main(String[] args) {
		Node root = new Node("10");

		Node node2 = new Node("8");
		Node node3 = new Node("2");
		Node node4 = new Node("3");
		Node node5 = new Node("5");
		Node node6 = new Node("2");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setlChild(node6);

		Node rootTree1 = getTree2();
		// System.out.println(BTreeUtil.getHeight(rootTree1));

		// System.out.println(isSumProperty(root));

		// System.out.println(isBalanced(rootTree1));

		inorderUsingStack(rootTree1);
	}

	/**
	 * Algorithm : 1) Create an empty stack S. 2) Initialize current node as
	 * root 3) Push the current node to S and set current = current->left until
	 * current is NULL 4) If current is NULL and stack is not empty then a) Pop
	 * the top item from stack. b) Print the popped item, set current =
	 * current->right c) Go to step 3. 5) If current is NULL and stack is empty
	 * then we are done. Time Complexity: O(n)
	 * 
	 * @param node
	 */
	public static void inorderUsingStack(Node node) {
		Stack<Node> stack = new Stack<Node>();

		// Push the current node to S and set current = current->left until
		// current is NULL
		while (node != null) {
			stack.add(node);
			node = node.lChild;
		}

		while (!stack.isEmpty()) {
			// Pop the top item from stack
			Node currentNode = stack.pop();

			// Print the popped item, set current = current->right
			System.out.print(currentNode.data + " ");

			if (currentNode.rChild != null) {
				currentNode = currentNode.rChild;
				stack.add(currentNode);

				while (currentNode.lChild != null) {
					stack.add(currentNode.lChild);
					currentNode = currentNode.lChild;
				}

			}
		}
	}

	/**
	 * An empty tree is height-balanced. A non-empty binary tree T is balanced
	 * if: 1) Left subtree of T is balanced 2) Right subtree of T is balanced 3)
	 * The difference between heights of left subtree and right subtree is not
	 * more than 1.Time Complexity: O(n)
	 * 
	 * @param node
	 * @return
	 */
	public static boolean isBalanced(Node node) {
		// leaf node
		if (node.lChild == null && node.rChild == null) {
			return true;
		} else {
			boolean flag = false;

			if (node.lChild != null) {
				if (!isBalanced(node.lChild)) {
					return false;
				}
			}

			if (node.rChild != null) {
				if (!isBalanced(node.rChild)) {
					return false;
				}
			}

			int lHeight = 0;
			int rHeight = 0;

			if (node.lChild != null) {
				lHeight = BTreeUtil.getHeight(node.lChild);
			}
			if (node.rChild != null) {
				rHeight = BTreeUtil.getHeight(node.rChild);
			}
			int diff = Math.abs(lHeight - rHeight);

			if (diff > 1) {
				flag = false;
			} else {
				flag = true;
			}

			return flag;
		}
	}

	public static int isSumProperty(Node node) {
		if (node == null || (node.lChild == null && node.rChild == null)) {
			return 0;
		}
		int lval = isSumProperty(node.lChild);
		int rval = isSumProperty(node.rChild);

		int flag = 0;
		if (lval == -1 || rval == -1) {
			flag = -1;
		} else if (lval == 0 && rval == 0) {
			int sum = 0;
			if (node.lChild != null) {
				sum += Integer.parseInt(node.lChild.data);
			}
			if (node.rChild != null) {
				sum += Integer.parseInt(node.rChild.data);
			}

			if (Integer.parseInt(node.data) == sum) {
				flag = 0;
			} else {
				flag = -1;
			}
		}
		return flag;
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

		node4.setlChild(node6);
		node4.setrChild(node7);

		node7.setlChild(node8);

		node5.setrChild(node9);
		node9.setlChild(node10);

		node3.setrChild(node11);
		node11.setlChild(node12);
		node11.setrChild(node13);

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

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node5.setlChild(node6);

		node3.setrChild(node7);

		return root;
	}
}
