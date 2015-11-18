package com.trash;

import java.util.LinkedList;

public class Trie {

	TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word, int index) {
		char[] key = word.toCharArray();

		TrieNode node = this.root;

		for (int i = 0; i < key.length; i++) {
			if (node.childrens[key[i]] == null) {
				node.childrens[key[i]] = new TrieNode();
			}
			node = node.childrens[key[i]];
		}
		
		node.setLeaf(true);
		
		LinkedList<Integer> list=node.getList();
		list.add(index);
		node.setList(list);
	}
}
