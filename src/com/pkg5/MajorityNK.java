package com.pkg5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * http://www.geeksforgeeks.org/given-an-array-of-of-size-n-finds-all-the-elements-that-appear-more-than-nk-times/
 * Time Complexity: O(nk) Auxiliary
 * Space: O(k)
 * 
 * @author Deepesh
 * 
 */
public class MajorityNK {

	public static void main(String[] args) {
		MajorityNK nk = new MajorityNK();

		System.out.print("First Test -> ");
		int arr1[] = { 4, 5, 6, 7, 8, 4, 4 };
		int k = 3;
		nk.moreThanNdK(arr1, k);

		System.out.print("Second Test -> ");
		int arr2[] = { 4, 2, 2, 7 };
		k = 3;
		nk.moreThanNdK(arr2, k);

		System.out.print("Third Test -> ");
		int arr3[] = { 2, 7, 2 };
		k = 2;
		nk.moreThanNdK(arr3, k);

		System.out.print("Fourth Test -> ");
		int arr4[] = { 2, 3, 3, 2 };
		k = 3;
		nk.moreThanNdK(arr4, k);
	}

	private void moreThanNdK(int[] arr, int k) {
		if (k < 2)
			return;

		// Step 1 - Find potential majority elements
		Map<Integer, Integer> map = populateMap(arr, k);

		// System.out.println(map);

		List<Integer> list = new ArrayList<Integer>();

		for (Integer key : map.keySet()) {
			list.add(key);
		}

		// Step 2 - Verify majority elements
		System.out.println("Majority Elemets : ");
		for (Integer memb : list) {
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (memb == arr[i]) {
					count++;
				}
				if (count > (arr.length / k)) {
					System.out.print(arr[i] + " ");
					break;
				}
			}
		}
		System.out.println();
	}

	private Map<Integer, Integer> populateMap(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < arr.length; i++) {
			if (map.size() < k || map.containsKey(arr[i])) {

				if (map.get(arr[i]) == null) {
					map.put(arr[i], 1);
				} else {
					int count = map.get(arr[i]);
					map.put(arr[i], count + 1);
				}

			} else {
				List<Integer> list = new ArrayList<Integer>();

				// Decrement all count by 1
				for (Integer key : map.keySet()) {
					int count = map.get(key);
					count--;
					map.put(key, count);
					if (count == 0) {
						list.add(key);
					}
				}

				for (Integer key : list) {
					map.remove(key);
				}
			}
		}

		return map;
	}
}
