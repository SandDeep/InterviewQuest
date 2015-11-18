package com.trash;

/**
 * Time Complexity : O(n)
 * 
 * @author Deepesh
 * 
 */
public class ManacherAlgo {

	public static void main(String[] args) {
		ManacherAlgo algo = new ManacherAlgo();

		algo.findLongestPalindromicString("babcbabcbaccba".toCharArray());
		algo.findLongestPalindromicString("abaaba".toCharArray());
		algo.findLongestPalindromicString("abababa".toCharArray());
	}

	/**
	 * In Terms of Position=i-d to i+d 
	 * In Terms of index=[(i-d)/2] to [(i+d)/2-1]
	 * 
	 * @param arr
	 */
	public void findLongestPalindromicString(char[] arr) {
		if (arr.length == 0) {
			return;
		}

		int N = 2 * arr.length + 1;
		int L[] = new int[N];
		L[0] = 0;
		L[1] = 1;

		int C = 1; // centerPosition
		int R = 2; // centerRightPosition
		int i = 0; // currentRightPosition
		int iMirror; // currentLeftPosition
		//int expand = -1;
		int diff = -1;
		int maxLPSLength = 0;
		int maxLPSCenterPosition = 0;
		int start = -1;
		int end = -1;

		for (i = 2; i < N; i++) {
			iMirror = 2 * C - i;
			diff = R - i;
			//expand = 1;

			//HACK
			if(diff > 0){
				L[i]=Math.min(L[iMirror], diff);
			}
			
			// If currentRightPosition i is within centerRightPosition R
			/*if (diff > 0) {
				// CASE 1
				if (L[iMirror] < diff) {
					L[i] = L[iMirror];
				}
				// CASE 2
				else if (L[iMirror] == diff && R == N - 1) {
					L[i] = L[iMirror];
				}
				// CASE 3
				else if (L[iMirror] == diff && R < N - 1) {
					L[i] = L[iMirror];
					expand = 1;
				}
				// CASE 4
				else if (L[iMirror] > diff) {
					L[i] = diff;
					expand = 1;
				}
			} else {
				L[i] = 0;
				expand = 1;
			}*/

			//if (expand == 1) {
				/*while (((i + L[i] < N) && (i - L[i] > 0))
						&& ((i + L[i] + 1) % 2 == 0)
						|| (arr[(i + L[i] + 1) / 2] == arr[(i - L[i] - 1) / 2])) {
					L[i]++;
				}*/
				while (((i + L[i]) < N-1 && (i - L[i]) > 0)
						&& (((i + L[i] + 1) % 2 == 0) || 
						(arr[(i + L[i] + 1) / 2] == arr[(i - L[i] - 1) / 2]))) 
				{
					L[i]++;
				}
			//}

			if (L[i] > maxLPSLength) {
				maxLPSLength = L[i];
				maxLPSCenterPosition = i;
			}

			if (i + L[i] > R) {
				C = i;
				R = i + L[i];
			}
		}

		// Print LPS
		start = (maxLPSCenterPosition - maxLPSLength) / 2;
		end = start + maxLPSLength - 1;

		for (int j = start; j <= end; j++) {
			System.out.print(arr[j]);
		}
		System.out.println();
	}
}
