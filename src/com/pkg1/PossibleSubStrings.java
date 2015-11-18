package com.pkg1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PossibleSubStrings {

	public static void main(String[] args) {

		String A = "abcd";
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < A.length(); i++) {
			for (int j = i + 1; j <= A.length(); j++) {
				list.add(A.substring(i, j));
			}
		}
		Collections.sort(list);
		System.out.println(list.size()+" : "+list);

	}

}
