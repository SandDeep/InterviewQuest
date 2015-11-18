package com.rough;

import java.util.HashMap;
import java.util.Map;

public class P78 {

	public static void main(String[] args) {
		int arr[] = { 1, 2, 1, 3, 4, 2, 3 };
		int k = 4;

		P78 test = new P78();
		test.countWindowDistinct(arr, k);
	}

	private void countWindowDistinct(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		int n = arr.length;

		for (int i = 0; i < k; i++) {
			if (map.get(arr[i]) == null) {
				map.put(arr[i], 1);
			} else {
				int val = map.get(arr[i]);
				map.put(arr[i], val + 1);
			}
		}

		System.out.println(map.size());

		for (int i = k; i < n; i++) {
			int val = map.get(arr[i - k]);
			if(val > 1){
				map.put(arr[i - k], val-1);
			}else{
				map.remove(arr[i - k]);
			}
			

			if (map.get(arr[i]) == null) {
				map.put(arr[i], 1);
			} else {
				int val1 = map.get(arr[i]);
				map.put(arr[i], val1 + 1);
			}
			System.out.println(map.size());
		}
	}
}
