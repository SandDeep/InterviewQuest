package com.rough;

public class P31 {

	static int size = 256;
	DLLNode head = null;
	DLLNode tail = null;

	public static void main(String[] args) {
		char[] arr = "geeksforgeeksandgeeksquizfor".toCharArray();
		P31 test = new P31();
		boolean[] visited = new boolean[size];
		SingleNode root = null;

		for (int i = 0; i < arr.length; i++) {
			root = test.findNonRepeating(root, arr[i], visited);
		}
		System.out.println("\nUsing DLL : \n");
		test.findFirstNonRepeating(arr);

	}

	private void findFirstNonRepeating(char[] arr) {
		boolean[] repeated = new boolean[size];
		DLLNode[] inDLL = new DLLNode[size];

		for (int i = 0; i < arr.length; i++) {
			if (!repeated[arr[i]]) {

				if (inDLL[arr[i]] == null) {
					DLLNode node = new DLLNode(arr[i]);
					addAtEnd(node);
					inDLL[arr[i]] = node;
				} else {
					remove(inDLL[arr[i]]);
					inDLL[arr[i]] = null;
					repeated[arr[i]] = true;
				}
			}

			if (head != null) {
				System.out.print(head.data + " ");
			}
		}
	}

	private void remove(DLLNode dllNode) {
		if (head == null) {
			return;
		}

		if (head.data == dllNode.data) {
			head = head.next;
		} else if (tail.data == dllNode.data) {
			tail = tail.prev;
		} else {
			if (dllNode.prev != null)
				dllNode.prev.next = dllNode.next;
			if (dllNode.next != null)
				dllNode.next.prev = dllNode.prev;
		}
	}

	private void addAtEnd(DLLNode node) {

		if (head == null) {
			head = tail = node;
			return;
		}

		node.prev = tail;
		tail.next = node;
		tail = node;
	}

	private SingleNode findNonRepeating(SingleNode root, char data,
			boolean[] visited) {

		if (visited[data]) {
			System.out.print(root.data + " ");
			return root;
		}

		// First Node
		if (root == null) {
			root = new SingleNode(data);
			System.out.print(data + " ");
			return root;
		}

		SingleNode node = root;

		while (node.next != null) {
			if (node.data == data) {
				node = node.next;
				visited[data] = true;
				root = node;
				break;
			}

			if (node.next.next != null && node.next.data == data) {
				node.next = node.next.next;
				visited[data] = true;
				break;
			}

			if (node.next.next == null && node.next.data == data) {
				node.next = null;
				visited[data] = true;
				break;
			}
			node = node.next;
		}

		if (node != null && !visited[data]) {
			node.next = new SingleNode(data);
		}

		System.out.print(root.data + " ");
		return root;
	}

	class DLLNode {
		char data;
		DLLNode next;
		DLLNode prev;

		public DLLNode(char data) {
			this.data = data;
			this.next = null;
			this.prev = null;
		}

		@Override
		public String toString() {
			return "DLLNode [data=" + data + "]";
		}
	}

	class SingleNode {
		char data;
		SingleNode next;

		public SingleNode(char data) {
			this.data = data;
			next = null;
		}

		@Override
		public String toString() {
			return "SingleNode [data=" + data + "]";
		}
	}
}
