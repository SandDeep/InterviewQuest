package com.prac.bt;

import java.util.LinkedList;
import java.util.Queue;

public class CompleteBT {

	public static Queue<Node> queue = new LinkedList<Node>();

	public static void main(String[] args) {
		Node root = getTree();

		int status = isCompleteBT(root);
		System.out.println("\n" + status);
	}

	private static int isCompleteBT(Node node) {
		if (node == null) {
			return -1;
		}

		queue.add(node);
		boolean flag = false;

		while (!queue.isEmpty()) {
			Node temp = queue.remove();

			System.out.print(temp.getData() + " ");

			if (temp.lChild != null) {

				if (flag) {
					return 0;
				}

				queue.add(temp.lChild);
			} else {
				flag = true;
			}

			if (temp.rChild != null) {

				if (flag) {
					return 0;
				}

				queue.add(temp.rChild);
			} else {
				flag = true;
			}
		}

		return 1;
	}

	public static Node getTree() {
		Node root = new Node("1");

		Node node2 = new Node("2");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("6");

		root.setlChild(node2);
		root.setrChild(node3);

		
		node2.setrChild(node4);
		node3.setlChild(node5);
		node3.setrChild(node6);
		 

/*		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setlChild(node6);*/

		return root;
	}
}
