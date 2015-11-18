package com.pkg3;

public class SplitCLL {

	static Node head1 = null;
	static Node head2 = null;

	public static void main(String[] args) {
		Node head = null;

		head = CLL.insert("2", head);
		head = CLL.insert("5", head);
		head = CLL.insert("7", head);
		head = CLL.insert("8", head);
		head = CLL.insert("10", head);

		CLL.printList(head);
		
		SplitCLL splitCLL=new SplitCLL();
		splitCLL.split(head.next);
		
		CLL.printList(head1);
		System.out.println();
		CLL.printList(head2);
	}

	public void split(Node head) {
		Node slow = head;
		Node fast = head;

		while (!fast.next.getData().equals(head.getData())
				&& !fast.next.next.getData().equals(head.getData())) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		fast.next=slow.next;
		slow.next=head;
		
		head1=slow;
		head2=fast;
		System.out.println();
	}
}
