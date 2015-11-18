package com.prac;

public class GreatestSD {

	public static void main(String[] args) {
		String num = "218765";
		GreatestSD sd = new GreatestSD();
		sd.findLargestCombination(num);
	}

	public void findLargestCombination(String num) {

		char[] arrTest = new char[num.length()];
		for (int i = 0; i < num.length(); i++) {
			arrTest[i] = num.charAt(i);
		}
		System.out.println(arrTest);
		int n = num.length();

		/*
		 * I) Start from the right most digit and find the first digit that is
		 * smaller than the digit next to it.
		 */
		for (int i = n - 1; i > 0; i--) {
			if (arrTest[i] < arrTest[i - 1]) {
				break;
			}
		}
	}

}
