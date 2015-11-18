package com.pkg2;

public class CoinChange {

	public static void main(String[] args) {
		
		int arr[] = { 1, 2, 3 }; 
		int n = 4;
		

		//int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8 };
		//int n = 8;

		CoinChange coin = new CoinChange();

		//int count = coin.count(arr, arr.length - 1, n);
		int count = coin.countDP(arr, arr.length, n);
		System.out.println(count);
	}

	int count(int[] arr, int m, int n) {

		// possible solution
		if (n == 0) {
			return 1;
		}

		// amount is -ve || coins are not available
		if (n < 0) {
			return 0;
		}

		// coins are not available but amount is possible
		if (m < 0 && n > 0) {
			return 0;
		}

		// mth coin not included
		int a = count(arr, m - 1, n);

		// atleast one mth coin is included
		int b = count(arr, m, n - arr[m]);

		return a + b;
	}
	
	int countDP( int S[], int m, int n )
	{
	    int i, j, x, y;
	 
	    // We need n+1 rows as the table is constructed in bottom up manner using 
	    // the base case 0 value case (n = 0)
	    int[][] table=new int[n+1][m];
	    
	    // Fill the entries for 0 value case (n = 0)
	    for (i=0; i<m; i++)
	        table[0][i] = 1;
	 
	    // Fill rest of the table entries in bottom up manner  
	    for (i = 1; i < n+1; i++)
	    {
	        for (j = 0; j < m; j++)
	        {
	            // Count of solutions including S[j]
	            x = (i-S[j] >= 0)? table[i - S[j]][j]: 0;
	 
	            // Count of solutions excluding S[j]
	            y = (j >= 1)? table[i][j-1]: 0;
	 
	            // total count
	            table[i][j] = x + y;
	        }
	    }
	    return table[n][m-1];
	}
}
