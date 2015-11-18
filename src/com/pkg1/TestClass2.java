package com.pkg1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestClass2 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TestClass2 test = new TestClass2();

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			char[] input = br.readLine().toCharArray();

			if (input.length < 3) {
				System.out.println("Not possible!");
				continue;
			}

			int[] arr = new int[input.length];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = Integer.parseInt(input[j] + "");
			}

			Set<Integer> set = new HashSet<Integer>();
			test.permutate(arr, 0, set);

			List<Integer> list = new ArrayList<Integer>();
			for (Integer val : set) {
				list.add(val);
			}

			Collections.sort(list);

			System.out.println(list.get(2) + " " + list.get(list.size() - 3));
		}

	}

	public void permutate(int[] arr, int level, Set<Integer> set) {

		if (level == arr.length - 1) {
			String s = "";
			for (int i = 0; i < arr.length; i++) {
				s += arr[i];
			}
			set.add(Integer.parseInt(s));
		} else {
			for (int i = level; i < arr.length; i++) {
				swap(arr, level, i);
				permutate(arr, level + 1, set);
				swap(arr, level, i);
			}
		}
	}

	private void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;

	}
}
