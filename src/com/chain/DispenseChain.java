package com.chain;

public interface DispenseChain {

	public void setNext(DispenseChain nextChain);

	public void dispence(Currency currency);
}
