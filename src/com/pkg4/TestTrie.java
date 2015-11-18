package com.pkg4;

public class TestTrie {

	public static void main(String[] args) {
		String[] keys = { "the", "a", "there", "answer", "any", "by", "bye",
				"their" };

		Trie trie = new Trie();
		for (int i = 0; i < keys.length; i++) {
			trie.insert(keys[i]);
		}

		System.out.println(trie.search("the"));
		System.out.println(trie.search("these"));
		System.out.println(trie.search("their"));
		System.out.println(trie.search("thaw"));
	}

}
