package com.thread;

public class CubbyHole {

	private int content;
	private boolean available;

	public CubbyHole() {
		this.content = 0;
		this.available = false;
	}

	public synchronized int get() {
		while (!available) {
			try {
				// releases lock here
				// must regain the lock to reentering here
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		available = false;
		notify();
		return content;
	}

	public synchronized void put(int i) {
		while (available) {
			try {
				wait();
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
		this.content = i;
		available = true;
		notify();
	}
}
