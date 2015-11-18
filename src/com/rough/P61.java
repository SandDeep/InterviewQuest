package com.rough;

public class P61 {

	public static void main(String[] args) {
		int[][] arr = { 
				{ 2, 4, 6, 8 }, 
				{ 5, 9, 12, 16 }, 
				{ 2, 11, 5, 9 },
				{ 3, 2, 1, 8 } };
		
		P61 test=new P61();
		test.printSpiral(arr, arr.length, arr[0].length);
	}

	private void printSpiral(int[][] arr, int m, int n) {
		int top = 0;
		int bottom = m - 1;
		int left = 0;
		int right = n - 1;
		int dir = 1;
		while (top <= bottom && left <= right) {

			switch (dir) {
			case 1:

				for (int i = left; i <= right; i++) {
					System.out.print(arr[top][i]+" ");
				}
				top++;
				dir = 2;
				break;

			case 2:
				for (int i = top; i <= bottom; i++) {
					System.out.print(arr[i][right]+" ");
				}
				right--;
				dir = 3;
				break;

			case 3:
				for (int i = right; i >= left; i--) {
					System.out.print(arr[bottom][i]+" ");
				}

				bottom--;
				dir = 4;
				break;
			case 4:
				for (int i = bottom; i >= top; i--) {
					System.out.print(arr[i][left]+" ");
				}
				left++;
				dir = 1;
				break;
			}
		}
	}
}
