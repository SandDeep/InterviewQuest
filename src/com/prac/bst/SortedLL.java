package com.prac.bst;

public class SortedLL {

	static NodeL head = null;

	public static void main(String[] args) {
		SortedLL sortedLL = new SortedLL();

		head = new NodeL("1");
		insert("2", head);
		insert("3", head);
		insert("4", head);
		insert("5", head);
		insert("6", head);
		insert("7", head);

		Node root = sortedLL.sortedListToBST(head);
		BSTreeUtil.inorder(root);
	}

	public static void insert(String data, NodeL head) {

		NodeL temp = new NodeL(data);

		while (head.next != null) {
			head = head.next;
		}
		head.setNext(temp);
	}

	private Node sortedListToBST(NodeL head) {

		NodeL temp = head;
		int count = 0;
		while (temp != null) {
			count++;
			temp=temp.next;
		}
		System.out.println(count);

		Node root = slUtil(count);
		return root;
	}

	private Node slUtil(int n) {

		if (n <= 0) {
			return null;
		}

		Node left = slUtil(n / 2);

		Node root = new Node(Integer.parseInt(head.getData()));

		head = head.next;
		root.setlChild(left);

		root.setrChild(slUtil((n - n / 2) - 1));
		return root;
	}

}

class NodeL {

	public String data;
	public NodeL next;

	public NodeL(String data) {
		this.data = data;
		next = null;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public NodeL getNext() {
		return next;
	}

	public void setNext(NodeL next) {
		this.next = next;
	}

}
