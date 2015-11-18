package com.chain;

public class Currency {

	int amount;

	public Currency(int amount) {
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Currency [amount=" + amount + "$ ]";
	}

}
