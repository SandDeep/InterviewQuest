package com.prac.bt;

public class SpecialBTpreorder {

	static int index = 0;

	public static void main(String[] args) {
		int[] pre = { 10, 30, 20, 5, 15 };
		char[] preLN = { 'N', 'N', 'L', 'L', 'L' };

		Node root = buildSBT(pre, preLN);
		BTreeUtil.preorder(root);
	}

	private static Node buildSBT(int[] pre, char[] preLN) {
		int curr = index;

		if (index == pre.length) {
			return null;
		}

		Node temp = new Node(pre[index++] + "");

		if (preLN[curr] == 'N') {
			temp.lChild = buildSBT(pre, preLN);
			temp.rChild = buildSBT(pre, preLN);
		}

		return temp;
	}
}
