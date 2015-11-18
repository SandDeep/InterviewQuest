package com.thread;

import java.util.LinkedList;
import java.util.Queue;

public class TokenManager {

	public static void main(String[] args) {

		Token token = new Token(new LinkedList<Integer>(), 1);
		Thread pThread = new Thread(new TokenProducer(token));
		Thread cThread = new Thread(new TokenConsumer(token));

		pThread.start();
		cThread.start();
	}
}

class Token {
	Queue<Integer> queue;
	int capacity;
	int content;

	public Token(Queue<Integer> queue, int capacity) {
		this.queue = queue;
		this.capacity = capacity;
	}

	public void put(int content) {
		synchronized (this) {
			while (queue.size() == capacity) {
				try {
					System.out.println("Queue is full, waiting");
					this.wait();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			queue.add(content);
			System.out.println("Producer produces : " + content);
			this.notifyAll();
		}
	}

	public void take() {
		synchronized (this) {
			while (queue.isEmpty()) {
				try {
					System.out.println("Queue is empty, waiting");
					this.wait();
				} catch (InterruptedException e) {
					System.out.println(e.getMessage());
				}
			}
			System.out.println("Conumer consume : " + queue.remove());
			this.notifyAll();
		}
	}
}

class TokenProducer implements Runnable {
	Token token;

	public TokenProducer(Token token) {
		this.token = token;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			token.put(i);
		}
	}
}

class TokenConsumer implements Runnable {
	Token token;

	public TokenConsumer(Token token) {
		this.token = token;
	}

	@Override
	public void run() {
		for (int i = 1; i <= 10; i++) {
			token.take();
		}
	}
}