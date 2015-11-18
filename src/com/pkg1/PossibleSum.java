package com.pkg1;

public class PossibleSum {

	public static void main(String[] args) {
		int sample = 27;

		int[] arr = new int[sample];
		arr[0] = sample;
		
		for (int i = 0; i < sample; i++) {
			if (i == 0) {
				System.out.println(sample);
				continue;
			}

			int t = sample - i;
			if (t > 0) {
				arr[0]=t;
				arr[1]=i;
				possibleSum(arr, 2);
			}
		}

		//possibleCombination(arr, 1);
	}
	
	private static void possibleSum(int[] arr, int len) {
		if (allOne(arr, 1, len)) {
			printArray(arr, len);
			return;
		}
		
		//Initial Combination
		if(len==2){
			int index= getIndexOf(1, arr);
			
			//Last Element
			if (index == (len - 1)) {
				printArray(arr, len);
				return;
			}
			
			//Index not present
			else{
				int base=arr[0];
				int val=arr[1];
				
				// Like (4,3),(4,4)
				if(base >= val){
					printArray(arr, len);
					
					arr[len-1]=val-1;
					arr[len]=1;
					possibleSum(arr, len+1);
				}
				
				//(3,5),(2,6)
				else{
					
					while (arr[len - 2] < arr[len - 1]) {
						int val1 = arr[len - 1];
						arr[len - 1] = base;
						arr[len] = val1 - base;
						len++;
					}
					possibleSum(arr, len);
				}
			}
		}
		
		else{

			int index = getIndexOf(1, arr);

			// 1 not present
			if (index == -1) {
				printArray(arr, len);

				int val = arr[len - 1];
				arr[len - 1] = val - 1;
				arr[len] = 1;
				possibleSum(arr, len + 1);
			}

			// 1 is First Element
			else if (index == 1) {
				printArray(arr, len);
				return;
			}

			// 1 present in Middle
			else {
				printArray(arr, len);

				// indexed value is not last value
				//if (index <= (len - 1)) {
					int val1 = arr[index - 1] - 1;
					int val2 = arr[index] + 1;

					if (val1 >= val2) {
						arr[index - 1] = val1;
						arr[index] = val2;
						possibleSum(arr, len);
					} else {
						arr[index - 1] = val1;
						arr[len] = 1;
						possibleSum(arr, len + 1);
					}
				//}
			}
		}

	}

	public static void possibleCombination(int[] arr, int len) {
		if (allOne(arr,0, len)) {
			printArray(arr, len);
			return;
		}

		// Single Element
		if (len == 1) {
			int val = arr[0];
			arr[0] = val - 1;
			arr[1] = 1;
			possibleCombination(arr, len + 1);
		} else {

			int index = getIndexOf(1, arr);

			// 1 not present
			if (index == -1) {
				printArray(arr, len);

				int val = arr[len - 1];
				arr[len - 1] = val - 1;
				arr[len] = 1;
				possibleCombination(arr, len + 1);
			}

			// 1 is First Element
			else if (index == 0) {
				printArray(arr, len);
			}


			// 1 present in Middle
			else {
				printArray(arr, len);

				// indexed value is not last value
				//if (index <= (len - 1)) {
					int val1 = arr[index - 1] - 1;
					int val2 = arr[index] + 1;

					if (val1 >= val2) {
						arr[index - 1] = val1;
						arr[index] = val2;
						possibleCombination(arr, len);
					} else {
						arr[index - 1] = val1;
						arr[len] = 1;
						possibleCombination(arr, len + 1);
					}
				//}
			}
		}

	}

	public static int getIndexOf( int toSearch, int[] tab )
	{
	  for( int i=0; i< tab.length ; i ++ )
	    if( tab[ i ] == toSearch)
	     return i;

	  return -1;
	}
	
	public static void printArray(int[] arr, int len) {
		for (int i = 0; i < len; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	public static boolean allOne(int[] arr, int start,int len) {
		boolean flag = true;

		for (int i = start; i < len; i++) {

			if (arr[i] != 1) {
				flag = false;
				break;
			}
		}

		return flag;
	}

}
