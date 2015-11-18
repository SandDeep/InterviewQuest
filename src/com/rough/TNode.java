package com.rough;

import java.util.LinkedList;
import java.util.List;

public class TNode {

	int SIZE = 256;
	boolean isLeafNode;
	TNode[] childrens;
	List<Integer> list;

	public TNode() {
		childrens = new TNode[SIZE];
		isLeafNode = false;
		list=new LinkedList<Integer>();
	}

	public boolean isLeafNode() {
		return isLeafNode;
	}

	public void setLeafNode(boolean isLeafNode) {
		this.isLeafNode = isLeafNode;
	}

	public TNode[] getChildrens() {
		return childrens;
	}

	public void setChildrens(TNode[] childrens) {
		this.childrens = childrens;
	}

	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}
	
	
}
