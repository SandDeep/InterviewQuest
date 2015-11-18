package com.prac.bt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LevelOrder {

	static Map<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();

	public static void main(String[] args) {
		Node root = getTree();

		int[] path = new int[BTreeUtil.getHeight(root)];

		levelorder(root, path, 0);
		System.out.println(map);
	}

	private static void levelorder(Node node, int[] path, int level) {
		if (node == null) {
			return;
		}
		path[level] += 1;
		if (map.get(level) == null) {
			ArrayList<String> list = new ArrayList<String>();
			list.add(node.getData());
			map.put(level, list);
		} else {
			ArrayList<String> list = map.get(level);
			list.add(node.getData());
			map.put(level, list);
		}

		levelorder(node.lChild, path, level + 1);
		levelorder(node.rChild, path, level + 1);

	}

	public static Node getTree() {

		Node root = new Node("A");

		Node node2 = new Node("B");
		Node node3 = new Node("C");
		Node node4 = new Node("D");
		Node node5 = new Node("E");
		Node node6 = new Node("F");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setrChild(node6);
		return root;
	}

}
