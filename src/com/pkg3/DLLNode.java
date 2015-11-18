package com.pkg3;

public class DLLNode {

	String data;
	DLLNode next;
	DLLNode prev;

	public DLLNode(String data) {
		this.data = data;
		next = null;
		prev = null;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public DLLNode getNext() {
		return next;
	}

	public void setNext(DLLNode next) {
		this.next = next;
	}

	public DLLNode getPrev() {
		return prev;
	}

	public void setPrev(DLLNode prev) {
		this.prev = prev;
	}
}
