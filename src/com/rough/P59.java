package com.rough;

public class P59 {

	public static void main(String[] args) {
		int arr[] = { 40, 1, 10, 70, 2, 5, 30, 9, 8, 6 };
		int K = 5;
		int res=-1;
		P59 test = new P59();
		/* res = test.Rselect(arr, 0, arr.length - 1, K - 1);
		System.out.println("Kth Smallest number : " + res);*/

		res = test.kthSmallest(arr, 0, arr.length - 1, K);
		System.out.println("Kth Smallest number : " + res);
	}

	private int kthSmallest(int arr[], int l, int r, int k) {
		// If k is smaller than number of elements in array
		if (k > 0 && k <= r - l + 1) {
			// Partition the array around last element and get
			// position of pivot element in sorted array
			int pos = partition(arr, l, r);

			// If position is same as k
			if (pos /*- l*/ == k - 1)
				return arr[pos];
			if (pos/* - l*/ > k - 1) // If position is more, recur for left subarray
				return kthSmallest(arr, l, pos - 1, k);

			// Else recur for right subarray
			return kthSmallest(arr, pos + 1, r, k /*- pos + l - 1*/);
		}

		// If k is more than number of elements in array
		return Integer.MAX_VALUE;
	}

	/*private int randomPartition(int arr[], int l, int r)
	{
		Random random=new Random();
	    int n = r-l+1;
	    int pivot = rand() % n;
	    swap(arr,l + pivot, r);
	    return partition(arr, l, r);
	}*/
	private int Rselect(int[] arr, int start, int end, int k) {
		if (start <= end) {
			int pIndex = partition(arr, start, end);

			if (pIndex == k) {
				return arr[pIndex];
			}

			if (pIndex < k) {
				return Rselect(arr, pIndex + 1, end, k);
			} else {
				return Rselect(arr, start, pIndex - 1, k);
			}
		}
		return 0;
	}

	private int partition(int[] arr, int start, int end) {

/*		Random random = new Random();
		int n = end - start;
		System.out.println(end + " " + start + " -> " + n);
		int rIndex = -1;
		if (n == 0) {
			rIndex = start;
		} else {
			rIndex = start + random.nextInt(n);
		}
		swap(arr, rIndex, end);
*/
		int pivot = arr[end];
		int pIndex = start;

		for (int i = start; i < end; i++) {
			if (arr[i] <= pivot) {
				swap(arr, pIndex, i);
				pIndex++;
			}
		}

		swap(arr, pIndex, end);

		return pIndex;
	}

	public static void swap(int[] arr, int mIndex, int nIndex) {
		int temp = arr[mIndex];
		arr[mIndex] = arr[nIndex];
		arr[nIndex] = temp;
	}
}
