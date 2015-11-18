package com.pkg3;

public class Node {

	public String data;
	public Node next;

	public Node(String data) {
		this.data = data;
		next = null;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

}
