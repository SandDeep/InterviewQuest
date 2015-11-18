package com.rough;

import java.util.Arrays;

public class P35 {

	int max = 1;

	public static void main(String[] args) {
		int[][] arr = { { 4, 6, 7 }, { 1, 2, 3 }, { 4, 5, 6 }, { 10, 12, 32 } };
		P35 test = new P35();
		test.maxStack(arr, arr.length);
	}

	private void maxStack(int[][] arr, int n) {
		Box[] box = new Box[n * 3];

		int index = 0;
		for (int i = 0; i < n; i++) {
			box[index++] = new Box(arr[i][0], arr[i][1], arr[i][2]);
			box[index++] = new Box(arr[i][0], arr[i][2], arr[i][1]);
			box[index++] = new Box(arr[i][1], arr[i][2], arr[i][0]);
		}

		Arrays.sort(box);

		System.out.println(box);

		// maxStackHeight(box, box.length);
		max = maxStackHeightDP(box, box.length);
		System.out.println(max);
	}

	private int maxStackHeightDP(Box[] box, int n) {
		int height[] = new int[n];

		for (int i = 0; i < n; i++) {
			height[i] = box[i].getHeight();
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (box[i].getDepth() < box[j].getDepth()
						&& box[i].getWidth() < box[j].getWidth()
						&& (height[j] + box[i].getHeight()) > height[i]) {
					height[i] = height[j] + box[i].getHeight();
				}
			}
		}

		int maxSoFar = 1;
		for (int i : height) {
			if (maxSoFar < i) {
				maxSoFar = i;
			}
		}

		return maxSoFar;
	}

	private int maxStackHeight(Box[] box, int n) {
		if (n == 1) {
			return box[n - 1].getHeight();
		}

		int maxSoFar = 1;
		int ret = 1;

		for (int i = 1; i < n; i++) {
			ret = maxStackHeight(box, i);

			if (box[n - 1].getDepth() < box[i - 1].getDepth()
					&& box[n - 1].getWidth() < box[i - 1].getWidth()
					&& (ret + box[n - 1].getHeight()) > maxSoFar) {
				maxSoFar = ret + box[n - 1].getHeight();
			}
		}

		if (max < maxSoFar) {
			max = maxSoFar;
		}

		return maxSoFar;
	}
}

class Box implements Comparable<Box> {
	int depth;
	int width;
	int height;

	public Box(int depth, int width, int height) {
		this.depth = depth;
		this.width = width;
		this.height = height;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Box [depth=" + depth + ", width=" + width + ", height="
				+ height + ", base=" + depth * width + "]";
	}

	@Override
	public int compareTo(Box o) {
		int base1 = this.getDepth() * this.getWidth();
		int base2 = o.getDepth() * o.getWidth();

		if (base1 == base2) {
			return 0;
		}
		return (base1 > base2) ? -1 : 1;
	}

}