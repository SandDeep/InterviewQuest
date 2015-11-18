package com.rough;

public class P2 {

	LNode head = null;

	public static void main(String[] args) {
		P2 t = new P2();

		LNode root = null;
		root = t.insert(root, "15");
		root = t.insert(root, "10");
		root = t.insert(root, "5");
		root = t.insert(root, "20");
		root = t.insert(root, "3");
		root = t.insert(root, "2");

		t.traverse(root);
		// t.createLoop(root);
		// t.detectLoop(root);
		// root = t.reverse(root);
		// t.traverse(root);

		LNode list1 = null;
		list1 = t.insert(list1, "5");
		list1 = t.insert(list1, "10");
		list1 = t.insert(list1, "15");

		LNode list2 = null;
		list2 = t.insert(list2, "2");
		list2 = t.insert(list2, "3");
		list2 = t.insert(list2, "20");

		LNode result = t.merge(list1, list2);
		t.traverse(result);
	}

	private LNode merge(LNode list1, LNode list2) {
		LNode result = null;

		if (list1 == null) {
			return list2;
		} else if (list2 == null) {
			return list1;
		}

		int a = Integer.parseInt(list1.getData());
		int b = Integer.parseInt(list2.getData());

		if (a < b) {
			result = list1;
			result.setNext(merge(list1.next, list2));
		} else if (a > b) {
			result = list2;
			result.setNext(merge(list1, list2.next));
		}
		return result;
	}

	// Merge
	private LNode sortedMerge(LNode a, LNode b) {
		if (a == null) {
			return b;
		}
		if (b == null) {
			return a;
		}

		LNode result;
		if (a.data.compareTo(b.data) < 1) {
			result = a;
			result.next = sortedMerge(a.next, b);
		} else {
			result = b;
			result.next = sortedMerge(a, b.next);
		}

		return result;
	}

	private void detectLoop(LNode node) {
		LNode slow = node;
		LNode fast = node;

		while (slow != null && fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow.data.equals(fast.data)) {
				break;
			}
		}
		System.out.println(slow.getData());
	}

	private void createLoop(LNode node) {
		LNode temp = node;
		LNode tempMid = null;
		while (temp.next != null) {
			if (temp.data.equals("3")) {
				tempMid = temp;
			}
			temp = temp.next;
		}

		// Loop
		temp.setNext(tempMid);

	}

	public LNode reverse(LNode node) {
		LNode prev = null;
		LNode curr = node;
		LNode next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		node = prev;
		return node;
	}

	public void traverse(LNode root) {
		while (root != null) {
			System.out.print(root.data + " ");
			root = root.next;
		}
		System.out.println();
	}

	public LNode insert(LNode root, String data) {
		if (root == null) {
			return new LNode(data);
		} else {
			root.setNext(insert(root.next, data));
			return root;
		}

	}
}
