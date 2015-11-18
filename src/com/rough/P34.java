package com.rough;

public class P34 {

	public static int max = 1;
	public static int maxChain = 1;

	public static void main(String[] args) {
		int[] arr = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };

		P34 test = new P34();
		// test.lis(arr, arr.length);
		max=test.lisDP(arr, arr.length);
		System.out.println(max);

		int[][] air = { { 5, 24 }, { 15, 25 }, { 27, 40 }, { 50, 60 } };

		test.maxChain(air, air.length);
		System.out.println(maxChain);
	}

	private int lisDP(int[] arr, int n) {
		int res[] = new int[n];

		for (int i = 0; i < n; i++) {
			res[i] = 1;
		}

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && ((res[j] + 1) > res[i])) {
					res[i] = res[j] + 1;
				}
			}
		}
		
		int maxL=1;
		
		for (int i : res) {
			if (i > maxL) {
				maxL = i;
			}
		}

		
		return maxL;
	}

	private int maxChain(int[][] air, int length) {
		CPair[] pairs = new CPair[length];

		for (int i = 0; i < air.length; i++) {
			pairs[i] = new CPair(air[i][0], air[i][1]);
		}

		return maxChainUtil(pairs, pairs.length);
	}

	private int maxChainUtil(CPair[] pairs, int n) {

		if (n == 1) {
			return 1;
		}

		int maxSoFar = 1;
		int res = 1;

		for (int i = 1; i < n; i++) {
			res = maxChainUtil(pairs, i);

			if (pairs[n - 1].getStart() > pairs[i - 1].getEnd()
					&& (res + 1 > maxSoFar)) {
				maxSoFar = res + 1;
			}

		}

		if (maxChain < maxSoFar) {
			maxChain = maxSoFar;
		}
		return maxSoFar;
	}

	private int lis(int[] arr, int n) {

		if (n == 1) {
			return 1;
		}

		int maxSoFar = 1;
		int res = 1;

		for (int i = 1; i < n; i++) {
			res = lis(arr, i);
			if (arr[n - 1] > arr[i - 1] && res + 1 > maxSoFar) {
				maxSoFar = res + 1;
			}
		}

		if (max < maxSoFar) {
			max = maxSoFar;
		}

		return maxSoFar;
	}
}

class CPair {
	int start;
	int end;

	public CPair(int start, int end) {
		this.start = start;
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	@Override
	public String toString() {
		return "CPair [start=" + start + ", end=" + end + "]";
	}

}