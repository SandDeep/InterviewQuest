package com.pkg4;

public class Stock {

	public static void main(String[] args) {
		int price[] = {  /*100, 180, 260, 310, 40, 535, 695*/ 7, 1, 3, 2, 9, 2,
				5, 4, 2, 100 };
		Stock stock = new Stock();
		stock.stockBuySell(price, price.length);
	}

	private void stockBuySell(int[] price, int N) {
		if (N == 1) {
			return;
		}
		int count = 0;
		// 1 for odd number of elements
		BSInterval[] interval = new BSInterval[N / 2 + 1];
		for (int i = 0; i < interval.length; i++) {
			interval[i] = new BSInterval();
		}
		int i = 0;

		while (i < N - 1) {

			while (i < N - 1 && (price[i + 1] <= price[i])) {
				i++;
			}

			if (i == N - 1)
				break;

			// Buy Time
			interval[count].buy = i++;

			while (i < N && (price[i] >= price[i - 1])) {
				i++;
			}

			// Sell Time
			interval[count].sell = i - 1;

			count++;
		}

		int profit = 0;
		if (count == 0)
			System.out
					.println("There is no day when buying the stock will make profit");
		else {
			for (int j = 0; j < count; j++) {
				System.out.println("Buy on day: " + interval[j].buy
						+ " , Sell on day: " + interval[j].sell);
				profit += price[interval[j].sell] - price[interval[j].buy];
			}
		}

		System.out.println("Total Profit : " + profit);
	}
}

class BSInterval {
	int buy;
	int sell;

	public BSInterval() {
		this.buy = -1;
		this.sell = -1;
	}

	public int getBuy() {
		return buy;
	}

	public void setBuy(int buy) {
		this.buy = buy;
	}

	public int getSell() {
		return sell;
	}

	public void setSell(int sell) {
		this.sell = sell;
	}

	@Override
	public String toString() {
		return "Interval [buy=" + buy + ", sell=" + sell + "]";
	}

}