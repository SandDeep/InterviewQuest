package com.pkg3;

import com.prac.bt.BTreeUtil;
import com.prac.bt.Node;

public class PrePostOrder {

	static int preIndex = 0;

	public static void main(String[] args) {

		String[] pre = { "1", "2", "4", "8", "9", "5", "3", "6", "7" };
		String[] post = { "8", "9", "4", "5", "2", "6", "7", "3", "1" };

		Node root = contructTree(pre, post, 0, post.length);
		BTreeUtil.preorder(root);
	}

	public static Node contructTree(String[] pre, String[] post, int start,
			int end) {
		if ((start > end)) {
			return null;
		}

		Node temp = new Node(pre[preIndex++]);

		if (start == end) {
			return temp;
		}
		if ((preIndex > pre.length - 1)) {
			return temp;
		}
		int index = search(post, start, end, pre[preIndex]);

		temp.lChild = contructTree(pre, post, start, index);
		temp.rChild = contructTree(pre, post, index + 1, end - 1);

		return temp;
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
