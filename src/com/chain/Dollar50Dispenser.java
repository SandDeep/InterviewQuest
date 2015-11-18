package com.chain;

public class Dollar50Dispenser implements DispenseChain {

	DispenseChain chain;

	@Override
	public void setNext(DispenseChain nextChain) {
		this.chain = nextChain;
	}

	@Override
	public void dispence(Currency currency) {
		if (currency.getAmount() >= 50) {
			int num = currency.getAmount() / 50;
			int rem = currency.getAmount() % 50;

			System.out.println("Dispensing " + num + " 50$ note");
			if (rem != 0) {
				this.chain.dispence(new Currency(rem));
			}
		} else {
			this.chain.dispence(currency);
		}
	}

}
