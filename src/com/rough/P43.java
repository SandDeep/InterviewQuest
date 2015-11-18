package com.rough;

public class P43 {
	public static void main(String[] args) {

		int a[][] = { { 4, 5, 3, 2 }, { 2, 10, 1, 4 } };
		int t[][] = { { 0, 7, 4, 5 }, { 0, 9, 2, 8 } };

		int entry[] = { 10, 12 };
		int exit[] = { 18, 7 };

		P43 test = new P43();
		test.carAssembly(a, t, entry, exit);
	}

	private void carAssembly(int[][] a, int[][] t, int[] entry, int[] exit) {
		int n = a[0].length;

		int[] T1 = new int[n];
		int[] T2 = new int[n];

		// time taken to leave first station
		T1[0] = entry[0] + a[0][0];
		T2[0] = entry[1] + a[1][0];

		for (int i = 1; i < n; i++) {
			T1[i] = Math.min((T1[i - 1] + a[0][i]), (T2[i - 1] + t[1][i] + a[0][i]));
			T2[i] = Math.min((T2[i - 1] + a[1][i]),
					(T1[i - 1] + t[0][i] + a[1][i]));
		}
		
		// Consider exit time
		int cost = Math.min((T1[n - 1] + exit[0]), (T2[n - 1] + exit[1]));
		System.out.println("Min Cost : " + cost);
	}
}
