package com.prac;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstNR {

	public static void main(String[] args) {
		String testString = "geeksforgeeks";
		Map<Character, ArrayList<String>> map = new HashMap<Character, ArrayList<String>>();

		char[] charArray = testString.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			List<String> list = map.get(charArray[i]);
			if (list == null) {
				ArrayList<String> tempList = new ArrayList<String>();
				tempList.add("1");
				tempList.add(i + "");
				map.put(new Character(charArray[i]), tempList);
			} else {
				int count = Integer.parseInt(list.get(0));
				list.set(0, String.valueOf(++count));
			}
		}
		System.out.println(map);
		for (Map.Entry<Character, ArrayList<String>> entry : map.entrySet()) {

			ArrayList<String> arrayList = entry.getValue();
			if (arrayList.get(0).equals("1")) {
				System.out.println("Key : " + entry.getKey() + " Value : "
						+ entry.getValue());
				break;
			}
		}
	}
}
