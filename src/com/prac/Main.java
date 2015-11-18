package com.prac;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			String[] line = br.readLine().split("\\ ");
			int n = Integer.parseInt(line[0]); // array size
			int k = Integer.parseInt(line[1]); // even integer count

			String[] array = br.readLine().split("\\ ");
			int[] numArray = new int[array.length];
			for (int j = 0; j < array.length; j++) {
				numArray[j] = Integer.parseInt(array[j]);
			}

			String status = "NO";
			List<Integer> list = new ArrayList<Integer>();

			for (int j = 0; j < n; j++) {
				int num = numArray[j];

				// EVEN
				if (num % 2 == 0) {
					if (status.equals("NO")) {
						list.add(num);
						status = "YES";
						if (list.size() == k) {
							System.out.println(status);
							break;
						}
					} else if (status.equals("YES")) {
						list.add(num);
						if (list.size() == k) {
							System.out.println(status);
							break;
						}
					}
				}
				// ODD
				else {
					list.clear();
					status = "NO";
				}
			}
			if(status.equals("NO")){
				System.out.println(status);
			}
		}
	}

}
