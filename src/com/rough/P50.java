package com.rough;

import java.util.Stack;

public class P50 {

	public static void main(String[] args) {
		P50 test = new P50();
		Node root = test.getTree();

		// PreOrder
		test.preorder(root);
		System.out.println();
		test.iterativePreorder(root);

		System.out.println();

		// InOrder
		test.inorder(root);
		System.out.println();
		test.iterativeInorder(root);

		System.out.println();

		// PostOrder
		test.postorder(root);
		System.out.println();
		test.iterativepostorder(root);
		System.out.println();
		test.iterativePostorderOnlyStack(root);

	}

	private void iterativePostorderOnlyStack(Node node) {
		if (node == null) {
			return;
		}

		Stack<Node> stack = new Stack<Node>();
		Node curr = node;

		while (curr != null) {
			if (curr.rChild != null) {
				stack.push(curr.rChild);
			}
			stack.push(curr);
			curr = curr.lChild;
		}

		while (!stack.isEmpty()) {
			// while current not null
			while (curr != null) {
				if (curr.rChild != null) {
					stack.push(curr.rChild);
				}
				stack.push(curr);
				curr = curr.lChild;
			}

			Node temp = stack.pop();

			if (temp.rChild != null && !stack.isEmpty()
					&& temp.rChild.data == stack.peek().data) {
				curr = stack.pop();
				stack.push(temp);
			} else {
				System.out.print(temp.data + " ");
				curr = null;
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop().data + " ");
		}

	}

	private void iterativepostorder(Node node) {
		if (node == null) {
			return;
		}

		Stack<Node> stack1 = new Stack<Node>();
		Stack<Node> stack2 = new Stack<Node>();
		stack1.push(node);

		while (!stack1.isEmpty()) {
			Node temp = stack1.pop();

			if (temp.lChild != null) {
				stack1.push(temp.lChild);
			}

			if (temp.rChild != null) {
				stack1.push(temp.rChild);
			}

			stack2.push(temp);
		}

		while (!stack2.isEmpty()) {
			System.out.print(stack2.pop().data + " ");
		}
	}

	private void iterativeInorder(Node node) {
		if (node == null) {
			return;
		}

		Stack<Node> stack = new Stack<Node>();

		Node current = node;

		boolean done = false;

		while (!done) {

			while (current != null) {
				stack.push(current);
				current = current.lChild;
			}

			while (current == null && !stack.isEmpty()) {
				Node temp = stack.pop();

				System.out.print(temp.getData() + " ");

				current = temp.rChild;
			}

			if (current == null && stack.isEmpty()) {
				done = true;
			}
		}
	}

	// [NLR]
	private void iterativePreorder(Node node) {
		if (node == null) {
			return;
		}

		Stack<Node> stack = new Stack<Node>();
		stack.push(node);

		while (!stack.isEmpty()) {
			Node temp = stack.pop();

			System.out.print(temp.getData() + " ");
			if (temp.rChild != null) {
				stack.push(temp.rChild);
			}

			if (temp.lChild != null) {
				stack.push(temp.lChild);
			}
		}
	}

	public void inorder(Node root) {
		if (root != null) {
			inorder(root.lChild);
			System.out.print(root.data + " ");
			inorder(root.rChild);
		} else {
			return;
		}
	}

	public void preorder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.lChild);
			preorder(root.rChild);
		} else {
			return;
		}
	}

	public void postorder(Node root) {
		if (root == null) {
			return;
		}
		postorder(root.lChild);
		postorder(root.rChild);
		System.out.print(root.data + " ");
	}

	private Node getTree() {
		Node root = new Node(1);

		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);

		root.lChild = node2;
		root.rChild = node3;
		node2.lChild = node4;
		node2.rChild = node5;
		node3.lChild = node6;
		node3.rChild = node7;
		node6.lChild = node8;
		return root;
	}
}
