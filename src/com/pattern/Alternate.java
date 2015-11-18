package com.pattern;

import java.util.Arrays;

public class Alternate {

	public static void main(String[] args) {
		int[] arr = { -2, 3, 4, 5, -1, -6, 7, 9, 1 };

		Alternate alternate = new Alternate();
		alternate.ordering(arr);
		System.out.println(Arrays.toString(arr));
	}

	private void ordering(int[] arr) {
		int index = 0;
		int val = 0;
		boolean sign = true;

		for (int i = 0; i < arr.length; i++) {

			// negative
			if (sign) {
				if (arr[i] > 0) {

					for (int j = i + 1; j < arr.length; j++) {
						if (arr[j] < 0) {
							val = arr[j];
							index = j;
							break;
						}
					}

					if(index > i){
						reaarange(arr, i, val, index);
					}
				}
			}

			// positive
			else {
				if (arr[i] < 0) {

					for (int j = i + 1; j < arr.length; j++) {
						if (arr[j] < 0) {
							val = arr[j];
							index = j;
							break;
						}
					}

					if(index > i){
						reaarange(arr, i, val, index);
					}
				}
			}

			sign = !sign;
		}
	}

	private void reaarange(int[] arr, int i, int val, int index) {
		int temp = arr[i];
		arr[i++] = val;
		val = temp;
		//swap(arr,i++, index);
		
		while (i <= index) {
			//swap(arr,i++, index);
			temp = arr[i];
			arr[i++] = val;
			val = temp;
		}
	}

}
