package com.pkg4;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {

	public static void main(String[] args) {
		String data = "GEEKSFORGEEKS";

		LongestSubstring substring = new LongestSubstring();

		int length = substring.longestSubstring(data);
		System.out.println(length);
	}

	private int longestSubstring(String data) {

		char[] dataArr = data.toCharArray();
		Map<Character, Integer> map = new HashMap<Character, Integer>();

		int length = 0;
		int maxlen = 0;

		for (int i = 0; i < dataArr.length; i++) {

			Character character = new Character(dataArr[i]);

			if (map.get(character) == null || map.get(character) == 0) {
				length++;
				if (maxlen < length) {
					maxlen = length;
				}
				map.put(character, 1);
			} else {
				for (Character key : map.keySet()) {
					map.put(key, 0);
				}
				map.put(character, 1);
				length = 1;
			}
		}
		return maxlen;
	}
}
