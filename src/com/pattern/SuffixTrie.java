package com.pattern;

import java.util.List;

public class SuffixTrie {

	SuffixTrieNode root;

	public SuffixTrie(String txt) {
		root = new SuffixTrieNode();

		for (int i = 0; i < txt.length(); i++) {
			root.insertSuffix(txt.substring(i), i);
		}
	}

	public static void main(String[] args) {
		String txt = "geeksforgeeks.org";
		SuffixTrie suffixTrie = new SuffixTrie(txt);

		System.out.println("Search for 'ee'");
		suffixTrie.search("ee");

		System.out.println("Search for 'geek'");
		suffixTrie.search("geek");

		System.out.println("Search for 'quiz'");
		suffixTrie.search("quiz");

		System.out.println("Search for 'forgeeks'");
		suffixTrie.search("forgeeks");
	}

	private void search(String pat) {
		List<Integer> list = root.search(pat);

		if (list == null) {
			System.out.println("Pattern not found.");
		} else {
			int patLen = pat.length();
			for (Integer index : list) {
				System.out.println("Pattern found : "+ Math.abs(index - patLen));
			}
		}
	}
}
