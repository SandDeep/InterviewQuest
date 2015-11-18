package com.chain;

public class Dollar20Dispenser implements DispenseChain {

	DispenseChain chain;

	@Override
	public void setNext(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispence(Currency currency) {
		if (currency.getAmount() >= 20) {
			int num = currency.getAmount() / 20;
			int rem = currency.getAmount() % 20;

			System.out.println("Dispensing " + num + " 20$ note");
			if (rem != 0) {
				this.chain.dispence(new Currency(rem));
			}
		} else {
			this.chain.dispence(currency);
		}
	}

}
