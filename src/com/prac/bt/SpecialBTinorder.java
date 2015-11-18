package com.prac.bt;

public class SpecialBTinorder {

	public static void main(String[] args) {
		//int inorder[] = { 5, 10, 40, 30, 28 };
		int inorder[] = {1, 5, 10, 40, 30, 15, 28, 20};

		Node root = buildSBT(inorder, 0, inorder.length - 1);
		BTreeUtil.inorder(root);
	}

	private static Node buildSBT(int[] inorder, int i, int j) {

		if (i > j) {
			return null;
		}

		int largest = getLargest(inorder, i, j);
		int index = search(inorder, i, j, largest);
		Node tmp = new Node(largest + "");

		if (i == j) {
			return tmp;
		}

		tmp.lChild = buildSBT(inorder, i, index - 1);
		tmp.rChild = buildSBT(inorder, index + 1, j);
		return tmp;
	}

	private static int getLargest(int[] inorder, int i, int j) {
		int max = inorder[i];

		for (int k = i + 1; k <= j; k++) {
			if (inorder[k] > max) {
				max = inorder[k];
			}
		}
		return max;
	}

	public static int search(int[] arr, int strt, int end, int value) {
		int i;
		for (i = strt; i <= end; i++) {
			if (arr[i] == value)
				break;
		}
		return i;
	}

}
