package com.pkg1;

public class PointPolygon {

	public static void main(String[] args) {
		PointPolygon pointPolygon = new PointPolygon();

		Point[] polygon1 = { new Point(0, 0), new Point(10, 0),
				new Point(10, 10), new Point(0, 10) };

		// Point point = new Point(20, 20);
		Point point = new Point(5, 5);

		boolean status = pointPolygon.isIntersect(polygon1, point);
		pointPolygon.printResult(status);
	}

	private boolean isIntersect(Point[] polygon, Point point) {
		int count = 0;
		int i = 0;
		int n = polygon.length;

		// There must be at least 3 vertices in polygon[]
		if (n < 3)
			return false;

		Point extreme = new Point(Integer.MAX_VALUE, point.y);

		do {
			int next = (i + 1) % n;

			if (doIntersect(polygon[i], polygon[next], point, extreme)) {

				if (getOrientation(polygon[i], point, polygon[next]) == 0) {
					return onSegment(polygon[i], point, polygon[next]);
				}
				count++;
			}

			i = next;

		} while (i != 0);

		return (count % 2 == 0) ? false : true;
	}

	private boolean onSegment(Point p1, Point q1, Point p2) {

		if (q1.x <= Math.max(p1.x, p2.x) && q1.x >= Math.min(p1.x, p2.x)) {
			if (q1.y <= Math.max(p1.y, p2.y) && q1.y >= Math.min(p1.y, p2.y)) {
				return true;
			}
		}
		return false;
	}

	private int getOrientation(Point p, Point q, Point r) {
		int val = (q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y);

		// Collinear
		if (val == 0) {
			return 0;
		}

		// Clockwise or Anti-Clockwise
		return (val > 0) ? 1 : 2;
	}

	private boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
		int o1 = getOrientation(p1, q1, p2);
		int o2 = getOrientation(p1, q1, q2);
		int o3 = getOrientation(p2, q2, p1);
		int o4 = getOrientation(p2, q2, q1);

		// General Case
		if (o1 != o2 && o3 != o4) {
			return true;
		}

		// Special Cases

		// p1, q1, p2 are Collinear and p2 lies on line segment(p1,q1)
		if (o1 == 0 && onSegment(p1, q1, p2)) {
			return true;
		}

		// p1, q1, q2 are Collinear and q2 lies on line segment(p1,q1)
		if (o2 == 0 && onSegment(p1, q1, q2)) {
			return true;
		}

		// p2, q2, p1 are Collinear and p1 lies on line segment(p2,q2)
		if (o3 == 0 && onSegment(p2, q2, p1)) {
			return true;
		}

		// p2, q2, q1 are Collinear and q1 lies on line segment(p2,q2)
		if (o4 == 0 && onSegment(p2, q2, q1)) {
			return true;
		}

		return false;
	}

	public void printResult(boolean status) {
		if (status) {
			System.out.println("Line Segment Inside Polyon.");
		} else {
			System.out.println("Line Segment Outside Polyon.");
		}
	}
}
