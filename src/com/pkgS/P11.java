package com.pkgS;

public class P11 {

	public static void main(String[] args) {
		char set[] = { 'a', 'b', 'c' };

		P11 test = new P11();
		test.printPowerSet(set, set.length);
	}

	private void printPowerSet(char[] set, int size) {
		int n = (int) Math.pow(size, 2);

		for (int i = 0; i < n; i++) {
			System.out.print("{");
			for (int j = 0; j < size; j++) {

				/*if((i & (1 << j))!=0){
					System.out.print(1);
				}else
				System.out.print(0);*/
				// check for ith bit in sequence of 0,1
				if ((i & (1 << j)) != 0) {
					System.out.print(set[j]);
				}
			}
			System.out.print("}");
			System.out.println();
		}
	}
}
