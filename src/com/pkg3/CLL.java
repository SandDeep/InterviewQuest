package com.pkg3;

public class CLL {

	public static void main(String[] args) {
		Node head = null;

		head = insert("2", head);
		head = insert("5", head);
		head = insert("7", head);
		head = insert("8", head);
		head = insert("10", head);

		printList(head);
	}

	public static void printList(Node head) {
		Node temp = head;

		if (temp != null) {
			do {
				System.out.print(temp.getNext().getData() + " ");
				temp = temp.getNext();
			} while (temp != head);

		}
	}

	public static Node insert(String data, Node head) {

		Node temp = new Node(data);

		if (head == null) {
			head = temp;
			head.setNext(head);
		} else {
			temp.setNext(head.getNext());
			head.setNext(temp);
			head = temp;
		}

		return head;
	}
}
