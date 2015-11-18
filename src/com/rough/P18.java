package com.rough;

public class P18 {

	public static void main(String[] args) {
		P18 test = new P18();

		char str[] = "a1b2c3d4e5f6g7".toCharArray();

		int arr[] = { 5, 5, 10, 40, 50, 35 };
		int arr1[] = { 1000, 11, 445, 1, 330, 3000 };

		test.printMaxSum(arr);

		Pair res = test.maxMinPair(arr1, 0, arr1.length-1);
		System.out.println(res);
		
		
	}

	private Pair maxMinPair(int[] arr, int low, int high) {
		if (low > high) {
			return null;
		}

		Pair temp = null;

		// only 1 Element
		if (low == high) {
			temp = new Pair(arr[low], arr[high]);
			return temp;
		}

		if (high - low == 1) {
			if (arr[high] > arr[low]) {
				temp = new Pair(arr[high], arr[low]);
			} else {
				temp = new Pair(arr[low], arr[high]);
			}
			return temp;
		}

		int mid = low + (high - low) / 2;

		Pair pair1 = maxMinPair(arr, low, mid);
		Pair pair2 = maxMinPair(arr, mid + 1, high);

		int max = 0;
		int min = 0;

		max = (pair1.maximum > pair2.maximum) ? pair1.maximum : pair2.maximum;
		min = (pair1.minimum < pair2.minimum) ? pair1.minimum : pair2.minimum;

		temp = new Pair(max, min);
		return temp;
	}

	private void printMaxSum(int[] arr) {
		int size = arr.length;
		int incl = 0;
		int excl = 0;

		for (int i = 0; i < size; i++) {
			// Include Current Element
			int tempIncl = arr[i] + excl;

			// Exclude current element
			int tempExcl = Math.max(incl, excl);

			incl = tempIncl;
			excl = tempExcl;

		}

		System.out.println(Math.max(incl, excl));
	}
}

class Pair {
	int maximum = 0;
	int minimum = 0;

	public Pair(int maximum, int minimum) {
		this.maximum = maximum;
		this.minimum = minimum;
	}

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int maximum) {
		this.maximum = maximum;
	}

	public int getMinimum() {
		return minimum;
	}

	public void setMinimum(int minimum) {
		this.minimum = minimum;
	}

	@Override
	public String toString() {
		return "Pair [maximum=" + maximum + ", minimum=" + minimum + "]";
	}

}