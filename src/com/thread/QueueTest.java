package com.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class QueueTest {

	public static void main(String[] args) {
		try {
			BlockingQueue<String> queue = new ArrayBlockingQueue<>(2);

			queue.put("Java");
			queue.put("JDK");
			System.out.println(queue);
			//queue.put("J2SE");
			queue.take();
			System.out.println(queue.remainingCapacity());
			
			boolean status=queue.offer("J2SE");
			System.out.println(status);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
