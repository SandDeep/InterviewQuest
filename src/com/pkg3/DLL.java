package com.pkg3;

public class DLL {

	public static DLLNode first = null;

	public static void main(String[] args) {
		DLLNode head = null;

		head = insert("2", head);
		head = insert("5", head);
		head = insert("7", head);
		head = insert("8", head);
		head = insert("10", head);

		printList();
		reverse();
		System.out.println();
		printList();

	}

	private static void reverse() {

		DLLNode node = first;
		DLLNode tmpNode=null;

		while (node != null) {
			tmpNode = node.prev;
			node.prev = node.next;
			node.next = tmpNode;
			
			node=node.prev;
		}
		first=tmpNode.prev;
	}

	private static DLLNode insert(String data, DLLNode head) {
		DLLNode temp = new DLLNode(data);

		if (head == null) {
			head = temp;
			first = head;
		} else {
			head.setNext(temp);
			temp.setPrev(head);
			head = temp;
		}

		return head;
	}

	private static void printList() {
		DLLNode temp = first;

		while (temp != null) {
			System.out.print(temp.getData() + " ");
			temp = temp.next;
		}
	}

}
