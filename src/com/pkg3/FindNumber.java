package com.pkg3;

public class FindNumber {

	// public static int count = 0;
	public static int N = 15000;

	public static void main(String[] args) {
		String[] list = new String[N+2];
		list[0] = "3";
		list[1] = "4";

		findNumber(list, 0, 2);
		System.out.println(list[N - 1]);
	}

	private static void findNumber(String[] list, int index, int count) {
		if (count > N) {
			return;
		}
		String val = list[index++];
		String val1 = val + "3";
		String val2 = val + "4";

		list[count++] = val1;
		list[count++] = val2;

		findNumber(list, index, count);
	}
}
