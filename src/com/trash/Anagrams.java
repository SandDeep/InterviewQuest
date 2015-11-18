package com.trash;

import java.util.Arrays;
import java.util.List;

public class Anagrams {

	public static void main(String[] args) {
		String[] wordArr = { "cat", "dog", "tac", "god", "act", "gdo" };

		Anagrams anagrams = new Anagrams();
		anagrams.printTogether(wordArr, wordArr.length);

		anagrams.trieMethod(wordArr, wordArr.length);
	}

	public void trieMethod(String[] wordArr, int size) {
		Trie trie = new Trie();
		Words words[] = new Words[size];

		for (int i = 0; i < size; i++) {
			words[i] = new Words(i, wordArr[i]);

			char[] anams = words[i].getWord().toCharArray();
			Arrays.sort(anams);
			words[i].setWord(new String(anams));

			// Insert in trie
			trie.insert(words[i].getWord(), words[i].getIndex());
		}

		for (int i = 0; i < trie.root.childrens.length; i++) {
			printTrieUtil(trie.root.childrens[i], wordArr);
		}
	}

	private void printTrieUtil(TrieNode root, String[] word) {
		if (root == null) {
			return;
		}

		if (root.isLeaf) {
			List<Integer> list = root.getList();
			for (Integer index : list) {
				System.out.print(word[index] + " ");
			}
		}
		TrieNode[] chiNodes = root.childrens;

		for (int i = 0; i < chiNodes.length; i++) {
			printTrieUtil(chiNodes[i], word);
		}
	}

	public void printTogether(String[] wordArr, int size) {
		Words words[] = new Words[size];

		// Sort word , index remains the same.
		for (int i = 0; i < size; i++) {
			words[i] = new Words(i, wordArr[i]);

			char[] anams = words[i].getWord().toCharArray();
			Arrays.sort(anams);
			words[i].setWord(new String(anams));
			// System.out.println(words[i]);
		}

		Arrays.sort(words);

		for (int i = 0; i < words.length; i++) {
			int index = words[i].getIndex();
			System.out.print(wordArr[index] + " ");
		}
		System.out.println();
	}
}

class Words implements Comparable<Words> {
	int index;
	String word;

	public Words(int index, String word) {
		this.index = index;
		this.word = word;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	@Override
	public String toString() {
		return "Words [index=" + index + ", word=" + word + "]";
	}

	@Override
	public int compareTo(Words o) {
		return this.word.compareTo(o.word);
	}

}