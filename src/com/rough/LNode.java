package com.rough;

public class LNode {

	String data;
	LNode next;

	public LNode(String data) {
		this.data = data;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public LNode getNext() {
		return next;
	}

	public void setNext(LNode next) {
		this.next = next;
	}

}
