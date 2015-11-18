package com.prac.bt;

public class MirrorImageBT {

	public static String[] path = new String[1000];
	public static int pathlength = 0;

	public static void main(String[] args) {
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
		node5.setrChild(node7);

		System.out.println(root);
		//BTreeUtil.inorder(root);
		//mirror(root);
		//BTreeUtil.inorder(root);

		printPathsRecur(root, path, pathlength);

	}

	public static void mirror(Node root) {
		if (root == null) {
			return;
		} else {
			mirror(root.lChild);
			mirror(root.rChild);

			System.out.println("Swapping Node : " + root);
			Node temp = root.lChild;
			root.lChild = root.rChild;
			root.rChild = temp;

		}
	}

	public static void printPathsRecur(Node node, String[] path, int pathlength) {
		if (node != null) {
			path[pathlength] = node.data;
			pathlength++;

			if (node.lChild == null && node.rChild == null) {
				for (int i = 0; i < pathlength; i++) {
					System.out.print(path[i] + " ");
				}
				System.out.println();
			} else {
				printPathsRecur(node.lChild, path, pathlength);
				printPathsRecur(node.rChild, path, pathlength);
			}

		} else {
			return;
		}
	}
}
