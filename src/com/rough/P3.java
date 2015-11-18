package com.rough;

public class P3 {

	public static void main(String[] args) {
		LNode list1 = null;
		LNode list2 = null;

		P2 util = new P2();

		// List 1
		list1 = util.insert(list1, "1");
		list1 = util.insert(list1, "3");
		list1 = util.insert(list1, "30");
		list1 = util.insert(list1, "90");
		list1 = util.insert(list1, "120");
		list1 = util.insert(list1, "240");
		list1 = util.insert(list1, "511");

		// List 2
		list2 = util.insert(list2, "0");
		list2 = util.insert(list2, "3");
		list2 = util.insert(list2, "12");
		list2 = util.insert(list2, "32");
		list2 = util.insert(list2, "90");
		list2 = util.insert(list2, "125");
		list2 = util.insert(list2, "240");
		list2 = util.insert(list2, "249");

		util.traverse(list1);
		util.traverse(list2);

		P3 p = new P3();
		p.finalMaxSumList(list1, list2);
	}

	public void finalMaxSumList(LNode a, LNode b) {
		LNode pre1 = a;
		LNode pre2 = b;

		LNode curr1 = a;
		LNode curr2 = b;
		LNode result = null;

		while (curr1 != null && curr2 != null) {
			int sum1 = 0;
			int sum2 = 0;

			while (curr1 != null
					&& curr2 != null
					&& Integer.valueOf(curr1.getData()) != Integer
							.valueOf(curr2.getData())) {
				int x = Integer.valueOf(curr1.getData());
				int y = Integer.valueOf(curr2.getData());

				if (x <= y) {
					sum1 += x;
					curr1 = curr1.next;
				} else {
					sum2 += y;
					curr2 = curr2.next;
				}
			}

			if (curr1 == null) {
				while (curr2 != null) {
					sum2 += Integer.parseInt(curr2.data);
					curr2 = curr2.next;
				}
			}

			if (curr2 == null) {
				while (curr1 != null) {
					sum1 += Integer.parseInt(curr1.data);
					curr1 = curr1.next;
				}
			}

			if (pre1 == a && pre2 == b) {
				result = (sum1 > sum2) ? pre1 : pre2;
			} else {
				if (sum1 > sum2) {
					pre2.next = pre1.next;
				} else {
					pre1.next = pre2.next;
				}
			}

			pre1 = curr1;
			pre2 = curr2;

			if (curr1 != null) {
				curr1 = curr1.next;
			}
			if (curr2 != null) {
				curr2 = curr2.next;
			}
		}
		P2 util = new P2();
		util.traverse(result);
	}

}
