package com.pkgS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/minimum-number-of-swaps-required-for-arranging-
 * pairs-adjacent-to-each-other/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P6 {

	public static void main(String[] args) {
		int arr[] = { 3, 5, 6, 4, 1, 2 };
		Pair[] pairs = new Pair[3];
		pairs[0] = new Pair(1, 3);
		pairs[1] = new Pair(2, 6);
		pairs[2] = new Pair(4, 5);

		P6 test = new P6();
		int min = test.findMinSwap(arr, arr.length, pairs);
		System.out.println("Minimum Number of Swaps : " + min);
	}

	private int findMinSwap(int[] arr, int n, Pair[] pairs) {
		if (n % 2 != 0) {
			System.out.println("Pair not possible");
			return 0;
		}
		Map<Integer, Integer> pairMap = generatePairMap(pairs);

		return minSwapUtil(arr, 0, pairMap);
	}

	private int minSwapUtil(int[] arr, int index, Map<Integer, Integer> pairMap) {
		if (index == arr.length) {
			return 0;
		}

		// Already Right Position
		int pair1 = pairMap.get(arr[index + 1]);
		if (arr[index] == pair1) {
			return minSwapUtil(arr, index + 2, pairMap);
		}

		// First
		int pair = pairMap.get(arr[index]);
		int i = getIndex(arr, pair);
		int[] arr1 = Arrays.copyOf(arr, arr.length);
		swap(arr1, index + 1, i);

		int a = minSwapUtil(arr1, index + 2, pairMap);

		// Revert
		// swap(arr, index + 1, i);

		// Second
		pair = pairMap.get(arr[index + 1]);
		i = getIndex(arr, pair);
		arr1 = Arrays.copyOf(arr, arr.length);
		swap(arr1, index, i);

		int b = minSwapUtil(arr1, index + 2, pairMap);

		return 1 + Math.min(a, b);
	}

	private static void swap(int[] arr, int m, int n) {
		int temp = arr[m];
		arr[m] = arr[n];
		arr[n] = temp;
	}

	private int getIndex(int[] arr, int pair) {
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == pair) {
				return i;
			}
		}
		return -1;
	}

	private Map<Integer, Integer> generatePairMap(Pair[] pairs) {
		Map<Integer, Integer> pairMap = new HashMap<>();

		for (int i = 0; i < pairs.length; i++) {
			pairMap.put(pairs[i].val1, pairs[i].val2);
			pairMap.put(pairs[i].val2, pairs[i].val1);
		}
		return pairMap;
	}

}

class Pair {
	int val1;
	int val2;

	public Pair(int val1, int val2) {
		this.val1 = val1;
		this.val2 = val2;
	}

	public int getVal1() {
		return val1;
	}

	public void setVal1(int val1) {
		this.val1 = val1;
	}

	public int getVal2() {
		return val2;
	}

	public void setVal2(int val2) {
		this.val2 = val2;
	}

	@Override
	public String toString() {
		return "Pair [val1=" + val1 + ", val2=" + val2 + "]";
	}

}