package com.trash;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TrieNode {

	final int SIZE = 256;
	TrieNode[] childrens;
	boolean isLeaf;
	LinkedList<Integer> list;

	public TrieNode() {
		childrens = new TrieNode[SIZE];
		isLeaf = false;
		list = new LinkedList<Integer>();
	}

	public boolean isLeaf() {
		return isLeaf;
	}

	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	public LinkedList<Integer> getList() {
		return list;
	}

	public void setList(LinkedList<Integer> list) {
		this.list = list;
	}

	@Override
	public String toString() {
		List<String> buckets = new ArrayList<String>();
		for (int i = 0; i < childrens.length; i++) {
			if (childrens[i] != null) {
				buckets.add((char) i + "");
			}
		}
		
		return "Trie [childrens=" + buckets + ", isLeaf="
				+ isLeaf + ", list=" + list + "]";
	}
	
}
