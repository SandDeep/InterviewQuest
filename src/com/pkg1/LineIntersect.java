package com.pkg1;

/**
 * http://www.dcs.gla.ac.uk/~pat/52233/slides/Geometry1x1.pdf
 * 
 * @author Deepesh.Maheshwari
 * 
 */
public class LineIntersect {

	public static void main(String[] args) {

		LineIntersect intersect = new LineIntersect();

		// First
		Point p1 = new Point(1, 1);
		Point q1 = new Point(10, 1);

		Point p2 = new Point(1, 2);
		Point q2 = new Point(10, 2);

		boolean status1 = intersect.doIntersect(p1, q1, p2, q2);
		intersect.printResult(status1);

		// Second
		Point p11 = new Point(10, 0);
		Point q11 = new Point(0, 10);

		Point p22 = new Point(0, 0);
		Point q22 = new Point(0, 10);

		boolean status2 = intersect.doIntersect(p11, q11, p22, q22);
		intersect.printResult(status2);

		// Third
		Point p3 = new Point(10, 0);
		Point q3 = new Point(10, 10);

		Point p4 = new Point(5,5);
		Point q4 = new Point(Integer.MAX_VALUE, 5);

		boolean status3 = intersect.doIntersect(p3, q3, p4, q4);
		intersect.printResult(status3);

	}

	public boolean doIntersect(Point p1, Point q1, Point p2, Point q2) {
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

	public boolean onSegment(Point p1, Point q1, Point p2) {

		if (q1.x <= Math.max(p1.x, p2.x) && q1.x >= Math.min(p1.x, p2.x)) {
			if (q1.y <= Math.max(p1.y, p2.y) && q1.y >= Math.min(p1.y, p2.y)) {
				return true;
			}
		}
		return false;
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

	public void printResult(boolean status) {
		if (status) {
			System.out.println("Line Segment Intersect.");
		} else {
			System.out.println("Line Segment Donot Intersect.");
		}
	}
}
