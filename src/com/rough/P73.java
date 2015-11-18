package com.rough;

/**
 * http://www.geeksforgeeks.org/minimum-steps-to-reach-a-destination/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P73 {

	public static void main(String[] args) {
		int n = 5;
		P73 test = new P73();

		System.out.println("Is Reachable : "
				+ test.isReachable(0, 0, Math.abs(n)));
	}

	// http://ideone.com/Ou4X8q
	private int isReachable(int src, int move, int dest) {
		if (Math.abs(src) > dest) {
			return Integer.MAX_VALUE;
		}

		if (src == dest) {
			return move;
		}

		int left = isReachable(src + move + 1, move + 1, dest);
		int right = isReachable(src - move - 1, move + 1, dest);
		return Math.min(left, right);
	}
}
