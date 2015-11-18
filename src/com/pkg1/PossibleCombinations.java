package com.pkg1;

public class PossibleCombinations {

	public static void main(String[] args) {
		//int[] arr = { 1, 2, 3 };
		String[] arr={"A","B","C"};

		printCombintions(arr, 0);
	}

	public static void printCombintions(String[] arr, int level) {

		if (level == arr.length - 1) {
			for (int i = 0; i < arr.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.print(" , ");
		} else {
			for (int i = level; i < arr.length; i++) {
				arr = swap(arr, level, i);
				printCombintions(arr, level + 1);
				arr = swap(arr, level, i);
			}
		}
	}

	private static String[] swap(String[] arr, int i, int j) {
		String temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

		return arr;
	}
}
