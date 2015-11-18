package com.thread;

public class ISemaphore {
	private boolean signal = false;

	public synchronized void take() {
		this.signal = true;
		this.notify();
	}

	public void release() throws InterruptedException {
		while (signal != true) {
			this.wait();
		}
		this.signal = false;
	}
}
