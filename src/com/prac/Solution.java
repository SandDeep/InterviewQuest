package com.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int a = Integer.parseInt(br.readLine());
			int b = Integer.parseInt(br.readLine());

			int[] arr = new int[2];
			arr[0] = a;
			arr[1] = b;

			Map<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();

			ArrayList<Integer> tmp=new ArrayList<Integer>();
			// First element is 0.
			tmp.add(0);
			
			for (int j = 0; j < arr.length; j++) {
				
			}
			System.out.println(map);
		}
	}
}
