package com.pkg1;

/**
 * http://ms-amazon.blogspot.in/2013/10/quick-select-select-kth-smallest.html
 * 
 * @author Deepesh
 * 
 */
public class QuickSelect {

	public static void main(String... args) {
		int k = 3;
		int[] arr = { 9, 8, 7, 16, 5/*, 0, 1, 2, 3, 4 */};

		QuickSelect quick = new QuickSelect();
		int number = quick.selectKth(arr, k);
		System.out.println("Kth Element : " + number);
	}

	private int selectKth(int[] arr, int k) {
		if (arr == null || arr.length < k) {
			return -1;
		}
		int from = 0, to = arr.length - 1;

		// if from == to we reached the kth element
		while (from < to) {
			int r = from, w = to;
			int mid = arr[(r + w) / 2];

			// stop if the reader and writer meets
			while (r < w) {

				if (arr[r] >= mid) { // put the large values at the end
					int tmp = arr[w];
					arr[w] = arr[r];
					arr[r] = tmp;
					w--;
				} else { // the value is smaller than the pivot, skip
					r++;
				}
			}

			// if we stepped up (r++) we need to step one down
			if (arr[r] > mid)
				r--;

			// the r pointer is on the end of the first k elements
			if (k <= r) {
				to = r;
			} else {
				from = r + 1;
			}
		}

		return arr[k];
	}
}
