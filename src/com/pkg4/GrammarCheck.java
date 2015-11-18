package com.pkg4;

/**
 * http://www.geeksforgeeks.org/check-given-sentence-given-set-simple-grammer-
 * rules/
 * 
 * @author Deepesh
 * 
 */
public class GrammarCheck {

	public static void main(String[] args) {
		GrammarCheck check = new GrammarCheck();

		String[] inputs = { "I love cinema.", "The vertex is S.",
				"I am single.", "My name is KG.", "I lovE cinema.",
				"GeeksQuiz. is a quiz site.",
				"I love Geeksquiz and Geeksforgeeks.", "  You are my friend.",
				"I love cinema" };

		for (int i = 0; i < inputs.length; i++) {
			boolean status = check.grammarCheck(inputs[i]);
			if (status == true) {
				System.out.println("Correct");
			} else {
				System.out.println("Incorrect");
			}
		}
	}

	private boolean grammarCheck(String data) {

		char[] charArr = data.toCharArray();

		if (charArr[0] < 'A' || charArr[0] > 'Z') {
			return false;
		}

		if (charArr[charArr.length - 1] != '.') {
			return false;
		}

		int current = -1;
		int prev = 0;

		for (int i = 1; i < charArr.length; i++) {

			// Capital Letter state:0
			if (charArr[i] >= 'A' && charArr[i] <= 'Z') {
				current = 0;
			}

			// Space state : 1
			if (charArr[i] == ' ') {
				current = 1;
			}

			// Small Letter state:2
			if (charArr[i] >= 'a' && charArr[i] <= 'z') {
				current = 2;
			}

			// Space state : 3
			if (charArr[i] == '.') {
				current = 3;
			}

			if (current == prev && current != 2) {
				return false;
			}

			if (prev == 2 && current == 0) {
				return false;
			}

			// space and . not allowed
			if (current == 3 && prev != 1) {
				return true;
			}

			prev = current;
		}
		return false;
	}

}
