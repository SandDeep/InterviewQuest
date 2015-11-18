package com.pkg2;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		//int[] arr = { 7, 2, 1, 6, 8, 5, 3, 4 };
		//int[] arr = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12 };
		int A[] = new int[20]; 
		populateArray(A);
		System.out.println(Arrays.toString(A));
		insertionSort(A);
		System.out.println(Arrays.toString(A));
	}

	private static void insertionSort(int[] arr) {

		for (int i = 1; i < arr.length; i++) {
			int k=i;
			while (k > 0) {
				if(arr[k] < arr[k-1] ){
					swap(arr,k,k-1);
				}
				k--;
			}
		}
	}
	
	private static void swap(int[] arr, int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}
	
	public static void populateArray(int[] B) {
		for (int i = 0; i < B.length; i++) {
			B[i] = (int) (Math.random() * 100);
		}
	}

}
