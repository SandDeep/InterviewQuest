package com.trash;

/**
 * http://www.geeksforgeeks.org/rearrange-array-arrj-becomes-arri-j/
 * 
 * @author Deepesh
 * 
 */
public class Rearrange {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 0, 2 };

		Rearrange rearrange = new Rearrange();
		rearrange.rearrangeUtil(arr, arr.length);
	}

	private void rearrangeUtil(int[] arr, int N) {
		int val = 0;

		int i = arr[0]; // The next index is determined

		while (i != 0) {
			int new_i = arr[i];

			arr[i] = val;

			val = i;
			i = new_i;
		}

		arr[0] = val;
	}
}
