package com.chain;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ATMDispenseChain {

	private DispenseChain chain1;

	public ATMDispenseChain() {
		this.chain1 = new Dollar50Dispenser();
		DispenseChain chain2 = new Dollar20Dispenser();
		DispenseChain chain3 = new Dollar10Dispenser();

		// set the chain of responsibility
		chain1.setNext(chain2);
		chain2.setNext(chain3);
	}

	public static void main(String[] args) throws Exception {
		ATMDispenseChain atmDispenseChain = new ATMDispenseChain();

		while (true) {
			int amount = 0;
			System.out.println("Enter amount to dispense");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));

			amount = Integer.parseInt(br.readLine());

			if (amount % 10 != 0) {
				System.out.println("Amount should be in multiple of 10s.");
				System.exit(0);
			}

			atmDispenseChain.chain1.dispence(new Currency(amount));
		}
	}
}
