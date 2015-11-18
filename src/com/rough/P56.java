package com.rough;

/**
 * http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
 * @author Deepesh.Maheshwari
 *
 */
public class P56 {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9 };
		P56 test = new P56();
		test.minJump(arr, arr.length);
	}

	private void minJump(int[] arr, int n) {

		if (n == 0 || arr[0] == 0) {
			System.out.println("No path Possible.");
			return;
		}

		int path[] = new int[n];
		int jump[] = new int[n];

		for (int i = 1; i < n; i++) {

			for (int j = 0; j < i; j++) {
				if (j + arr[j] >= i) {
					int val = jump[j] + 1;
					if (val < jump[i] || jump[i] == 0) {
						jump[i] = val;
						path[i] = j;
					}
				}
			}
		}

		System.out.println("Min Jump Required : " + jump[n - 1]);
		System.out.println("Path Followed : ");

		int i = n - 1;
		while (i > 0) {
			System.out.print(arr[i] + " -> ");
			i = path[i];
		}
		System.out.print(arr[0]);
	}
}
