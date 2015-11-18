package com.pkg4;

/**
 * http://www.mathsisfun.com/pascals-triangle.html
 * O(n^2) time and O(1) extra space 
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class PascalTree {

	public static void main(String[] args) {
		PascalTree tree = new PascalTree();
		tree.drawPascalTree(10);
	}

	/**
	 * Sierpinski Triangle : If you color the Odd and Even numbers, you end up
	 * with a pattern the same as the Sierpinski Triangle
	 * 
	 * @param n
	 */
	public void drawPascalTree(int n) {
		int[] pascal = new int[n + 1];

		pascal[0] = 1;
		pascal[1] = 1;
		printArray(pascal, 0);
		printArray(pascal, 1);

		for (int i = 2; i <= n; i++) {
			pascal = pascalUtil(pascal, i);
			printArray(pascal, i);
		}

	}

	public int[] pascalUtil(int[] pascal, int level) {
		int[] temp = new int[pascal.length];

		for (int i = 0; i <= level; i++) {
			if (i == 0 || i == level) {
				temp[i] = 1;
				temp[i] = 1;
			} else {
				temp[i] = pascal[i - 1] + pascal[i];
			}
		}

		return temp;
	}

	private void printArray(int[] pascal, int N) {
		for (int i = 0; i <= N; i++) {
			System.out.print(pascal[i] + "  ");
		}
		System.out.print("\n");
	}
}
