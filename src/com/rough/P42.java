package com.rough;

public class P42 {

	public static void main(String[] args) {
		int arr[] = { 0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15/*1, 11, 2, 10, 4, 5, 2, 1 */};
		P42 test = new P42();

		test.LBS(arr, arr.length);
	}

	private void LBS(int[] arr, int n) {

		int lis[] = new int[n];
		int lds[] = new int[n];

		for (int i = 0; i < n; i++) {
			lis[i] = 1;
			lds[i] = 1;
		}

		// LIS
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i] && (lis[j] + 1) > lis[i]) {
					lis[i] = lis[j] + 1;
				}
			}
		}

		// LDS
		/*for (int i = n - 2; i >= 0; i--) {
			for (int j = n - 1; j > i; j--) {
				if (arr[j] < arr[i] && (lds[j] + 1) > lds[i]) {
					lds[i] = lds[j] + 1;
				}
			}
		}*/
		
		// LDS
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] > arr[i] && (lds[j] + 1) > lds[i]) {
					lds[i] = lds[j] + 1;
				}
			}
		}

		int max = 1;
		for (int i = 0; i < n; i++) {
			int b = lis[i] + lds[i] - 1;
			if(b > max){
				max=b;
			}
		}
		
		System.out.println(max);
	}

	int max = 1;

	public int lis(int[] arr, int n) {
		if (n == 1) {
			return 1;
		}

		int maxSoFar = 1;
		int res = 1;

		for (int i = 1; i < n; i++) {
			res = lis(arr, i);

			if (arr[i - 1] < arr[n - 1] && (res + 1) > maxSoFar) {
				maxSoFar = res + 1;
			}
		}

		if (max < maxSoFar) {
			max = maxSoFar;
		}
		return maxSoFar;
	}
}
