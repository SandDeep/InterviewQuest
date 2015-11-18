package com.pkg4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NumericKeypad {

	static int count = 0;

	public static void main(String[] args) {
		int[] number = { 2, 3, 4 };
		int size = number.length;

		NumericKeypad keypad = new NumericKeypad();
		Map<Integer, ArrayList<Character>> map = keypad.initializeMap();

		char[] output = new char[size];

		keypad.printWords(number, map, 0, output, size);
		System.out.println("\nTotal Combinaions : " + count);
	}

	private void printWords(int[] number,
			Map<Integer, ArrayList<Character>> map, int currDigit,
			char[] output, int size) {

		if (currDigit == size) {
			System.out.println(Arrays.toString(output));
			return;
		}

		ArrayList<Character> list = map.get(number[currDigit]);

		for (int i = 0; i < list.size(); i++) {
			count++;
			output[currDigit] = list.get(i);
			printWords(number, map, currDigit + 1, output, size);

			if (number[currDigit] == 1 || number[currDigit] == 0) {
				return;
			}
		}
	}

	private Map<Integer, ArrayList<Character>> initializeMap() {
		Map<Integer, ArrayList<Character>> map = new HashMap<Integer, ArrayList<Character>>();

		ArrayList<Character> tempList = null;

		// 1
		tempList = new ArrayList<Character>();
		map.put(1, tempList);

		// 2
		tempList = new ArrayList<Character>();
		tempList.add('A');
		tempList.add('B');
		tempList.add('C');
		map.put(2, tempList);

		// 3
		tempList = new ArrayList<Character>();
		tempList.add('D');
		tempList.add('E');
		tempList.add('F');
		map.put(3, tempList);

		// 4
		tempList = new ArrayList<Character>();
		tempList.add('G');
		tempList.add('H');
		tempList.add('I');
		map.put(4, tempList);

		// 5
		tempList = new ArrayList<Character>();
		tempList.add('J');
		tempList.add('K');
		tempList.add('L');
		map.put(5, tempList);

		// 6
		tempList = new ArrayList<Character>();
		tempList.add('M');
		tempList.add('N');
		tempList.add('O');
		map.put(6, tempList);

		// 7
		tempList = new ArrayList<Character>();
		tempList.add('P');
		tempList.add('Q');
		tempList.add('R');
		tempList.add('S');
		map.put(7, tempList);

		// 8
		tempList = new ArrayList<Character>();
		tempList.add('T');
		tempList.add('U');
		tempList.add('V');
		map.put(8, tempList);

		// 9
		tempList = new ArrayList<Character>();
		tempList.add('W');
		tempList.add('X');
		tempList.add('Y');
		tempList.add('Z');
		map.put(9, tempList);

		// 0
		tempList = new ArrayList<Character>();
		map.put(0, tempList);

		return map;
	}
}
