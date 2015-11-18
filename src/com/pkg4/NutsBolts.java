package com.pkg4;

import java.util.Arrays;

public class NutsBolts {

	public static void main(String[] args) {
		char[] nuts = { '@', '#', '$', '%', '^', '&' };
		char[] bolts = { '$', '%', '&', '^', '@', '#' };

		System.out.println("Before Matching");
		System.out.println("Nuts -- " + Arrays.toString(nuts));
		System.out.println("Bolt -- " + Arrays.toString(bolts));

		NutsBolts nutsBolts = new NutsBolts();
		nutsBolts.sortNB(nuts, bolts, 0, nuts.length - 1);

		System.out.println("After Matching");
		System.out.println("Nuts -- " + Arrays.toString(nuts));
		System.out.println("Bolt -- " + Arrays.toString(bolts));

	}

	private void sortNB(char[] nuts, char[] bolts, int start, int end) {

		if (start < end) {

			int pIndex = partition(nuts, start, end, bolts[end]);

			partition(bolts, start, end, nuts[pIndex]);

			sortNB(nuts, bolts, start, pIndex - 1);
			sortNB(nuts, bolts, pIndex + 1, end);
		}
	}

	private int partition(char[] arr, int start, int end, char pivot) {

		int pIndex = start;

		for (int i = start; i < end; i++) {
			if (arr[i] < pivot) {
				swap(arr, i, pIndex);
				pIndex++;
			} else if (arr[i] == pivot) {
				swap(arr, i, end);
				i--;
			}
		}

		swap(arr, pIndex, end);

		return pIndex;
	}

	public void swap(char[] arr, int mIndex, int nIndex) {
		char temp = arr[mIndex];
		arr[mIndex] = arr[nIndex];
		arr[nIndex] = temp;
	}
}
