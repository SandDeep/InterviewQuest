package com.pkg1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Calculate all possible combinations of given integers.
 * 
 * @author Deepesh
 * 
 */
public class Solution {

	static Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			String a = br.readLine();
			String b = br.readLine();

			String[] arr = new String[2];
			arr[0] = a;
			arr[1] = b;

			List<String> list = new ArrayList<String>();
			possibleStrings(n - 1, arr, list);
		}
	}

	private static void possibleStrings(int maxLength, String[] arr,
			List<String> list) {
		if (list.size() == maxLength) {
			int total = 0;
			for (String val : list) {
				total += Integer.valueOf(val);
			}
			System.out.println(list + " : " + total);
		} else {
			for (int i = 0; i < arr.length; i++) {

				list.add(arr[i]);
				possibleStrings(maxLength, arr, list);

				// Revert curr to original value
				list.remove(list.size() - 1);
			}
		}
	}
}
