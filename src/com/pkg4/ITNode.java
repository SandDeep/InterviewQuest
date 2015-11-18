package com.pkg4;

public class ITNode {

	ITNode lChild;
	ITNode rChild;
	Interval interval;
	int max;

	public ITNode(Interval interval) {
		this.interval = interval;
		this.lChild = null;
		this.rChild = null;
		max = 0;
	}

	public ITNode getlChild() {
		return lChild;
	}

	public void setlChild(ITNode lChild) {
		this.lChild = lChild;
	}

	public ITNode getrChild() {
		return rChild;
	}

	public void setrChild(ITNode rChild) {
		this.rChild = rChild;
	}

	public Interval getInterval() {
		return interval;
	}

	public void setInterval(Interval interval) {
		this.interval = interval;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	@Override
	public String toString() {
		return "ITNode [interval=" + interval + ", max=" + max + "]";
	}

}
