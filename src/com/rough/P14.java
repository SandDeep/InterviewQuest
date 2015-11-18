package com.rough;

import java.util.LinkedList;
import java.util.List;

public class P14 {

	public static void main(String[] args) {
		P14 test = new P14();

		TNode root = new TNode();
		test.insert(root, "cat".toCharArray(), 0);
		test.insert(root, "cats".toCharArray(), 0);
		test.insert(root, "dog".toCharArray(), 0);
		test.insert(root, "tac".toCharArray(), 0);
		test.insert(root, "god".toCharArray(), 0);
		test.insert(root, "act".toCharArray(), 0);
		test.insert(root, "gdo".toCharArray(), 0);

		printAllWords(root, "");
	}

	private static void printAllWords(TNode node, String word) {
		if (node == null) {
			return;
		}

		if (node.isLeafNode()) {
			System.out.println(word);
		}

		List<Character> list = new LinkedList<Character>();
		for (int i = 0; i < node.SIZE; i++) {
			if (node.childrens[i] != null) {
				list.add((char) i);
			}
		}

		for (Character character : list) {
			TNode temp=node;
			temp = temp.childrens[character];
			String w = word;
			w = w + character + "";
			printAllWords(temp, w);
		}
	}

	private void insert(TNode node, char[] word, int index) {
		if (node == null) {
			return;
		}

		while (index < word.length) {
			TNode temp = node.childrens[word[index]];
			if (temp == null) {
				node.childrens[word[index]] = new TNode();
			}
			node = node.childrens[word[index]];
			index++;
		}
		node.setLeafNode(true);

		List<Integer> list = node.getList();
		list.add(index);
		node.setList(list);
	}
}
