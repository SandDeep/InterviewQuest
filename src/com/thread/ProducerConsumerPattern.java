package com.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerPattern {

	public static void main(String[] args) {
		BlockingQueue<Integer> bQueue = new ArrayBlockingQueue<>(1);

		Thread pThread = new Thread(new BProducer(bQueue));
		Thread cThread = new Thread(new BConsumer(bQueue));

		pThread.start();
		cThread.start();
	}
}

class BProducer implements Runnable {
	BlockingQueue<Integer> queue = null;

	public BProducer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				queue.put(i);
				System.out.println("Producer produces : " + i);
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}

class BConsumer implements Runnable {
	BlockingQueue<Integer> queue = null;

	public BConsumer(BlockingQueue<Integer> queue) {
		this.queue = queue;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				System.out.println("Conumer consume : " + queue.take());
			} catch (InterruptedException e) {
				System.err.println(e.getMessage());
			}
		}
	}
}