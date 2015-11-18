package com.pkg4;

/**
 * Insert and search costs O(key_length), however the memory requirements of
 * trie is O(ALPHABET_SIZE * key_length * N) where N is number of keys in trie.
 * 
 * @author Deepesh.Maheshwari
 *
 */
public class Trie {

	int count;
	TrieNode root;

	public Trie() {
		count = 0;
		root = new TrieNode();
	}

	public void insert(String word) {
		char[] key = word.toCharArray();

		this.count++;
		TrieNode pCrawl = this.root;

		for (int i = 0; i < key.length; i++) {
			int index = charToIndex(key[i]);
			if (pCrawl.children[index] == null) {
				pCrawl.children[index] = new TrieNode();
			}
			pCrawl = pCrawl.children[index];
		}

		pCrawl.setValue(count);
	}

	public boolean search(String word) {
		char[] key = word.toCharArray();
		TrieNode pCrawl = this.root;

		for (int i = 0; i < key.length; i++) {
			int index = charToIndex(key[i]);

			if (pCrawl.children[index] == null) {
				return false;
			}
			pCrawl = pCrawl.children[index];
		}

		return (pCrawl != null && pCrawl.value != 0);
	}

	private int charToIndex(char c) {
		return c - 'a';
	}
}
