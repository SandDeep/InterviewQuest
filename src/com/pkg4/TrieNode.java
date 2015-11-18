package com.pkg4;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {

	int value;
	TrieNode[] children;
	int alphabetSize = 26;

	public TrieNode() {
		value = 0;
		children = new TrieNode[alphabetSize];
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < children.length; i++) {
			if (children[i] != null) {
				list.add(indexToChar(i) + " : " + children[i].value);
			}
		}
		return "TrieNode [value=" + value + ", children=" + list + "]";
	}

	private Character indexToChar(int i) {
		return new Character((char) (97 + i));
	}
}
