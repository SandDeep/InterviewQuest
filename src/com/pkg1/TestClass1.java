package com.pkg1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TestClass1 {

	public static void main(String[] args) throws NumberFormatException,
			IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			String[] input = br.readLine().split("\\s+");
			int N = Integer.parseInt(input[0]);
			int K = Integer.parseInt(input[1]);
			int L = Integer.parseInt(input[2]);
			int R = Integer.parseInt(input[3]);

			char[] str = br.readLine().toCharArray();
			char[] type = br.readLine().toCharArray();

			Set<String> set = new HashSet<String>();
			Map<Character, Boolean> map = new HashMap<Character, Boolean>();
			for (int z = 0; z < K; z++) {
				if (map.get(type[z]) == null) {
					map.put(type[z], true);
				}
			}

			for (int k = 0; k < N; k++) {
				for (int j = L; j <= R; j++) {
					String s = "";
					int count = 0;
					int index = k;
					while (index < N && count < j) {
						if (map.get(str[index]) != null) {
							count++;
						}
						s += str[index++];
					}
					if (count == j) {
						set.add(s);
					}
				}

			}

			System.out.println(set.size() + "\n" + set);
		}
	}
}
