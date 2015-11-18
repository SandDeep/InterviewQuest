package com.pattern;

import java.util.LinkedList;
import java.util.List;

public class SuffixTrieNode {

	List<Integer> indexes;
	SuffixTrieNode[] children = null;
	public final int SIZE = 256;

	public SuffixTrieNode() {
		this.indexes = new LinkedList<Integer>();
		this.children = new SuffixTrieNode[SIZE];
	}

	public void insertSuffix(String suffix, int index) {
		indexes.add(index);

		if (suffix.length() > 0) {
			char c = suffix.charAt(0);
			if (children[c] == null) {
				children[c] = new SuffixTrieNode();
			}
			
			children[c].insertSuffix(suffix.substring(1), index + 1);
		}
	}

	@Override
	public String toString() {
		return "SuffixTrieNode [indexes=" + indexes + "]";
	}

	public List<Integer> search(String pat) {
		if (pat.length() == 0) {
			return indexes;
		}

		if (children[pat.charAt(0)] != null) {
			return children[pat.charAt(0)].search(pat.substring(1));
		}

		return null;
	}

}
