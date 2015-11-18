package com.thread;

public class SendingTest {

	public static void main(String[] args) {
		ISemaphore semaphore = new ISemaphore();

		SendingThread sender = new SendingThread(semaphore);
		ReceivingThread receiver = new ReceivingThread(semaphore);

		receiver.start();
		sender.start();
	}

}

enum MyEnum {
	first("First Value"), second("Second Value"), third("Third Value");

	private final String text;

	private MyEnum(String text) {
		this.text = text;
	}

	@Override
	public String toString() {
		return text;
	}
}