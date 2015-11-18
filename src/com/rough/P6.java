package com.rough;

import java.util.Arrays;

import com.prac.bt.Node;

public class P6 {

	static int preIndex = 0;

	public static void main(String[] args) {
		String[] in = { "D", "B", "E", "A", "F", "C" };
		String[] pre = { "A", "B", "D", "E", "C", "F" };

		P6 test = new P6();
		Node root = test.builTree(in, pre, 0, pre.length - 1);
		test.inorder(root);
	}

	private Node builTree(String[] in, String[] pre, int start, int end) {
		if (start > end) {
			return null;
		}

		String data = pre[preIndex++];
		Node node = new Node(data);

		if (start == end) {
			return node;
		}

		int index = Arrays.asList(in).indexOf(data);

		node.lChild = builTree(in, pre, start, index - 1);
		node.rChild = builTree(in, pre, index + 1, end);

		return node;
	}

	private void inorder(Node root) {
		if (root != null) {
			inorder(root.lChild);
			System.out.print(root.getData() + " ");
			inorder(root.rChild);
		}
	}
}
