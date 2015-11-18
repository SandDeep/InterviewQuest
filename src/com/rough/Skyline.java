package com.rough;

public class Skyline {

	Strip[] arr;
	int capacity;
	int n;

	public Skyline(int capacity) {
		this.capacity = capacity;
		arr = new Strip[capacity];
		this.n = 0;
	}

	public void append(Strip strip) {
		// Check for redundant strip, a strip is redundant if it

		// same height
		if (n > 0 && arr[n - 1].height == strip.height) {
			return;
		}

		// left as previous
		if (n > 0 && arr[n - 1].left == strip.left) {
			arr[n - 1].height = Math.max(arr[n - 1].height, strip.height);
			return;
		}

		arr[n++] = strip;
	}

	public void printSkyline() {
		for (int i = 0; i < arr.length; i++) {
			if(arr[i]!=null)
			System.out.println(arr[i]);
		}
	}
}

class Strip {
	int left;
	int height;

	public Strip(int left, int height) {
		this.left = left;
		this.height = height;
	}

	public int getLeft() {
		return left;
	}

	public void setLeft(int left) {
		this.left = left;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Strip [left=" + left + ", height=" + height + "]";
	}

}
