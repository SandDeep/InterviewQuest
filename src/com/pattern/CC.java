package com.pattern;

public class CC {

	static int count = 0;

	public static void main(String[] args) {
		int arr[] = { 1, 2, 3 };
		int N = 4;
		CC cc = new CC();
		cc.findCC(arr, arr.length, N);
		System.out.println(count);
	}

	private void findCC(int[] arr, int n, int sum) {
		if (sum == 0) {
			count++;
			return;
		}
		if ((n < 1 && sum > 0) || (sum < 0)) {
			return;
		}

		// Include value
		findCC(arr, n, sum - arr[n - 1]);

		//Exclude Value
		findCC(arr, n - 1, sum);
	}
}
