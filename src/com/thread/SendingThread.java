package com.thread;

public class SendingThread extends Thread{
	ISemaphore semaphore = null;

	public SendingThread(ISemaphore semaphore) {
		this.semaphore = semaphore;
	}
	
	public void run(){
		while(true){
			this.semaphore.take();
		}
	}
}
