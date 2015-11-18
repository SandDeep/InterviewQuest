package com.rough;

import java.util.Arrays;

public class P66 {

	public static void main(String[] args) {
		MemoryInfo[] list = new MemoryInfo[8];
		list[0] = new MemoryInfo(1, 512, 1, State.READ);
		list[1] = new MemoryInfo(2, 432, 2, State.WRITE);
		list[2] = new MemoryInfo(3, 512, 3, State.READ);
		list[3] = new MemoryInfo(4, 932, 4, State.READ);
		list[4] = new MemoryInfo(5, 512, 5, State.WRITE);
		list[5] = new MemoryInfo(6, 932, 6, State.READ);
		list[6] = new MemoryInfo(7, 835, 7, State.READ);
		list[7] = new MemoryInfo(8, 432, 8, State.READ);

		P66 test = new P66();
		test.findMemoryConflict(list);
	}

	private void findMemoryConflict(MemoryInfo[] list) {

		Arrays.sort(list);
		System.out.println(list);

		for (int i = 0; i < list.length; i++) {
			if (list[i].getOperation() == State.WRITE) {
				int j = i - 1;

				// Backward
				while (j >= 0
						&& list[i].getMemoryBlock() == list[j].getMemoryBlock()) {
					if ((Math.abs(list[i].getTime() - list[j].getTime())) <= 5) {
						System.out.println("Memory Conflict : "
								+ list[i].getThreadId() + " --> "
								+ list[j].getThreadId());
					}
					j--;
				}

				j = i + 1;
				// Forward
				while (j < list.length
						&& list[i].getMemoryBlock() == list[j].getMemoryBlock()) {
					if ((Math.abs(list[i].getTime() - list[j].getTime())) <= 5) {
						System.out.println("Memory Conflict : "
								+ list[i].getThreadId() + " --> "
								+ list[j].getThreadId());
					}
					j++;
				}
			}
		}
	}
}

class MemoryInfo implements Comparable<MemoryInfo> {

	int threadId;
	int memoryBlock;
	int time;
	State operation;

	public MemoryInfo(int threadId, int memoryBlock, int time, State operation) {
		this.threadId = threadId;
		this.memoryBlock = memoryBlock;
		this.time = time;
		this.operation = operation;
	}

	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public int getMemoryBlock() {
		return memoryBlock;
	}

	public void setMemoryBlock(int memoryBlock) {
		this.memoryBlock = memoryBlock;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public State getOperation() {
		return operation;
	}

	public void setOperation(State operation) {
		this.operation = operation;
	}

	@Override
	public int compareTo(MemoryInfo o) {
		int mBlock1 = this.memoryBlock;
		int mBlock2 = o.getMemoryBlock();

		if (mBlock1 == mBlock2) {
			int time1 = this.time;
			int time2 = o.getTime();

			if (time1 == time2) {
				return 0;
			}

			return (time1 > time2) ? 1 : -1;
		}
		return (mBlock1 > mBlock2) ? 1 : -1;
	}

	@Override
	public String toString() {
		return "MemoryInfo [threadId=" + threadId + ", memoryBlock="
				+ memoryBlock + ", time=" + time + ", operation=" + operation
				+ "]";
	}

}

enum State {
	READ, WRITE
}