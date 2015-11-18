package com.pkg1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution2 {

	public static void main(String[] args) {
		try {

			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			int t = Integer.parseInt(br.readLine());

			for (int i = 0; i < t; i++) {
				int size = Integer.parseInt(br.readLine());

				String[] arr = br.readLine().split("\\s+");
				int[] pos = new int[size];
				for (int j = 0; j < arr.length; j++) {
					pos[j] = Integer.parseInt(arr[j]);
				}

				String[] arr1 = br.readLine().split("\\s+");
				int[] distance = new int[size];
				for (int j = 0; j < arr1.length; j++) {
					distance[j] = Integer.parseInt(arr1[j]);
				}

				Arrays.sort(pos);
				Arrays.sort(distance);
				
				int[] time = new int[size];
				for (int j = 0; j < size; j++) {
					time[j] = Math.abs(distance[j] - pos[j]);
				}

				int max = getMax(time, size);
				System.out.println(max);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static int getMax(int arr[], int n) {
		int max = arr[0];
		int i;
		for (i = 0; i < n; i++) {
			if (arr[i] > max)
				max = arr[i];
		}
		return max;
	}
}
