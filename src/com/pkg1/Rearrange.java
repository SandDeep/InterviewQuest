package com.pkg1;

import java.util.HashMap;
import java.util.Map;

public class Rearrange {

	public static void main(String[] args) {
		// String input = "abcabc";
		String input = "geeksforgeeks";
		//int d = 3;

		Map<Character, Integer> map = new HashMap<Character, Integer>();

		for (int i = 0; i < input.length(); i++) {
			if (map.get(input.charAt(i)) == null) {
				map.put(input.charAt(i), 1);
			} else {
				Integer val = map.get(input.charAt(i));
				map.put(input.charAt(i), val + 1);
			}
		}

		charFreq[] freq = new charFreq[map.size()];
		int count = 0;
		for (Character character : map.keySet()) {
			freq[count] = new charFreq(map.get(character), character);
			count++;
		}
		System.out.println(map);
	}
}

class charFreq implements Comparable<charFreq>{
	int count;
	char alphabet;

	public charFreq(int count, char alphabet) {
		this.count = count;
		this.alphabet = alphabet;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public char getAlphabet() {
		return alphabet;
	}

	public void setAlphabet(char alphabet) {
		this.alphabet = alphabet;
	}

	@Override
	public String toString() {
		return "charFreq [count=" + count + ", alphabet=" + alphabet + "]";
	}

	@Override
	public int compareTo(charFreq o) {
		 return this.getCount()-o.getCount();
	}

}