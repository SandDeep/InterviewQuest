package com.prac.bst;

public class BSTreeUtil {
	/**
	 * Algorithm Inorder(tree) <b>[LNR]</b>
	 * 
	 * 1. Traverse the left subtree, i.e., call Inorder(left-subtree) <p>2. Visit
	 * the root. </p>3. Traverse the right subtree,i.e., call Inorder(right-subtree)
	 * 
	 * @param root
	 */
	public static void inorder(Node root) {
		if (root != null) {
			inorder(root.lChild);
			System.out.print(root.data + " ");
			inorder(root.rChild);
		} else {
			return;
		}
	}

	/**
	 * Algorithm Preorder(tree) [NLR]
	 * 
	 * 1. Visit the root. 2. Traverse the left subtree,i.e., call
	 * Preorder(left-subtree) 3. Traverse the right subtree, i.e., call
	 * Preorder(right-subtree)
	 * 
	 * @param root
	 */
	public static void preorder(Node root) {
		if (root != null) {
			System.out.print(root.data + " ");
			preorder(root.lChild);
			preorder(root.rChild);
		} else {
			return;
		}
	}

	/**
	 * Algorithm Postorder(tree) [LRN]
	 * 
	 * 1. Traverse the left subtree, i.e., call Postorder(left-subtree) 2.
	 * Traverse the right subtree, i.e., call Postorder(right-subtree) 3. Visit
	 * the root.
	 * 
	 * @param root
	 */
	public static void postorder(Node root) {
		if (root != null) {
			preorder(root.lChild);
			preorder(root.rChild);
			System.out.print(root.data + " ");
		} else {
			return;
		}
	}

	/**
	 * Size of a tree = Size of left subtree + 1 + Size of right subtree
	 * 
	 * @param root
	 */
	public static int size(Node node) {
		if (node == null) {
			return 0;
		} else {
			return (size(node.lChild) + 1 + size(node.rChild));
		}
	}

	public static int getHeight(Node node) {
		if (node == null) {
			return 0;
		} else {
			int l = getHeight(node.lChild);
			int r = getHeight(node.rChild);
			if (l > r)
				return l + 1;
			else
				return r + 1;
		}
	}

	public static void delete(Node node) {
		if (node == null) {
			return;
		} else {
			delete(node.lChild);
			delete(node.rChild);

			System.out.println("Deleting Node : " + node.data);
			node.lChild = null;
			node.rChild = null;

			return;
		}
	}

}
