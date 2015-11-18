package com.pkg4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HuffmanCoding {

	public static void main(String[] args) {
		char arr[] = { 'a', 'c', 'd', 'e', 'f', 'b' };
		int freq[] = { 5, 12, 13, 16, 45, 9 };

		int N = freq.length;
		HuffCode[] huffArr = new HuffCode[N];

		for (int i = 0; i < N; i++) {
			huffArr[i] = new HuffCode(arr[i], freq[i]);
		}

		HuffmanCoding coding = new HuffmanCoding();

		Node root = coding.huffmanCode(huffArr, N);
		//System.out.println(root);
		//coding.inorder(root);
		coding.printCode(root);
	}

	public void printCode(Node node) {
		if (node == null) {
			return;
		}

		printCodeUtil(node.lChild, "0");
		printCodeUtil(node.rChild, "1");

	}

	public void printCodeUtil(Node node, String code) {
		if (node == null) {
			return;
		}

		// Leaf Node
		if (node.lChild == null && node.rChild == null) {
			System.out.println(node.getData().getData() + " : " + code);
		}
		
		printCodeUtil(node.lChild, code + "0");
		printCodeUtil(node.rChild, code+"1");
	}

	public void inorder(Node root) {
		if (root != null) {
			inorder(root.lChild);
			System.out.println(root.getData());
			inorder(root.rChild);
		}
	}

	public Node huffmanCode(HuffCode[] huffArr, int N) {
		Arrays.sort(huffArr);

		Queue<Node> queue1 = new LinkedList<Node>();
		Queue<Node> queue2 = new LinkedList<Node>();

		for (int i = 0; i < N; i++) {
			Node temp = new Node(huffArr[i]);
			queue1.add(temp);
		}

		while (!queue1.isEmpty()) {
			int count = 0;
			Node root = new Node();

			for (int i = 0; i < 2; i++) {

				Node tempNode = null;

				if (!queue1.isEmpty() && queue2.isEmpty()) {

					tempNode = queue1.poll();

				} else if (queue1.isEmpty() && !queue2.isEmpty()) {

					tempNode = queue2.poll();

				} else {
					Node temp1 = queue1.peek();
					Node temp2 = queue2.peek();

					if (temp1.getData().getVal() <= temp2.getData().getVal()) {
						tempNode = queue1.poll();
					} else {
						tempNode = queue2.poll();
					}

				}

				if (i == 0) {
					count += tempNode.getData().getVal();
					HuffCode code = new HuffCode('$', count);
					root.setData(code);
					root.setlChild(tempNode);
				} else {
					count += tempNode.getData().getVal();
					HuffCode code = new HuffCode('$', count);
					root.setData(code);
					root.setrChild(tempNode);
				}
			}

			queue2.add(root);

			if (queue1.isEmpty() && queue2.size() == 1) {
				return queue2.poll();
			}
		}
		return null;
	}
}

class HuffCode implements Comparable<HuffCode> {
	char data;
	int val;

	public HuffCode() {
		this.data = '\0';
		this.val = 0;
	}

	public HuffCode(char data, int val) {
		this.data = data;
		this.val = val;
	}

	public char getData() {
		return data;
	}

	public void setData(char data) {
		this.data = data;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	@Override
	public String toString() {
		return "HuffCode [data=" + data + ", val=" + val + "]";
	}

	@Override
	public int compareTo(HuffCode o) {
		int val1 = this.val;
		int val2 = o.val;

		if (val1 == val2) {
			return 0;
		}
		return (val1 > val2) ? 1 : -1;
	}

}

class Node {

	HuffCode data;
	Node lChild;
	Node rChild;

	public Node() {
		this.data = new HuffCode();
		lChild = null;
		rChild = null;
	}

	public Node(HuffCode data) {
		this.data = data;
		lChild = null;
		rChild = null;
	}

	public HuffCode getData() {
		return data;
	}

	public void setData(HuffCode data) {
		this.data = data;
	}

	public Node getlChild() {
		return lChild;
	}

	public void setlChild(Node lChild) {
		this.lChild = lChild;
	}

	public Node getrChild() {
		return rChild;
	}

	public void setrChild(Node rChild) {
		this.rChild = rChild;
	}

	@Override
	public String toString() {
		return "Node [data=" + data + "]";
	}

}