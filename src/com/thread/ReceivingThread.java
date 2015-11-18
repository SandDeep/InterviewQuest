package com.thread;

public class ReceivingThread extends Thread {
	ISemaphore semaphore = null;

	public ReceivingThread(ISemaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void run() {
		try {
			while (true) {
				this.semaphore.release();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
