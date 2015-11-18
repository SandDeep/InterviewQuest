package com.rough;

import java.util.HashMap;

public class P32 {

	public static void main(String[] args) {
		int cacheSize = 4;

		HashMap<Integer, CacheNode> map = new HashMap<Integer, CacheNode>();
		Queue queue = new Queue(cacheSize);
		P32 test = new P32();

		test.referencePage(queue, map, 1);
		test.referencePage(queue, map, 2);
		test.referencePage(queue, map, 3);
		test.referencePage(queue, map, 1);		
		test.referencePage(queue, map, 4);
		test.referencePage(queue, map, 5);

		System.out.println(queue);
	}

	private void referencePage(Queue queue, HashMap<Integer, CacheNode> map,
			int pageNumber) {

		CacheNode reqPage = map.get(pageNumber);

		if (reqPage == null) {
			enqueue(queue, map, pageNumber);
		}

		else if (reqPage != queue.front) {

			reqPage.prev.next = reqPage.next;
			if (reqPage.next != null) {
				reqPage.next.prev = reqPage.prev;
			}

			if (reqPage == queue.rear) {
				queue.rear = reqPage.prev;
				queue.rear.next = null;
			}

			reqPage.next = queue.front;
			queue.front.prev = reqPage;
			queue.front = reqPage;
		}
	}

	private void enqueue(Queue queue, HashMap<Integer, CacheNode> map,
			int pageNumber) {
		if (queue.isFull()) {
			map.remove(pageNumber);
			dequeue(queue, map, pageNumber);
		}

		CacheNode temp = new CacheNode(pageNumber);
		temp.next = queue.front;

		if (queue.front == null) {
			queue.front = queue.rear = temp;
		} else {
			queue.front.prev = temp;
			queue.front = temp;
		}

		map.put(pageNumber, temp);
		queue.count++;
	}

	private void dequeue(Queue queue, HashMap<Integer, CacheNode> map,
			int pageNumber) {
		if (queue.isEmpty()) {
			return;
		}

		if (queue.front == queue.rear) {
			queue.front = null;
		}

		queue.rear = queue.rear.prev;

		if (queue.rear != null) {
			queue.rear.next = null;
		}
		queue.count--;
	}

}

class Queue {
	int count;
	int numberOfFrames;
	CacheNode front;
	CacheNode rear;

	public Queue(int numberOfFrames) {
		this.numberOfFrames = numberOfFrames;
		this.count = 0;
		this.front = null;
		this.rear = null;
	}

	public boolean isEmpty() {
		return (count == 0) ? true : false;
	}

	public boolean isFull() {
		return (count == numberOfFrames) ? true : false;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public CacheNode getFront() {
		return front;
	}

	public void setFront(CacheNode front) {
		this.front = front;
	}

	public CacheNode getRear() {
		return rear;
	}

	public void setRear(CacheNode rear) {
		this.rear = rear;
	}

	@Override
	public String toString() {
		int f = -1;
		if (front != null)
			f = front.pageNumber;

		int r = -1;
		if (rear != null)
			r = rear.pageNumber;

		return "Queue [count=" + count + ", numberOfFrames=" + numberOfFrames
				+ ", front=" + f + ", rear=" + r + "]";
	}

}

class CacheNode {

	int pageNumber;
	CacheNode next;
	CacheNode prev;

	public CacheNode(int data) {
		this.pageNumber = data;
		this.next = null;
		this.prev = null;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public CacheNode getNext() {
		return next;
	}

	public void setNext(CacheNode next) {
		this.next = next;
	}

	public CacheNode getPrev() {
		return prev;
	}

	public void setPrev(CacheNode prev) {
		this.prev = prev;
	}

	@Override
	public String toString() {
		return "CacheNode [pageNumber=" + pageNumber + "]";
	}

}
