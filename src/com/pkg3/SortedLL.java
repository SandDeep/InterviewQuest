package com.pkg3;

public class SortedLL {

	public static void main(String[] args) {
		SortedLL ll = new SortedLL();

		Node head1 = new Node("511");
		head1 = ll.push(head1, 240);
		head1 = ll.push(head1, 120);
		head1 = ll.push(head1, 90);
		head1 = ll.push(head1, 30);
		head1 = ll.push(head1, 3);
		head1 = ll.push(head1, 1);

		Node head2 = new Node("249");
		head2 = ll.push(head2, 240);
		head2 = ll.push(head2, 125);
		head2 = ll.push(head2, 90);
		head2 = ll.push(head2, 32);
		head2 = ll.push(head2, 12);
		head2 = ll.push(head2, 3);
		head2 = ll.push(head2, 0);

		ll.printLL(head1);
		ll.printLL(head2);

		Node result = ll.maxSumLL(head1, head2);
		ll.printLL(result);
	}

	private Node maxSumLL(Node head1, Node head2) {
		Node curr1 = head1;
		Node curr2 = head2;
		Node result = null;
		Node resultHead = null;

		while (head1 != null && head2 != null) {
			int sum1 = 0;
			int sum2 = 0;

			while (head1 != null && head2 != null
					&& !head1.getData().equals(head2.getData())) {
				int val1 = Integer.parseInt(head1.getData());
				int val2 = Integer.parseInt(head2.getData());

				if (val1 < val2) {
					sum1 += val1;
					head1 = head1.next;
				} else if (val1 > val2) {
					sum2 += val2;
					head2 = head2.next;
				}
			}

			if (head1 == null) {
				while (head2 != null) {
					sum2 += Integer.parseInt(head2.getData());
					head2 = head2.next;
				}
			}
			if (head2 == null) {
				while (head1 != null) {
					sum1 += Integer.parseInt(head1.getData());
					head1 = head1.next;
				}
			}

			if (resultHead == null) {
				result = (sum1 > sum2) ? curr1 : curr2;
				resultHead = result;
			} else {
				if (sum1 > sum2) {
					curr2.next = curr1.next;
				} else {
					curr1.next = curr2.next;
				}
			}

			curr1 = head1;
			curr2 = head2;
			if (head1 != null) {
				head1 = head1.next;
			}

			if (head2 != null) {
				head2 = head2.next;
			}
		}

		return resultHead;
	}

	private void printLL(Node node) {
		while (node != null) {
			System.out.print(node.getData() + " ");
			node = node.next;
		}
		System.out.println();
	}

	private Node push(Node node, int data) {
		Node temp = new Node(data + "");
		temp.setNext(node);
		return temp;
	}
}
