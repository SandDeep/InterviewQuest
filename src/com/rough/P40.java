package com.rough;

public class P40 {

	public static void main(String[] args) {
		int price[] = { 2, 30, 15, 10, 8, 25, 80 };
		P40 test = new P40();

		test.maxProfit(price, price.length);
	}

	private void maxProfit(int[] price, int n) {
		int[] profit = new int[n];

		profit[n - 1] = 0;
		int maxPrice = price[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			if (price[i] > maxPrice) {
				maxPrice = price[i];
			}
			profit[i] = Math.max(profit[i + 1], maxPrice - price[i]);
		}

		int minPrice = price[0];
		for (int i = 1; i < profit.length; i++) {
			if (minPrice > price[i]) {
				minPrice = price[i];
			}
			profit[i] = Math.max(profit[i - 1], profit[i]
					+ (price[i] - minPrice));
		}
		System.out.println("Max Profit : " + profit[n - 1]);
	}
}
