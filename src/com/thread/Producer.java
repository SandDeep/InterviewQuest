package com.thread;

public class Producer extends Thread {
	private CubbyHole cubbyHole;
	private int number;

	public Producer(CubbyHole cubbyHole, int number) {
		this.cubbyHole = cubbyHole;
		this.number = number;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			cubbyHole.put(i);
			System.out.println("Producer #" + this.number + " put : " + i);

			try {
				sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
			}

		}
	}

}
