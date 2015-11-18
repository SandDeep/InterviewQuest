package com.pkgS;

public class P17 {

	public static void main(String[] args) {
		int arr[] = { 15, -2, 2, -8, 1, 7, 10, 23 };

		P17 test = new P17();
		int maxSum = test.maxSum(arr, arr.length);
		System.out.println("Max Sum SubArray : " + maxSum);

		int maxSubArray = test.maxSubArray(arr, arr.length);
		System.out.println("Max 0 SubArray : " + maxSubArray);
	}

	private int maxSubArray(int[] arr, int n) {
		int max = -1;

		for (int i = 0; i < arr.length; i++) {
			int sum=0;
			for (int j = i; j < arr.length; j++) {
				sum+=arr[j];
			}
		}

		return 0;
	}

	private int maxSum(int[] arr, int n) {

		int max = arr[0];
		int local = arr[0];
		for (int i = 1; i < n; i++) {
			local = Math.max(arr[i], local + arr[i]);
			max = Math.max(max, local);
		}
		return max;
	}
}
