package com.pkg1;

import com.prac.bt.Node;

public class TreeListRecursion {

	public static void main(String[] args) {
		Node root = getTree();

		root = treeListRecursion(root);
		printList(root);
	}

	private static void printList(Node head) {
		Node temp = head;

		do{
			System.out.print(temp.getData() + " ");
			temp = temp.rChild;
		}
		while (temp != head);
	}
	
	private static Node treeListRecursion(Node node) {
		if (node == null) {
			return null;
		} else {

			Node leftHead = treeListRecursion(node.lChild);
			Node rightHead = treeListRecursion(node.rChild);

			Node lNode = leftHead;
			Node rNode = rightHead;

			/* RightMost Node for Left Child */
			while (lNode != null
					&& (lNode.rChild != null && lNode.rChild != leftHead)) {
				lNode = lNode.rChild;
			}

			// now, lnode => tail of left list

			if (lNode != null) {
				lNode.rChild = node;
				node.lChild = lNode;
			}

			if (rightHead != null) {
				rightHead.lChild = node;
				node.rChild = rightHead;
				
				/* RightMost Node for Right Child */
				while (rNode != null
						&& (rNode.rChild != null && rNode.rChild != rightHead)) {
					rNode = rNode.rChild;
				}
			}
			// Base vase when (node.lChild!=null && node.rChild==null)
			else{
				rightHead=node;
				rNode=rightHead;
			}

			if (leftHead != null && rightHead != null) {
				leftHead.lChild = rNode;
				rNode.rChild = leftHead;
			}

			return leftHead != null ? leftHead : node;
		}
	}

	public static Node getTree() {
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

		node3.setlChild(node6);
		node3.setrChild(node7);

		return root;
	}

	public static Node getTree1() {
		Node root = new Node("4");

		Node node2 = new Node("2");
		Node node3 = new Node("5");
		Node node4 = new Node("1");
		Node node5 = new Node("3");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		return root;
	}
}
