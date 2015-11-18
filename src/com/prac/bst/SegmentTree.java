package com.prac.bst;

import java.util.Arrays;

/**
 * <b>Sum of given range</b> : <p>Time Complexity for tree construction is O(n). There are
 * total 2n-1 nodes, and value of every node is calculated only once in tree
 * construction.</p>
 * 
 * <p>Time complexity to query is O(Logn). To query a sum, we process at most four
 * nodes at every level and number of levels is O(Logn).</p>
 * 
 * <p>The time complexity of update is also O(Logn). To update a leaf value, we
 * process one node at every level and number of levels is O(Logn).</p>
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class SegmentTree {

	public static void main(String[] args) {
		int[] arr = { 1, 3, 5, 7, 9, 11 };
		SegmentTree tree = new SegmentTree();
		int[] segment = new int[(int) (Math.pow(2,
				Math.ceil(Math.log(arr.length) / Math.log(2)) + 1) - 1)];
		int[] segmentMin = new int[(int) (Math.pow(2,
				Math.ceil(Math.log(arr.length) / Math.log(2)) + 1) - 1)];
		tree.contructST(arr, segment);
		tree.contructRmqST(arr, segmentMin);

		int sum = tree.getSum(segment, arr.length, 1, 3);
		System.out.println(sum);

		//tree.updateValue(arr, segment, arr.length, 1, 10);

		//sum = tree.getSum(segment, arr.length, 1, 3);
		//System.out.println(sum);
		
		//System.out.println(Arrays.toString(segment));
		
		tree.RMQ(segmentMin,arr.length,3,5);
	}

	private void contructRmqST(int[] arr, int[] segmentMin) {
		contructSTUtil(arr,0,arr.length-1,0,segmentMin);
		System.out.println(Arrays.toString(segmentMin));
	}

	private int contructSTUtil(int[] arr, int ss, int se, int si,
			int[] segmentMin) {
		if (ss == se) {
			segmentMin[si] = arr[ss];
			return arr[ss];
		}

		int mid = getMid(ss, se);
		segmentMin[si] = Math.min(
				contructSTUtil(arr, ss, mid, 2 * si + 1, segmentMin),
				contructSTUtil(arr, mid + 1, se, 2 * si + 2, segmentMin));
		return segmentMin[si];
	}

	private void RMQ(int[] segment, int N, int qs, int qe) {
		if (qs < 0 || qe > N - 1 || qs > qe) {
			System.out.println("Invalid Input");
			return;
		}

		int min = RMQUtil(segment, 0, N - 1, qs, qe,0);
		System.out.println(min);
	}

	private int RMQUtil(int[] segment, int ss, int se, int qs, int qe, int si) {
		
		if (ss >= qs && se <= qe) {
			return segment[si];
		}
		
		if (se < qs || ss > qe) {
			return Integer.MAX_VALUE;
		}

		int mid = getMid(ss, se);
		return Math.min(RMQUtil(segment, ss, mid, qs, qe, 2 * si + 1),
				RMQUtil(segment, mid + 1, se, qs, qe, 2 * si + 2));
	}

	public void updateValue(int[] arr, int[] segment, int N, int index,
			int value) {
		if (index < 0 || index > N - 1) {
			System.out.println("Invalid Input");
			return;
		}

		int diff = value - arr[index];
		arr[index] = value;

		updateValueUtil(segment, 0, N - 1, 0, index, diff);
	}

	/*private void updateValueUtil(int[] segment, int ss, int se, int si,
			int index, int diff) {
		if (se == ss) {
			segment[si] = segment[si] + diff;
			return;
		}

		if (index >= ss && index <= se) {
			segment[si] = segment[si] + diff;
		}

		int mid = getMid(ss, se);

		if (index <= mid) {
			updateValueUtil(segment, ss, mid, 2 * si + 1, index, diff);
		} else {
			updateValueUtil(segment, mid + 1, se, 2 * si + 2, index, diff);
		}

	}*/
	
	public void updateValueUtil(int[] segment, int ss, int se, int si,
			int index, int diff) {
		if (index > se || index < ss) {
			return;
		}

		segment[si] = segment[si] + diff;

		if (ss != se) {
			int mid = getMid(ss, se);
			updateValueUtil(segment, ss, mid, 2 * si + 1, index, diff);
			updateValueUtil(segment, mid + 1, se, 2 * si + 2, index, diff);
		}

	}

	public int getSum(int[] segment, int N, int qs, int qe) {
		if (qs < 0 || qe > N - 1 || qs > qe) {
			return -1;
		}

		return getSumUtil(segment, 0, N - 1, qs, qe, 0);
	}

	public int getSumUtil(int[] segment, int ss, int se, int qs, int qe, int si) {

		if (ss >= qs && se <= qe) {
			return segment[si];
		}

		if (ss > qe || se < qs) {
			return 0;
		}

		int mid = getMid(ss, se);
		return getSumUtil(segment, ss, mid, qs, qe, 2 * si + 1)
				+ getSumUtil(segment, mid + 1, se, qs, qe, 2 * si + 2);

	}

	public void contructST(int[] arr, int[] segment) {

		contructSTUtil(arr, 0, arr.length - 1, segment, 0);
		System.out.println(Arrays.toString(segment));
	}

	public int contructSTUtil(int[] arr, int ss, int se, int[] segment, int si) {

		if (ss == se) {
			segment[si] = arr[ss];
			return segment[si];
		}

		int mid = getMid(ss, se);
		segment[si] = contructSTUtil(arr, ss, mid, segment, 2 * si + 1)
				+ contructSTUtil(arr, mid + 1, se, segment, 2 * si + 2);
		return segment[si];
	}

	public int getMid(int ss, int se) {
		return (ss + (se - ss) / 2);
	}
}
