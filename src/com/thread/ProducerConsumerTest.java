package com.thread;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		CubbyHole cubbyHole = new CubbyHole();
		Producer producer = new Producer(cubbyHole, 1);
		Consumer consumer = new Consumer(cubbyHole, 1);

		Producer producer1 = new Producer(cubbyHole, 2);
		Consumer consumer1 = new Consumer(cubbyHole, 2);

		producer.start();
		consumer.start();

		producer1.start();
		consumer1.start();
	}
}
