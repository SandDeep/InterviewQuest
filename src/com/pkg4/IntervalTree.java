package com.pkg4;

/**
 * Interval tree is mainly a geometric data structure and often used for
 * windowing queries, for instance, to find all roads on a computerized map
 * inside a rectangular viewport, or to find all visible elements inside a
 * three-dimensional scene
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class IntervalTree {

	/**
	 * <b>Interval Tree vs Segment Tree</b><br /> Both segment and interval trees store
	 * intervals. Segment tree is mainly optimized for queries for a given
	 * point, and interval trees are mainly optimized for overlapping queries
	 * for a given interval.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		int intervals[][] = { { 15, 20 }, { 10, 30 }, { 17, 19 }, { 5, 20 },
				{ 12, 15 }, { 30, 40 } };

		IntervalTree tree = new IntervalTree();
		ITNode root = tree.populateTree(intervals);

		tree.inorder(root);

		Interval interval = new Interval(25, 41);

		/*Interval overlap = */tree.overlapSearch(root, interval);

		/*if (overlap == null) {
			System.out.println("No Overlap");
		} else {
			System.out.println("Overlapping Interval : " + overlap);
		}*/
	}

	private void overlapSearch(ITNode root, Interval interval) {
		if (root == null) {
			return ;
		}

		boolean status = isOverlap(root.getInterval(), interval);

		if (status) {
			System.out.println("Overlapping Interval : " + root.getInterval());
			//return root.getInterval();
		}

		int low = interval.getLow();

		if (root.lChild != null && root.getlChild().getMax() >= low) {
			overlapSearch(root.lChild, interval);
		}

		overlapSearch(root.rChild, interval);
	}

	private boolean isOverlap(Interval inter1, Interval inter2) {
		if (inter2.getHigh() < inter1.getLow() || inter2.low > inter1.getHigh()) {
			return false;
		}
		return true;

		/*
		 * if(inter1.low <= inter2.high && inter2.low<=inter1.high){ return
		 * true; } return false;
		 */
	}

	private ITNode populateTree(int[][] intls) {
		Interval[] intervals = new Interval[intls.length];

		for (int i = 0; i < intervals.length; i++) {
			intervals[i] = new Interval(intls[i][0], intls[i][1]);
		}

		ITNode root = null;

		for (int i = 0; i < intervals.length; i++) {
			root = insert(root, intervals[i]);
		}

		return root;
	}

	private ITNode insert(ITNode node, Interval interval) {
		if (node == null) {
			node = new ITNode(interval);
			node.setMax(interval.getHigh());
		} else {
			int val = interval.getLow();

			if (val < node.getInterval().getLow()) {
				node.setlChild(insert(node.lChild, interval));
			} else if (val > node.getInterval().getLow()) {
				node.setrChild(insert(node.rChild, interval));
			}

			if (node.max < interval.high) {
				node.setMax(interval.high);
			}

		}
		return node;
	}

	private void inorder(ITNode node) {
		if (node == null) {
			return;
		}

		inorder(node.lChild);
		System.out.println(node);
		inorder(node.rChild);
	}
}
