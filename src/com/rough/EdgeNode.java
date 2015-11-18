package com.rough;

public class EdgeNode {

	int dest;
	int weight;
	EdgeNode next;

	public EdgeNode(int dest) {
		this.dest = dest;
		this.weight=0;
		next = null;
	}

	public int getDest() {
		return dest;
	}

	public void setDest(int dest) {
		this.dest = dest;
	}

	public EdgeNode getNext() {
		return next;
	}

	public void setNext(EdgeNode next) {
		this.next = next;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

}
