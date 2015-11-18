package com.pkg4;

class Interval {
	int low;
	int high;

	public Interval(int low, int high) {
		this.low = low;
		this.high = high;
	}

	public int getLow() {
		return low;
	}

	public void setLow(int low) {
		this.low = low;
	}

	public int getHigh() {
		return high;
	}

	public void setHigh(int high) {
		this.high = high;
	}

	@Override
	public String toString() {
		return "Interval [low=" + low + ", high=" + high + "]";
	}

}
