package com.pkgS;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int a_size = 0;
		a_size = Integer.parseInt(in.nextLine());

		int a[] = new int[a_size];

		for (int i = 0; i < a_size; i++) {
			a[i] = Integer.parseInt(in.nextLine());
		}

		swap_array(a);

		in.close();
	}

	private static void swap_array(int[] a) {

		BinaryClass[] classes = new BinaryClass[a.length];

		for (int i = 0; i < a.length; i++) {
			int countBits = getSetBits(a[i]);
			classes[i] = new BinaryClass(a[i], countBits);
		}

		//Arrays.sort(classes);
		Collections.sort(Arrays.asList(classes),Collections.reverseOrder());
		
		for (BinaryClass binaryClass : classes) {
			System.out.println(binaryClass.a);
		}
	}

	private static int getSetBits(int n) {
		int count = 0;

		while (n != 0) {
			n &= (n - 1);
			count++;
		}
		return count;
	}
}

class BinaryClass implements Comparable<BinaryClass> {
	int a;
	int count;

	public BinaryClass(int a, int count) {
		this.a = a;
		this.count = count;
	}

	@Override
	public int compareTo(BinaryClass o) {

		if (this.count == o.count) {
			if (this.a == o.a) {
				return 0;
			}
			return (this.a > o.a) ? 1 : -1;
		}
		return (this.count > o.count) ? 1 : -1;
	}

	@Override
	public String toString() {
		return "BinaryClass [a=" + a + ", count=" + count + "]";
	}
	
}