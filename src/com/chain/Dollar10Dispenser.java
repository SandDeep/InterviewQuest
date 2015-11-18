package com.chain;

public class Dollar10Dispenser implements DispenseChain {

	DispenseChain chain;

	@Override
	public void setNext(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispence(Currency currency) {
		if (currency.getAmount() >= 10) {
			int num = currency.getAmount() / 10;
			int rem = currency.getAmount() % 10;

			System.out.println("Dispensing " + num + " 10$ note");
			if (rem != 0) {
				this.chain.dispence(new Currency(rem));
			}
		} else {
			this.chain.dispence(currency);
		}
	}

}
