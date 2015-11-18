package com.rough;

public class P33 {

	public static void main(String[] args) {
		/*String str = "121198";
		int n = 2;*/
		
		String str = "4325043";
		int n = 3;
		P33 test = new P33();

		System.out.println(test.buildLowestNumber(str, n));
	}

	private String buildLowestNumber(String arr, int n) {
		String res = "";

		return buildLowestNumberUtil(arr, n, res);
	}

	private String buildLowestNumberUtil(String arr, int n, String res) {

		if (n == 0) {
			res = res + arr;
			return res;
		}

		int len = arr.length();
		if (len <= n) {
			return res;
		}

		int minIndex = 0;
		for (int i = 1; i <= n; i++) {
			if (arr.charAt(i) < arr.charAt(minIndex)) {
				minIndex = i;
			}
		}

		res += arr.charAt(minIndex);

		arr = arr.substring(minIndex + 1);
		return buildLowestNumberUtil(arr, n - minIndex, res);
	}
}
