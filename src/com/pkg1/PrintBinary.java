package com.pkg1;

import java.util.LinkedList;
import java.util.Queue;

public class PrintBinary {

	public static void main(String[] args) {
		int n = 3;
	    generatePrintBinary(n);
	}
	
	static void generatePrintBinary(int n)
 {
		Queue<String> q = new LinkedList<String>();

		// Enqueue the first binary number
		q.add("1");

		// This loops is like BFS of a tree with 1 as root
		// 0 as left child and 1 as right child and so on
		while (n-- > 0) {
			// print the front of queue
			String s1 = q.poll();
			System.out.println(s1);
			String s2 = s1; // Store s1 before changing it

			// Append "0" to s1 and enqueue it
			q.add(s1 + "0");

			// Append "1" to s2 and enqueue it. Note that s2 contains
			// the previous front
			q.add(s2 + "1");

		}
	}
}
