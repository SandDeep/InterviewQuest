package com.pkg1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution1 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		Solution1 sol = new Solution1();

		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			// String[] arr = str.split("(?!^)");
			char[] arr = str.toCharArray();

			/*
			 * 1. If all digits sorted in descending order, then output is
			 * always “Not Possible”
			 */
			char[] temp = Arrays.copyOf(arr, arr.length);
			char[] sortArr = new char[temp.length];

			Arrays.sort(temp);
			int size = temp.length;

			int count = 0;
			for (int j = size - 1; j >= 0; j--) {
				sortArr[count] = temp[j];
				count++;
			}

			if (new String(arr).equals(new String(sortArr))) {
				System.out.println("no answer");
				continue;
			}

			/*
			 * 2. If all digits are sorted in ascending order, then we need to
			 * swap last two digits
			 */
			Arrays.sort(temp);
			if (new String(arr).equals(new String(temp))) {
				int l = arr.length;
				sol.swap(l - 1, l - 2, arr);
				System.out.println(new String(arr));
				continue;
			}

			int j = 0;
			for (j = size - 1; j > 0; j--) {

				if (arr[j] > arr[j - 1]) {
					break;
				}

			}

			char num = arr[j - 1];

			char smallest = arr[j];

			for (int k = j; k < size; k++) {
				if ((arr[k] > num) && (arr[k] < smallest)) {
					smallest = arr[k];
				}
			}

			int swapindex = sol.getIndexOf(smallest, arr);
			sol.swap(j - 1, swapindex, arr);

			//Arrays.sort(arr, 0, size - 1);
			char[] tmp = new char[size - j];
			
			for (int k = 0; k < tmp.length; k++) {
				tmp[k]=arr[j+k];
			}
			Arrays.sort(tmp);

			count=0;
			for (int k = j; k < arr.length; k++) {
				arr[k]=tmp[count];
				count++;
			}
			System.out.println(new String(arr));
		}
	}

	public int getIndexOf(char toSearch, char[] tab) {
		for (int i = 0; i < tab.length; i++)
			if (tab[i] == toSearch)
				return i;

		return -1;
	}

	public void swap(int i, int j, char[] arr) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
}
