package com.pkgG;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

import com.pkg1.LineIntersect;
import com.pkg1.Point;

public class ConvexHull {

	public static void main(String[] args) {
		ConvexHull hull = new ConvexHull();

		Point[] polygon1 = { new Point(0, 3), new Point(2, 2), new Point(1, 1),
				new Point(2, 1), new Point(3, 0), new Point(0, 0),
				new Point(3, 3) };

		hull.jarvisConvexHull(polygon1);

		Point[] polygon2 = { new Point(0, 3), new Point(1, 1), new Point(2, 2),
				new Point(4, 4), new Point(0, 0), new Point(1, 2),
				new Point(3, 1), new Point(3, 3) };

		Point[] polygon3 = { new Point(0, 3), new Point(3, 1), new Point(4, 4),
				new Point(5, 5), new Point(1, 2), new Point(0, 0) };

		hull.GrahamScanConvexHull(polygon3);
	}

	/**
	 * Time Complexity: Let n be the number of input points. The algorithm takes
	 * O(nLogn) time if we use a O(nLogn) sorting algorithm.Overall complexity
	 * is O(n) + O(nLogn) + O(n) which is O(nLogn)
	 * 
	 * @param polygon
	 */
	private void GrahamScanConvexHull(Point[] polygon) {
		int yMin = 0;

		for (int i = 1; i < polygon.length; i++) {
			if (polygon[i].getY() < polygon[yMin].getY()) {
				yMin = i;
			} else if (polygon[i].getY() == polygon[yMin].getY()
					&& polygon[i].getX() < polygon[yMin].getX()) {
				yMin = i;
			}
		}

		swap(polygon, 0, yMin);

		final Point p0 = polygon[0];

		Arrays.sort(polygon, 1, polygon.length, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				int val = new LineIntersect().getOrientation(p0, o1, o2);

				if (val == 0) {
					return (distance(p0, o2) >= distance(p0, o1)) ? -1 : 1;
				}

				return (val == 2) ? -1 : 1;
			}

			private int distance(Point p1, Point p2) {
				return (p1.getX() - p2.getX()) * (p1.getX() - p2.getX())
						+ (p1.getY() - p2.getY()) * (p1.getY() - p2.getY());
			}
		});

		Stack<Point> stack = new Stack<Point>();

		// Adding first three points
		stack.push(p0);
		stack.push(polygon[1]);
		stack.push(polygon[2]);

		for (int i = 3; i < polygon.length; i++) {

			while (getOrientation(nextTop(stack), stack.peek(), polygon[i]) != 2) {
				stack.pop();
			}
			stack.push(polygon[i]);
		}

		System.out.println(stack);
	}

	private Point nextTop(Stack<Point> stack) {
		Point curr = stack.pop();
		Point prev = stack.peek();
		stack.push(curr);
		return prev;
	}

	public static void swap(Point[] arr, int mIndex, int nIndex) {
		Point temp = arr[mIndex];
		arr[mIndex] = arr[nIndex];
		arr[nIndex] = temp;
	}

	/**
	 * Jarvis’s Algorithm or Wrapping : Time complexity is \Theta(m * n) where n
	 * is number of input points and m is number of output or hull points (m <=
	 * n). In worst case, time complexity is O(n 2). The worst case occurs when
	 * all the points are on the hull (m = n)
	 * 
	 * @param polygon
	 */
	public void jarvisConvexHull(Point[] polygon) {
		int N = polygon.length;

		if (N < 3) {
			return;
		}

		int[] next = new int[N];
		for (int i = 0; i < next.length; i++) {
			next[i] = -1;
		}
		int start = 0;
		for (int i = 0; i < polygon.length; i++) {
			if (polygon[i].getX() < polygon[start].getX()) {
				start = polygon[i].getX();
			}
		}

		int p = 0;
		int q = 0;

		do {
			q = (p + 1) % N;
			for (int i = 0; i < N; i++) {
				if (getOrientation(polygon[p], polygon[i], polygon[q]) == 2) {
					q = i;
				}
			}
			next[p] = q;
			p = q;
		} while (p != start);

		for (int i = 0; i < next.length; i++) {
			if (next[i] != -1) {
				System.out.println(polygon[i] + " ");
			}
		}
	}

	public int getOrientation(Point p, Point q, Point r) {
		int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

		// Collinear
		if (val == 0) {
			return 0;
		}

		// Clockwise or Anti-Clockwise
		return (val > 0) ? 1 : 2;
	}
}
