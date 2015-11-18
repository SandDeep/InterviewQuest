package com.rough;

import java.util.Stack;

/**
 * http://www.geeksforgeeks.org/next-greater-element/
 * 
 * @author Deepesh
 * 
 */
public class P30 {

	public static void main(String[] args) {
		char str[] = "geeksforgeeks".toCharArray();
		P30 test = new P30();

		test.findNonRepeating(str, str.length);

		int arr[] = { 11, 13, 21, 3 /* 4, 5, 2, 25 */};
		System.out.println("Next Greater Element\n");
		test.printNGE(arr);

		int arr1[] = { 5, 3, 2, 4, 8, 6 };
		System.out.println("Left Greater Element\n");
		test.printPGE(arr1);

	}

	private void printPGE(int[] arr) {
		if (arr.length < 1) {
			return;
		}

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(arr[0]);
		int next = arr[0];
		int element = 0;

		System.out.println(next + " -- > " + -1);

		for (int i = 1; i < arr.length; i++) {
			next = arr[i];

			if (!stack.isEmpty()) {
				element = stack.pop();

				while (next > element) {
					if (stack.isEmpty()) {
						break;
					}
					element = stack.pop();
				}

				if (element > next) {
					System.out.println(next + " -- > " + element);
					stack.push(element);
				} else {
					System.out.println(next + " -- > " + -1);
				}
			}
			stack.push(next);
		}
	}

	private void printNGE(int[] arr) {
		if (arr.length < 1) {
			return;
		}

		Stack<Integer> stack = new Stack<Integer>();
		stack.push(arr[0]);
		int next = 0;

		for (int j = 1; j < arr.length; j++) {
			next = arr[j];

			if (!stack.isEmpty()) {
				int element = stack.pop();

				while (element < next) {
					System.out.println(element + " -- > " + next);

					if (stack.isEmpty()) {
						break;
					}
					element = stack.pop();
				}
				if (element > next) {
					stack.push(element);
				}
			}
			stack.push(next);
		}

		while (!stack.isEmpty()) {
			System.out.println(stack.pop() + " -- > " + -1);
		}
	}

	private void findNonRepeating(char[] str, int n) {
		int SIZE = 256;
		Feed count[] = new Feed[SIZE];

		for (int i = 0; i < SIZE; i++) {
			count[i] = new Feed();
		}

		for (int i = 0; i < n; i++) {
			Feed temp = count[str[i]];
			if (temp.index == -1) {
				temp.setIndex(i);
			}
			temp.setCount(temp.getCount() + 1);
		}

		int rIndex = Integer.MAX_VALUE;
		for (int i = 0; i < SIZE; i++) {
			Feed temp = count[i];
			if (temp.getCount() == 1 && rIndex > temp.getIndex()) {
				rIndex = temp.getIndex();
			}
		}

		if (rIndex == Integer.MAX_VALUE) {
			System.out
					.println("Either all characters are repeating or string is empty");
		} else
			System.out.println("First non-repeating character is : "
					+ str[rIndex]);
	}
}

class Feed {
	int index;
	int count;

	public Feed() {
		this.index = -1;
		this.count = 0;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "Feed [index=" + index + ", count=" + count + "]";
	}
}