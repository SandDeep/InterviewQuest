package com.rough;

import java.util.Arrays;
import java.util.Comparator;

/**
 * http://www.geeksforgeeks.org/closest-pair-of-points/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P72 implements Comparator<Point> {

	public static void main(String[] args) {
		Point point[] = new Point[6];
		point[0] = new Point(2, 3);
		point[1] = new Point(12, 30);
		point[2] = new Point(40, 50);
		point[3] = new Point(5, 1);
		point[4] = new Point(12, 10);
		point[5] = new Point(3, 4);

		P72 test = new P72();

		double minDistance = test.getMinDistance(point, point.length);
		System.out.println("Minimum Distance  : " + minDistance);
	}

	private double getMinDistance(Point[] point, int length) {
		if (length < 1) {
			return -1;
		}

		// Sort on X-Axis
		Arrays.sort(point);

		// Sort on Y-Axis
		Arrays.sort(point, new P72());

		return getMinUtil(point, 0, length - 1);
	}

	private double getMinUtil(Point[] point, int left, int right) {

		if (right - left <= 3) {
			return bruteforce(point, left, right);
		}

		int mid = left + (right - left) / 2;

		double dl = getMinUtil(point, left, mid);
		double dr = getMinUtil(point, mid + 1, right);

		double d = Math.min(dl, dr);

		int n = right - left + 1;
		Point[] strip = new Point[n];

		int index = 0;
		for (int i = left; i <= right; i++) {
			if (absoluteDistance(point[mid], point[i]) < d) {
				strip[index++] = point[i];
			}
		}

		/*Point[] stripUpd = new Point[index];
		for (int i = 0; i < index; i++) {
			stripUpd[i] = strip[i];
		}*/

		// Sort on Y-Axis
		// Arrays.sort(stripUpd, new P72());

		return Math.min(d, stripClosest(strip, index, d));
	}

	private double stripClosest(Point[] strip, int index, double d) {
		double minDistance = d;

		if (index < 2) {
			return Double.MAX_VALUE;
		}

		for (int i = 0; i < index; i++) {
			for (int j = i + 1; j <= index
					&& (strip[j].getY() - strip[i].getY()) < d; j++) {
				if (absoluteDistance(strip[i], strip[j]) < minDistance) {
					minDistance = absoluteDistance(strip[i], strip[j]);
				}
			}
		}
		return minDistance;
	}

	private double bruteforce(Point[] point, int left, int right) {
		double min = Double.MAX_VALUE;

		for (int i = left; i < right; i++) {
			for (int j = i + 1; j < right; j++) {
				double d = absoluteDistance(point[i], point[j]);
				if (d < min) {
					min = d;
				}
			}
		}
		return min;
	}

	public double absoluteDistance(Point p1, Point p2) {
		return Math.sqrt((p1.getX() - p2.getX()) * (p1.getX() - p2.getX())
				+ (p1.getY() - p2.getY()) * (p1.getY() - p2.getY()));
	}

	@Override
	public int compare(Point o1, Point o2) {
		int y1 = o1.Y;
		int y2 = o2.Y;

		if (y1 == y2) {
			return 0;
		}

		return (y1 > y2) ? y1 : y2;
	}
}

class Point implements Comparable<Point> {
	int X;
	int Y;

	public Point(int X, int Y) {
		this.X = X;
		this.Y = Y;
	}

	public int getX() {
		return X;
	}

	public void setX(int x) {
		X = x;
	}

	public int getY() {
		return Y;
	}

	public void setY(int y) {
		Y = y;
	}

	@Override
	public String toString() {
		return "Point [X=" + X + ", Y=" + Y + "]";
	}

	@Override
	public int compareTo(Point o) {
		int x1 = this.getX();
		int x2 = o.getX();

		if (x1 == x2) {
			return 0;
		}

		return (x1 > x2) ? 1 : -1;
	}

}
