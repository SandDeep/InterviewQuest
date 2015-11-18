package com.trash;

public class WordBreak {

	public static void main(String[] args) {
		String[] dictionary = { "i", "like", "sam", "sung"/*, "samsung"*/,
				"mobile", "ice", "cream", "icecream",/* "man",*/ "go", "mango","and" };

		String word = "ilikesamsung";
		boolean status=false;
		WordBreak obj = new WordBreak();
		/*status = obj.wordBreak(word, dictionary);
		System.out.println("\n" + status + "\n");

		System.out.println("\n"
				+ obj.wordBreak("ilikelikeimangoiii", dictionary));*/

		status = obj.wordBreakDP("samsungandmango", dictionary);
		System.out.println("\n" + status + "\n");

	}

	private boolean wordBreakDP(String word, String[] dictionary) {

		int size = word.length();

		boolean[] wb = new boolean[size + 1];

		for (int i = 1; i <= size; i++) {

			if(wb[i]==false && dictionaryContains(word.substring(0, i), dictionary)){
				wb[i] = true;
			}
			
			if (wb[i] == true) {

				// Base condition - reached last prefix
				if (i == size) {
					return true;
				}
				
				for (int j = i + 1; j <= size; j++) {
					
					//here checking  - for prefix for each word
					/**
					 * "ABCDE"  - here we check for prefix - B , BC , BCD , BCDE
					 */
					/**
					 * it marks next starting prefix which will be used to continue with next one
					 * sam --> start here	[1st call]
					 * sung -->mark here<--- andmango
					 * 
					 * sung --> start here [2nd call]
					 * and -->mark here<--- mango
					 * 
					 * and --> start here [3rd call]
					 * man -->mark here<--- go
					 * 
					 */
					if(wb[j]==false && dictionaryContains(word.substring(i, j), dictionary)){
						wb[j] = true;
					}
					
					if(j==size && wb[j]==true){
						return true;
					}
				}
			}
		}
		return false;
	}

	private boolean wordBreak(String word, String[] dictionary) {

		int size = word.length();

		// Base Case
		if (size <= 0) {
			return true;
		}

		for (int i = 1; i <= size; i++) {
			if (dictionaryContains(word.substring(0, i), dictionary)
					&& wordBreak(word.substring(i, size), dictionary)) {
				System.out.print(word.substring(0, i) + " ");
				return true;
			}
		}
		return false;
	}

	private boolean dictionaryContains(String word, String[] dictionary) {

		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i].equals(word)) {
				return true;
			}
		}
		return false;
	}

}
