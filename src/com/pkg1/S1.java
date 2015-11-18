package com.pkg1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class S1 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		String status = "010111110";
		char[] arr = status.toCharArray();

		Map<Character, Integer> map = new HashMap<Character, Integer>();
		for (char c : arr) {
			if (map.containsKey(c)) {
				int currentCount = map.get(c);
				map.put(c, currentCount + 1);
			} else {
				map.put(c, 1);
			}
		}

		Map<Character, ArrayList<Integer>> mapIndex = new HashMap<Character, ArrayList<Integer>>();
		for (int i = 0; i < arr.length; i++) {
			if (mapIndex.containsKey(arr[i])) {
				ArrayList<Integer> currentList = mapIndex.get(arr[i]);
				int count = (int) currentList.get(1);
				currentList.set(1, count + 1);
				mapIndex.put(arr[i], currentList);
			} else {
				ArrayList<Integer> tempList = new ArrayList<Integer>();
				tempList.add(i); // Index
				tempList.add(1); // Count
				mapIndex.put(arr[i], tempList);
			}
		}

		System.out.println();
		for (int i = 0; i < arr.length; i++) {

		}
	}

	public void possibleCombinations(int combolen, char[] arr) {
		//char[] testArr=arr;
	}

}
