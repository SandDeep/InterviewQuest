package com.pkgS;

import java.util.Arrays;
import java.util.Collections;

/**
 * http://www.geeksforgeeks.org/find-the-largest-rectangle-of-1s-with-swapping-
 * of-columns-allowed/
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class P12 {

	public static void main(String[] args) {
		int mat1[][] = { 
				{ 0, 1, 0, 1, 0 }, 
				{ 0, 1, 0, 1, 1 }, 
				{ 1, 1, 0, 1, 0 } };

		int mat[][] = { 
				{0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1}
             };
		P12 test = new P12();
		System.out.println("Area of the largest rectangle is "+ test.maxArea(mat));
		System.out.println("Area of the largest rectangle is "+ test.maxArea(mat1));
	}

	private Integer maxArea(int[][] mat) {

		int R = mat.length;
		int C = mat[0].length;

		// Step 1
		Integer[][] hist = new Integer[R][C];
		
		for (int i = 0; i < C; i++) {
			int counter=0;
			for (int j = 0; j < R; j++) {
				if(mat[j][i]==0){
					counter=0;
				}else{
					counter++;
				}
				hist[j][i]=counter;
			}
			
		}
		
		//Sort Row-wise
		for (int i = 0; i < R; i++) {
			Arrays.sort(hist[i],Collections.reverseOrder());
		}
		
		//Max Product
		int maxArea = Integer.MIN_VALUE;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				int currArea = hist[i][j] * (j + 1);
				maxArea = Math.max(maxArea, currArea);
			}
		}
		return maxArea;
	}
}
