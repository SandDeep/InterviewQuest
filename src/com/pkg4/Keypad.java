package com.pkg4;

import java.util.HashMap;
import java.util.Map;

public class Keypad {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		Keypad keypad = new Keypad();

		// 2
		map.put("A", 2);
		map.put("B", 2);
		map.put("C", 2);

		// 3
		map.put("D", 3);
		map.put("E", 3);
		map.put("F", 3);

		// 4
		map.put("G", 4);
		map.put("H", 4);
		map.put("I", 4);

		// 5
		map.put("J", 5);
		map.put("K", 5);
		map.put("L", 5);

		// 6
		map.put("M", 6);
		map.put("N", 6);
		map.put("O", 6);

		// 7
		map.put("P", 7);
		map.put("Q", 7);
		map.put("R", 7);
		map.put("S", 7);
		// 8
		map.put("T", 8);
		map.put("U", 8);
		map.put("V", 8);

		// 9
		map.put("W", 9);
		map.put("X", 9);
		map.put("Y", 9);
		map.put("Z", 9);

		keypad.convert(map, "microsoft");
		keypad.convert(map, "facebook");
		keypad.convert(map, "amazon");
	}

	private void convert(Map<String, Integer> map, String word) {
		String[] arr = word.split("");

		for (int i = 1; i < arr.length; i++) {
			int l=map.get(arr[i].toUpperCase());
			System.out.print(l);
		}
		System.out.println();
	}
}
