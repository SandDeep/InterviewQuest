package com.rough;

public class P41 {

	public static void main(String[] args) {
		P41 test = new P41();

		int arr[] = { 0, 10, 2, -10, -20 };
		int missing = test.findMissing(arr, arr.length);
		System.out.println(missing);
	}

	private int findMissing(int[] arr, int n) {
		int index = segregate(arr, arr.length);

		return findMisPos(arr, index);
	}

	private int findMisPos(int[] arr, int index) {
		for (int i = index; i < arr.length; i++) {
			if((Math.abs(arr[i])-1) < arr.length && arr[Math.abs(arr[i])-1+index+1] > 0){
				arr[Math.abs(arr[i]) - 1 + index+1] = -arr[Math.abs(arr[i]) - 1 + index+1];
			}
		}
		
		for (int i = index; i < arr.length; i++) {
			if(arr[i] > 0){
				return i+1;
			}
		}
		return arr.length+1;
	}

	private int segregate(int[] arr, int n) {
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				swap(arr, index, i);
				index++;
			}
		}
		return index;
	}

	public void swap(int[] arr, int mIndex, int nIndex) {
		int temp = arr[mIndex];
		arr[mIndex] = arr[nIndex];
		arr[nIndex] = temp;
	}
}
