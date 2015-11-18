package com.pkg5;

/**
 * Median: In probability theory and statistics, a median is described as the
 * number separating the higher half of a sample, a population, or a probability
 * distribution, from the lower half. The median of a finite list of numbers can
 * be found by arranging all the numbers from lowest value to highest value and
 * picking the middle one.
 * {@link http://www.geeksforgeeks.org/median-of-two-sorted-arrays/}
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class Median {

	public static void main(String[] args) {
		//int[] arr1 = { 1, 12, 15, 26, 38 };
		//int[] arr2 = { 2, 13, 17, 30, 45 };

		int[] arr1 = {1, 5, 7, 10, 13};
		   int[] arr2 = {11, 15, 23, 30, 45};
		int median = findMedian(arr1, arr2, 0,arr1.length, 0,arr2.length);
		//int median = findbinarySearchMedian(arr1, arr2, 0,arr1.length-1, 0,arr2.length-1);
		System.out.println(median);
	}

	public static int findbinarySearchMedian(int[] arr1, int[] arr2, int mStart,int mEnd, int nStart,int nEnd) {
		
		int i = mStart + (mEnd - mStart) / 2;

		int j = arr2.length - i - 1;

		if (arr1[i] >= arr2[j] && arr1[i] <= arr2[j + 1]) {
			return (arr1[i] + arr2[j]) / 2;
		}
		else if(arr1[i] > arr2[j] && arr1[i] > arr2[j+1]){
			return findbinarySearchMedian(arr1, arr2, mStart, i-1, nStart, nEnd);
		}else if(arr1[i] < arr2[j] && arr1[i] < arr2[j+1]){
			return findbinarySearchMedian(arr1, arr2, i+1, mEnd, nStart, nEnd);
		}
		return j;
	}

	/**
	 * Time Complexity: O(logn) Algorithmic Paradigm: Divide and Conquer
	 * 
	 * @return
	 */
	public static int findMedian(int[] arr1, int[] arr2, int mStart,int mEnd, int nStart,int nEnd) {

		if((mEnd-mStart)<=1 && (nEnd-nStart)<=1){
			return (Math.max(arr1[mStart], arr2[nStart]) + Math.min(arr1[mEnd], arr2[nEnd]))/2;
		}
		int m1=(mStart + (mEnd-mStart)/2);
		int m2=(nStart + (nEnd-nStart)/2);

		if(arr1[m1]==arr2[m2]){
			return m1;
		}
		else if(arr1[m1] > arr2[m2]){
			return findMedian(arr1, arr2, mStart, m1, m2, nEnd);
		}else{
			return findMedian(arr1, arr2, m1, mEnd, nStart, m2);
		}
		
	}
}
