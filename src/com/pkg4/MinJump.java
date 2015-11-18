package com.pkg4;

public class MinJump {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 6, 1, 0, 9 };

		MinJump jump = new MinJump();
		int jumps = jump.minJumps(arr, arr.length);
		System.out.println(jumps);
	}

	private int minJumps(int[] arr, int n) {
		int[] jumps = new int[n];

		if (n == 0 || arr[0] == 0)
	        return Integer.MAX_VALUE;
	 
	    jumps[0] = 0;
	 
	    // Find the minimum number of jumps to reach arr[i]
	    // from arr[0], and assign this value to jumps[i]
	    for (int i = 1; i < n; i++)
	    {
	        jumps[i] = Integer.MAX_VALUE;
	        for (int j = 0; j < i; j++)
	        {
	            if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE)
	            {
	                 jumps[i] = Math.min(jumps[i], jumps[j] + 1);
	                 break;
	            }
	        }
	    }
	    return jumps[n-1];
	}
}
