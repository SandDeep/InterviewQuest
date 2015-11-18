package com.rough;

import java.util.Stack;

public class P49 {

	public static void main(String[] args) {
		int hist[] = { 6, 2, 5, 4, 5, 1, 6 };

		P49 test = new P49();
		int segment[] = test.constructST(hist, hist.length);

		System.out.println(test.RMQ(hist, segment, hist.length, 0, 5));

		int maxArea = test.getMaxArea(hist, 0, hist.length - 1, segment);
		System.out.println("Max Area : " + maxArea);

		maxArea = test.maxArea(hist, hist.length);
		System.out.println("Max Area : " + maxArea);

		maxArea = test.largestArea(hist, hist.length);
		System.out.println("Max Area : " + maxArea);
	}

	/**
	 * @see <a
	 *      href="http://tech-queries.blogspot.in/2011/03/maximum-area-rectangle-in-histogram.html">stack
	 *      based</a>
	 */
	public int largestArea(int[] arr, int n) {

		int area[] = new int[n]; // initialize it to 0
		Stack<Integer> St = new Stack<Integer>();
		Boolean done;
		int t;
		for (int i = 0; i < n; i++) {
			while (!St.empty()) {
				if (arr[i] <= arr[St.peek()]) {
					St.pop();
				} else
					break;
			}
			if (St.empty())
				t = -1;
			else
				t = St.pop();
			// Calculating Li
			area[i] = i - t - 1;
			St.push(i);
		}

		// clearing stack for finding Ri
		while (!St.empty())
			St.pop();

		for (int i = n - 1; i >= 0; i--) {
			while (!St.empty()) {
				if (arr[i] <= arr[St.peek()]) {
					St.pop();
				} else
					break;
			}
			if (St.empty())
				t = n;
			else
				t = St.peek();
			// calculating Ri, after this step area[i] = Li + Ri
			area[i] += t - i - 1;
			St.push(i);
		}

		int max = 0;
		// Calculating Area[i] and find max Area
		for (int i = 0; i < n; i++) {
			area[i] = arr[i] * (area[i] + 1);
			if (area[i] > max)
				max = area[i];
		}

		return max;
	}

	private int maxArea(int[] hist, int n) {

		Stack<Integer> stack = new Stack<Integer>();
		int i = 0;

		int maxArea = hist[0];

		while (i < n) {
			if (stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
				stack.push(i);
			} else {
				int top = stack.pop();

				int area = hist[top]
						* (stack.isEmpty() ? i : (i - stack.peek() - 1));

				if (maxArea < area) {
					maxArea = area;
				}
			}
			i++;
		}

		while (!stack.isEmpty()) {

			int top = stack.pop();

			int area = hist[top]
					* (stack.isEmpty() ? i : (i - stack.peek() - 1));

			if (maxArea < area) {
				maxArea = area;
			}

		}
		return maxArea;
	}

	private int getMaxArea(int[] hist, int l, int r, int[] segment) {
		if (l > r) {
			return Integer.MIN_VALUE;
		}

		if (l == r) {
			return hist[l];
		}

		int minIndex = RMQ(hist, segment, hist.length, l, r);

		int left = getMaxArea(hist, l, minIndex - 1, segment);
		int right = getMaxArea(hist, minIndex + 1, r, segment);
		int center = hist[minIndex] * ((r - l) + 1);

		return Math.max(left, Math.max(right, center));
	}

	private int RMQ(int[] hist, int[] segment, int n, int qs, int qe) {
		if (qs < 0 || qe > n - 1) {
			System.out.println("Invalid Input Query.");
			return -1;
		}

		return RMQUtil(hist, segment, 0, n - 1, qs, qe, 0);
	}

	private int RMQUtil(int[] hist, int[] segment, int ss, int se, int qs,
			int qe, int si) {
		if (ss >= qs && se <= qe) {
			return segment[si];
		}

		if (ss > qe || se < qs) {
			return -1;
		}

		int mid = ss + (se - ss) / 2;

		int index1 = RMQUtil(hist, segment, ss, mid, qs, qe, 2 * si + 1);
		int index2 = RMQUtil(hist, segment, mid + 1, se, qs, qe, 2 * si + 2);

		return getMin(hist, index1, index2);

	}

	private int getMin(int[] hist, int index1, int index2) {
		if (index1 == -1) {
			return index2;
		}
		if (index2 == -1) {
			return index1;
		}
		return (hist[index1] <= hist[index2]) ? index1 : index2;
	}

	private int[] constructST(int[] hist, int n) {
		int size = (int) (2 * Math.pow(2, Math.ceil(Math.log(n) / Math.log(2))) - 1);
		int[] segement = new int[size];
		constructSTUtil(hist, 0, n - 1, segement, 0);
		return segement;
	}

	private int constructSTUtil(int[] hist, int ss, int se, int[] segement,
			int si) {
		if (ss == se) {
			segement[si] = ss;
			return segement[si];
		}

		int mid = ss + (se - ss) / 2;

		int index1 = constructSTUtil(hist, ss, mid, segement, 2 * si + 1);
		int index2 = constructSTUtil(hist, mid + 1, se, segement, 2 * si + 2);

		int min = getMin(hist, index1, index2);
		segement[si] = min;
		return min;
	}
}
