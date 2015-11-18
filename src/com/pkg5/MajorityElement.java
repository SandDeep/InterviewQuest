package com.pkg5;

public class MajorityElement {

	/**
	 * Another Technique - Find median and compare with max occurring element with it.
	 * @param args
	 */
	public static void main(String[] args) {
		int a[] = { 1, 3, 3, 1, 2 };
		int A[] = { 2, 2, 3, 5, 2, 2, 6 };

		MajorityElement major = new MajorityElement();
		major.printMajority(A, 5);
	}

	/**
	 * Moore’s Voting Algorithm : Time Complexity - O(n) Space Complexity - O(1)
	 * 
	 * @param arr
	 * @param n
	 */
	private void printMajority(int[] arr, int n) {
		int majIndex = 0;
		int count = 0;

		// Finding Majority Element
		for (int i = 0; i < n; i++) {
			if (count == 0) {
				majIndex = i;
				count++;
			} else {
				if (arr[majIndex] == arr[i]) {
					count++;
				} else {
					count--;
				}
			}
		}

		int fCount = 0;
		// Verifying majority element
		for (int i = 0; i < n; i++) {
			if (arr[majIndex] == arr[i]) {
				fCount++;
			}
		}
		if (fCount >= n / 2) {
			System.out.println("Majority Element :" + arr[majIndex]);
		} else {
			System.out.println("No Majority Element ");
		}
	}
}
