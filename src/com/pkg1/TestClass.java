package com.pkg1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TestClass {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		char[] input = br.readLine().toCharArray();

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < N; i++) {
			if (map.get(input[i]) == null) {
				map.put(input[i], 1);
			} else {
				int count = map.get(input[i]);
				map.put(input[i], ++count);
			}
		}

		int Q = Integer.parseInt(br.readLine());

		for (int i = 0; i < Q; i++) {
			char[] strArr = br.readLine().toCharArray();

			Long poss = 0L;
			if (map.get(strArr[0]) != null && map.get(strArr[1]) != null
					&& map.get(strArr[2]) != null) {
				poss = (long) (map.get(strArr[0]) * map.get(strArr[1])
						* map.get(strArr[2]));

				if (poss > 0) {
					int count = map.get(strArr[0]);
					map.put(strArr[0], --count);

					count = map.get(strArr[1]);
					map.put(strArr[1], --count);

					count = map.get(strArr[2]);
					map.put(strArr[2], --count);
				}
			}

			// print it modulo 1000000007 ( 10^9 + 7 )
			if(poss > 100000){
				
			}
			System.out.println(poss);
		}

	}
}
