package com.pkg2;

public class HNumber {

	public static void main(String[] args) {
		int n = 987;
		int num = ++n;

		boolean flag = false;

		while (!flag) {
			flag = isAscHighest(num);
			if (!flag) {
				num++;
			}
		}
		System.out.println(num);
	}

	private static boolean isAscHighest(int num) {
		boolean status = true;

		int a = num % 10;
		num = num / 10;

		while (String.valueOf(num).length() != 0) {
			int b = num % 10;
			num = num / 10;

			if (a <= b) {
				status = false;
				break;
			}
			a = b;
		}

		return status;
	}
}
