package com.pkg3;

import com.prac.bt.Node;

public class BTtoDLL {

	public static void main(String[] args) {
		Node node = getTree();
		System.out.println(node);
	}

	public static Node getTree() {
		Node root = new Node("10");

		Node node2 = new Node("12");
		Node node3 = new Node("15");
		Node node4 = new Node("25");
		Node node5 = new Node("30");
		Node node6 = new Node("36");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setlChild(node6);
		return root;
	}

}
