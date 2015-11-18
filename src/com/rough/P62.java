package com.rough;

public class P62 {

	public static void main(String[] args) {
		P62 test = new P62();

		boolean status = test.wordBreak("iloveicecreamandmango");
		System.out.println("Word Break Status : " + status);

		test.wordBreakRecur("iloveicecreamandmango", "");
	}

	// Recursive program to print all possible partitions of a given string
	private void wordBreakRecur(String word, String result) {
		int size = word.length();

		for (int i = 1; i <= size; i++) {
			String prefix = word.substring(0, i);

			if (dictionaryContains(prefix)) {
				if (i == size) {
					result += prefix;
					System.out.println(result);
					return;
				}

				wordBreakRecur(word.substring(i), result + prefix + " ");
			}
		}
	}

	private boolean wordBreak(String word) {
		int size = word.length();

		if (size == 0) {
			return true;
		}

		for (int i = 1; i <= size; i++) {
			if (dictionaryContains(word.substring(0, i))
					&& wordBreak(word.substring(i))) {
				return true;
			}
		}
		return false;
	}

	private boolean dictionaryContains(String word) {
		String dictionary[] = { "mobile", "samsung", "sam", "sung", "man",
				"mango", "icecream", "and", "go", "i", "love", "ice", "cream" };

		for (int i = 0; i < dictionary.length; i++) {
			if (dictionary[i].equals(word)) {
				return true;
			}
		}
		return false;
	}
}
