package com.prac.bt;

import java.util.Arrays;

/**
 * Time Complexity: O(n^2). Worst case occurs when tree is left skewed. Example
 * Preorder and Inorder traversals for worst case are {A, B, C, D} and {D, C, B,
 * A}.
 * 
 * @author Deepesh
 * 
 */
public class BuildTree {

	static int preIndex = 0;

	public static void main(String[] args) {
		String[] inorder = { "D", "B", "E", "A", "F", "C" };
		String[] preorder = { "A", "B", "D", "E", "C", "F" };

		Node root = buildTree(inorder, preorder, 0, inorder.length - 1);
		BTreeUtil.preorder(root);
	}

	private static Node buildTree(String[] inorder, String[] preorder,
			int inStart, int inEnd) {

		if (inStart > inEnd) {
			return null;
		}

		/*
		 * Pick current node from Preorder traversal using preIndex and
		 * increment preIndex
		 */
		String preVal = preorder[preIndex++];

		Node tNode = new Node(preVal);

		/* If this node has no children then return */
		if (inStart == inEnd) {
			return tNode;
		}

		/* Else find the index of this node in Inorder traversal */
		int index = Arrays.asList(inorder).indexOf(preVal);

		/*
		 * Using index in Inorder traversal, construct left and right subtrees.
		 */
		tNode.lChild = buildTree(inorder, preorder, inStart, index - 1);
		tNode.rChild = buildTree(inorder, preorder, index + 1, inEnd);

		return tNode;
	}

	public static int search(String[] arr, int strt, int end, String value) {
		int i;
		for (i = strt; i <= end; i++) {
			if (arr[i].equals(value))
				break;
		}
		return i;
	}

}
