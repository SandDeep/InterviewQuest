package com.prac.bt;

public class Foldable {

	public static void main(String[] args) {
		Node root = getTree4();

		// boolean flag = isFoldable(root);
		// System.out.println("Tree is Foldable : " + flag);

		// int level = getLevel(root, 1, "9");
		// System.out.println(level);

		//String[] path = new String[BTreeUtil.getHeight(root)];
		//printAncestor(root, path, 0, "7");
		
		int i=isSumBTree(root);
		System.out.println(i);
	}

	static int isSumBTree(Node root) {
		if (root == null) {
			return -1;
		}

		int sum = isSumTree(root.lChild) + isSumTree(root.rChild);
		int diff = Integer.parseInt(root.data) - sum;
		return diff;
	}

	static int isSumTree(Node node) {
		
		if(node==null){
			return 0;
		}
		
		int l=isSumTree(node.lChild);
		int r=isSumTree(node.rChild);
		
		return Integer.parseInt(node.data) + l + r;
	}

	/**
	 * Print Nodes from root to its parent.
	 * 
	 * @param node
	 * @param path
	 * @param level
	 * @param key
	 */
	static void printAncestor(Node node, String[] path, int level,
			String key) {
		if (node == null) {
			return;
		}

		if (node.getData().equals(key)) {
			printArr(path, level);
			return;
		}
		path[level] = node.getData();

		printAncestor(node.lChild, path, level + 1, key);
		printAncestor(node.rChild, path, level + 1, key);

	}

	private static void printArr(String[] path, int level) {
		for (int i = level-1; i >= 0; i--) {
			System.out.print(path[i] + " ");
		}
	}

	static int getLevel(Node node, int level, String key) {
		if (node == null) {
			return 0;
		}

		if (node.getData().equals(key)) {
			return level;
		}

		int downLevel = getLevel(node.lChild, level + 1, key);
		if (downLevel != 0) {
			return downLevel;
		}

		downLevel = getLevel(node.rChild, level + 1, key);

		return 0;
	}

	public static boolean isFoldable(Node root) {

		boolean flag = false;

		if (root == null) {
			return true;
		}

		if (root.lChild != null && root.rChild != null) {
			flag = isFoldableUtility(root.lChild, root.rChild);
		}

		return flag;
	}

	private static boolean isFoldableUtility(Node node1, Node node2) {

		if (node1 == null && node2 == null) {
			return true;
		}

		if (node1 == null || node2 == null) {
			return false;
		}

		return isFoldableUtility(node1.rChild, node2.lChild)
				&& isFoldableUtility(node1.lChild, node2.rChild);

	}

	public static Node getTree() {

		Node root = new Node("10");

		Node node2 = new Node("7");
		Node node3 = new Node("15");
		Node node4 = new Node("9");
		Node node5 = new Node("11");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setrChild(node4);

		node3.setlChild(node5);

		return root;

	}

	public static Node getTree1() {

		Node root = new Node("10");

		Node node2 = new Node("7");
		Node node3 = new Node("15");
		Node node4 = new Node("9");
		Node node5 = new Node("11");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);

		node3.setrChild(node5);

		return root;

	}

	public static Node getTree2() {

		Node root = new Node("10");

		Node node2 = new Node("7");
		Node node3 = new Node("15");
		Node node4 = new Node("9");
		Node node5 = new Node("10");
		Node node6 = new Node("12");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node6);

		node3.setlChild(node5);

		return root;

	}

	public static Node getTree3() {

		Node root = new Node("1");

		Node node2 = new Node("2");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("5");
		Node node6 = new Node("7");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node4.setlChild(node6);

		return root;

	}
	
	public static Node getTree4() {

		Node root = new Node("26");

		Node node2 = new Node("10");
		Node node3 = new Node("3");
		Node node4 = new Node("4");
		Node node5 = new Node("6");
		Node node6 = new Node("3");

		root.setlChild(node2);
		root.setrChild(node3);

		node2.setlChild(node4);
		node2.setrChild(node5);

		node3.setrChild(node6);

		return root;

	}

}
