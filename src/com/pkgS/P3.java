package com.pkgS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * http://www.geeksforgeeks.org/minimum-time-required-so-that-all-oranges-become
 * -rotten/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P3 {

	public static void main(String[] args) {
		int arr[][] = { { 2, 1, 0, 2, 1 }, { 1, 0, 1, 2, 1 }, { 1, 0, 0, 2, 1 } };

		int arr1[][] = { { 2, 1, 0, 2, 1 }, { 0, 0, 1, 2, 1 },
				{ 1, 0, 0, 2, 1 } };
		P3 test = new P3();
		int timeRequired = test.findTimeFrame(arr1);
		System.out.println("Time Frame required : " + timeRequired);
	}

	private int findTimeFrame(int[][] arr) {

		Queue<Point> queue = new LinkedList<>();
		int m = arr.length;
		int n = arr[0].length;

		// populate rotten position
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 2) {
					queue.add(new Point(i, j));
				}
			}
		}

		// Delimiter
		Point delimiter = new Point(-1, -1);
		queue.add(delimiter);

		int timeFrame = 0;

		// int[]
		while (!queue.isEmpty()) {

			boolean flag = false;

			// While delimiter in Q is not reached
			while (!isDelimited(queue.peek())) {
				Point temp = queue.poll();
				int x = temp.getX();
				int y = temp.getY();

				// [i-1,j]
				if (isValid(x - 1, y, arr)) {
					arr[x - 1][y] = 2;
					queue.add(new Point(x - 1, y));
					flag = true;
				}
				// [i+1,j]
				if (isValid(x + 1, y, arr)) {
					arr[x + 1][y] = 2;
					queue.add(new Point(x + 1, y));
					flag = true;
				}
				// [i,j-1]
				if (isValid(x, y - 1, arr)) {
					arr[x][y - 1] = 2;
					queue.add(new Point(x, y - 1));
					flag = true;
				}
				// [i,j+1]
				if (isValid(x, y + 1, arr)) {
					arr[x][y + 1] = 2;
					queue.add(new Point(x, y + 1));
					flag = true;
				}

			}

			if (flag) {
				timeFrame++;
			} else {
				break;
			}

			// Dequeue the old delimiter and enqueue a new delimiter
			queue.poll();
			queue.add(new Point(-1, -1));
		}

		if (!isRotten(arr)) {
			timeFrame = -1;
		}
		return timeFrame;
	}

	private boolean isRotten(int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;

		// populate rotten position
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (arr[i][j] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isDelimited(Point peek) {
		if (peek.getX() == -1 && peek.getY() == -1) {
			return true;
		}
		return false;
	}

	private boolean isValid(int x, int y, int[][] arr) {
		int m = arr.length;
		int n = arr[0].length;

		if (x >= 0 && x < m && y >= 0 && y < n && arr[x][y] == 1) {
			return true;
		}
		return false;
	}
}

class Point {
	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}