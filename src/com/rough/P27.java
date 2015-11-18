package com.rough;

public class P27 {

	public static void main(String[] args) {
		P27 test = new P27();

		test.findLongestPalindromicString("abababa".toCharArray());
	}

	private void findLongestPalindromicString(char[] arr) {
		if (arr.length == 0) {
			return;
		}

		int N = 2 * arr.length + 1;
		int[] L = new int[N];
		L[0] = 0;
		L[1] = 1;

		int iMirror = 0;
		int C = 1;
		int R = 2;
		int i = 0;

		int expand = -1;
		int diff = -1;
		int maxLPSLength = 0;
		int maxLPSCenterPosition = 0;

		for (i = 2; i < N; i++) {
			iMirror = 2 * C - i;
			diff = R - i;
			expand = 0;

			if (diff > 0) {

				// Case1
				if (L[iMirror] < diff) {
					L[i] = L[iMirror];
				}

				// Case 2
				else if (L[iMirror] == diff && i == N - 1) {
					L[i] = L[iMirror];
				}

				// Case 3
				else if (L[iMirror] == diff && i < N - 1) {
					L[i] = L[iMirror];
					expand = 1;
				}

				// Case 4
				else if (L[iMirror] > diff) {
					L[i] = diff;
					expand = 1;
				}
			} else {
				L[i] = 0;
				expand = 1;
			}

			/*if (diff > 0) {
				L[i]=Math.min(L[iMirror], diff);
			}*/
			if (expand == 1) {
				while ((((i + L[i]) < N-1) && ((i - L[i]) > 0))
						&& (((i + L[i] + 1) % 2 == 0)
						|| (arr[(i + L[i] + 1) / 2] == arr[(i - L[i] - 1) / 2]))) 
				{
					L[i]++;
				}
			}

			if (L[i] > maxLPSLength) {
				maxLPSLength = L[i];
				maxLPSCenterPosition = i;
			}

			if (i + L[i] > R) {
				C = i;
				R = i + L[i];
			}
		}

		int start = (maxLPSCenterPosition - maxLPSLength) / 2;
		int end = start + maxLPSLength - 1;

		for (int j = start; j <= end; j++) {
			System.out.print(arr[j]);
		}
	}
}
