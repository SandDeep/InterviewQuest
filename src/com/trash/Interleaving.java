package com.trash;

/**
 * Time Complexity: O(MN) Auxiliary Space: O(MN)
 * 
 * @author Deepesh
 * 
 */
public class Interleaving {

	public static void main(String[] args) {

		Interleaving interleaving = new Interleaving();
		interleaving.test("XXY".toCharArray(), "XXZ".toCharArray(),
				"XXZXXXY".toCharArray());
		interleaving.testDP("XY".toCharArray(), "WZ".toCharArray(),
				"WZXY".toCharArray());
	}

	private void testDP(char[] arr1, char[] arr2, char[] arr3) {
		int M = arr1.length;
		int N = arr2.length;

		boolean IL[][] = new boolean[M + 1][N + 1];

		if ((M + N) != arr3.length) {
			System.out.println("Interleaved : False");
			return;
		}
		for (int i = 0; i <= M; i++) {
			for (int j = 0; j <= N; j++) {

				// two empty strings have an empty string
				// as interleaving
				if (i == 0 && j == 0) {
					IL[i][j] = true;
				}

				else if (i == 0 && arr2[j - 1] == arr3[j - 1]) {
					IL[i][j] = IL[i][j - 1];
				}

				else if (j == 0 && arr1[i - 1] == arr3[i - 1]) {
					IL[i][j] = IL[i - 1][j];
				}

				/*
				 * Current character of C matches with current character of
				 * A,but doesn't match with current character of B
				 */
				else if (i != 0 && j != 0 && arr1[i - 1] == arr3[i + j - 1]
						&& arr2[j - 1] != arr3[i + j - 1]) {
					IL[i][j] = IL[i - 1][j];
				}

				/*
				 * Current character of C matches with current character of B,
				 * but doesn't match with current character of A
				 */
				else if (i != 0 && j != 0 && arr1[i - 1] != arr3[i + j - 1]
						&& arr2[j - 1] == arr3[i + j - 1]) {
					IL[i][j] = IL[i][j - 1];
				}

				/*
				 * Current character of C matches with that of both A and B
				 */
				else if (i != 0 && j != 0 && arr1[i - 1] == arr3[i + j - 1]
						&& arr2[j - 1] == arr3[i + j - 1]) {
					IL[i][j] = IL[i][j - 1] || IL[i - 1][j];
				}
			}
		}

		System.out.println("Interleaved : " + IL[M][N]);
	}

	private void test(char[] arr1, char[] arr2, char[] testArr) {
		if (testArr.length < 1) {
			return;
		}

		boolean status = testUtil(arr1, arr2, arr1.length, arr2.length,
				testArr, testArr.length);
		System.out.println(status);
	}

	private boolean testUtil(char[] arr1, char[] arr2, int m, int n,
			char[] testArr, int z) {

		// All Are empty
		if (z < 1 && m < 1 && n < 1) {
			return true;
		}

		// Test string in empty
		if (z < 1) {
			return false;
		}

		if (m > 0 && testArr[z - 1] == arr1[m - 1]) {
			return testUtil(arr1, arr2, m - 1, n, testArr, z - 1);
		} else if (n > 0 && testArr[z - 1] == arr2[n - 1]) {
			return testUtil(arr1, arr2, m, n - 1, testArr, z - 1);
		} else {
			return false;
		}
	}

}
