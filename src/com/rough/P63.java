package com.rough;

/**
 * Count frequencies of all elements in array in O(1) extra space and O(n) time
 * http://www.geeksforgeeks.org/count-frequencies-elements-array-o1-extra-space-
 * time/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P63 {

	public static void main(String[] args) {
		P63 test = new P63();

		int arr[] = { 2, 3, 3, 2, 5 };
		int arr2[] = {1, 3, 5, 7, 9, 1, 3, 5, 7, 9, 1};
		test.findCounts(arr2, arr2.length);
	}

	private void findCounts(int[] arr, int n) {
		int i = 0;
		while (i < n) {

			// If this element is already processed,nothing to do
			if (arr[i] <= 0) {
				i++;
				continue;
			}

			int elementIndex = arr[i] - 1;

			/**
			 * If the elementIndex has an element that is not processed yet,
			 * then first store that element to arr[i] so that we don't loose
			 * anything.
			 */
			if (arr[elementIndex] > 0) {
				arr[i] = arr[elementIndex];
				arr[elementIndex] = -1;
			} else {
				// increment its count.
				arr[elementIndex]--;

				// arr[i] as 0 means the element, 'i+1' is not seen so far
				arr[i] = 0;
				i++;
			}
		}

		for (i = 0; i < arr.length; i++) {
			System.out.println(i + 1 + "  -->  " + Math.abs(arr[i]));
		}
	}
}
